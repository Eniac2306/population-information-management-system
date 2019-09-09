package com.cesec.springboot.system.service.impl;

import com.cesec.springboot.system.dao.UserInfoDao;
import com.cesec.springboot.system.entity.UserInfo;
import com.cesec.springboot.system.service.UserInfoService;
import com.cesec.springboot.system.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public int getUserInfoLogin(String userName, String passWord) {
      int num  =  userInfoDao.findUserInfoLogin(userName,passWord);
      return num;
    }
}
