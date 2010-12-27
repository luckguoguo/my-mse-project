package cn.edu.sjtu.book.service.exception;

public class BookNotExistsException extends BusinessException {

	private static final long serialVersionUID = 2915031256905962926L;

	public BookNotExistsException() {
		super();
	}

	public BookNotExistsException(String message) {
		super(message);
	}

	public BookNotExistsException(Throwable cause) {
		super(cause);
	}

	public BookNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
