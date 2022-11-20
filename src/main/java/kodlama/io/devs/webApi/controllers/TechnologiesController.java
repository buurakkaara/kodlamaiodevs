package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.entities.dtos.GetAllTechnologiesDto;
import kodlama.io.devs.entities.dtos.GetByIdTechnologyDto;
import kodlama.io.devs.entities.dtos.TechnologyAddDto;
import kodlama.io.devs.entities.dtos.TechnologyUpdateDto;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesDto> getAll(){
		return this.technologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody TechnologyAddDto technologyAddDto ) {
		this.technologyService.add(technologyAddDto);
	}
	
	@DeleteMapping("/delete/{technologyId}")
	public void delete(@PathVariable int technologyId) throws Exception {
		technologyService.delete(technologyId);
	}
	
	@PutMapping("/update/{technologyId}")
	public void update(@PathVariable int technologyId , @RequestBody TechnologyUpdateDto technologyUpdateDto) throws Exception {
		this.technologyService.update(technologyId, technologyUpdateDto);
	}
	
	@GetMapping("/getById")
	public GetByIdTechnologyDto getById(@RequestParam int technologyId) throws Exception{
		return this.technologyService.getById(technologyId);
	}
	
}
