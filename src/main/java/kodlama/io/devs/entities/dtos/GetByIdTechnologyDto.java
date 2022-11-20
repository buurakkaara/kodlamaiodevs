package kodlama.io.devs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdTechnologyDto {

	private String technologyName;
	private String languageName;
	
}
