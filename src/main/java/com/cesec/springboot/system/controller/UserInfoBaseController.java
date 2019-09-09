package com.cesec.springboot.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.cesec.springboot.system.entity.*;
import com.cesec.springboot.system.service.UserInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * LoginController
 *
 * @author xiangpeng
 * @date 2019/7/31
 */
@Controller
//人口基本信息页
public class UserInfoBaseController {
    @Autowired
    private UserInfoService userInfoService;
    //根据姓名或身份证或民族进行查询
    @RequestMapping("FindPageByOthers")
    @ResponseBody
    public PageInfoNew FindPageByOthers(String name,String idCard,String nation,int page,int limit){
        //传入五个参数，分别是姓名，身份证，民族，当前页面，页面大小
        //传入的nation民族已经是int类型
        //接下来判断传入的姓名、身份证、民族是否为空
        int real_nation = 0;
        if(nation==null||"".equals(nation)){
            real_nation = 0;
        }else{
            real_nation = Integer.valueOf(nation);
        }
        System.out.println("page,limit"+page+limit);
        PageInfo<UserBaseInfo> pageInfo = userInfoService.selectByOther(name, idCard, real_nation, page, limit);
        PageInfoNew pageInfoNew = new PageInfoNew(pageInfo.getTotal(), pageInfo.getList());
        return pageInfoNew;
    }


    //对表进行删除操作
    @RequestMapping("deleteUserInfoList")
    @ResponseBody
    public int deleteUserInfodd(String id){
        //rowId先转成int类型
        System.out.println(id);
        String string[]=id.split(",");
        System.out.println(string);
        for(int i=0;i<string.length-1;i++){
            userInfoService.deleteUserInfo(Integer.valueOf(string[i]));
        }
//        int status = userInfoService.deleteUserInfo(Integer.valueOf(rowId));
//       JSONObject jsonObject = new JSONObject();
//       jsonObject.put("status",status);
        return  1;
    }
    //对表进行删除操作
    @RequestMapping("deleteUserInfo")
    @ResponseBody
    public JSONObject deleteUserInfo(String rowId){
        //rowId先转成int类型
        int status = userInfoService.deleteUserInfo(Integer.valueOf(rowId));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",status);
        return  jsonObject;
    }
    /**
     * xufeng
     * @param
     * @return
     */
    //对表进行修改操作
    @RequestMapping("updateUserInfo")
    @ResponseBody
    public int updateUserInfo(UserBaseInfo userBaseInfo) throws ParseException {

        int rowId=userBaseInfo.getRowId();
        String name=userBaseInfo.getName();
        String idCard=userBaseInfo.getIdCard();
        String sex=userBaseInfo.getNewsex();
        int sex1=Integer.valueOf(sex);
        String  nation=userBaseInfo.getNewnation();
        int nation1=Integer.valueOf(nation);
        String height=userBaseInfo.getHeight();
        int height1=Integer.valueOf(height);
        Date bornDate=userBaseInfo.getBornDate();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bornDate);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date d = format1.parse(format);

        java.sql.Date date=new java.sql.Date(d.getTime());  //把java.util.Date转换成java.sql.Date


        String birth_place=userBaseInfo.getBirthPlace();
        String phone=userBaseInfo.getPhone();
        String education=userBaseInfo.getEducation();

