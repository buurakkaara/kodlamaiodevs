package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.TechnologyAddRequest;
import kodlama.io.devs.business.requests.TechnologyUpdateRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.devs.core.utilities.results.DataResult;
import kodlama.io.devs.core.utilities.results.Result;

public interface TechnologyService {

	DataResult<List<GetAllTechnologiesResponse>> getAll();
	Result add(TechnologyAddRequest technologyAddDto);
	Result delete(int technologyId);
	Result update(int technologyId , TechnologyUpdateRequest technologyUpdateDto);
	DataResult<GetByIdTechnologyResponse> getById(int technologyId);
	
}
