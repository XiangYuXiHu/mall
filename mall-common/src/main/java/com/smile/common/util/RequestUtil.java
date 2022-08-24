package com.smile.common.util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 请求工具类
 *
 * @Description
 * @ClassName RequestUtil
 * @Author smile
 * @date 2022.08.23 20:48
 */
public class RequestUtil {

    /**
     * 获取请求的IP
     *
     * @param request
     * @return
     */
    public static String getRequestIp(HttpServletRequest request) {
        /**
         * 通过Http代理服务转发时添加
         */
        String ipAddress = request.getHeader("x-forwarded-for");
        if (null == ipAddress || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (null == ipAddress || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (null == ipAddress || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            /**
             * 从本地访问时根据网卡取本机配置的IP
             */
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inetAddress.getHostAddress();
            }
        }
        /**
         * 通过多个代理转发的情况，第一个IP为客户端真实IP，多个IP会按照','分割
         */
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
}
