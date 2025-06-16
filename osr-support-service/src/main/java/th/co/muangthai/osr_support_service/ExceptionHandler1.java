package th.co.muangthai.osr_support_service;

import java.util.Date;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler1 {
	
	 	@ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<HashMap<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        String errorMessage = ex.getBindingResult().getAllErrors().stream().map(error -> error.getDefaultMessage())
	                .reduce((message1, message2) -> message1 + "; " + message2).orElse("Validation error");
	        HashMap<String, Object> response = new HashMap<>();
	        response.put("responseCode","-1");
	        response.put("message",errorMessage);
	        response.put("date",new Date());
	        
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    }
}
