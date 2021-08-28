package com.store.grocery.utils;


import java.util.Collection;

import com.store.grocery.dto.GenericRequest;
import com.store.grocery.dto.GenericResponse;

public class ValidateData {

	@SuppressWarnings("rawtypes")
	public static boolean dataNotFound(GenericResponse reponse) {
		boolean validate = true;
		validate = isNullOrEmpty(reponse.getObject());
		if(validate) {
			reponse.setStatusCode(CodesEnum.DATA_NOT_FOUND.getstatusCode());
			reponse.setMessage(CodesEnum.DATA_NOT_FOUND.getMesage());
		}else {
			setStatusOK(reponse);
		}
		
		return validate;
	}
	@SuppressWarnings("rawtypes")
	public static boolean request(GenericRequest request, GenericResponse reponse) {
		boolean validate = false;
		validate = !isNullOrEmpty(request.getObject());
		if(!validate) {
			reponse.setStatusCode(CodesEnum.EMPTY_REQUEST.getstatusCode());
			reponse.setMessage(CodesEnum.EMPTY_REQUEST.getMesage());
		}else {
			setStatusOK(reponse);
		}
		return validate;
	}
	@SuppressWarnings("rawtypes")
	public static boolean request(Integer request, GenericResponse reponse) {
		boolean validate = false;
		validate = !isNullOrEmpty(request);
		if(!validate) {
			reponse.setStatusCode(CodesEnum.EMPTY_REQUEST.getstatusCode());
			reponse.setMessage(CodesEnum.EMPTY_REQUEST.getMesage());
		}else {
			setStatusOK(reponse);
		}
		return validate;
	}
	
	private static boolean isNullOrEmpty(Object obj) {
		boolean validate = false;
		if(obj == null)
			validate = true;
		if(obj instanceof Collection)
			validate = ((Collection<?>) obj).isEmpty();
		
		return validate;
	}
	@SuppressWarnings("rawtypes")
	private static void setStatusOK(GenericResponse reponse) {
		reponse.setStatusCode(CodesEnum.OK.getstatusCode());
		reponse.setMessage(CodesEnum.OK.getMesage());
	}
}
