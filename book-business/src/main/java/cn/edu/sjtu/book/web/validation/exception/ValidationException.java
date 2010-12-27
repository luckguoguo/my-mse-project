package cn.edu.sjtu.book.web.validation.exception;

public class ValidationException extends Exception {

	private static final long serialVersionUID = -8978820055410037575L;

	public ValidationException() {
		super();
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
