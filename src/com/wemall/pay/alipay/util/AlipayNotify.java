package com.wemall.pay.alipay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import com.wemall.pay.alipay.config.AlipayConfig;

public class AlipayNotify {
    //private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
    private static final String HTTP_VERIFY_URL = "http://notify.alipay.com/trade/notify_query.do?";
    /**
     * 鏀粯瀹濇秷鎭獙璇佸湴鍧€
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    /**
     * 楠岃瘉娑堟伅鏄惁鏄敮浠桦疂鍙戝嚭镄勫悎娉曟秷鎭?
     *
     * @param params
     *            阃氱煡杩斿洖鏉ョ殑鍙傛暟鏁扮粍
     * @return 楠岃瘉缁撴灉
     */
    public static boolean verifyWap(AlipayConfig config, Map<String, String> params){

        params.put("subject", "娴嬭瘯");
        // 鍒ゆ柇responsetTxt鏄惁涓篓rue锛宨sSign鏄惁涓篓rue
        // responsetTxt镄勭粨鏋滀笉鏄痶rue锛屼笌链嶅姟鍣ㄨ缃棶棰朴€佸悎浣滆韩浠借€匢D銆乶otify_id涓€鍒嗛挓澶辨晥链夊叧
        // isSign涓嶆槸true锛屼笌瀹夊叏镙￠獙镰并€佽姹傛椂镄勫弬鏁版牸寮忥纸濡傦细甯﹁嚜瀹氢箟鍙傛暟绛夛级銆佺紪镰佹牸寮忔湁鍏?
        String responseTxt = "false";
        if (params.get("notify_id") != null){
            String notify_id = params.get("notify_id");
            responseTxt = verifyResponse(config, notify_id);
        }
        String sign = "";
        if (params.get("sign") != null){
            sign = params.get("sign");
        }
        boolean isSign = getSignVeryfyWap(config, params, sign);

        // 鍐欐棩蹇楄褰曪纸鑻ヨ璋冭瘯锛岃鍙栨秷涓嬮溃涓よ娉ㄩ喷锛?
        // String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign +
        // "\n 杩斿洖锲炴潵镄勫弬鏁帮细" + AlipayCore.createLinkString(params);
        // AlipayCore.logResult(sWord);

        if (isSign && responseTxt.equals("true")){
            return true;
        }else{
            return false;
        }
    }

    public static boolean verify(AlipayConfig config, Map<String, String> params){
        String responseTxt = "true";
        if (params.get("notify_id") != null){
            String notify_id = (String)params.get("notify_id");
            responseTxt = verifyResponse(config, notify_id);
        }
        String sign = "";
        if (params.get("sign") != null){
            sign = (String)params.get("sign");
        }
        boolean isSign = getSignVeryfy(config, params, sign, true);

        String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign +
                       "\n 杩斿洖锲炴潵镄勫弬鏁帮细" + AlipayCore.createLinkString(params);

        return (isSign) && (responseTxt.equals("true"));
    }

    public static Map<String, String> decrypt(AlipayConfig config, Map<String, String> inputPara) throws Exception {
        inputPara.put("notify_data", RSA.decrypt((String)inputPara.get("notify_data"),
                      AlipayConfig.private_key, config.getInput_charset()));
        return inputPara;
    }

    public static boolean verifyNotifyWap(AlipayConfig config, Map<String, String> params) throws Exception {

        if (config.getSign_type().equals("0001")){
            params = decrypt(config, params);
        }

        String responseTxt = "true";
        try {
            Document document = DocumentHelper.parseText((String)params.get("notify_data"));
            String notify_id = document.selectSingleNode("//notify/notify_id").getText();
            responseTxt = verifyResponse(config, notify_id);
        } catch (Exception e){
            responseTxt = e.toString();
        }

        String sign = "";
        if (params.get("sign") != null){
            sign = (String)params.get("sign");
        }
        boolean isSign = getSignVeryfy(config, params, sign, false);

        return (isSign) && (responseTxt.equals("true"));
    }

    private static boolean getSignVeryfy(AlipayConfig config, Map<String, String> Params, String sign, boolean isSort){
        Map sParaNew = AlipayCore.paraFilter(Params);

        String preSignStr = "";
        if (isSort)
            preSignStr = AlipayCore.createLinkString(sParaNew);
       else{
            preSignStr = AlipayCore.createLinkStringNoSort(sParaNew);
        }

        boolean isSign = false;
        if (config.getSign_type().equals("MD5")){
            isSign = MD5.verify(preSignStr, sign, config.getKey(),
                                config.getInput_charset());
        }
        if (config.getSign_type().equals("0001")){
            isSign = RSA.verify(preSignStr, sign, AlipayConfig.getAli_public_key(),
                                config.getInput_charset());
        }
        return isSign;
    }

