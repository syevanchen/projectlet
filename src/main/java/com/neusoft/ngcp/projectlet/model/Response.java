package com.neusoft.ngcp.projectlet.model;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("服务应答数据对象")
public class Response<T> {

	public static Response<Void> OK = new Response<>();

	@ApiModelProperty("响应代码，\"0\" 正常，其他值为错误代码")
	private long code;

	@ApiModelProperty("响应消息，\"ok\" 正常，其他值为错误消息")
	private String msg;

	@ApiModelProperty("应答数据")
	private T value;

	public Response() {
		this.code = 0;
		this.msg = "ok";
	}

	public Response(final long code, final String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Response(final long code, final String msg, final T t) {
		this.code = code;
		this.msg = msg;
		this.value = t;
	}

	public Response(final T t) {
		this.code = 0;
		this.msg = "ok";
		this.value = t;
	}

	public String json() {
		return new Gson().toJson(this);
	}
}
