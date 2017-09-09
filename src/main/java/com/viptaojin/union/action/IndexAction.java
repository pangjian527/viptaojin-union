package com.viptaojin.union.action;

import com.viptaojin.union.common.data.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by pj on 5/10/17.
 */
@Controller
public class IndexAction extends BaseAction{

    @RequestMapping("/")
    public String execute(HttpSession session, Model model){
        System.out.println("欢迎使用vip淘金网");
        return "index";
    }

    @RequestMapping("/applet")
    @ResponseBody
    public ResultData wxApplet(){
        System.out.println("请求成功");
        return toSuccessResultData("返回成功");
    }
}
