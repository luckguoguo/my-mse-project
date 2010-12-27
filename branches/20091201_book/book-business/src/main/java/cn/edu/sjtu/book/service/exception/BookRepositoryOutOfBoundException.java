package cn.edu.sjtu.book.service.exception;

public class BookRepositoryOutOfBoundException extends BusinessException {

	private static final long serialVersionUID = -7609754351687066141L;

	public BookRepositoryOutOfBoundException() {
		super();
	}

	public BookRepositoryOutOfBoundException(String message) {
		super(message);
	}

	public BookRepositoryOutOfBoundException(Throwable cause) {
		super(cause);
	}

	public BookRepositoryOutOfBoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
