package kodlama.io.devs.core.utilities.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationExceptionResponse extends ExceptionResponse{

	private Map<String,String> validationErrors;
	
}
