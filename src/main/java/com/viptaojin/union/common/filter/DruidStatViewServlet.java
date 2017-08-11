package com.viptaojin.union.common.filter;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by pj on 4/21/17.
 */
@WebServlet(urlPatterns="/druid/*",
    initParams={
            @WebInitParam(name="loginUsername",value="viptaojin"),// 用户名
            @WebInitParam(name="loginPassword",value="viptaojin@2017"),// 密码
            @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
    })
public class DruidStatViewServlet extends StatViewServlet {
    private static final long serialVersionUID = -2688872071445249539L;

}
