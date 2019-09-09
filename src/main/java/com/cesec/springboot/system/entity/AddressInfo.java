package com.cesec.springboot.system.entity;

import javax.persistence.Table;
import java.sql.Date;

@Table(name = "t_address_info")
public class AddressInfo {
    private int rowId;
    private  int fRowId;
    private int deleteId;
    private String updateBy;
    private String createBy;
    private Date updateTime;
    private Date createTime;
    private String province;
    private String city;
    private String area;
    private String details;
    private int isRent;
    private int isResident;
    private int userRowId;
    private String userName;
    String[] staticdatas={"否","是"};
    public String getNewIsRent() {
        return newIsRent;
    }

    public void setNewIsRent(String newIsRent) {
        this.newIsRent = newIsRent;
    }

    public String getNewIsResident() {
        return newIsResident;
    }

    public void setNewIsResident(String newIsResident) {
        this.newIsResident = newIsResident;
    }

    private String newIsRent;
   private String newIsResident;
    public int getUserRowId() {
        return userRowId;
    }

    public void setUserRowId(int userRowId) {
        this.userRowId = userRowId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    private String userIdCard;

    public UserBaseInfo getUserBaseInfo() {
        return userBaseInfo;
    }

    public void setUserBaseInfo(UserBaseInfo userBaseInfo) {
        this.userBaseInfo = userBaseInfo;
    }

    private UserBaseInfo userBaseInfo;

    public AddressInfo() {
    }

    public AddressInfo(int rowId, int fRowId, int deleteId, String updateBy, String createBy, Date updateTime, Date createTime, String province, String city, String area, String details, int isRent, int isResident, UserBaseInfo userBaseInfo) {
        this.rowId = rowId;
        this.fRowId = fRowId;
        this.deleteId = deleteId;
        this.updateBy = updateBy;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.province = province;
        this.city = city;
        this.area = area;
        this.details = details;
        this.isRent = isRent;
        this.isResident = isResident;
        this.userBaseInfo = userBaseInfo;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getfRowId() {
        return fRowId;
    }

    public void setfRowId(int fRowId) {
        this.fRowId = fRowId;
    }

    public int getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getIsRent() {
        return isRent;
    }

    public void setIsRent(int isRent) {
        this.isRent = isRent;
        this.newIsRent=staticdatas[isRent];
    }

    public int getIsResident() {
        return isResident;
    }

    public void setIsResident(int isResident) {
        this.isResident = isResident;
        this.newIsResident=staticdatas[isResident];
    }
}
