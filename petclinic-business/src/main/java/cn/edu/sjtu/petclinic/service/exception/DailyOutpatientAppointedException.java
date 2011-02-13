package cn.edu.sjtu.petclinic.service.exception;

public class DailyOutpatientAppointedException extends ServiceException {

	private static final long serialVersionUID = -2413169025648430044L;

	public DailyOutpatientAppointedException() {
		super();
	}

	public DailyOutpatientAppointedException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
