package com.cesec.springboot.system.interceptor;

import com.cesec.springboot.system.entity.UserLogin;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 李帅龙
 * date 2019/8/19 13:54
 * @version 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    //在访问其他接口时先调用该方法进行判断，验证用户的登录状态
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        //获取session中的userlogin对象
        HttpSession session = request.getSession();
        UserLogin userLogin = (UserLogin) session.getAttribute("userlogin");
        //判断该userLogin对象是否为空，如果是空，则代表没有登录
        if(userLogin == null){
            //为空，则返回false
            String url = "/hello";
            response.sendRedirect(url);
            return false;
        }else{
            //非空，则说明已经登录过了
            return true;
        }
    }
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
