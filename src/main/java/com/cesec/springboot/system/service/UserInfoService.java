package com.cesec.springboot.system.service;

import com.cesec.springboot.system.entity.*;
import com.github.pagehelper.PageInfo;
import org.apache.tomcat.jni.Address;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

public interface UserInfoService {
    List<UserInfo> selectMyAll();

    //根据姓名、身份证、民族查询人口基本信息
    PageInfo<UserBaseInfo> selectByOther(String name,String idCard,int nation,int pageNum,int pageSize);
    //根据rowid查询扩展表
    UserBaseInfo selectByRowId(int rowId);
    //根据rowid查询所有表
    UserBaseInfo getAllByRowId(int rowId);

    //删除主表和从表信息
    int deleteUserInfo(int rowId);

    //修改主表和主表扩展表
    int updateUserInfo(int rowId, String idCard, String name, int sex, int nation, int height, Date bornDate,String birth_place,String phone,String education,String politic);
    //增加操作
     void addUserInfo(UserBaseInfo userBaseInfo) throws ParseException;


     //车辆查询根据人查询
    List<CarInfo> selectCarByPeople(int peopleid);
   // List<CarInfo> selectCarByNumber(int carNumber);
    //车牌号查询
   PageInfo<CarInfo> selectCarByCarNumber(String carNumber,String brand,int pageNum,int pageSize);
    //车辆修改
    void updateCar(CarInfo carInfo) throws ParseException;
    //车辆增加
    void addCar(CarInfo carInfo) throws ParseException;
    //删除
    void deleteCar(int rowId);


    //地址表查询根据人查询
    List<AddressInfo> selectAddressByPeople(int peopleid);
    //删除
    PageInfo<AddressInfo> selectAddressByAddress(String province,String city,String area,int pageNum,int pageSize);

    void deleteAddress(int rowId);
    //地址表新增
    void addAddress(AddressInfo addressInfo);
    //地址表修改
    void updateAddress(AddressInfo addressInfo);
    //地址表查询
    //PageInfo<AddressInfo> selectAddressByIndustry(int industry,String company_name,int pageNum,int pageSize);



    //职业表查询根据人查询
    List<CareerInfo> selectCareerByPeople(int peopleid);
    PageInfo<CareerInfo> selectCareerByIndustry(int industry,String company_name,int pageNum,int pageSize);
    //删除
    void deleteCareer(int rowId);
    //新增
    void addCareer(CareerInfo careerInfo);
    //修改
    void updateCareer(CareerInfo careerInfo);







}
