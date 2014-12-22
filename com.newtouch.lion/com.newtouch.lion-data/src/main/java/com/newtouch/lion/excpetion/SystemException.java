/*
 * Copyright (c)  2013, lion
 * All rights reserved. 
 *
 * $id: SystemException.java 9552 2013-4-7 下午12:05:36 WangLijun$
 */
package com.newtouch.lion.excpetion;

import org.springframework.core.NestedRuntimeException;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company: lion
 * </p>
 * 
 * @author WangLijun
 * @version 1.0
 */
public class SystemException extends NestedRuntimeException {

	
	private static final long serialVersionUID = -1490742393672145880L;

	/** 错误代码 */
	private String code;
	/** 参数 */
	private Object[] params;

	public SystemException(String code) {
		this(code, null, null);
	}

	public SystemException(String code, String param) {
		this(code, new String[] { param });
	}

	public SystemException(String code, String[] params) {
		this(code, params, null);
	}

	public SystemException(String code, String[] params, Throwable cause) {
		super(code, cause);
		this.code = code;
		this.params = params;
	}

	@Deprecated
	public SystemException(String code, String[] params, String defaultMessage,
			Throwable cause) {
		super(defaultMessage, cause);
		this.code = code;
		this.params = params;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the params
	 */
	public Object[] getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}
	
	
	
}