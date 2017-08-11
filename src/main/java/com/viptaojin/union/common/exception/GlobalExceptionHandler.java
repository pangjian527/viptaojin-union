package com.viptaojin.union.common.exception;

import com.viptaojin.union.common.data.ResultData;
import com.viptaojin.union.common.data.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by pj on 5/5/17.
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData exceptionSysHandler(RuntimeException e, HttpServletResponse response) {
        ResultData resultData = new ResultData();

        resultData.setCode(StatusCode.SYS_FAIL_CODE);
        resultData.setMsg("全局系统操作异常:-->"+e.getMessage());
        logger.error(e.getMessage(),e);
        return resultData;
    }

    @ExceptionHandler(BusException.class)
    @ResponseBody
    public ResultData exceptionBusHandler(RuntimeException e, HttpServletResponse response) {
        ResultData resultData = new ResultData();

        resultData.setCode(StatusCode.BUS_FAIL_CODE);
        resultData.setMsg("全局异常处理业务：-->"+e.getMessage());
        logger.error(e.getMessage(),e);
        return resultData;
    }

}
