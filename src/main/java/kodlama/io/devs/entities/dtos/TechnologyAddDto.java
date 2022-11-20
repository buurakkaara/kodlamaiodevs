package kodlama.io.devs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TechnologyAddDto {

	private String technologyName;
	private int languageId;
	
}
