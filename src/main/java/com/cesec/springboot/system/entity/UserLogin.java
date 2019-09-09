package com.cesec.springboot.system.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 李帅龙
 * date 2019/8/19 13:56
 * @version 1.0
 */
@Table(name = "login")
public class UserLogin implements Serializable {
    @Id
    @Column(name = "rowid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rowId;
    private String userName;
    private String passWord;

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
