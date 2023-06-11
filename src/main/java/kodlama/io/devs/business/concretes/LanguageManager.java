package kodlama.io.devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.LanguageAddRequest;
import kodlama.io.devs.business.requests.LanguageUpdateRequest;
import kodlama.io.devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdLanguageResponse;
import kodlama.io.devs.business.validation.LanguageValidationManager;
import kodlama.io.devs.core.utilities.mapper.ModelMapperService;
import kodlama.io.devs.core.utilities.results.DataResult;
import kodlama.io.devs.core.utilities.results.Result;
import kodlama.io.devs.core.utilities.results.SuccessDataResult;
import kodlama.io.devs.core.utilities.results.SuccessResult;
import kodlama.io.devs.dataAccess.LanguageRepository;
import kodlama.io.devs.entities.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	private LanguageValidationManager languageValidationManager;
	private ModelMapperService modelMapperService;
	
	

	@Override
	public Result add(LanguageAddRequest languageAddRequest){

		languageValidationManager.checkIfLanguageNameExists(languageAddRequest.getName());

		Language language = this.modelMapperService.forRequest().map(languageAddRequest, Language.class);
		
		this.languageRepository.save(language);
		
		return new SuccessResult(" Data eklendi ");
	}
	
	@Override
	public Result update(int languageId, LanguageUpdateRequest languageUpdateRequest){

		languageValidationManager.checkIfLanguageNameExists(languageUpdateRequest.getName());
		
		Language language = this.modelMapperService.forRequest().map(languageUpdateRequest, Language.class);
		
		this.languageRepository.save(language);	
		
		return new SuccessResult(" Data güncellendi ");
	}
			
	@Override
	public Result delete(int languageId){
		
		languageValidationManager.checkIfLanguageIdExists(languageId);
		languageRepository.deleteById(languageId);
		return new SuccessResult("Data silindi");
	}

	@Override
	public DataResult<List<GetAllLanguagesResponse>> getAll() {
		
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesDto = languages.stream()
				.map(language -> this.modelMapperService.forResponse()
				.map(language, GetAllLanguagesResponse.class))
				.collect(Collectors.toList());
		
		return new SuccessDataResult<List<GetAllLanguagesResponse>>
		(languagesDto, "Data listelendi");
	}
	
	@Override
	public DataResult<GetByIdLanguageResponse> getById(int languageId) {
		
		languageValidationManager.checkIfLanguageIdExists(languageId);
		
		Language language = languageRepository.getById(languageId);
		GetByIdLanguageResponse getByIdLanguageDto = this.modelMapperService.forResponse()
												.map(language, GetByIdLanguageResponse.class);
		
		return new SuccessDataResult<GetByIdLanguageResponse>
		(getByIdLanguageDto, "Data listelendi");
	}

}
