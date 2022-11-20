package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.entities.dtos.GetAllTechnologiesDto;
import kodlama.io.devs.entities.dtos.GetByIdTechnologyDto;
import kodlama.io.devs.entities.dtos.TechnologyAddDto;
import kodlama.io.devs.entities.dtos.TechnologyUpdateDto;

public interface TechnologyService {

	List<GetAllTechnologiesDto> getAll();
	void add(TechnologyAddDto technologyAddDto);
	void delete(int technologyId);
	void update(int technologyId , TechnologyUpdateDto technologyUpdateDto) throws Exception ;
	GetByIdTechnologyDto getById(int technologyId) throws Exception;
	
}
