package kodlama.io.devs.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyUpdateRequest {
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	private int languageId;
	

	
}
