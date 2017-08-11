package com.viptaojin.union.common.data;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by pj on 4/25/17.
 */
public enum StatusCode {
    //系统错误
    @ApiModelProperty(value = "系统错误", required = false)
    SYS_FAIL_CODE(1),

    //业务异常
    @ApiModelProperty(value = "业务错误", required = false)
    BUS_FAIL_CODE(2),

    //成功
    @ApiModelProperty(value = "成功", required = false)
    SUCCESS(0);

    private int code ;

    private StatusCode(int i){
        this.code = i;
    }
}
