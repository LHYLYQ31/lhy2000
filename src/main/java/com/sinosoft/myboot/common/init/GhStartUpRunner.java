/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.common.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sinosoft.myboot.common.constant.WebConfig;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年6月22日
 */
@Component
@Order(value = 1) //如果有多个的话，执行优先级是按value值从小到大顺序【越小越先执行】
public class GhStartUpRunner implements CommandLineRunner {
    @Autowired
    WebConfig webConfig;

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {

    }

}
