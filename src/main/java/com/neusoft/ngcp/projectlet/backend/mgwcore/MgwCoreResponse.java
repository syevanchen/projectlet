package com.neusoft.ngcp.projectlet.backend.mgwcore;


public abstract class MgwCoreResponse {

	public static final String CODE_SUCCESS = "success";
	public static final String MSG_SUCCESS = "成功";

	private String code;
	private String msg;
	
	public MgwCoreResponse(){
		success();
	}
	
	protected void error(String sc, String sm) {
		code = sc;
		msg = sm;
	}
	
	protected void success(){
		code = CODE_SUCCESS;
		msg = MSG_SUCCESS;
	}


	public String getCode() {
		return code;
	}
	

	public String getMsg() {
		return msg;
	}
	
	public void setCode(String c){
		code = c;
	}
	
	public void setMsg(String m){
		msg = m;
	}
}
