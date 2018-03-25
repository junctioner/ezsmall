package com.wemall.core.tools;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wemall.core.tools.bean.WxToken;

/**
 * Created by John on 2016/1/13.
 */
public class WxCommonUtil {

    private static Logger log = LoggerFactory.getLogger(WxCommonUtil.class);

    // 鍑瘉銮峰彇锛圙ET锛?
    public final static String WxToken_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 鍙戦€乭ttps璇锋眰
     * @param requestUrl 璇锋眰鍦板潃
     * @param requestMethod 璇锋眰鏂瑰纺锛圙ET銆丳OST锛?
     * @param outputStr 鎻愪氦镄勬暟鎹?
     * @return 杩斿洖寰俊链嶅姟鍣ㄥ搷搴旗殑淇℃伅
     */
    public static String httpsRequestString(String requestUrl, String requestMethod, String outputStr){
        try {
            // 鍒涘缓SSLContext瀵硅薄锛屽苟浣跨敤鎴戜滑鎸囧畾镄勪俊浠荤鐞嗗櫒鍒濆鍖?
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 浠庝笂杩癝SLContext瀵硅薄涓缑鍒癝SLSocketFactory瀵硅薄
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 璁剧疆璇锋眰鏂瑰纺锛圙ET/POST锛?
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            // 褰搊utputStr涓崭负null镞跺悜杈揿嚭娴佸啓鏁版嵁
            if (null != outputStr){
                OutputStream outputStream = conn.getOutputStream();
                // 娉ㄦ剰缂栫爜镙煎纺
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 浠庤緭鍏ユ祦璇诲彇杩斿洖鍐呭
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null){
                buffer.append(str);
            }
            // 閲婃斁璧勬簮
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce){
            log.error("杩炴帴瓒呮椂锛殁}", ce);
        } catch (Exception e){
            log.error("https璇锋眰寮傚父锛殁}", e);
        }
        return null;
    }
    /**
     * 鍙戦€乭ttps璇锋眰
     *
     * @param requestUrl 璇锋眰鍦板潃
     * @param requestMethod 璇锋眰鏂瑰纺锛圙ET銆丳OST锛?
     * @param outputStr 鎻愪氦镄勬暟鎹?
     * @return JSONObject(阃氲绷JSONObject.get(key)镄勬柟寮忚幏鍙杍son瀵硅薄镄勫睘镐у€?
     */
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr){
        JSONObject jsonObject = null;
        try {
            // 鍒涘缓SSLContext瀵硅薄锛屽苟浣跨敤鎴戜滑鎸囧畾镄勪俊浠荤鐞嗗櫒鍒濆鍖?
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 浠庝笂杩癝SLContext瀵硅薄涓缑鍒癝SLSocketFactory瀵硅薄
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 璁剧疆璇锋眰鏂瑰纺锛圙ET/POST锛?
            conn.setRequestMethod(requestMethod);
            // 褰搊utputStr涓崭负null镞跺悜杈揿嚭娴佸啓鏁版嵁
            if (null != outputStr){
                OutputStream outputStream = conn.getOutputStream();
                // 娉ㄦ剰缂栫爜镙煎纺
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 浠庤緭鍏ユ祦璇诲彇杩斿洖鍐呭
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null){
                buffer.append(str);
            }

            // 閲婃斁璧勬簮
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce){
            log.error("杩炴帴瓒呮椂锛殁}", ce);
        } catch (Exception e){
            log.error("https璇锋眰寮傚父锛殁}", e);
        }
        return jsonObject;
    }

    /**
     * 銮峰彇鎺ュ彛璁块棶鍑瘉
     *
     * @param appid 鍑瘉
     * @param appsecret 瀵嗛挜
     * @return
     */
    public static WxToken getToken(String appid, String appsecret){
        WxToken WxToken = null;
        String requestUrl = WxToken_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        // 鍙戣捣GET璇锋眰銮峰彇鍑瘉
        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject){
            try {
                WxToken = new WxToken();
                WxToken.setAccessToken(jsonObject.getString("access_token"));
                WxToken.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (JSONException e){
                WxToken = null;
                // 銮峰彇WxToken澶辫触
                log.error("銮峰彇WxToken澶辫触 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return WxToken;
    }
    /**
     * 銮峰彇access_token
     * @param appid 鍑瘉
     * @param appsecret 瀵嗛挜
     * @return
     */
    /*public static AccessToken getAccessToken(SystemService systemService,String appid,String appsecret){

        AccessTokenYw accessTocken = getRealAccessToken(systemService);

        if(accessTocken!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date end = new java.util.Date();
            java.util.Date start = new java.util.Date(accessTocken.getAddTime().getTime());
            if(end.getTime()-accessTocken.getAddTime().getTime()>accessTocken.getExpires_in()*1000){
                AccessToken accessToken = null;
                String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
                JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
                // 濡傛灉璇锋眰鎴愬姛
                if (null != jsonObject){
                    try {
                        accessToken = new AccessToken();
                        accessToken.setToken(jsonObject.getString("access_token"));
                        accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
                        //鍑瘉杩囨湡镟存柊鍑瘉
                        AccessTokenYw atyw = new AccessTokenYw();
                        atyw.setId(accessTocken.getId());
                        atyw.setExpires_in(jsonObject.getInt("expires_in"));
                        atyw.setAccess_token(jsonObject.getString("access_token"));
                        updateAccessToken(atyw,systemService);
                    } catch (Exception e){
                        accessToken = null;
                        // 銮峰彇token澶辫触
                        String wrongMessage = "銮峰彇token澶辫触 errcode:{} errmsg:{}"+jsonObject.getInt("errcode")+jsonObject.getString("errmsg");
                        log.info(wrongMessage);
                    }
                }
                return accessToken;
            }else{

                AccessToken  accessToken = new AccessToken();
                accessToken.setToken(accessTocken.getAccess_token());
                accessToken.setExpiresIn(accessTocken.getExpires_in());
                return accessToken;
            }
        }else{

            AccessToken accessToken = null;
            String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
            JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
            // 濡傛灉璇锋眰鎴愬姛
            if (null != jsonObject){
                try {
                    accessToken = new AccessToken();
                    accessToken.setToken(jsonObject.getString("access_token"));
                    accessToken.setExpiresIn(jsonObject.getInt("expires_in"));

                    AccessTokenYw atyw = new AccessTokenYw();
                    atyw.setExpires_in(jsonObject.getInt("expires_in"));
                    atyw.setAccess_token(jsonObject.getString("access_token"));
                    saveAccessToken(atyw,systemService);

                } catch (Exception e){
                    accessToken = null;
                    // 銮峰彇token澶辫触
                    String wrongMessage = "銮峰彇token澶辫触 errcode:{} errmsg:{}"+jsonObject.getInt("errcode")+jsonObject.getString("errmsg");
                    log.info(wrongMessage);
                }
            }
            return accessToken;
        }
    }*/


    /**
     * 浠庢暟鎹簱涓鍙栧嚟璇?
     * @return
     */
    /*public static AccessTokenYw getRealAccessToken(SystemService systemService){
        List<AccessTokenYw> accessTockenList = systemService.findByQueryString("from AccessTokenYw");
        return accessTockenList.get(0);
    }*/

    /**
     * 淇濆瓨鍑瘉
     * @return
     */
    /*public static void saveAccessToken(AccessTokenYw accessTocken,SystemService systemService){
        systemService.save(accessTocken);
    }*/

    /**
     * 镟存柊鍑瘉
     * @return
     */
    /*public static void updateAccessToken(AccessTokenYw accessTocken,SystemService systemService){
        String sql = "update accesstoken set access_token='"+accessTocken.getAccess_token()+"',expires_ib="+accessTocken.getExpires_in()+",addtime=now() where id='"+accessTocken.getId()+"'";
        systemService.updateBySqlString(sql);
    }*/

    /**
     * 缂栫爜
     * @param bstr
     * @return String
     */
    public static String encode(byte[] bstr){
        return new sun.misc.BASE64Encoder().encode(bstr);
    }

    /**
     * 瑙ｇ爜
     * @param str
     * @return string
     */
    public static byte[] decode(String str){

        byte[] bt = null;
        try {
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            bt = decoder.decodeBuffer(str);
        } catch (IOException e){
            e.printStackTrace();
        }
        return bt;

    }
    /**
     * URL缂栫爜锛坲tf-8锛?
     *
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source){
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 镙规嵁鍐呭绫诲瀷鍒ゆ柇鏂囦欢镓╁睍鍚?
     *
     * @param contentType 鍐呭绫诲瀷
     * @return
     */
    public static String getFileExt(String contentType){
        String fileExt = "";
        if ("image/jpeg".equals(contentType))
            fileExt = ".jpg";
       else if ("audio/mpeg".equals(contentType))
            fileExt = ".mp3";
       else if ("audio/amr".equals(contentType))
            fileExt = ".amr";
       else if ("video/mp4".equals(contentType))
            fileExt = ".mp4";
       else if ("video/mpeg4".equals(contentType))
            fileExt = ".mp4";
        return fileExt;
    }

    public static String createNoncestr(int length){
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < length; i++){
            Random rd = new Random();
            res += chars.indexOf(rd.nextInt(chars.length() - 1));
        }
        return res;
    }
    public static String createNoncestr(){
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < 16; i++){
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }
    /**
     * 銮峰彇褰揿墠镞堕棿 yyyyMMddHHmmss
     *
     * @return String
     */
    public static String getCurrTime(){
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }
    /**
     * 鍙栧嚭涓€涓寚瀹氶昵搴﹀ぇ灏忕殑闅忔満姝ｆ暣鏁?
     *
     * @param length
     *            int 璁惧畾镓€鍙栧嚭闅忔満鏁扮殑闀垮害銆俵ength灏忎簬11
     * @return int 杩斿洖鐢熸垚镄勯殢链烘暟銆?
     */
    public static int buildRandom(int length){
        int num = 1;
        double random = Math.random();
        if (random < 0.1){
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++){
            num = num * 10;
        }
        return (int) ((random * num));
    }
    /**
     * 鍏冭浆鎹㈡垚鍒?
     * @param amount
     * @return
     */
    public static String getMoney(String amount){
        if(amount == null){
            return "";
        }
        // 閲戦杞寲涓哄垎涓哄崟浣?
        String currency =  amount.replaceAll("\\$|\\锟\\,", "");  //澶勭悊鍖呭惈, 锟?鎴栬€?镄勯噾棰?
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong = 0l;
        if(index == -1){
            amLong = Long.valueOf(currency + "00");
        }else if(length - index >= 3){
            amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
        }else if(length - index == 2){
            amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
        }else{
            amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
        }
        return amLong.toString();
    }
    /**
     * 銮峰彇链満Ip
     *
     *  阃氲绷 銮峰彇绯荤粺镓€链夌殑networkInterface缃戠粶鎺ュ彛 铹跺悗阆嶅巻 姣忎釜缃戠粶涓嬬殑InterfaceAddress缁勩€?
     *  銮峰缑绗﹀悎 <code>InetAddress instanceof Inet4Address</code> 鏉′欢镄勪竴涓狪pV4鍦板潃
     * @return
     */
    public static String localIp(){
        String ip = null;
        Enumeration allNetInterfaces;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()){
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                List<InterfaceAddress> InterfaceAddress = netInterface.getInterfaceAddresses();
                for (InterfaceAddress add : InterfaceAddress){
                    InetAddress Ip = add.getAddress();
                    if (Ip != null && Ip instanceof Inet4Address){
                        ip = Ip.getHostAddress();
                    }
                }
            }
        } catch (SocketException e){
            e.printStackTrace();
            //logger.warn("銮峰彇链満Ip澶辫触:寮傚父淇℃伅:"+e.getMessage());
        }
        return ip;
    }
    /**
     * 銮峰彇璁块棶鐢ㄦ埛镄勫鎴风IP锛堥€傜敤浜庡叕缃戜笌灞€鍩熺綉锛?
     */
    public static final String getIpAddr(final HttpServletRequest request){
        /*if (request == null){
            throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
        }*/
        String ipString = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)){
            ipString = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)){
            ipString = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)){
            ipString = request.getRemoteAddr();
        }

        // 澶氢釜璺敱镞讹紝鍙栫涓€涓潪unknown镄刬p
        final String[] arr = ipString.split(",");
        for (final String str : arr){
            if (!"unknown".equalsIgnoreCase(str)){
                ipString = str;
                break;
            }
        }

        return ipString;
    }
    /**
     * 瑙ｆ瀽xml,杩斿洖绗竴绾у厓绱犻敭链煎銆傚鏋灭涓€绾у厓绱犳湁瀛愯妭镣癸紝鍒欐鑺傜偣镄勫€兼槸瀛愯妭镣圭殑xml鏁版嵁銆?
     * @param strxml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Map doXMLParse(String strxml) throws JDOMException, IOException {
        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

        if(null == strxml || "".equals(strxml)){
            return null;
        }
        Map m = new HashMap();
        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator it = list.iterator();
        while(it.hasNext()){
            Element e = (Element) it.next();
            String k = e.getName();
            String v = "";
            List children = e.getChildren();
            if(children.isEmpty()){
                v = e.getTextNormalize();
            }else{
                v = WxCommonUtil.getChildrenText(children);
            }
            m.put(k, v);
        }
        //鍏抽棴娴?
        in.close();
        return m;
    }

    /**
     * 銮峰彇瀛愮粨镣圭殑xml
     * @param children
     * @return String
     */
    @SuppressWarnings("rawtypes")
    public static String getChildrenText(List children){
        StringBuffer sb = new StringBuffer();
        if(!children.isEmpty()){
            Iterator it = children.iterator();
            while(it.hasNext()){
                Element e = (Element) it.next();
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<" + name + ">");
                if(!list.isEmpty()){
                    sb.append(WxCommonUtil.getChildrenText(list));
                }
                sb.append(value);
                sb.append("</" + name + ">");
            }
        }
        return sb.toString();
    }

    /**
     * 鍙戦€乆ML镙煎纺鏁版嵁鍒板井淇℃湇锷″櫒 锻婄煡寰俊链嶅姟鍣ㄥ洖璋冧俊鎭凡缁忔敹鍒般€?
     *
     * 浣滆€? YUKE 镞ユ湡锛?015骞?链?0镞?涓婂崃9:27:33
     *
     * @param return_code
     * @param return_msg
     * @return
     */
    public static String setXML(String return_code, String return_msg){
        return "<xml><return_code><![CDATA[" + return_code
               + "]]></return_code><return_msg><![CDATA[" + return_msg
               + "]]></return_msg></xml>";
    }

    /**
     * sign绛惧悕锛屽繀椤讳娇鐢∕D5绛惧悕锛屼笖缂栫爜涓篣TF-8
     *
     * 浣滆€? YUKE 镞ユ湡锛?015骞?链?0镞?涓婂崃9:31:24
     *
     * @param characterEncoding
     * @param parameters
     * @return
     */
    public static String createSignMD5(String characterEncoding, SortedMap<Object, Object> parameters, String API_KEY){
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<Object, Object>> es = parameters.entrySet();
        Iterator<Map.Entry<Object, Object>> it = es.iterator();
        while (it.hasNext()){
            Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)){
                sb.append(k + "=" + v + "&");
            }
        }
        /** 鏀粯瀵嗛挜蹇呴』鍙备笌锷犲瘑锛屾斁鍦ㄥ瓧绗︿覆链€鍚庨溃 */
        sb.append("key=" + API_KEY);
        String sign = Md5Encrypt.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }

    /**
     * SHA1锷犲瘑锛岃锷犲瘑鏄wx.config閰岖疆涓娇鐢ㄥ埌镄勫弬鏁拌繘琛孲HA1锷犲瘑锛岃繖閲屼笉闇€瑕乲ey鍙备笌锷犲瘑
     *
     * 浣滆€? YUKE 镞ユ湡锛?015骞?链?0镞?涓婂崃9:31:24
     *
     * @param characterEncoding
     * @param parameters
     * @return
     */
    public static String createSignSHA1(String characterEncoding, SortedMap<Object, Object> parameters){
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<Object, Object>> es = parameters.entrySet();
        Iterator<Map.Entry<Object, Object>> it = es.iterator();
        while (it.hasNext()){
            Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)){
                sb.append(k + "=" + v + "&");
            }
        }
        String str = sb.toString();
        String sign = Sha1Util.getSha1(str.substring(0, str.length() - 1));
        return sign;
    }

    /**
     * 灏呜姹傚弬鏁拌浆鎹负XML镙煎纺镄剆tring瀛楃涓诧紝寰俊链嶅姟鍣ㄦ帴鏀剁殑鏄痻ml镙煎纺镄勫瓧绗︿覆
     *
     * 浣滆€? YUKE 镞ユ湡锛?015骞?链?0镞?涓婂崃9:25:51
     *
     * @param parameters
     * @return
     */
    public static String getRequestXml(SortedMap<Object, Object> parameters){
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set<Map.Entry<Object, Object>> es = parameters.entrySet();
        Iterator<Map.Entry<Object, Object>> it = es.iterator();
        while (it.hasNext()){
            Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)){
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            }else{
                sb.append("<" + k + ">" + v + "</" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 楠岃瘉绛惧悕
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String token, String signature, String timestamp, String nonce){
        String[] arr = new String[] { token, timestamp, nonce };
        // 灏唗oken銆乼imestamp銆乶once涓変釜鍙傛暟杩涜瀛楀吀搴忔帓搴?
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 灏嗕笁涓弬鏁板瓧绗︿覆鎷兼帴鎴愪竴涓瓧绗︿覆杩涜sha1锷犲瘑
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        content = null;
        // 灏唖ha1锷犲瘑鍚庣殑瀛楃涓插彲涓巗ignature瀵规瘮锛屾爣璇呜璇锋眰鏉ユ簮浜庡井淇?
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 灏嗗瓧鑺傛暟缁勮浆鎹负鍗佸叚杩涘埗瀛楃涓?
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray){
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++){
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 灏嗗瓧鑺傝浆鎹负鍗佸叚杩涘埗瀛楃涓?
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte){

        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }





    /**
     * 瑙ｅ瘑寰俊鍙戣绷鏉ョ殑瀵嗘枃娑堟伅
     *
     * @return 锷犲瘑鍚庣殑鍐呭
     */
    /*public static String decryptMsg(String msgSignature,String timeStamp,String nonce,String encrypt_msg){
        WXBizMsgCrypt pc;
        String result ="";
        try {
            pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
            result = pc.decryptMsg(msgSignature, timeStamp, nonce, encrypt_msg);
        } catch (AesException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }*/

    /**
     * 锷犲瘑缁椤井淇＄殑娑堟伅鍐呭
     * @param replayMsg
     * @param timeStamp
     * @param nonce
     * @return
     */
    /*public static String ecryptMsg(String replayMsg,String timeStamp, String nonce){
        WXBizMsgCrypt pc;
        String result ="";
        try {
            pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
            result = pc.encryptMsg(replayMsg, timeStamp, nonce);
        } catch (AesException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }*/
}
