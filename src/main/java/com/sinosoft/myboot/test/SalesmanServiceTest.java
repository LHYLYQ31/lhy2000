/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sinosoft.myboot.common.constant.WebConfig;
import com.sinosoft.myboot.common.util.SystemConfig;
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
 * @since 2018年6月22日
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SalesmanServiceTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService service;
    @Autowired
    WebConfig webConfig;
    @Autowired
    SystemConfig systemConfig;

    @Test
    public void testFindAll() {
        System.out.println("===============================");
        logger.error("==================================");
        logger.info("========================434343==========");
        logger.debug("========================43qwqwqwq3==========");
        //service.findAll().forEach(salesman -> System.out.println(salesman.toString()));
    }

    @Test
    public void testSave() {
        User u = new User();
        u.setUserName("234234");
        service.save(u);
        logger.error("---------" + JSONObject.fromObject(u).toString());
        logger.debug("++++++++++++++++++++++++++++++++++++++++++++++++++==" + systemConfig.getProperty("web.name"));
    }
}
