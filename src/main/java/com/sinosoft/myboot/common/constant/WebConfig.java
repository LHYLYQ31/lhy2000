/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.common.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <B>系统名称：myboot</B><BR>
 * <B>模块名称：自定义配置文件的读取</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年6月22日
 */
//
////绑定配置项的前缀
@ConfigurationProperties(prefix = "web")
////添加自定义配置文件 如果找不到文件，就加载使用application.properties
@PropertySource(value = { "classpath:/config/config.properties" }, ignoreResourceNotFound = true)
@Component
public class WebConfig {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
