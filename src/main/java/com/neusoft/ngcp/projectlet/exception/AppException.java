package com.neusoft.ngcp.projectlet.exception;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 6788915723539510737L;

	/*
	 * 1:
	 * 2:
	 * 3: 程序适当性检查
	 * 		3101: 自然人找不到
	 * 4: 调用问题（client）
	 * 5: 服务问题（server）
	 * 6: 数据问题
	 * 7: 依赖问题
	 * 8:
	 * 9: 系统问题
	 *
	 */
	private long code;
	private String msg;
	private Exception root;

	public AppException(final long code, final String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public AppException(final long code, final String msg, final Exception e) {
		super(msg, e);
		this.code = code;
		this.msg = msg;
		root = e;
	}

	public long getCode() {
		return code;
	}

	public void setCode(final long code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(final String msg) {
		this.msg = msg;
	}

	public Exception getRoot() {
		return root;
	}

	public void setRoot(final Exception root) {
		this.root = root;
	}
}
