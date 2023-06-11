package kodlama.io.devs.business.validation;

import org.springframework.stereotype.Component;

import kodlama.io.devs.core.utilities.exceptions.BusinessException;
import kodlama.io.devs.dataAccess.TechnologyRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TechnologyValidationManager{

	private TechnologyRepository technologyDao;
	
	
	public void checkIfTechnologyNameExists(String name) {
		if (technologyDao.existsByName(name)) {
			throw new BusinessException("Technology name already exists");
		}
	}

	public void checkIfTechnologyIdExists(int id) {
		if (technologyDao.existsById(id)) {
			throw new BusinessException("Technology id does not exist");
		}
	}


}
