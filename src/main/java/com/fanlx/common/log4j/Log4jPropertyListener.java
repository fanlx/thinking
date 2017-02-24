package com.fanlx.common.log4j;

import org.springframework.util.ResourceUtils;
import org.springframework.web.util.Log4jConfigListener;
import org.springframework.web.util.Log4jWebConfigurer;

import javax.servlet.ServletContextEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by fanlx on 24/02/2017.
 * 加载log4j配置文件
 */
public class Log4jPropertyListener extends Log4jConfigListener {

    private final static String LOG4J_PROPERTIES_PATH = "log4jProperties";

    @Override
    public void contextInitialized(ServletContextEvent event) {
        initLogProperty(event);
        Log4jWebConfigurer.initLogging(event.getServletContext());
    }

    private void initLogProperty(ServletContextEvent event) {
        String resourceLocation = event.getServletContext().getInitParameter(LOG4J_PROPERTIES_PATH);
        Properties prop = new Properties();
        try {
            File file = ResourceUtils.getFile(resourceLocation);
            prop.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new IllegalArgumentException("load log4jProperties file failed, path= " + resourceLocation, e);
        }
        Enumeration<Object> en = prop.keys();
        while (en.hasMoreElements()) {
            String name = en.nextElement().toString();
            String value = prop.getProperty(name);
            System.setProperty(name, value);
        }

    }

}
