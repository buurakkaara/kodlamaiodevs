package kodlama.io.devs.business.validation;

import org.springframework.stereotype.Service;

import kodlama.io.devs.dataAccess.abstracts.LanguageDao;
import kodlama.io.devs.entities.concretes.Language;

@Service
public class LanguageValidationManager implements ValidationService{

	private LanguageDao languageDao;
	

	public LanguageValidationManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public void validateNameIfEmpty(String name) throws Exception {
		if (name.isEmpty()) {
			throw new Exception("Validasyon hatası : İsim boş olamaz");
		}
	}
	
	@Override
	public void validateNameIfExist(String name) throws Exception {
		for (Language language : languageDao.findAll()) {
			if (language.getLanguageName().equals(name)) {
			throw new Exception("Validasyon hatası : İsim mevcut");
			}
		}	
	}	
	
	@Override
	public void validateIdIfExist(int languageId) throws Exception {
		if (languageDao.existsById(languageId)) {
			throw new Exception("Validasyon hatası : Id mevcut");
		}
	}
	
	@Override
	public void validateIdIfNotExist(int languageId) throws Exception {
		if (!languageDao.existsById(languageId)) {
			throw new Exception("Validasyon hatası : Id mevcut değil");
		}
	}
}
