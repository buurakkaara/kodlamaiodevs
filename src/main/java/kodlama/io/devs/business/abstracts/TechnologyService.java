package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.core.utilities.results.DataResult;
import kodlama.io.devs.core.utilities.results.Result;
import kodlama.io.devs.entities.dtos.GetAllTechnologiesDto;
import kodlama.io.devs.entities.dtos.GetByIdTechnologyDto;
import kodlama.io.devs.entities.dtos.TechnologyAddDto;
import kodlama.io.devs.entities.dtos.TechnologyUpdateDto;

public interface TechnologyService {

	DataResult<List<GetAllTechnologiesDto>> getAll();
	Result add(TechnologyAddDto technologyAddDto) throws Exception ;
	Result delete(int technologyId) throws Exception ;
	Result update(int technologyId , TechnologyUpdateDto technologyUpdateDto) throws Exception ;
	DataResult<GetByIdTechnologyDto> getById(int technologyId) throws Exception;
	
}