        String politic=userBaseInfo.getPolitic();
        int flag=userInfoService.updateUserInfo(rowId,idCard,name,sex1,nation1,height1, date,birth_place,phone,education,politic);
        return  flag;
    }
    @RequestMapping("AddUser")
    @ResponseBody
    public int addUserInfo(UserBaseInfo userBaseInfo) throws ParseException {
        userInfoService.addUserInfo(userBaseInfo);
        return 1;
    }
    //详情
    @RequestMapping("getAllInfo")
    @ResponseBody
    public JSONObject peopledetailsInfo(Integer rowId) throws ParseException {
      JSONObject jsonObject=new JSONObject();
      int row_id=Integer.valueOf(rowId);
        UserBaseInfo userBaseInfo=userInfoService.getAllByRowId(rowId);
        List<AddressInfo> addressInfoList=userInfoService.selectAddressByPeople(row_id);
        List<CarInfo> carInfoList=userInfoService.selectCarByPeople(row_id);
        List<CareerInfo> careerInfoList=userInfoService.selectCareerByPeople(row_id);
        jsonObject.put("addressInfoList",addressInfoList);
        jsonObject.put("carInfoList",carInfoList);
        jsonObject.put("careerInfoList",careerInfoList);
        jsonObject.put("userBaseInfo",userBaseInfo);
        return jsonObject;
    }




    //车牌查车
    @RequestMapping("selectCarByNumber")
    @ResponseBody
    public PageInfoNew selectCarByNumber(String carNumber, String brand,int page,int limit) throws ParseException{

        JSONObject jsonObject=new JSONObject();
        PageInfo<CarInfo> pageInfo=userInfoService.selectCarByCarNumber(carNumber,brand, page, limit);
        PageInfoNew pageInfoNew = new PageInfoNew(pageInfo.getTotal(), pageInfo.getList());



        return pageInfoNew;

    }

    //车辆表修改
    @RequestMapping("carModify")
    @ResponseBody
    public  int updateCar(@RequestBody CarInfo carInfo) throws ParseException {
        userInfoService.updateCar(carInfo);
        return 1;
    }
    @RequestMapping("carAdd")
    @ResponseBody
    public int addCar(@RequestBody CarInfo carInfo) throws ParseException {
        //System.out.println(carInfo.toString());
        userInfoService.addCar(carInfo);
        return 1;
    }

    //车辆表删除
    @RequestMapping("carDelete")
    @ResponseBody
    public int deleteCar(String rowId){

        userInfoService.deleteCar(Integer.valueOf(rowId));
    return 1;
    }
    //职业表删除
    @RequestMapping("careerDelete")
    @ResponseBody
    public int deleteCareer(String rowId){

        userInfoService.deleteCareer(Integer.valueOf(rowId));
        return 1;
    }
    //地址表删除
    @RequestMapping("addressDelete")
    @ResponseBody
    public int deleteAddress(String rowId){

        userInfoService.deleteAddress(Integer.valueOf(rowId));
        return 1;
    }



    //职业表修改
    @RequestMapping("careerModify")
    @ResponseBody
    public  int updateCareer(@RequestBody CareerInfo careerInfo) throws ParseException {
        userInfoService.updateCareer(careerInfo);
        return 1;
    }
    //职业表新增
    @RequestMapping("careerAdd")
    @ResponseBody
    public int addCareer(@RequestBody CareerInfo careerInfo) throws ParseException {
        //System.out.println(carInfo.toString());
        userInfoService.addCareer(careerInfo);
        return 1;
    }
    //职业表
    @RequestMapping("selectCareerByIndustry")
    @ResponseBody
    public PageInfoNew selectCareerByIndustry(String industry, String companyName,int page,int limit) throws ParseException{

        //JSONObject jsonObject=new JSONObject();
        if(industry==null||industry.equals("")){
            industry="0";
        }
        PageInfo<CareerInfo> pageInfo=userInfoService.selectCareerByIndustry(Integer.valueOf(industry),companyName, page, limit);
        PageInfoNew pageInfoNew = new PageInfoNew(pageInfo.getTotal(), pageInfo.getList());



        return pageInfoNew;

    }

    //地址表修改
    @RequestMapping("addressModify")
    @ResponseBody
    public  int updateAddress(@RequestBody AddressInfo addressInfo) throws ParseException {
        userInfoService.updateAddress(addressInfo);
        return 1;
    }
    //地址表新增
    @RequestMapping("addressAdd")
    @ResponseBody
    public int addAddress(@RequestBody AddressInfo addressInfo) throws ParseException {
        //System.out.println(carInfo.toString());
        userInfoService.addAddress(addressInfo);
        return 1;
    }

    //车牌查车
    @RequestMapping("selectAddressByAddress")
    @ResponseBody
    public PageInfoNew selectAddressByAddress(String province, String city,String area,int page,int limit) throws ParseException{

        //JSONObject jsonObject=new JSONObject();
        PageInfo<AddressInfo> pageInfo=userInfoService.selectAddressByAddress(province,city,area, page, limit);
        PageInfoNew pageInfoNew = new PageInfoNew(pageInfo.getTotal(), pageInfo.getList());



        return pageInfoNew;

    }
}