    /**
     * 镙规嵁鍙嶉锲炴潵镄勪俊鎭紝鐢熸垚绛惧悕缁撴灉
     *
     * @param Params
     *            阃氱煡杩斿洖鏉ョ殑鍙傛暟鏁扮粍
     * @param sign
     *            姣斿镄勭鍚岖粨鏋?
     * @return 鐢熸垚镄勭鍚岖粨鏋?
     */
    private static boolean getSignVeryfyWap(AlipayConfig config, Map<String, String> Params, String sign){
        // 杩囨护绌哄€笺€乻ign涓巗ign_type鍙傛暟
        Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        // 銮峰彇寰呯鍚嶅瓧绗︿覆
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        // 銮峰缑绛惧悕楠岃瘉缁撴灉
        boolean isSign = false;
        if (config.getSign_type().equals("RSA")){
            isSign = RSA.verifyWap(preSignStr, sign, AlipayConfig.getAli_public_key(), config.getInput_charset());
        }
        return isSign;
    }

    /**
     * 銮峰彇杩灭▼链嶅姟鍣ˋTN缁撴灉,楠岃瘉杩斿洖URL
     *
     * @param notify_id
     *            阃氱煡镙￠獙ID
     * @return 链嶅姟鍣ˋTN缁撴灉 楠岃瘉缁撴灉板嗭细 invalid锻戒护鍙傛暟涓嶅 鍑虹幇杩欎釜阌栾锛岃妫€娴嬭繑锲炲鐞嗕腑partner鍜宬ey鏄惁涓虹┖ true
     *         杩斿洖姝ｇ‘淇℃伅 false 璇锋镆ラ槻鐏鎴栬€呮槸链嶅姟鍣ㄩ樆姝㈢鍙ｉ棶棰树互鍙婇獙璇佹椂闂存槸鍚﹁秴杩囦竴鍒嗛挓
     */
    private static String verifyResponse(AlipayConfig config, String notify_id){

        String veryfy_url = "";
        if (config.getTransport().equalsIgnoreCase("https"))
            veryfy_url = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
       else{
            veryfy_url = "http://notify.alipay.com/trade/notify_query.do?";
        }
        String partner = config.getPartner();
        veryfy_url = veryfy_url + "partner=" + partner + "&notify_id=" + notify_id;

        return checkUrl(veryfy_url);
    }


    /*
    private static String verifyResponse(String notify_id){
    	// 銮峰彇杩灭▼链嶅姟鍣ˋTN缁撴灉锛岄獙璇佹槸鍚︽槸鏀粯瀹濇湇锷″櫒鍙戞潵镄勮姹?

    	String partner = AlipayConfig.partner;
    	String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner
    			+ "&notify_id=" + notify_id;

    	return checkUrl(veryfy_url);
    }*/

    /**
     * 銮峰彇杩灭▼链嶅姟鍣ˋTN缁撴灉
     *
     * @param urlvalue
     *            鎸囧畾URL璺缎鍦板潃
     * @return 链嶅姟鍣ˋTN缁撴灉 楠岃瘉缁撴灉板嗭细 invalid锻戒护鍙傛暟涓嶅 鍑虹幇杩欎釜阌栾锛岃妫€娴嬭繑锲炲鐞嗕腑partner鍜宬ey鏄惁涓虹┖ true
     *         杩斿洖姝ｇ‘淇℃伅 false 璇锋镆ラ槻鐏鎴栬€呮槸链嶅姟鍣ㄩ樆姝㈢鍙ｉ棶棰树互鍙婇獙璇佹椂闂存槸鍚﹁秴杩囦竴鍒嗛挓
     */
    private static String checkUrl(String urlvalue){
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url
                                              .openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e){
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }


    /*private static String checkUrl(String urlvalue)
    {
      String inputLine = "";
      try
      {
        URL url = new URL(urlvalue);
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        BufferedReader in = new BufferedReader(
          new InputStreamReader(urlConnection.getInputStream()));
        inputLine = in.readLine().toString();
      } catch (Exception e){
        e.printStackTrace();
        inputLine = "";
      }

      return inputLine;
    }*/


}




