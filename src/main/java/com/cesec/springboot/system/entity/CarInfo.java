package com.cesec.springboot.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.sql.Date;
import java.util.List;
@Table(name = "t_car_info")
public class CarInfo {
    private int rowId;
    private int fRowId;
    private String carNumber;
    private String brand;
    private String model;
    private String color;
    private float price;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buyDate;
    private int deleteId;
    private String updateBy;
    private String createBy;
    private Date updateTime;
    private Date createTime;
    private List<UserBaseInfo> userBaseInfoList;
    private String newPrice;

    public UserBaseInfo getUserBaseInfo() {
        return userBaseInfo;
    }

    public void setUserBaseInfo(UserBaseInfo userBaseInfo) {
        this.userBaseInfo = userBaseInfo;
    }

    private UserBaseInfo userBaseInfo;
    private int userRowId;
    private String userName;

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

    public CarInfo() {
    }

    public CarInfo(int rowId, int fRowId, String carNumber, String brand, String model, String color, float price, Date buyDate, int deleteId, String updateBy, String createBy, Date updateTime, Date createTime, List<UserBaseInfo> userBaseInfoList, UserBaseInfo userBaseInfo, int userRowId, String userName, String userIdCard) {
        this.rowId = rowId;
        this.fRowId = fRowId;
        this.carNumber = carNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.buyDate = buyDate;
        this.deleteId = deleteId;
        this.updateBy = updateBy;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.userBaseInfoList = userBaseInfoList;
        this.userBaseInfo = userBaseInfo;
        this.userRowId = userRowId;
        this.userName = userName;
        this.userIdCard = userIdCard;
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

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
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

    public List<UserBaseInfo> getUserBaseInfoList() {
        return userBaseInfoList;
    }

    public void setUserBaseInfoList(List<UserBaseInfo> userBaseInfoList) {
        this.userBaseInfoList = userBaseInfoList;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }
}
