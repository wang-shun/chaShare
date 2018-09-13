package com.holley.charging.listener;

import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.holley.charging.model.def.ChargingConfig;
import com.holley.common.cache.RedisUtil;
import com.holley.common.constants.Globals;

public class ShareLoadListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        Set<String> oids = ChargingConfig.getOperatorIds();
        for (String oid : oids) {
            RedisUtil.delKey(Globals.KEY_PUSH_TOKEN + oid);// 删除刷新token
        }
        System.out.println("监听器");
    }
}
