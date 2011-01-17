package cn.edu.sjtu.petclinic.service.exception;

public class InvalidClinicPasswordException extends ServiceException {

	private static final long serialVersionUID = 713158949816503095L;

	public InvalidClinicPasswordException() {
		super();
	}

	public InvalidClinicPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

}
