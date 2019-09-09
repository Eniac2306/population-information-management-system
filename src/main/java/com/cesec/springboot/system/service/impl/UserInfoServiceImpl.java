package com.cesec.springboot.system.service.impl;

import com.cesec.springboot.common.utils.StringToMap;
import com.cesec.springboot.system.dao.UserInfoDao;
import com.cesec.springboot.system.entity.*;
import com.cesec.springboot.system.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    //获取表中扩展字段
    public String exValue;

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> selectMyAll() {
        return userInfoDao.selectAll();
    }

    //主表查询查询语句
    @Override
    public PageInfo<UserBaseInfo> selectByOther(String userName, String idCard, int
                nation,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //接下来对name，idCard，nation进行判断是否为空
        //默认是查询所有
        PageInfo<UserBaseInfo> pageInfo = new PageInfo<>(userInfoDao.getAll());
        if (userName != null && !"".equals(userName)) {
            //姓名不为空
            if (idCard != null && !"".equals(idCard)) {
                //身份证不为空
                if (nation != 0) {
                    //民族不为空
                    PageHelper.startPage(pageNum, pageSize);
                    pageInfo = new PageInfo<>(userInfoDao.getAllByNameAndIdCardAndNation(userName, idCard, nation));
                } else {
                    //民族为空
                    PageHelper.startPage(pageNum, pageSize);
                    pageInfo = new PageInfo<>(userInfoDao.getAllByNameAndIdCard(userName, idCard));
                }
            } else {
                //身份证为空
                if (nation != 0) {
                    //民族不为空
                    PageHelper.startPage(pageNum, pageSize);
                    pageInfo = new PageInfo<>(userInfoDao.getAllByNameAndNation(userName, nation));
                } else {
                    //民族为空
                    PageHelper.startPage(pageNum, pageSize);
                    pageInfo = new PageInfo<>(userInfoDao.getAllByName(userName));
                }
            }
        } else {
            //姓名为空
            if (idCard != null && !"".equals(idCard)) {
                //身份证不为空
                if (nation != 0) {
                    //民族不为空
                    PageHelper.startPage(pageNum, pageSize);
                    pageInfo = new PageInfo<>(userInfoDao.getAllByIdCardAndNation(idCard, nation));
                } else {
                    //民族为空
                    PageHelper.startPage(pageNum, pageSize);
                    pageInfo = new PageInfo<>(userInfoDao.getAllByIdCard(idCard));
                }
            } else {
                //身份证为空
                if (nation != 0) {
                    //民族不为空
                    PageHelper.startPage(pageNum, pageSize);
                    pageInfo = new PageInfo<>(userInfoDao.getAllByNation(nation));
                } else {
                    //民族为空
                    //不做操作，查询所有
                }
            }
        }
        List<UserBaseInfo> list = pageInfo.getList();
        for (int k = 0; k < list.size(); k++) {
            //遍历list,对每个a的额外值进行拆分
            String birthPlace = "";   //出生地
            String phone = ""; //手机号码
            String education = "";//教育程度
            String politic = ""; //政治面貌
            String source = "";//数据来源
            String height = "";//身高

            String extValue = list.get(k).getExtValue();
            if(extValue!=null){
            //将extValue 转成json格式
            extValue = extValue.substring(1, extValue.length() - 1);
            String string[] = extValue.split(",");
            int lenth = string.length;
            //寻找是否存在出生地
            for (int i = 0; i < lenth; i++) {
                String b = string[i];
                if (b.indexOf("birth_place") != -1) {
                    //包含出生地
                    //切割字符串
                    String bstr[] = b.split("=");
                    birthPlace = bstr[1];
                }
                if (b.indexOf("phone") != -1) {
                    //包含手机号码
                    //切割字符串
                    String bstr[] = b.split("=");
                    phone = bstr[1];
                }
                if (b.indexOf("education") != -1) {
                    //包含教育程度
                    //切割字符串
                    String bstr[] = b.split("=");
                    education = bstr[1];
                }
                if (b.indexOf("politic") != -1) {
                    //包含政治面貌
                    //切割字符串
                    String bstr[] = b.split("=");
                    politic = bstr[1];
                }
                if (b.indexOf("userName") != -1) {
                    //包含数据来源
                    //切割字符串
                    String bstr[] = b.split("=");
                    source = bstr[1];
                }
                if (b.indexOf("height") != -1) {
                    //包含身高
                    //切割字符串
                    String bstr[] = b.split("=");
                    height = bstr[1];
                }
                if (b.indexOf("hight") != -1) {
                    //包含身高
                    //切割字符串
                    String bstr[] = b.split("=");
                    height = bstr[1];
                }
            }
            list.get(k).setBirthPlace(birthPlace);
            list.get(k).setPhone(phone);
            list.get(k).setEducation(education);
            list.get(k).setPolitic(politic);
            list.get(k).setSource(source);
            if (list.get(k).getHeight() == null || "".equals(list.get(k).getHeight())) {
                list.get(k).setHeight(height);

            }
        }
        }
            pageInfo.setList(list);
            return pageInfo;
        }

    @Override
    public UserBaseInfo selectByRowId(int rowId) {
        UserBaseInfo userBaseInfo=userInfoDao.selectByrowid(rowId);
        return userBaseInfo;
    }

    @Override
    public UserBaseInfo getAllByRowId(int rowId) {
        UserBaseInfo userBaseInfo = userInfoDao.getAllByRowId(rowId);
        String extValue = userBaseInfo.getExtValue();
        String birthPlace = "";   //出生地
        String phone = ""; //手机号码
        String education = "";//教育程度
        String politic = ""; //政治面貌
        String source = "";//数据来源
        String height = "";//身高
        if (extValue != null) {
            //将extValue 转成json格式
            extValue = extValue.substring(1, extValue.length() - 1);
            String string[] = extValue.split(",");
            int lenth = string.length;
            //寻找是否存在出生地
            for (int i = 0; i < lenth; i++) {
                String b = string[i];
                if (b.indexOf("birth_place") != -1) {
                    //包含出生地
                    //切割字符串
                    String bstr[] = b.split("=");
                    birthPlace = bstr[1];
                }
                if (b.indexOf("phone") != -1) {
                    //包含手机号码
                    //切割字符串
                    String bstr[] = b.split("=");
                    phone = bstr[1];
                }
                if (b.indexOf("education") != -1) {
                    //包含教育程度
                    //切割字符串
                    String bstr[] = b.split("=");
                    education = bstr[1];
                }
                if (b.indexOf("politic") != -1) {
                    //包含政治面貌
                    //切割字符串
                    String bstr[] = b.split("=");
                    politic = bstr[1];
                }
                if (b.indexOf("userName") != -1) {
                    //包含数据来源
                    //切割字符串
                    String bstr[] = b.split("=");
                    source = bstr[1];
                }
                if (b.indexOf("height") != -1) {
                    //包含身高
                    //切割字符串
                    String bstr[] = b.split("=");
                    height = bstr[1];
                }
                if (b.indexOf("hight") != -1) {
                    //包含身高
                    //切割字符串
                    String bstr[] = b.split("=");
                    height = bstr[1];
                }
            }

        }
        userBaseInfo.setBirthPlace(birthPlace);
        userBaseInfo.setPhone(phone);
        userBaseInfo.setEducation(education);
        userBaseInfo.setPolitic(politic);
        userBaseInfo.setSource(source);
        if (userBaseInfo.getHeight() == null || "".equals(userBaseInfo.getHeight())) {
            userBaseInfo.setHeight(height);

        }
        return userBaseInfo;
    }
    //删除主表和从表指定数据


    @Override
    public int deleteUserInfo(int rowId) {
        //先删除从表数据，若删除成功，再删除主表数据
      userInfoDao.deleteUserCareerInfo(rowId);
        userInfoDao.deleteUserCarInfo(rowId);
        userInfoDao.deleteUserAddressInfo(rowId);
     userInfoDao.deleteUserBaseInfo(rowId);
        return 1;
    }

    @Override
    public int updateUserInfo(int rowId, String idCard, String name, int sex, int nation,int height, Date bornDate, String birth_place,String phone,String education,String politic) {
        int flag;
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String updateTime=dateFormat.format(calendar.getTime());
        UserBaseInfo userBaseInfo=userInfoDao.selectByrowid(rowId);
        exValue=userBaseInfo.getExtValue();
        //扩展字段String转map
        StringToMap tool=new StringToMap();
        HashMap map=tool.ToMap(exValue);
        map.put("birth_place",birth_place);
        map.put("phone",phone);
        map.put("education",education);
        map.put("politic",politic);
        String extValue=map.toString();
        String updateBy="lsl";
        userInfoDao.updateUserBaseInfo(rowId,idCard,name,sex,nation, height,bornDate,updateBy);
        int f_rowId=rowId;
        userInfoDao.updateUserExInfo(f_rowId,extValue);
        return 1;
    }

    @Override
    public void addUserInfo(UserBaseInfo userBaseInfo) throws ParseException {
        int rowId=userInfoDao.selectMaxRowId().getRowId()+1;
        String id_card=userBaseInfo.getIdCard();
        String name=userBaseInfo.getName();
        String sex=userBaseInfo.getNewsex();
        int sex1=Integer.valueOf(sex);
        String nation=userBaseInfo.getNewnation();
        int nation1=Integer.valueOf(nation);
        String height=userBaseInfo.getHeight();
        int height1=Integer.valueOf(height);
        //java.util.Date date=userBaseInfo.getBornDate();
        java.util.Date bornDate=userBaseInfo.getBornDate();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bornDate);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date d = format1.parse(format);

        java.sql.Date date=new java.sql.Date(d.getTime());
        userInfoDao.addUserInfo(rowId,id_card,name,sex1,nation1,height1,date);
        String birth_place=userBaseInfo.getBirthPlace();
        String phone=userBaseInfo.getPhone();
        String politic=userBaseInfo.getPolitic();
        String education=userBaseInfo.getEducation();
        HashMap map=new HashMap();
        map.put("birth_place",birth_place);
        map.put("phone",phone);
        map.put("education",education);
        map.put("politic",politic);
        String extValue=map.toString();
        userInfoDao.addUserExInfo(rowId,extValue);



    }

    //TODO
    @Override
    public List<CarInfo> selectCarByPeople(int peopleid) {
        List<CarInfo> list = userInfoDao.selectCarByPeopleId(peopleid);
        for(int i=0;i<list.size();i++) {
            CarInfo carInfo = list.get(i);
            DecimalFormat df = new DecimalFormat(".00");
            float price = (float) carInfo.getPrice();
            String newPrice = df.format(price / 10000);
            carInfo.setNewPrice(newPrice);
        }
        return list;
    }

    //TODO
    @Override
    public PageInfo<CarInfo> selectCarByCarNumber(String carNumber,String brand,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<CarInfo> list = userInfoDao.selectCarByCarNumber(carNumber,brand);
        for(int i=0;i<list.size();i++){
            CarInfo carInfo=list.get(i);
            DecimalFormat df = new DecimalFormat(".00");
            float price = (float) carInfo.getPrice();
            String newPrice = df.format(price/10000);
            carInfo.setNewPrice(newPrice);
            //根据车查询人
            int rowId=carInfo.getfRowId();
            UserBaseInfo userBaseInfo=userInfoDao.getAllByRowId(rowId);

            carInfo.setUserBaseInfo(userBaseInfo);
            carInfo.setUserRowId(userBaseInfo.getRowId());
            carInfo.setUserIdCard(userBaseInfo.getIdCard());
            carInfo.setUserName(userBaseInfo.getName());
        }

        return new PageInfo<CarInfo>(list);
    }

    @Override
    public void updateCar(CarInfo carInfo) throws ParseException {
        int rowId=carInfo.getRowId();
        String brand=carInfo.getBrand();
        String carNumber=carInfo.getCarNumber();
        String model=carInfo.getModel();
        String color=carInfo.getColor();
        Float price=carInfo.getPrice();
        Date buyDate=carInfo.getBuyDate();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(buyDate);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date d = format1.parse(format);

        java.sql.Date date=new java.sql.Date(d.getTime());
        userInfoDao.updateCar(rowId,carNumber,brand,model,color,price,buyDate);
    }

    @Override
    public void addCar(CarInfo carInfo) throws ParseException {
        int fRowId=carInfo.getfRowId();
        String brand=carInfo.getBrand();
        String carNumber=carInfo.getCarNumber();
        String model=carInfo.getModel();
        String color=carInfo.getColor();
        Float price=carInfo.getPrice();
        Date buyDate=carInfo.getBuyDate();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(buyDate);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date d = format1.parse(format);

        java.sql.Date date=new java.sql.Date(d.getTime());
        userInfoDao.addCar(fRowId,carNumber,brand,model,color,price,buyDate);
    }

    @Override
    public void deleteCar(int rowId) {
        userInfoDao.deleteUserCarInfo(rowId);
    }

