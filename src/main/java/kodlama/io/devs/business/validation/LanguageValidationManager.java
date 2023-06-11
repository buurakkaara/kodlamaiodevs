package kodlama.io.devs.business.validation;

import org.springframework.stereotype.Component;

import kodlama.io.devs.core.utilities.exceptions.BusinessException;
import kodlama.io.devs.dataAccess.LanguageRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LanguageValidationManager{

	private LanguageRepository languageDao;

	public void checkIfLanguageNameExists(String name) {
		if (languageDao.existsByName(name)) {
			throw new BusinessException("Language name already exists");
		}
	}

	public void checkIfLanguageIdExists(int id) {
		if (!languageDao.existsById(id)) {
			throw new BusinessException("Language id does not exist");
		}
	}
	
	
	
}
