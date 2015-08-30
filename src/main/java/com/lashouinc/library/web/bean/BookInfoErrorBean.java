package com.lashouinc.library.web.bean;

public class BookInfoErrorBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String msg;
	private Integer code;
	private String request;

    public BookInfoErrorBean() {}
    public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	
}
