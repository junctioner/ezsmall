package com.wemall.core.tools;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/**
 * Created by John on 2016/1/13.
 */
public class MyX509TrustManager implements X509TrustManager {

    // 妫€镆ュ鎴风璇佷功
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    // 妫€镆ユ湇锷″櫒绔瘉涔?
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    // 杩斿洖鍙椾俊浠荤殑X509璇佷功鏁扮粍
    public X509Certificate[] getAcceptedIssuers(){
        return null;
    }
}
