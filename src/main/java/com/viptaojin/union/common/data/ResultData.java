package com.viptaojin.union.common.data;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by pj on 4/23/17.
 */
public class ResultData<T> {

    @ApiModelProperty(value = "错误编码（sysfail=系统错误，需要前段特殊处理,bisfail=业务错误，直接显示错误信息,success）", required = false)
    private StatusCode code ;

    @ApiModelProperty(value = "具体的错误信息", required = false)
    private String msg;

    @ApiModelProperty(value = "业务信息", required = false)
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public StatusCode getCode() {
        return code;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
