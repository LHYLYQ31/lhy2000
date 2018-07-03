/**
 * Copyright 2017 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.common.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sinosoft.myboot.common.cache.MemoryCache;

import net.sf.json.JSONObject;

/**
 * <B>系统名称：移动推送管理系统</B><BR>
 * <B>模块名称：拦截器</B><BR>
 * <B>中文类名：拦截器</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2017年11月21日
 */
@Component
@WebFilter(filterName = "loginFilter", urlPatterns = "/myboot/*", initParams = {
        @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")//忽略资源
})
public class LoginFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * <B>方法名称：拦截器结束方法</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {

    }

    /**
     * <B>方法名称：拦截器</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     *      javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        logger.error("++++++++++++++++++++++++++++++++loginFilter++++++++++++++++++++++++++++++++++++++++");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String url = request.getContextPath() + "/modules/login/login.html";
        JSONObject json = new JSONObject();
        chain.doFilter(request, response);
    }

    /**
     * <B>方法名称：拦截器初始还方法</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 
     * <B>方法名称：判断路径是否拦截</B><BR>
     * <B>概要说明：</B><BR>
     *
     * @author：lihaiyi
     * @cretetime:2018年1月31日 下午1:38:18
     * @param request
     * @return Boolean
     */
    public Boolean checkPath(HttpServletRequest request) {
        List list = MemoryCache.getNoFilterList();
        Iterator it = list.iterator();
        Boolean result = false;
        String path = request.getServletPath();//请求路径
        logger.info("请求路径" + path);
        while (it.hasNext()) {
            //如果是退出操作
            if (path.indexOf("loginOut") != -1) {
                request.getSession().setAttribute("loginTime", "");
                request.getSession().setAttribute("userId", "");
                break;
            }
            String noFilterPath = (String) it.next();
            if (path.indexOf(noFilterPath) != -1) {
                //不需要拦截
                result = true;
                break;
            }

        }
        return result;

    }

    /**
     * 
     * <B>方法名称：doRedirect</B><BR>
     * <B>概要说明：重定向页面</B><BR>
     *
     * @author：lihaiyi
     * @cretetime:2018年6月8日 上午10:10:32
     * @param request
     * @param response
     * @param URL
     * @throws IOException void
     */
    private void doRedirect(HttpServletRequest request, HttpServletResponse response, String URL) throws IOException {
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
        String type = request.getHeader("X-Requested-With");
        if (StringUtils.equals("XMLHttpRequest", type)) {
            // ajax请求
            response.setHeader("SESSIONSTATUS", "TIMEOUT");
            response.setHeader("CONTEXTPATH", basePath + "/modules/login/login.html");
            response.setHeader("REDIRECT", "REDIRECT");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);//403 禁止
            response.setHeader("REDIRECT", "REDIRECT");
        }
        else {
            response.sendRedirect(URL);
        }

    }

}