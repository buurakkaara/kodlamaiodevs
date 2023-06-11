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

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.LanguageAddRequest;
import kodlama.io.devs.business.requests.LanguageUpdateRequest;
import kodlama.io.devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.business.responses.GetByIdLanguageResponse;
import kodlama.io.devs.core.utilities.results.DataResult;
import kodlama.io.devs.core.utilities.results.Result;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	
	@GetMapping()
	public DataResult<List<GetAllLanguagesResponse>> getAll(){
		return this.languageService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public Result add(@RequestBody @Valid LanguageAddRequest languageAddDto){
		return this.languageService.add(languageAddDto);
	}
	
	@GetMapping("/{languageId}")
	public DataResult<GetByIdLanguageResponse> getById(@PathVariable int languageId){
		return this.languageService.getById(languageId);
	}
	
	@DeleteMapping("/{languageId}")
	public Result delete(@PathVariable int languageId){
		return languageService.delete(languageId);
	}
	
	@PutMapping("/{languageId}")
	public Result update(@PathVariable int languageId , @RequestBody @Valid LanguageUpdateRequest languageUpdateDto){
		return this.languageService.update(languageId, languageUpdateDto);
	}
	
}
