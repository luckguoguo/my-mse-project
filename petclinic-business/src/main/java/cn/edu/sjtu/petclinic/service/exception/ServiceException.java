package cn.edu.sjtu.petclinic.service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 3164723983688318023L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
