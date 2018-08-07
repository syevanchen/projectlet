package com.neusoft.ngcp.projectlet.exception;

import com.neusoft.ngcp.projectlet.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAppException(final Exception e, final WebRequest request) {
        long code = 9;
        String msg = "未知异常";
        if (e instanceof AppException) {
            code = ((AppException) e).getCode();
            msg = ((AppException) e).getMsg();
        }
        log.error("未处理异常，原因：{}", e.getMessage(), e);
        log.error("[Root Exception]", ExceptionUtils.getRootCause(e));
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        //add by lyb 20180411 "3"开头信息返回 Request 为 200 status
        HttpStatus status;
        if (String.valueOf(code).startsWith("3")) {
            status = HttpStatus.OK;
        } else {
            status = code == 4 ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return handleExceptionInternal(e, new Response<>(code, msg == null ? e.getMessage()
                : msg).json(), headers, status, request);
    }
}
