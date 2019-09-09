package com.cesec.springboot.system.service;

import com.cesec.springboot.system.entity.UserInfo;

import java.util.List;

public interface UserLoginService {
        int getUserInfoLogin(String userName,String passWord);
}
