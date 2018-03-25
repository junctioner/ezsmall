package com.wemall.pay.alipay.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.wemall.pay.alipay.config.AlipayConfig;
import com.wemall.pay.alipay.util.httpClient.HttpProtocolHandler;
import com.wemall.pay.alipay.util.httpClient.HttpRequest;
import com.wemall.pay.alipay.util.httpClient.HttpResponse;
import com.wemall.pay.alipay.util.httpClient.HttpResultType;

public class AlipaySubmit {
    private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
    private static final String WAP_ALIPAY_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?";

    public static String buildForm(AlipayConfig config, Map<String, String> sParaTemp, String gateway, String strMethod, String strButtonName){
        Map sPara = buildRequestPara(config, sParaTemp);
        List keys = new ArrayList(sPara.keySet());
        StringBuffer sbHtml = new StringBuffer();
        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" enctype=\"multipart/form-data\" action=\"" +
                      gateway + "_input_charset=" + config.getInput_charset() + "\" method=\"" + strMethod + "\">");

        for (int i = 0; i < keys.size(); i++){
            String name = (String)keys.get(i);
            String value = (String)sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName +
                      "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

        return sbHtml.toString();
    }

    private static NameValuePair[] generatNameValuePair(Map<String, String> properties){
        NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
        int i = 0;
        for (Map.Entry entry : properties.entrySet()){
            nameValuePair[(i++)] =
                new NameValuePair((String)entry.getKey(),
                                  (String)entry.getValue());
        }

        return nameValuePair;
    }

    public static String sendPostInfo(AlipayConfig config, Map<String, String> sParaTemp, String gateway)
    throws Exception {
        Map sPara = buildRequestPara(config, sParaTemp);

        HttpProtocolHandler httpProtocolHandler =
            HttpProtocolHandler.getInstance();

        HttpRequest request = new HttpRequest(HttpResultType.BYTES);

        request.setCharset(config.getInput_charset());

        request.setParameters(generatNameValuePair(sPara));
        request.setUrl(gateway + "_input_charset=" + config.getInput_charset());

        HttpResponse response = httpProtocolHandler.execute(request);
        if (response == null){
            return null;
        }

        String strResult = response.getStringResult();

        return strResult;
    }

    public static String buildRequest(AlipayConfig config, String type, Map<String, String> sParaTemp, String strParaFileName, String strFilePath)
    throws HttpException, IOException {
        Map sPara = buildRequestPara(config, sParaTemp);
        HttpProtocolHandler httpProtocolHandler =
            HttpProtocolHandler.getInstance();
        HttpRequest request = new HttpRequest(HttpResultType.BYTES);

        request.setCharset(config.getInput_charset());
        request.setParameters(generatNameValuePair(sPara));
        if (type.equals("web")){
            request.setUrl("https://mapi.alipay.com/gateway.do?_input_charset=" +
                           config.getInput_charset());
        }
        if (type.equals("wap")){
            request.setUrl("http://wappaygw.alipay.com/service/rest.htm?_input_charset=" +
                           config.getInput_charset());
        }
        HttpResponse response = httpProtocolHandler.execute(request,
                                strParaFileName, strFilePath);
        if (response == null){
            return null;
        }
        String strResult = response.getStringResult();
        return strResult;
    }

    /**
     * wap寤虹珛璇锋眰锛屼互琛ㄥ崟HTML褰㈠纺鏋勯€狅纸榛樿锛?
     * @param sParaTemp 璇锋眰鍙傛暟鏁扮粍
     * @param strMethod 鎻愪氦鏂瑰纺銆备袱涓€煎彲阃夛细post銆乬et
     * @param strButtonName 纭鎸夐挳鏄剧ず鏂囧瓧
     * @return 鎻愪氦琛ㄥ崟HTML鏂囨湰
     */
    public static String buildRequestWap(AlipayConfig config, Map<String, String> sParaTemp, String strMethod, String strButtonName){
        //寰呰姹傚弬鏁版暟缁?
        Map<String, String> sPara = buildRequestParaWap(config, sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" + config.getInput_charset() + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++){
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        //submit鎸夐挳鎺т欢璇蜂笉瑕佸惈链塶ame灞炴€?
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

        return sbHtml.toString();
    }

    /**
     * 鐢熸垚瑕佽姹傜粰鏀粯瀹濈殑鍙傛暟鏁扮粍
     * @param sParaTemp 璇锋眰鍓岖殑鍙傛暟鏁扮粍
     * @return 瑕佽姹傜殑鍙傛暟鏁扮粍
     */
    private static Map<String, String> buildRequestParaWap(AlipayConfig config, Map<String, String> sParaTemp){
        //闄ゅ幓鏁扮粍涓殑绌哄€煎拰绛惧悕鍙傛暟
        Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);
        //鐢熸垚绛惧悕缁撴灉
        String mysign = buildRequestMysign(config, sPara);

        //绛惧悕缁撴灉涓庣鍚嶆柟寮忓姞鍏ヨ姹傛彁浜ゅ弬鏁扮粍涓?
        sPara.put("sign", mysign);
        //sPara.put("sign_type", AlipayConfig.sign_type);
        sPara.put("sign_type", config.getSign_type());

        return sPara;
    }

