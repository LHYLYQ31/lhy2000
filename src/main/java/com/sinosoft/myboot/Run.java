/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年1月18日
 */
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = { "com.sinosoft" })
@ImportResource(value = { "classpath:providers.xml" }) // 使用 providers.xml 配置； extends SpringBootServletInitializer
//extends Application implements EmbeddedServletContainerCustomizer
public class Run extends SpringBootServletInitializer {
    static Logger logger = LoggerFactory.getLogger(Run.class);

    public static void main(String[] args) {
        logger.info("++++++++++++ApplicationPath主函数入口++++++++++++++++++++++++++");
        //配置监听器
        //        SpringApplication app = new SpringApplication(ApplicationPath.class);
        //        app.addListeners(new StartApplicationListener());
        SpringApplication.run(Run.class, args);
    }

    /**
     * <B>方法名称：修改内置tomcat的端口</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer#customize(org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer)
     */
    //    @Override
    //    public void customize(ConfigurableEmbeddedServletContainer container) {
    //        container.setPort(8082);
    //        container.setContextPath("/springboot");
    //
    //    }

    //    @Bean
    //    public FilterRegistrationBean testFilterRegistration() {
    //        FilterRegistrationBean registration = new FilterRegistrationBean(new LoginFilter());
    //        registration.addUrlPatterns("/webapi/*"); //  
    //        registration.addInitParameter("paramName", "paramValue"); //  
    //        registration.setName("loginFilter");
    //        registration.setOrder(1);
    //        return registration;
    //    }

    //    @Bean
    //    public ServletListenerRegistrationBean initDataRegistration() {
    //        ServletListenerRegistrationBean registration = new ServletListenerRegistrationBean(new InitData());
    //        registration.addInitParameter("aaa", "1111");
    //        registration.setName("InitData");
    //        registration.setOrder(2);
    //        return registration;
    //    }

    //    @Bean
    //    public StartApplicationListener applicationStartListener() {
    //        return new StartApplicationListener();
    //    }

    //    @Bean
    //    @ConfigurationProperties(locations = "classpath:config/config.properties", prefix = "web")
    //    public WebConfig webConfig() {
    //        return new WebConfig();
    //
    //    }

}
