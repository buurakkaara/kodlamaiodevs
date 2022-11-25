package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.validation.ValidationService;
import kodlama.io.devs.dataAccess.abstracts.LanguageDao;
import kodlama.io.devs.dataAccess.abstracts.TechnologyDao;
import kodlama.io.devs.entities.concretes.Language;
import kodlama.io.devs.entities.concretes.Technology;
import kodlama.io.devs.entities.dtos.GetAllTechnologiesDto;
import kodlama.io.devs.entities.dtos.GetByIdTechnologyDto;
import kodlama.io.devs.entities.dtos.TechnologyAddDto;
import kodlama.io.devs.entities.dtos.TechnologyUpdateDto;

@Service
public class TechnologyManager implements TechnologyService{

	private TechnologyDao technologyDao;
	private LanguageDao languageDao;
	@Qualifier("technologyValidationManager")
	private ValidationService validationService;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao,LanguageDao languageDao) {
		super();
		this.technologyDao = technologyDao;
		this.languageDao = languageDao;
		//this.validationService= validationService;
	}

	@Override
	public List<GetAllTechnologiesDto> getAll() {
		
		List<Technology> technologies = technologyDao.findAll();
		List<GetAllTechnologiesDto> technologiesDto = new ArrayList<GetAllTechnologiesDto>();
		
		for (Technology technology : technologies) {	
			GetAllTechnologiesDto technologyItem = new GetAllTechnologiesDto();
			technologyItem.setTechnologyName(technology.getTechnologyName());
			technologyItem.setTechnologyId(technology.getTechnologyId());
			technologyItem.setLanguageName(technology.getLanguage().getLanguageName());
			technologiesDto.add(technologyItem);
		}
		
		return technologiesDto ;
	}

	@Override
	public void add(TechnologyAddDto technologyAddDto) throws Exception {
     
		validationService.validateNameIfEmpty(technologyAddDto.getTechnologyName());
		validationService.validateNameIfExist(technologyAddDto.getTechnologyName());
		
		Technology technology = new Technology();
		Language language = languageDao.findById(technologyAddDto.getLanguageId()).get();
		technology.setTechnologyName(technologyAddDto.getTechnologyName());
		technology.setLanguage(language);
		technologyDao.save(technology);
		
	}

	@Override
	public void delete(int technologyId) {
		technologyDao.deleteById(technologyId);
	}

	@Override
	public void update(int technologyId, TechnologyUpdateDto technologyUpdateDto) throws Exception {

		validationService.validateIdIfNotExist(technologyId);
		validationService.validateNameIfEmpty(technologyUpdateDto.getTechnologyName());
		validationService.validateNameIfExist(technologyUpdateDto.getTechnologyName());
		
		Technology technology = this.technologyDao.findById(technologyId).get();
		Language language = this.languageDao.findById(technologyUpdateDto.getLanguageId()).get();
		technology.setTechnologyName(technologyUpdateDto.getTechnologyName());
		technology.setLanguage(language);
		this.technologyDao.save(technology);

		
	}

	@Override
	public GetByIdTechnologyDto getById(int technologyId) throws Exception {

		validationService.validateIdIfNotExist(technologyId);
		
		Technology technology = technologyDao.getById(technologyId);
		GetByIdTechnologyDto getByIdTechnologyDto = new GetByIdTechnologyDto();
		getByIdTechnologyDto.setTechnologyName(technology.getTechnologyName());
		getByIdTechnologyDto.setLanguageName(technology.getLanguage().getLanguageName());
		
		return getByIdTechnologyDto;
	}


}
