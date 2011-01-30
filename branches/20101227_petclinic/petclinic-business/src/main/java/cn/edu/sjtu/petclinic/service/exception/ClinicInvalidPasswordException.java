package cn.edu.sjtu.petclinic.service.exception;

public class ClinicInvalidPasswordException extends ServiceException {

	private static final long serialVersionUID = 1006183734268727442L;

	public ClinicInvalidPasswordException() {
		super();
	}

	public ClinicInvalidPasswordException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
