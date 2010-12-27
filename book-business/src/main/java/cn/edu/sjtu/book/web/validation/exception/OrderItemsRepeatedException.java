package cn.edu.sjtu.book.web.validation.exception;


public class OrderItemsRepeatedException extends ValidationException {

	private static final long serialVersionUID = -2134358415261485873L;

	public OrderItemsRepeatedException() {
		super();
	}

	public OrderItemsRepeatedException(String message) {
		super(message);
	}

	public OrderItemsRepeatedException(Throwable cause) {
		super(cause);
	}

	public OrderItemsRepeatedException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
