package kodlama.io.devs.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TechnologyAddRequest {

	@NotNull
	@NotBlank
	private String name;
	
	private int languageId;
	
}
