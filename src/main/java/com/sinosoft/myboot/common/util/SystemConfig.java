/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.common.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：读properties的工具类</B><BR>
 * <B>概要说明：用的话，就直接这样子
 * String value = SystemConfig.getProperty("key");</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年1月18日
 */
@Component
public class SystemConfig {
    private static Log log = LogFactory.getLog(SystemConfig.class);
    private static Properties props;

    public SystemConfig() {
        try {
            Resource resource = new ClassPathResource("application.properties");
            props = PropertiesLoaderUtils.loadProperties(resource);
        }
        catch (IOException e) {
            e.printStackTrace();
            log.error(e);
        }
    }

    /**
     * 获取属性
     * 
     * @param key
     * @return
     */
    public static String getProperty(String key) {

        return props == null ? null : props.getProperty(key);

    }

    /**
     * 获取属性
     * 
     * @param key 属性key
     * @param defaultValue 属性value
     * @return
     */
    public static String getProperty(String key, String defaultValue) {

        return props == null ? null : props.getProperty(key, defaultValue);

    }

    /**
     * 获取properyies属性
     * 
     * @return
     */
    public static Properties getProperties() {
        return props;
    }

}
