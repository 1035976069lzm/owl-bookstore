package cn.net.bysoft.owl.bookstore.facade.user.exception;

import cn.net.bysoft.owl.bookstore.common.exception.BaseException;

public class EmailAlreadyExistsException extends BaseException {

	private static final long serialVersionUID = 32073650414581085L;

	public EmailAlreadyExistsException(String msg) {
		super(new RuntimeException(msg), UserExceptionCodeFactory.EMAIL_ALREADY_EXISTS, msg);
	}

	public EmailAlreadyExistsException(Throwable cause, String msg) {
		super(cause, UserExceptionCodeFactory.EMAIL_ALREADY_EXISTS, msg);
	}

	@Override
	public Throwable getCause() {
		return super.getCause();
	}

}
