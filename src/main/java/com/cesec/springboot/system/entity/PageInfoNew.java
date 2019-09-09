package com.cesec.springboot.system.entity;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 李帅龙
 * date 2019/8/21 13:40
 * @version 1.0
 */
public class PageInfoNew {
    private int code;

    private  Long count;
    private  String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    private List<?> data;

    public PageInfoNew(Long count,List<?> data) {
        this.data = data;
        this.count=count;
        this.msg="success";
        this.code=0;
    }


}
