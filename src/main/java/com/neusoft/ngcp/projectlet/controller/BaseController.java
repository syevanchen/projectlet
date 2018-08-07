package com.neusoft.ngcp.projectlet.controller;

import org.slf4j.Logger;

public abstract class BaseController {

    private static final long MAX_INFO_TIME = 1000;

    private static final String TAKE_TIME_CONTENT = "系统用时 {} ms, ";

    /**
     * 需要计算是否超过限定时间警告
     */
    void printReturnLog(Logger log, String content, long startTime, Object result) {
        long takeTime = System.currentTimeMillis() - startTime;
        if (MAX_INFO_TIME < takeTime) {
            log.warn(TAKE_TIME_CONTENT + "超过系统定义超长时间 " + MAX_INFO_TIME + "ms, " + content, takeTime, result);
        } else {
            log.info(TAKE_TIME_CONTENT + content, takeTime, result);
        }
    }
}
