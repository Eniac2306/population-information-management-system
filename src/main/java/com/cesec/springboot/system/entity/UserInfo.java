package com.cesec.springboot.system.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_people_baseinfo")
public class UserInfo implements Serializable {
	@Id
    @Column(name = "rowid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rowid;

	private String idcard;
	private String name;
	private int sex;
	private int nation;
	private int height;
	private String borndate;
	private String createby;
	@Column(name = "update_time")
	private String createtime;
	private String updateby;
	@Column(name = "create_time")
	private String updatetime;

	private  int deleteid;

	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getNation() {
		return nation;
	}

	public void setNation(int nation) {
		this.nation = nation;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getBorndate() {
		return borndate;
	}

	public void setBorndate(String borndate) {
		this.borndate = borndate;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public int getDeleteid() {
		return deleteid;
	}

	public void setDeleteid(int deleteid) {
		this.deleteid = deleteid;
	}
}
