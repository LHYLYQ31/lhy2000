/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.modules.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年6月21日
 */
@Entity
@Table(name = "sb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //用户id
    private Long id;
    //登录人姓名
    private String userName;
    //添加时间
    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
