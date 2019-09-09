package com.cesec.springboot.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 李帅龙
 * date 2019/8/20 9:00
 * @version 1.0
 */
@Table(name = "t_people_baseinfo")
public class UserBaseInfo implements Serializable {
    @Id
    @Column(name = "row_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int rowId;
    private String idCard;//身份证
    private String name; //姓名
    private String sex; //性别    字典表查询
    private String newsex;// 实际性别
    private String nation;   //民族   字典表查询
    private String newnation; //实际民族
    private String height;//身高
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bornDate; //出生日期
    //通用字段
    private String createBy;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String createTime;
    private String updateBy;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String updateTime;
    private int deleteId;  //删除标志位  0代表未删除 1代表被删除


    private String birthPlace;   //籍贯
    private String phone; //手机号码
    private String education;//教育程度
    private String politic; //政治面貌
    private String source;//数据来源
    private String extValue;



    public String getNewsex() {
        return newsex;
    }

    public void setNewsex(String newsex) {
        this.newsex = newsex;
    }

    public String getNewnation() {
        return newnation;
    }

    public void setNewnation(String newnation) {
        this.newnation = newnation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    public String getExtValue() {
        return extValue;
    }

    public void setExtValue(String extValue) {
        this.extValue = extValue;
    }

    @Override
    public String toString() {
        return "UserBaseInfo{" +
                "rowId=" + rowId +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", newsex='" + newsex + '\'' +
                ", nation='" + nation + '\'' +
                ", newnation='" + newnation + '\'' +
                ", height='" + height + '\'' +
                ", bornDate=" + bornDate +
                ", createBy='" + createBy + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleteId=" + deleteId +
                ", birthPlace='" + birthPlace + '\'' +
                ", phone='" + phone + '\'' +
                ", education='" + education + '\'' +
                ", politic='" + politic + '\'' +
                ", extValue='" + extValue + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
