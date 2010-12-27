package cn.edu.sjtu.book.service.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 6052152058565838537L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
