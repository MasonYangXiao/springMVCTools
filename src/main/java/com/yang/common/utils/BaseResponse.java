package com.yang.common.utils;

import lombok.Data;

@Data
public class BaseResponse<T> {

	private String code;
	
	private String message;
	
	private T data;
	
}
