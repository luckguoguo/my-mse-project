package cn.edu.sjtu.petclinic.service.exception;

public class DuplicatedUsernameException extends ServiceException {

	private static final long serialVersionUID = -7064576709522573260L;

	public DuplicatedUsernameException() {
		super();
	}

	public DuplicatedUsernameException(String message, Throwable cause) {
		super(message, cause);
	}

}
