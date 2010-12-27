package cn.edu.sjtu.book.service.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -498468098054693592L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
