package kodlama.io.devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.TechnologyAddRequest;
import kodlama.io.devs.business.requests.TechnologyUpdateRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.devs.business.validation.LanguageValidationManager;
import kodlama.io.devs.business.validation.TechnologyValidationManager;
import kodlama.io.devs.core.utilities.mapper.ModelMapperService;
import kodlama.io.devs.core.utilities.results.DataResult;
import kodlama.io.devs.core.utilities.results.Result;
import kodlama.io.devs.core.utilities.results.SuccessDataResult;
import kodlama.io.devs.core.utilities.results.SuccessResult;
import kodlama.io.devs.dataAccess.TechnologyRepository;
import kodlama.io.devs.entities.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService{

	private TechnologyRepository technologyRepository;
	private TechnologyValidationManager technologyValidationManager;
	private LanguageValidationManager languageValidationManager;
	private ModelMapperService modelMapperService;
	

	@Override
	public DataResult<List<GetAllTechnologiesResponse>> getAll() {
		
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> technologiesResponse = technologies.stream()
													  .map(technology -> this.modelMapperService.forResponse()
													  .map(technology, GetAllTechnologiesResponse.class))
													  .collect(Collectors.toList());

		return new SuccessDataResult<>(technologiesResponse, "Data listelendi");
	}

	@Override
	public Result add(TechnologyAddRequest technologyAddRequest){
     
		technologyValidationManager.checkIfTechnologyNameExists(technologyAddRequest.getName());
		languageValidationManager.checkIfLanguageIdExists(technologyAddRequest.getLanguageId());
		
		Technology technology = this.modelMapperService.forRequest().map(technologyAddRequest, Technology.class);
		this.technologyRepository.save(technology);

		return new SuccessResult("Data eklendi");
	}

	@Override
	public Result delete(int technologyId) {
		
		technologyValidationManager.checkIfTechnologyIdExists(technologyId);
		
		technologyRepository.deleteById(technologyId);
		return new SuccessResult("Data silindi");
	}

	@Override
	public Result update(int technologyId, TechnologyUpdateRequest technologyUpdateRequest){

		technologyValidationManager.checkIfTechnologyNameExists(technologyUpdateRequest.getName());
		
		Technology technology = this.modelMapperService.forRequest().map(technologyUpdateRequest, Technology.class);
		
		this.technologyRepository.save(technology);

		return new SuccessResult("Data güncellendi");
	}

	@Override
	public DataResult<GetByIdTechnologyResponse> getById(int technologyId){

		technologyValidationManager.checkIfTechnologyIdExists(technologyId);
		
		Technology technology = technologyRepository.findById(technologyId).orElseThrow();
		GetByIdTechnologyResponse getByIdTechnologyResponse = this.modelMapperService.forResponse()
													.map(technology, GetByIdTechnologyResponse.class);
		
		return new SuccessDataResult<GetByIdTechnologyResponse>(getByIdTechnologyResponse, "Data listelendi");
	}


}