    private static Map<String, String> buildRequestPara(AlipayConfig config, Map<String, String> sParaTemp){
        Map sPara = AlipayCore.paraFilter(sParaTemp);

        String mysign = AlipayCore.buildMysign(config, sPara);

        sPara.put("sign", mysign);
        if (!((String)sPara.get("service")).equals("alipay.wap.trade.create.direct")){
            if (!((String)sPara.get("service")).equals(
                        "alipay.wap.auth.authAndExecute"))
                sPara.put("sign_type", config.getSign_type());
        }
        return sPara;
    }

    /**
     * 鐢熸垚绛惧悕缁撴灉
     * @param sPara 瑕佺鍚岖殑鏁扮粍
     * @return 绛惧悕缁撴灉瀛楃涓?
     */
    public static String buildRequestMysign(AlipayConfig config, Map<String, String> sPara){
        String prestr = AlipayCore.createLinkString(sPara); //鎶婃暟缁勬墍链夊厓绱狅紝鎸夌収钬滃弬鏁?鍙傛暟链尖€濈殑妯″纺鐢ㄢ€?钬濆瓧绗︽嫾鎺ユ垚瀛楃涓?
        String mysign = "";
        if(config.getSign_type().equals("RSA")){
            mysign = RSA.signWap(prestr, AlipayConfig.private_key, config.getInput_charset());
        }
        return mysign;
    }


    /**
     * 鐢ㄤ簬阒查挀楸硷紝璋幂敤鎺ュ彛query_timestamp鏉ヨ幏鍙栨椂闂存埑镄勫鐞嗗嚱鏁?
     * 娉ㄦ剰锛氲繙绋嬭В鏋怷ML鍑洪敊锛屼笌链嶅姟鍣ㄦ槸鍚︽敮鎸丼SL绛夐厤缃湁鍏?
     * @return 镞堕棿鎴冲瓧绗︿覆
     * @throws IOException
     * @throws DocumentException
     * @throws MalformedURLException
     */
    public static String query_timestamp(AlipayConfig config) throws Exception {

        //鏋勯€犺闂畄uery_timestamp鎺ュ彛镄刄RL涓?
        String strUrl = ALIPAY_GATEWAY_NEW + "service=query_timestamp&partner=" + config.getPartner() + "&_input_charset" + config.getInput_charset();
        StringBuffer result = new StringBuffer();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new URL(strUrl).openStream());

        List<Node> nodeList = doc.selectNodes("//alipay/*");

        for (Node node : nodeList){
            // 鎴彇閮ㄥ垎涓嶉渶瑕佽В鏋愮殑淇℃伅
            if (node.getName().equals("is_success") && node.getText().equals("T")){
                // 鍒ゆ柇鏄惁链夋垚锷熸爣绀?
                List<Node> nodeList1 = doc.selectNodes("//response/timestamp/*");
                for (Node node1 : nodeList1){
                    result.append(node1.getText());
                }
            }
        }

        return result.toString();
    }

    public static String getRequestToken(AlipayConfig config, String text)
    throws Exception {
        String request_token = "";

        String[] strSplitText = text.split("&");

        Map paraText = new HashMap();
        for (int i = 0; i < strSplitText.length; i++){
            int nPos = strSplitText[i].indexOf("=");

            int nLen = strSplitText[i].length();

            String strKey = strSplitText[i].substring(0, nPos);

            String strValue = strSplitText[i].substring(nPos + 1, nLen);

            paraText.put(strKey, strValue);
        }

        if (paraText.get("res_data") != null){
            String res_data = (String)paraText.get("res_data");

            if (config.getSign_type().equals("0001")){
                res_data = RSA.decrypt(res_data, AlipayConfig.getPrivate_key(),
                                       config.getInput_charset());
            }

            Document document = DocumentHelper.parseText(res_data);
            request_token = document.selectSingleNode(
                                "//direct_trade_create_res/request_token").getText();
        }
        return request_token;
    }
}




