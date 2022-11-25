package kodlama.io.devs.business.validation;

import org.springframework.stereotype.Service;

import kodlama.io.devs.dataAccess.abstracts.TechnologyDao;
import kodlama.io.devs.entities.concretes.Technology;

@Service
public class TechnologyValidationManager implements ValidationService{

	private TechnologyDao technologyDao;
	
	
	
	public TechnologyValidationManager(TechnologyDao technologyDao) {
		super();
		this.technologyDao = technologyDao;
	}

	@Override
	public void validateNameIfEmpty(String name) throws Exception {
		if (name.isEmpty()) {
			throw new Exception("Validasyon hatası : İsim boş olamaz");
		}
	}

	@Override
	public void validateNameIfExist(String name) throws Exception {
		for (Technology technology : technologyDao.findAll()) {
			if (technology.getTechnologyName().equals(name)) {
			throw new Exception("Validasyon hatası : İsim mevcut");
			}
		}	
	}

	@Override
	public void validateIdIfExist(int technologyId) throws Exception {
		if (technologyDao.existsById(technologyId)) {
			throw new Exception("Validasyon hatası : Id mevcut");
		}
	}

	@Override
	public void validateIdIfNotExist(int technologyId) throws Exception {
		if (!technologyDao.existsById(technologyId)) {
			throw new Exception("Validasyon hatası : Id mevcut değil");
		}
	}

}
