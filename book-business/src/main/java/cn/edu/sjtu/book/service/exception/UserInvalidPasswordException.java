package cn.edu.sjtu.book.service.exception;

public class UserInvalidPasswordException extends BusinessException {

	private static final long serialVersionUID = 6819215824506511194L;

	public UserInvalidPasswordException() {
		super();
	}

	public UserInvalidPasswordException(String message) {
		super(message);
	}

	public UserInvalidPasswordException(Throwable cause) {
		super(cause);
	}

	public UserInvalidPasswordException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
