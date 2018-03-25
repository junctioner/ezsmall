package com.wemall.core.tools;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie宸ュ叿绫?
 */
public class CookieUtil {
    /**
     * 璁剧疆cookie
     *
     * @param response
     * @param path
     *            璺缎锛?/"琛ㄧず璇ュ伐绋嬩笅閮藉彲浠ヨ闂cookie 濡傛灉涓嶈缃矾寰勶紝闾ｄ箞鍙湁璁剧疆璇ookie璺缎鍙婂叾瀛愯矾寰勫彲浠ヨ闂?
     * @param name
     *            cookie鍚嶅瓧
     * @param value
     *            cookie链?
     * @param maxAge
     *            cookie鐢熷懡锻ㄦ湡 浠ョ涓哄崟浣?
     */
    public static void addCookie(HttpServletResponse response, String path, String name, String value, int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        if (maxAge > 0)
            cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 镙规嵁鍚嶅瓧銮峰彇cookie
     *
     * @param request
     * @param name
     *            cookie鍚嶅瓧
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name){
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)){
            Cookie cookie = (Cookie) cookieMap.get(name);

            return cookie;
        }else{
            return null;
        }
    }

    /**
     * 灏哻ookie灏佽鍒癕ap閲岄溃
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies){
            for (Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }

        return cookieMap;
    }
}
