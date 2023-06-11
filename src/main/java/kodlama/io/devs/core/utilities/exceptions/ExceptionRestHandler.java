package kodlama.io.devs.core.utilities.exceptions;

import java.util.Date;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionRestHandler {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse handleBusinessException (BusinessException businessException) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setMessage(businessException.getMessage());
		exceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		exceptionResponse.setTimestamp(new Date());
		
		return exceptionResponse;
		
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse handleValidationException (MethodArgumentNotValidException methodArgumentNotValidException) {
		
		ValidationExceptionResponse validationExceptionResponse = new ValidationExceptionResponse();
		validationExceptionResponse.setMessage("VALIDATION_EXCEPTION");
		validationExceptionResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		validationExceptionResponse.setTimestamp(new Date());
		validationExceptionResponse.setValidationErrors(new HashMap<String,String>());
		
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationExceptionResponse.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return validationExceptionResponse;
		
	}
	
}



