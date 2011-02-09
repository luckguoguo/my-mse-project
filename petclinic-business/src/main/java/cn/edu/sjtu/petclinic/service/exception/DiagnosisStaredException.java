package cn.edu.sjtu.petclinic.service.exception;

public class DiagnosisStaredException extends ServiceException {

	private static final long serialVersionUID = -5339033450899268653L;

	public DiagnosisStaredException() {
		super();
	}

	public DiagnosisStaredException(String message, Throwable cause) {
		super(message, cause);
	}

}
