package com.yang.exception;

import com.yang.common.utils.BaseErrorCode;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    private BaseErrorCode errorCode;
	
	public CustomException(String msg) {
		super(msg);
	}
	
	public CustomException(String msg, Throwable e) {
		super(msg, e);
	}
	
	public CustomException(BaseErrorCode errorCode) {
		super(errorCode.code());
		this.errorCode = errorCode;
	}
	
	public BaseErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(BaseErrorCode errorCode) {
		this.errorCode = errorCode;
	}

}
