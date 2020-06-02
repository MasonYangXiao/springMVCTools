package com.yang.common;

import com.yang.common.utils.BaseErrorCode;
import com.yang.common.utils.BaseResponse;
import com.yang.exception.CustomException;

import lombok.extern.slf4j.Slf4j;




/**
 * Controlle
 * 
 * @author yangxiaodong
 * @data 
 */
@Slf4j
public class BaseController {
	

	public <T> BaseResponse<T> controllerMethod(BaseControllerManner m,Class<T> clzz,String message) {
		BaseResponse<T> rd = new BaseResponse<>();
		try {
			Object o = m.manner();
			if(o!=null&&clzz.isInstance(o)){
				rd.setData(clzz.cast(o));
		    }
		} catch (CustomException e) {
			log.error(message, e);
			BaseErrorCode errorCode = e.getErrorCode();
			rd.setCode(errorCode.code());
			rd.setMessage(errorCode.message());
		} catch (Exception e) {
			log.error("服务器错误", e);
			rd.setCode("500");
			rd.setMessage("服务器错误");
		}
		return rd;
	}
	
	public BaseResponse<?> controllerMethod(BaseControllerVoidManner m,String message) {
		BaseResponse<?> rd = new BaseResponse<>();
		try {
			 m.manner();
		} catch (CustomException e) {
			BaseErrorCode errorCode = e.getErrorCode();
			rd.setCode(errorCode.code());
			rd.setMessage(errorCode.message());
			log.error(message, e);
		} catch (Exception e) {
			log.error("服务器错误", e);
			rd.setCode("500");
			rd.setMessage("服务器错误");
		}
		return rd;
	}
}
