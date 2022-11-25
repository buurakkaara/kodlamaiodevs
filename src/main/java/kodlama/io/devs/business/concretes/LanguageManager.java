package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.validation.ValidationService;
import kodlama.io.devs.dataAccess.abstracts.LanguageDao;
import kodlama.io.devs.entities.concretes.Language;
import kodlama.io.devs.entities.dtos.GetAllLanguagesDto;
import kodlama.io.devs.entities.dtos.GetByIdLanguageDto;
import kodlama.io.devs.entities.dtos.LanguageAddDto;
import kodlama.io.devs.entities.dtos.LanguageUpdateDto;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	
	@Qualifier("languageValidationManager")
	private ValidationService validationService;
	
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
		//this.validationService= validationService;
	}

	@Override
	public void add(LanguageAddDto languageAddDto) throws Exception{

		validationService.validateNameIfEmpty(languageAddDto.getLanguageName());
		validationService.validateNameIfExist(languageAddDto.getLanguageName());
		
		Language language = new Language();
		language.setLanguageName(languageAddDto.getLanguageName());
		
		this.languageDao.save(language);
	}
	
	@Override
	public void update(int languageId, LanguageUpdateDto languageUpdateDto) throws Exception {

		validationService.validateIdIfNotExist(languageId);
		validationService.validateNameIfEmpty(languageUpdateDto.getLanguageName());
		validationService.validateNameIfExist(languageUpdateDto.getLanguageName());
		
		Language language = languageDao.findById(languageId).get();
		language.setLanguageName(languageUpdateDto.getLanguageName());
		this.languageDao.save(language);	
	}
			

	@Override
	public List<GetAllLanguagesDto> getAll() {
		
		List<Language> languages = languageDao.findAll();
		List<GetAllLanguagesDto> languagesDto = new ArrayList<GetAllLanguagesDto>();
		
		for (Language language : languages) {
			GetAllLanguagesDto languageItem = new GetAllLanguagesDto();
			languageItem.setLanguageId(language.getLanguageId());
			languageItem.setLanguageName(language.getLanguageName());
			languagesDto.add(languageItem);
		}
		
		return languagesDto;
	}
	
	@Override
	public GetByIdLanguageDto getById(int languageId) throws Exception {
		
		validationService.validateIdIfNotExist(languageId);
		
		Language language = languageDao.getById(languageId);
		GetByIdLanguageDto getByIdLanguageDto = new GetByIdLanguageDto();
		getByIdLanguageDto.setLanguageName(language.getLanguageName());
		return getByIdLanguageDto;
	}


	@Override
	public void delete(int languageId) throws Exception {
		
		validationService.validateIdIfNotExist(languageId);
		languageDao.deleteById(languageId);
	}
	
}
