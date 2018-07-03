/**
 * Copyright 2018 SinoSoft. All Rights Reserved.
 */
package com.sinosoft.myboot.modules.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.sinosoft.mms.intercace.device.model.DeviceInteface;
import com.sinosoft.mms.intercace.device.service.DeviceServiceInterface;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author 中科软科技 lihaiyi
 * @since 2018年6月25日
 */
@Service(version = "1.0.0")
public class TestServiceImple implements DeviceServiceInterface {

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see com.sinosoft.mms.intercace.device.service.DeviceServiceInterface#save(com.sinosoft.mms.intercace.device.model.DeviceInteface)
     */
    @Override
    public String save(DeviceInteface device) {
        // TODO Auto-generated method stub
        return "我是dubbo服务";
    }

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see com.sinosoft.mms.intercace.device.service.DeviceServiceInterface#update(com.sinosoft.mms.intercace.device.model.DeviceInteface)
     */
    @Override
    public String update(DeviceInteface device) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * <B>方法名称：</B><BR>
     * <B>概要说明：</B><BR>
     * 
     * @see com.sinosoft.mms.intercace.device.service.DeviceServiceInterface#getModel(java.lang.String)
     */
    @Override
    public DeviceInteface getModel(String uuId) {
        // TODO Auto-generated method stub
        return null;
    }

}
