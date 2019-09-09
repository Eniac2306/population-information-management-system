package com.cesec.springboot.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.cesec.springboot.system.entity.UserLogin;
import com.cesec.springboot.system.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 李帅龙
 * date 2019/8/19 13:43
 * @version 1.0
 */
@Controller
public class UserLoginController {
    UserLogin userlogin = new UserLogin();

    @Autowired
    private UserLoginService userLoginService;


    @RequestMapping("/hello")
    //重定向到登录页面
    public String hello(){
        return "html/loginIndex";
    }
//    public String hello(){
//        return "html/demo";
//    }


    @RequestMapping("/first/login")
     @ResponseBody
    //登录验证，目前未完成的是防止用户重复登录
    public JSONObject login(String userName, String passWord,HttpServletRequest request){
        //将userName和passWord拿去数据库查询，是否存在此用户
     int flag =  userLoginService.getUserInfoLogin(userName,passWord);
        JSONObject jsonObject = new JSONObject();
     if(flag>0){
        //说明存在该用户
         //获取传过来的userName和passWord
//         UserLogin userlogin = new UserLogin();
         userlogin.setUserName(userName);
         userlogin.setPassWord(passWord);
         //在session中放入对象
         request.getSession().setAttribute("userlogin",userlogin);
         //定义跳转页面
        String url = "toIndex";
        String message = "登录成功！";
        jsonObject.put("url",url);
        jsonObject.put("message",message);
    }else{
       String message = "用户名或密码错误！";
       jsonObject.put("message",message);
     }
     jsonObject.put("flag",flag);;
     return jsonObject;
   }

    @RequestMapping("/toIndex")
    //重定向到登录成功后的首页
    public String toIndex(){
        return "html/Index";
    }

    @RequestMapping("/toFindPassWord")
    //重定向到找回密码页面
    public String toFindPassWord(){
        return "html/FindPassWord";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public JSONObject loginout(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        HttpSession session = request.getSession(false);
        session.removeAttribute("userlogin");
        jsonObject.put("message","退出成功！");
        jsonObject.put("status","200");
        return jsonObject;
    }

    @RequestMapping("/getLoginUser")
    @ResponseBody
    public JSONObject getLoginUser(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName", userlogin.getUserName());
        return jsonObject;
    }

}