//    @Override
//    public CarInfo selectCarByCarId(String carNumber) {
//        return null;
//    }

    @Override
    public List<AddressInfo> selectAddressByPeople(int peopleid) {
        return userInfoDao.selectAddressByPeopleId(peopleid);
    }

    @Override
    public PageInfo<AddressInfo> selectAddressByAddress(String province, String city,String area, int pageNum, int pageSize) {
        String[] isRents={"否","是"};
        PageHelper.startPage(pageNum, pageSize);
        List<AddressInfo> list = userInfoDao.selectAddressByAddress(province,city,area);
        for(int i=0;i<list.size();i++){
            AddressInfo addressInfo=list.get(i);
            //根据车查询人
            int rowId=addressInfo.getfRowId();
            UserBaseInfo userBaseInfo=userInfoDao.getAllByRowId(rowId);
            addressInfo.setUserBaseInfo(userBaseInfo);
            addressInfo.setUserRowId(userBaseInfo.getRowId());
            addressInfo.setUserIdCard(userBaseInfo.getIdCard());
            addressInfo.setUserName(userBaseInfo.getName());
            //userBaseInfo=userInfoDao.getAllByRowId(rowId);
            addressInfo.setUserBaseInfo(userBaseInfo);
        }

        return new PageInfo<AddressInfo>(list);
    }

    @Override
    public void deleteAddress(int rowId) {
        userInfoDao.deleteUserAddressInfo(rowId);

    }

    @Override
    public void addAddress(AddressInfo addressInfo) {
        int fRowId=addressInfo.getfRowId();
        String province=addressInfo.getProvince();
        String city=addressInfo.getCity();
        String area=addressInfo.getArea();
        String details=addressInfo.getDetails();
        int isRent=addressInfo.getIsRent();
        int isResident=addressInfo.getIsResident();
        userInfoDao.addAddress(fRowId,province,city,area,details,isRent,isResident);
    }

    @Override
    public void updateAddress(AddressInfo addressInfo) {
        int rowId=addressInfo.getRowId();
        String province=addressInfo.getProvince();
        String city=addressInfo.getCity();
        String area=addressInfo.getArea();
        String details=addressInfo.getDetails();
        int isRent=addressInfo.getIsRent();
        int isResident=addressInfo.getIsResident();
        userInfoDao.updateAddress(rowId,province,city,area,details,isRent,isResident);
    }

    @Override
    public List<CareerInfo> selectCareerByPeople(int peopleid) {
        return userInfoDao.selectCareerByPeopleId(peopleid);
    }

    @Override
    public PageInfo<CareerInfo> selectCareerByIndustry(int industry, String company_name, int pageNum, int pageSize) {
       PageHelper.startPage(pageNum, pageSize);
        List<CareerInfo> list = userInfoDao.selectCareerByIndustry(industry,company_name);
        for(int i=0;i<list.size();i++){
            CareerInfo careerInfo=list.get(i);
            //根据车查询人
            int rowId=careerInfo.getfRowId();
            UserBaseInfo userBaseInfo=userInfoDao.getAllByRowId(rowId);
            careerInfo.setUserBaseInfo(userBaseInfo);
            careerInfo.setUserRowId(userBaseInfo.getRowId());
            careerInfo.setUserIdCard(userBaseInfo.getIdCard());
            careerInfo.setUserName(userBaseInfo.getName());
            //userBaseInfo=userInfoDao.getAllByRowId(rowId);
            careerInfo.setUserBaseInfo(userBaseInfo);
        }

        return new PageInfo<CareerInfo>(list);
    }

    @Override
    public void deleteCareer(int rowId) {
        userInfoDao.deleteUserCareerInfo(rowId);
    }

    @Override
    public void addCareer(CareerInfo careerInfo) {
        int fRowId=careerInfo.getfRowId();
        int industry=careerInfo.getIndustry();
        String companyName=careerInfo.getCompanyName();
        String jobName=careerInfo.getJobName();
        float time=careerInfo.getTime();
        userInfoDao.addCareer(fRowId,industry,companyName,jobName,time);

    }

    @Override
    public void updateCareer(CareerInfo careerInfo) {
        int rowId=careerInfo.getRowId();
        int industry=careerInfo.getIndustry();
        String companyName=careerInfo.getCompanyName();
        String jobName=careerInfo.getJobName();
        float time=careerInfo.getTime();
        userInfoDao.updateCareer(rowId,industry,companyName,jobName,time);
    }
}
