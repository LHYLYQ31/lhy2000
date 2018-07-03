/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.modules.user.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sinosoft.myboot.modules.user.model.User;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年1月18日
 */

public interface UserService {
    public String getUser(String userid);

    Page<User> page(User u, int page, int size);

    List<User> list(User u);

    User save(User u);

    Boolean update(User u);

    Boolean delete(User u);
}
