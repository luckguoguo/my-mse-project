package cn.edu.sjtu.petclinic.service.exception;

public class DuplicatedClinicNameException extends ServiceException {

	private static final long serialVersionUID = -2294237810172551638L;

	public DuplicatedClinicNameException() {
		super();
	}

	public DuplicatedClinicNameException(String message, Throwable cause) {
		super(message, cause);
	}

}
