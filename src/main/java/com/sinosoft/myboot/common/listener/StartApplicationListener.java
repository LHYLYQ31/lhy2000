/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年6月22日
 */
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    protected Logger logger = LoggerFactory.getLogger(StartApplicationListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        logger.error("+++++++++++++++++++StartApplicationListener+++++++++++++++++++++++");
        try {
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
