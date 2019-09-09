package com.cesec.springboot.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LoginController
 *
 * @author xiangpeng
 * @date 2019/7/31
 */
@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping("/500")
    public String error1(){
        return "html/500";
    }

    @RequestMapping("/403")
    public String error2(){
        return "html/403";
    }

    @RequestMapping("/404")
    public String error3(){
        return "html/404";
    }

    @RequestMapping("/jsp")
    public String jsp(){
        return "index";
    }


}
