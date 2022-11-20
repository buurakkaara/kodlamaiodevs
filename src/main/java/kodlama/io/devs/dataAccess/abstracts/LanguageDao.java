package kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devs.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

	//@Query("From Language")
	//List<GetAllLanguagesDto> getAll();
	
	
}
