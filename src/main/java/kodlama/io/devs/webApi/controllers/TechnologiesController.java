package kodlama.io.devs.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.TechnologyAddRequest;
import kodlama.io.devs.business.requests.TechnologyUpdateRequest;
import kodlama.io.devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.devs.core.utilities.results.DataResult;
import kodlama.io.devs.core.utilities.results.Result;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping()
	public DataResult<List<GetAllTechnologiesResponse>> getAll(){
		return this.technologyService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result add(@RequestBody @Valid TechnologyAddRequest technologyAddDto ){
		return this.technologyService.add(technologyAddDto);
	}
	
	@DeleteMapping("/{technologyId}")
	public Result delete(@PathVariable int technologyId){
		return this.technologyService.delete(technologyId);
	}
	
	@PutMapping("/{technologyId}")
	public Result update(@PathVariable int technologyId , @Valid @RequestBody TechnologyUpdateRequest technologyUpdateDto){
		return this.technologyService.update(technologyId, technologyUpdateDto);
	}
	
	@GetMapping("/{technologyId}")
	public DataResult<GetByIdTechnologyResponse> getById(@PathVariable int technologyId){
		return this.technologyService.getById(technologyId);
	}
	
}
