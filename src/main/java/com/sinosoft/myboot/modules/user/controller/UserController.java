/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.modules.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.myboot.modules.user.model.User;
import com.sinosoft.myboot.modules.user.service.UserService;

import net.sf.json.JSONObject;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年1月18日
 */
@RestController
@RequestMapping("/myboot/user")
@EnableAutoConfiguration //此注释自动载入应用程序所需的所有Bean
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    /**
     * 
     * <B>方法名称：restful风格</B><BR>
     * <B>概要说明：</B><BR>
     *
     * @author：lihaiyi
     * @cretetime:2018年1月18日 下午2:35:07
     * @param userid
     * @return String
     */
    @RequestMapping(value = "/user/{page}/{size}", method = RequestMethod.GET)
    public Page<User> getUserInfo(@PathVariable Integer page, @PathVariable Integer size, User u) {
        System.out.println("+++++++++++++++++++++++++:" + u.getUserName());
        System.out.println("+++++++++++++++++++++++++:" + page);
        System.out.println("+++++++++++++++++++++++++:" + size);
        Page<User> u1 = userService.page(u, page, size);

        logger.info("getUserInfoJ：" + JSONObject.fromObject(u1).toString());
        return u1;
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public User save(User u) {
        logger.info("++++++++++++++++打印日志测试+++++++++++++++++++++++++++++++");
        u.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return userService.save(u);
    }

}
