package cn.edu.sjtu.petclinic.service.exception;

public class DailyOutpatientExpiredException extends ServiceException {

	private static final long serialVersionUID = -7071327805532198582L;

	public DailyOutpatientExpiredException() {
		super();
	}

	public DailyOutpatientExpiredException(String message, Throwable cause) {
		super(message, cause);
	}

}
