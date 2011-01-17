package cn.edu.sjtu.petclinic.service.exception;

public class UserNotExistsException extends ServiceException {

	private static final long serialVersionUID = 5493811166325687009L;

	public UserNotExistsException() {
		super();
	}

	public UserNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
