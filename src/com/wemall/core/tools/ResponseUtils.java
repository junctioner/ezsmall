package com.wemall.core.tools;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpServletResponse甯侄绫?
 */
public final class ResponseUtils {
    public static final Logger log = LoggerFactory
                                     .getLogger(ResponseUtils.class);

    /**
     * 鍙戦€佹枃链€备娇鐢║TF-8缂栫爜銆?
     *
     * @param response
     *            HttpServletResponse
     * @param text
     *            鍙戦€佺殑瀛楃涓?
     */
    public static void renderText(HttpServletResponse response, String text){
        render(response, "text/plain;charset=UTF-8", text);
    }

    /**
     * 鍙戦€乯son銆备娇鐢║TF-8缂栫爜銆?
     *
     * @param response
     *            HttpServletResponse
     * @param text
     *            鍙戦€佺殑瀛楃涓?
     */
    public static void renderJson(HttpServletResponse response, String text){
        render(response, "application/json;charset=UTF-8", text);
    }

    /**
     * 鍙戦€亁ml銆备娇鐢║TF-8缂栫爜銆?
     *
     * @param response
     *            HttpServletResponse
     * @param text
     *            鍙戦€佺殑瀛楃涓?
     */
    public static void renderXml(HttpServletResponse response, String text){
        render(response, "text/xml;charset=UTF-8", text);
    }

    /**
     * 鍙戦€佸唴瀹广€备娇鐢║TF-8缂栫爜銆?
     *
     * @param response
     * @param contentType
     * @param text
     */
    public static void render(HttpServletResponse response, String contentType,
                              String text){
        response.setContentType(contentType);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        try {
            response.getWriter().write(text);
        } catch (IOException e){
            log.error(e.getMessage(), e);
        }
    }
}
