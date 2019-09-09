package com.cesec.springboot.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * LoginController
 *
 * @author xiangpeng
 * @date 2019/7/31
 */
@Controller
@RequestMapping("")
public class RenderController {

    @RequestMapping("/toUserInfo")
    public String toUserInfo(){
        return "html/UserInfo";
    }

    @RequestMapping("/toDeletedUserInfo")
    public String toDeletedUserInfo() {
        return "html/DeletedUserInfo";
    }
    @RequestMapping("/toCarInfo")
    public String toCarrInfo(){
        return "html/CarInfo";
    }
    @RequestMapping("/toDeletedCarInfo")
    public String toDeletedCarrInfo(){
        return "html/DeletedCarInfo";
    }
    @RequestMapping("/toCareerInfo")
    public String toCareerInfo(){
        return "html/CareerInfo";
    }
    @RequestMapping("/toDeletedCareerInfo")
    public String toDeletedCareerInfo(){
        return "html/DeletedCareerInfo";
    }
    @RequestMapping("/toAddressInfo")
    public String toAddressInfo(){
        return "html/AddressInfo";
    }
    @RequestMapping("/toDeletedAddressInfo")
    public String toDeletedAddressInfo(){
        return "html/DeletedAddressInfo";
    }
    @RequestMapping("/toupdateUserInfo")
    public String toupdateUserInfo(){
        return "html/UpdateUserBaseInfo";
    }
    @RequestMapping("/toAddUserInfo")
    public String toAddUserInfo(){
        return "html/AddUserBaseInfo";
    }
    @RequestMapping("/todetails")
    public String todetails(String rowId, HttpServletRequest request){
        request.getSession().setAttribute("rowId",rowId);
        return "html/UserInfodetails";
    }
    @RequestMapping("/toico")
    public String toico(){
        return "html/unicode";
    }
    @RequestMapping("/getRowId")
    @ResponseBody
    public String getRowId(HttpServletRequest request){
        return (String) request.getSession().getAttribute("rowId");
    }

    @RequestMapping("/toWelcome")
    public  String towelcome(){
        return "html/welcome";
    }
}
