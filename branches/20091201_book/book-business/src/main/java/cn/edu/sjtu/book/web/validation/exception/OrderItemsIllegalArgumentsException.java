package cn.edu.sjtu.book.web.validation.exception;

public class OrderItemsIllegalArgumentsException extends ValidationException {

	private static final long serialVersionUID = -3283520681973485969L;

	public OrderItemsIllegalArgumentsException() {
		super();
	}

	public OrderItemsIllegalArgumentsException(String message) {
		super(message);
	}

	public OrderItemsIllegalArgumentsException(Throwable cause) {
		super(cause);
	}

	public OrderItemsIllegalArgumentsException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
