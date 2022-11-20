package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyService;
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
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao,LanguageDao languageDao) {
		super();
		this.technologyDao = technologyDao;
		this.languageDao = languageDao;
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
	public void add(TechnologyAddDto technologyAddDto) {
     
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

		Technology technology = this.technologyDao.findById(technologyId).get();
		Language language = this.languageDao.findById(technologyUpdateDto.getLanguageId()).get();
		technology.setTechnologyName(technologyUpdateDto.getTechnologyName());
		technology.setLanguage(language);
		this.technologyDao.save(technology);

		
	}

	@Override
	public GetByIdTechnologyDto getById(int technologyId) throws Exception {

		if (!isIdExist(technologyId)) {

			throw new Exception("Geçersiz id");
		}
		
		Technology technology = technologyDao.getById(technologyId);
		GetByIdTechnologyDto getByIdTechnologyDto = new GetByIdTechnologyDto();
		getByIdTechnologyDto.setTechnologyName(technology.getTechnologyName());
		getByIdTechnologyDto.setLanguageName(technology.getLanguage().getLanguageName());
		
		return getByIdTechnologyDto;
	}

	private boolean isIdExist(int languageId) {
		if (languageDao.existsById(languageId)) {
			return true;
		}
		return false;
	}

}
