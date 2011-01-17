package cn.edu.sjtu.petclinic.service.exception;

public class DailyOutpatientCountExceedsException extends ServiceException {

	private static final long serialVersionUID = 2038786634934109518L;

	public DailyOutpatientCountExceedsException() {
		super();
	}

	public DailyOutpatientCountExceedsException(String message, Throwable cause) {
		super(message, cause);
	}

}
