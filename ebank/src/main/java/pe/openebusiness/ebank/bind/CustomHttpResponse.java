package pe.openebusiness.ebank.bind;

import java.io.Serializable;

public class CustomHttpResponse implements Serializable {
	
	private Integer statusCode;
	
	private String message;
	
	private StackTraceElement[] stackTrace;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(StackTraceElement[] stackTrace) {
		this.stackTrace = stackTrace;
	}

}
