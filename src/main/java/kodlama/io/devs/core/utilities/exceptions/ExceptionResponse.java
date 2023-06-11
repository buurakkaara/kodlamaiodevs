package kodlama.io.devs.core.utilities.exceptions;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse {

	private int statusCode;
	private String message;
	private Date timestamp;
	
}
