package cn.edu.sjtu.book.web.validation.exception;


public class NonOrderItemException extends ValidationException {

	private static final long serialVersionUID = 6827533960869570533L;

	public NonOrderItemException() {
		super();
	}

	public NonOrderItemException(String message) {
		super(message);
	}

	public NonOrderItemException(Throwable cause) {
		super(cause);
	}

	public NonOrderItemException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
