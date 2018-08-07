package com.neusoft.ngcp.projectlet.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "接口请求对象", description = "封装接口请求参数的json对象")
@JsonInclude(Include.NON_EMPTY)
public class RequestObject {

}
