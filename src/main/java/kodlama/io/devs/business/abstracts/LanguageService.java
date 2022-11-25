package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.core.utilities.results.DataResult;
import kodlama.io.devs.core.utilities.results.Result;
import kodlama.io.devs.entities.dtos.GetAllLanguagesDto;
import kodlama.io.devs.entities.dtos.GetByIdLanguageDto;
import kodlama.io.devs.entities.dtos.LanguageAddDto;
import kodlama.io.devs.entities.dtos.LanguageUpdateDto;

public interface LanguageService {

	//List<Language> getAll();
	Result add(LanguageAddDto languageAddDto) throws Exception ;
	Result delete(int languageId) throws Exception;
	Result update(int languageId , LanguageUpdateDto languageUpdateDto) throws Exception ;
	
	
	//Language getById(int languageId);
	
	DataResult<List<GetAllLanguagesDto>> getAll();
	DataResult<GetByIdLanguageDto> getById(int languageId) throws Exception;
}
