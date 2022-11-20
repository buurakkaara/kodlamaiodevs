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

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.entities.dtos.GetAllLanguagesDto;
import kodlama.io.devs.entities.dtos.GetByIdLanguageDto;
import kodlama.io.devs.entities.dtos.LanguageAddDto;
import kodlama.io.devs.entities.dtos.LanguageUpdateDto;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	
	@GetMapping("/getall")
	public List<GetAllLanguagesDto> getAll(){
		return this.languageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody LanguageAddDto languageAddDto) throws Exception {
		this.languageService.add(languageAddDto);
	}
	
	@GetMapping("/getById")
	public GetByIdLanguageDto getById(@RequestParam int languageId) throws Exception{
		return this.languageService.getById(languageId);
	}
	
	@DeleteMapping("/{languageId}")
	public void delete(@PathVariable int languageId) throws Exception {
			
		languageService.delete(languageId);
	}
	
	@PutMapping("/update/{languageId}")
	public void update(@PathVariable int languageId , @RequestBody LanguageUpdateDto languageUpdateDto) throws Exception {
		this.languageService.update(languageId, languageUpdateDto);
	}
	
}
