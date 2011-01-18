package cn.edu.sjtu.petclinic.service.exception;

public class UserInvalidStatusException extends ServiceException {

	private static final long serialVersionUID = 3527677871331486126L;

	public UserInvalidStatusException() {
		super();
	}

	public UserInvalidStatusException(String message, Throwable cause) {
		super(message, cause);
	}

}
