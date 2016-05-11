package net.devstudy.resume.exception;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
public class CantCompleteClientRequestException extends RuntimeException {
	private static final long serialVersionUID = -2220394963797849800L;

	public CantCompleteClientRequestException(String message) {
		super(message);
	}

	public CantCompleteClientRequestException(Throwable cause) {
		super(cause);
	}

	public CantCompleteClientRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
