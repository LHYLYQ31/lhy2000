/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.common.init;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.sinosoft.myboot.common.cache.MemoryCache;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年1月31日
 */
@WebListener
public class InitData implements ServletContextListener {//ServletContextListener
    Logger logger = LoggerFactory.getLogger(InitData.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        // context销毁时，销毁初始化数据
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        //        ServletContext context = event.getServletContext();
        //        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        InputStream inputStream = null;
        try {
            logger.error("+++++++++++++++++InitData++++++++++++++++++++++++++++++++++");
            ClassPathResource resource = new ClassPathResource("filterUrl.xml");
            inputStream = resource.getInputStream();
            byte[] body = new byte[inputStream.available()];
            inputStream.read(body);
            XMLSerializer xmlSerializer = new XMLSerializer();
            JSON json = xmlSerializer.read(new String(body));
            logger.error("转换结果:" + json.toString(0));
            JSONObject cache = JSONObject.fromObject(json);
            Object noFilterPathObj = cache.get("noFilter");
            if (noFilterPathObj instanceof String) {
                List<String> list = new ArrayList<>();
                list.add(noFilterPathObj.toString());
                MemoryCache.setNoFilterList(list);
            }
            else if (noFilterPathObj instanceof JSONArray) {
                List<String> list2 = JSONArray.toList((JSONArray) noFilterPathObj, new String(), new JsonConfig());//参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
                MemoryCache.setNoFilterList(list2);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("初始化文件失败:" + e.getMessage());
        }
        finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
