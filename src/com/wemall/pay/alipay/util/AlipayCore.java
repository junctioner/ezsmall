package com.wemall.pay.alipay.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.PartSource;

import com.wemall.pay.alipay.config.AlipayConfig;

public class AlipayCore {
    public static String buildMysign(AlipayConfig config, Map<String, String> sArray){
        String prestr = createLinkString(sArray);
        String mysign = MD5.sign(prestr, config.getKey(),
                                 config.getInput_charset());
        return mysign;
    }

    /**
     * 闄ゅ幓鏁扮粍涓殑绌哄€煎拰绛惧悕鍙傛暟
     * @param sArray 绛惧悕鍙傛暟缁?
     * @return 铡绘帀绌哄€间笌绛惧悕鍙傛暟鍚庣殑鏂扮鍚嶅弬鏁扮粍
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray){

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0){
            return result;
        }

        for (String key : sArray.keySet()){
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                    || key.equalsIgnoreCase("sign_type")){
                continue;
            }
            result.put(key, value);
        }

        return result;
    }
    /**
     * 鎶婃暟缁勬墍链夊厓绱犳帓搴忥紝骞舵寜镦р€滃弬鏁?鍙傛暟链尖€濈殑妯″纺鐢ㄢ€?钬濆瓧绗︽嫾鎺ユ垚瀛楃涓?
     * @param params 闇€瑕佹帓搴忓苟鍙备笌瀛楃鎷兼帴镄勫弬鏁扮粍
     * @return 鎷兼帴鍚庡瓧绗︿覆
     */
    public static String createLinkString(Map<String, String> params){

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++){
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1){ //鎷兼帴镞讹紝涓嶅寘鎷渶鍚庝竴涓?瀛楃
                prestr = prestr + key + "=" + value;
            }else{
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }


    public static String createLinkStringNoSort(Map<String, String> params){
        List<String> keys = new ArrayList();
        keys.add("service");
        keys.add("v");
        keys.add("sec_id");
        keys.add("notify_data");
        String prestr = "";
        for (String key : keys){
            prestr = prestr + key + "=" + (String)params.get(key) + "&";
        }
        prestr = prestr.substring(0, prestr.length() - 1);
        return prestr;
    }

    public static String createLinkStringNoSort1(Map<String, String> params){
        Map<String, String> sParaSort = new HashMap<String, String>();
        sParaSort.put("service", (String)params.get("service"));
        sParaSort.put("v", (String)params.get("v"));
        sParaSort.put("sec_id", (String)params.get("sec_id"));
        sParaSort.put("notify_data", (String)params.get("notify_data"));

        String prestr = "";
        for (String key : sParaSort.keySet()){
            prestr = prestr + key + "=" + (String)sParaSort.get(key) + "&";
        }
        prestr = prestr.substring(0, prestr.length() - 1);

        return prestr;
    }
    /**
     * 鍐欐棩蹇楋紝鏂逛究娴嬭瘯锛堢湅缃戠珯闇€姹傦紝涔熷彲浠ユ敼鎴愭妸璁板綍瀛桦叆鏁版嵁搴掳级
     * @param sWord 瑕佸啓鍏ユ棩蹇楅噷镄勬枃链唴瀹?
     */
    public static void logResult(AlipayConfig config, String sWord){
        FileWriter writer = null;
        try {
            writer = new FileWriter(config.getLog_path());
            writer.write(sWord);
        } catch (Exception e){
            e.printStackTrace();

            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e1){
                    e1.printStackTrace();
                }
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
        }
    }

    /**
     * 鐢熸垚鏂囦欢鎽樿
     * @param strFilePath 鏂囦欢璺缎
     * @param file_digest_type 鎽樿绠楁硶
     * @return 鏂囦欢鎽樿缁撴灉
     */
    public static String getAbstract(String strFilePath, String file_digest_type) throws IOException {
        PartSource file = new FilePartSource(new File(strFilePath));
        if(file_digest_type.equals("MD5")){
            return DigestUtils.md5Hex(file.createInputStream());
        }else if(file_digest_type.equals("SHA")){
            return DigestUtils.sha256Hex(file.createInputStream());
        }else{
            return "";
        }
    }
}




