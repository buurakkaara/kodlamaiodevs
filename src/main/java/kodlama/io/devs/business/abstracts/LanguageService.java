package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.entities.dtos.GetAllLanguagesDto;
import kodlama.io.devs.entities.dtos.GetByIdLanguageDto;
import kodlama.io.devs.entities.dtos.LanguageAddDto;
import kodlama.io.devs.entities.dtos.LanguageUpdateDto;

public interface LanguageService {

	//List<Language> getAll();
	void add(LanguageAddDto languageAddDto) throws Exception ;
	void delete(int languageId) throws Exception;
	void update(int languageId , LanguageUpdateDto languageUpdateDto) throws Exception ;
	
	
	//Language getById(int languageId);
	
	List<GetAllLanguagesDto> getAll();
	GetByIdLanguageDto getById(int languageId) throws Exception;
}
