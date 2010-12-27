package cn.edu.sjtu.book.service.exception;

public class UserNotExistsException extends BusinessException {

	private static final long serialVersionUID = -1594143400848791507L;

	public UserNotExistsException() {
		super();
	}

	public UserNotExistsException(String message) {
		super(message);
	}

	public UserNotExistsException(Throwable cause) {
		super(cause);
	}

	public UserNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
