package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.LanguageAddRequest;
import kodlama.io.devs.business.requests.LanguageUpdateRequest;
import kodlama.io.devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdLanguageResponse;
import kodlama.io.devs.core.utilities.results.DataResult;
import kodlama.io.devs.core.utilities.results.Result;

public interface LanguageService {

	//List<Language> getAll();
	Result add(LanguageAddRequest languageAddDto);
	Result delete(int languageId);
	Result update(int languageId , LanguageUpdateRequest languageUpdateDto) ;
	
	
	//Language getById(int languageId);
	
	DataResult<List<GetAllLanguagesResponse>> getAll();
	DataResult<GetByIdLanguageResponse> getById(int languageId);
}
