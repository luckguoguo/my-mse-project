package cn.edu.sjtu.petclinic.service.exception;

public class DailyOutpatientExistsException extends ServiceException {

	private static final long serialVersionUID = -7473026488056169031L;

	public DailyOutpatientExistsException() {
		super();
	}

	public DailyOutpatientExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
