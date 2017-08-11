package com.viptaojin.union.action;

import com.viptaojin.union.common.data.ResultData;
import com.viptaojin.union.common.data.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pj on 4/21/17.
 */
public class BaseAction {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());


    public ResultData toResultData(StatusCode statusCode, Object obj, String msg){
        ResultData resultData = new ResultData();

        resultData.setData(obj);
        resultData.setCode(statusCode);
        resultData.setMsg(msg);

        return resultData;
    }

    public ResultData toSuccessResultData(Object obj){
        ResultData resultData = new ResultData();

        resultData.setData(obj);
        resultData.setCode(StatusCode.SUCCESS);
        resultData.setMsg("成功");

        return resultData;
    }

    public ResultData busExceptionResultData(String msg){
        ResultData resultData = new ResultData();

        resultData.setData(null);
        resultData.setCode(StatusCode.BUS_FAIL_CODE);
        resultData.setMsg(msg);

        return resultData;
    }

    public ResultData sysExceptionResultData(String msg){
        ResultData resultData = new ResultData();

        resultData.setCode(StatusCode.SYS_FAIL_CODE);
        resultData.setMsg("系统操作异常:-->"+msg);

        return resultData;
    }
}
