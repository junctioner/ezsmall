package com.wemall.core.tools;

import com.wemall.core.base.AppGlobal;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * HttpServletRequest甯侄绫?
 */
public class RequestUtils {
    private static final Logger log = LoggerFactory.getLogger(RequestUtils.class);

    /**
     * 銮峰彇QueryString镄勫弬鏁帮紝骞朵娇鐢║RLDecoder浠TF-8镙煎纺杞爜銆傚鏋滆姹傛槸浠ost鏂规硶鎻愪氦镄勶紝
     * 闾ｄ箞灏嗛€氲绷HttpServletRequest#getParameter銮峰彇銆?
     *
     * @param request web璇锋眰
     * @param name    鍙傛暟鍚岖О
     * @return
     */
    public static String getQueryParam(HttpServletRequest request, String name){
        if (StringUtils.isBlank(name)){
            return null;
        }
        if (request.getMethod().equalsIgnoreCase(AppGlobal.POST)){
            return request.getParameter(name);
        }
        String s = request.getQueryString();
        if (StringUtils.isBlank(s)){
            return null;
        }
        try {
            s = URLDecoder.decode(s, AppGlobal.UTF8);
        } catch (UnsupportedEncodingException e){
            log.error("encoding " + AppGlobal.UTF8 + " not support?", e);
        }
        String[] values = parseQueryString(s).get(name);
        if (values != null && values.length > 0){
            return values[values.length - 1];
        }else{
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getQueryParams(HttpServletRequest request){
        Map<String, String[]> map;
        if (request.getMethod().equalsIgnoreCase(AppGlobal.POST)){
            map = request.getParameterMap();
        }else{
            String s = request.getQueryString();
            if (StringUtils.isBlank(s)){
                return new HashMap<String, Object>();
            }
            try {
                s = URLDecoder.decode(s, AppGlobal.UTF8);
            } catch (UnsupportedEncodingException e){
                log.error("encoding " + AppGlobal.UTF8 + " not support?", e);
            }
            map = parseQueryString(s);
        }

        Map<String, Object> params = new HashMap<String, Object>(map.size());
        int len;
        for (Map.Entry<String, String[]> entry : map.entrySet()){
            len = entry.getValue().length;
            if (len == 1){
                params.put(entry.getKey(), entry.getValue()[0]);
            }else if (len > 1){
                params.put(entry.getKey(), entry.getValue());
            }
        }

        return params;
    }

    /**
     * Parses a query string passed from the client to the server and builds a
     * <code>HashTable</code> object with key-value pairs. The query string
     * should be in the form of a string packaged by the GET or POST method,
     * that is, it should have key-value pairs in the form <i>key=value</i>,
     * with each pair separated from the next by a &amp; character.
     * <p/>
     * <p/>
     * A key can appear more than once in the query string with different
     * values. However, the key appears only once in the hashtable, with its
     * value being an array of strings containing the multiple values sent by
     * the query string.
     * <p/>
     * <p/>
     * The keys and values in the hashtable are stored in their decoded form, so
     * any + characters are converted to spaces, and characters sent in
     * hexadecimal notation (like <i>%xx</i>) are converted to ASCII characters.
     *
     * @param s a string containing the query to be parsed
     * @return a <code>HashTable</code> object built from the parsed key-value
     * pairs
     * @throws IllegalArgumentException if the query string is invalid
     */
    public static Map<String, String[]> parseQueryString(String s){
        String valArray[] = null;
        if (s == null){
            throw new IllegalArgumentException();
        }
        Map<String, String[]> ht = new HashMap<String, String[]>();
        StringTokenizer st = new StringTokenizer(s, "&");
        while (st.hasMoreTokens()){
            String pair = (String) st.nextToken();
            int pos = pair.indexOf('=');
            if (pos == -1){
                continue;
            }
            String key = pair.substring(0, pos);
            String val = pair.substring(pos + 1, pair.length());
            if (ht.containsKey(key)){
                String oldVals[] = (String[]) ht.get(key);
                valArray = new String[oldVals.length + 1];
                for (int i = 0; i < oldVals.length; i++){
                    valArray[i] = oldVals[i];
                }
                valArray[oldVals.length] = val;
            }else{
                valArray = new String[1];
                valArray[0] = val;
            }
            ht.put(key, valArray);
        }

        return ht;
    }

    public static Map<String, String> getRequestMap(HttpServletRequest request, String prefix){
        return getRequestMap(request, prefix, false);
    }

    public static Map<String, String> getRequestMapWithPrefix(HttpServletRequest request, String prefix){
        return getRequestMap(request, prefix, true);
    }

    @SuppressWarnings("unchecked")
    private static Map<String, String> getRequestMap(HttpServletRequest request, String prefix, boolean nameWithPrefix){
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> names = request.getParameterNames();
        String name, key, value;
        while (names.hasMoreElements()){
            name = names.nextElement();
            if (name.startsWith(prefix)){
                key = nameWithPrefix ? name : name.substring(prefix.length());
                value = StringUtils.join(request.getParameterValues(name), ',');
                map.put(key, value);
            }
        }

        return map;
    }

    /**
     * 銮峰彇璁块棶钥匢P
     * <p/>
     * 鍦ㄤ竴鑸儏鍐典笅浣跨敤Request.getRemoteAddr()鍗冲彲锛屼絾鏄粡杩噉ginx绛夊弽鍚戜唬鐞呜蒋浠跺悗锛岃繖涓柟娉曚细澶辨晥銆?
     * <p/>
     * 链柟娉曞厛浠嶩eader涓幏鍙术-Real-IP锛屽鏋滀笉瀛桦湪鍐崭粠X-Forwarded-For銮峰缑绗竴涓狪P(鐢?鍒嗗壊)锛?
     * 濡傛灉杩树笉瀛桦湪鍒栾皟鐢≧equest .getRemoteAddr()銆?
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request){
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)){
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)){
            // 澶氭鍙嶅悜浠ｇ悊鍚庝细链夊涓狪P链硷紝绗竴涓负鐪熷疄IP銆?
            int index = ip.indexOf(',');
            if (index != -1){
                return ip.substring(0, index);
            }else{
                return ip;
            }
        }else{
            return request.getRemoteAddr();
        }
    }

    /**
     * 銮峰缑褰撶殑璁块棶璺缎
     * <p/>
     * HttpServletRequest.getRequestURL+"?"+HttpServletRequest.getQueryString
     *
     * @param request
     * @return
     */
    public static String getLocation(HttpServletRequest request){
        UrlPathHelper helper = new UrlPathHelper();
        StringBuffer buff = request.getRequestURL();
        String uri = request.getRequestURI();
        String origUri = helper.getOriginatingRequestUri(request);
        buff.replace(buff.length() - uri.length(), buff.length(), origUri);
        String queryString = helper.getOriginatingQueryString(request);
        if (queryString != null){
            buff.append("?").append(queryString);
        }

        return buff.toString();
    }

    /**
     * 銮峰缑璇锋眰镄剆ession id锛屼絾鏄疕ttpServletRequest#getRequestedSessionId()鏂规硶链変竴浜涢棶棰朴€?
     * 褰揿瓨鍦ㄩ儴缃茶矾寰勭殑镞跺€欙紝浼氲幏鍙栧埌镙硅矾寰勪笅镄刯sessionid銆?
     *
     * @param request
     * @return
     * @see HttpServletRequest#getRequestedSessionId()
     */
    public static String getRequestedSessionId(HttpServletRequest request){
        String sid = request.getRequestedSessionId();
        String ctx = request.getContextPath();
        // 濡傛灉session id鏄粠url涓幏鍙栵紝鎴栬€呴儴缃茶矾寰勪负绌猴紝闾ｄ箞鏄湪姝ｇ‘镄勩€?
        if (request.isRequestedSessionIdFromURL() || StringUtils.isBlank(ctx)){
            return sid;
        }else{
            // 镓嫔姩浠巆ookie銮峰彇
            Cookie cookie = CookieUtil.getCookieByName(request, AppGlobal.JSESSION_COOKIE);
            if (cookie != null){
                return cookie.getValue();
            }else{
                return request.getSession().getId();
            }
        }
    }
}
