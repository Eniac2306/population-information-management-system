package com.cesec.springboot.system.entity;

import javax.persistence.Table;
import java.sql.Date;
@Table(name = "t_career_info")
public class CareerInfo {
    private int rowId;
    private  int fRowId;
    private int deleteId;
    private String updateBy;
    private String createBy;
    private Date updateTime;
    private Date createTime;
    private int industry;
    private String companyName;
    private String jobName;
    private float time;
    private int userRowId;
    private String userName;
    private String userIdCard;

    public String getNewIndustry() {
        return newIndustry;
    }

    public void setNewIndustry(String newIndustry) {
        this.newIndustry = newIndustry;
    }

    private String newIndustry;

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

    public UserBaseInfo getUserBaseInfo() {
        return userBaseInfo;
    }

    public void setUserBaseInfo(UserBaseInfo userBaseInfo) {
        this.userBaseInfo = userBaseInfo;
    }

    private UserBaseInfo userBaseInfo;

    public CareerInfo() {
    }

    public CareerInfo(int rowId, int fRowId, int deleteId, String updateBy, String createBy, Date updateTime, Date createTime, int industry, String companyName, String jobName, float time, UserBaseInfo userBaseInfo) {
        this.rowId = rowId;
        this.fRowId = fRowId;
        this.deleteId = deleteId;
        this.updateBy = updateBy;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.industry = industry;
        this.companyName = companyName;
        this.jobName = jobName;
        this.time = time;
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

    public int getIndustry() {
        return industry;
    }

    public void setIndustry(int industry) {
        this.industry = industry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
