package com.viptaojin.union.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
