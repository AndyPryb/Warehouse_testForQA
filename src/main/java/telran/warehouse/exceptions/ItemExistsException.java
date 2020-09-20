package telran.warehouse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ItemExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7727475428615665390L;

}
