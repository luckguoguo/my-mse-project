package cn.edu.sjtu.petclinic.service.exception;

public class UserInvalidPasswordException extends ServiceException {

	private static final long serialVersionUID = 137954174395274698L;

	public UserInvalidPasswordException() {
		super();
	}

	public UserInvalidPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

}
