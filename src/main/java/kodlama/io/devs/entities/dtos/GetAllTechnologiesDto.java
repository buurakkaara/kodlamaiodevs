package kodlama.io.devs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologiesDto {

	private int technologyId;
	private String technologyName;
	private String languageName;
	
}
