package com.px.partybuild.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

@Component
public class RemoteHelper {

    private final Logger logger;

    public RemoteHelper(){
        logger = LoggerFactory.getLogger(this.getClass());
    }



    protected CloseableHttpClient getHttpsHttpClient(){

        SSLConnectionSocketFactory factory =
                new SSLConnectionSocketFactory(SSLContexts.createDefault(),
                        new String[] {"TLSv1.2", "TLSv1"}, new String[] {"TLS_RSA_WITH_AES_256_CBC_SHA"},
                        SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(factory).build();

        return client;

    }

    protected CloseableHttpClient getHttpsHttpClient(InputStream cer) throws Exception{

        // Load Certificate
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        // 这里的路径为证书存放路径
        Certificate certificate =certificateFactory.generateCertificate(cer);

        // Create TrustStore
        KeyStore trustStoreContainingTheCertificate = KeyStore.getInstance("JKS");
        trustStoreContainingTheCertificate.load(null, null);

        // AddCertificate	第一个参数为证书别名, 可以任取
        trustStoreContainingTheCertificate.setCertificateEntry("XYZ", certificate);
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStoreContainingTheCertificate);

        // Create SSLContext	我这里协议为TLSv1.2
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null,trustManagerFactory.getTrustManagers(),null);
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();

        return client;

    }

    /**
     * 功能：后台交易提交请求报文并接收同步应答报文<br>
     * @param reqData 请求报文<br>
     * @param reqUrl  请求地址<br>
     * @param encoding<br>
     * @return 应答http 200返回true ,其他false<br>
     */
    public String post(
            Map<String, String> reqData, String reqUrl, String encoding) {
        String rspData="";
        Map<String,String> headers=new HashMap<>();
        rspData=post(reqData,reqUrl,encoding,headers);
        return rspData;
    }
    public String post(
            Map<String, String> reqData, String reqUrl, String encoding,Map<String,String> headers) {
        String rspData="";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(reqUrl);
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<>();
        for(String key:reqData.keySet()){
            formparams.add(new BasicNameValuePair(key,reqData.get(key)));
        }
        headers.entrySet().forEach(h->{
            httppost.setHeader(h.getKey(),h.getValue());
        });
        UrlEncodedFormEntity entity = null;
        try {

            entity = new UrlEncodedFormEntity(formparams, encoding);
            httppost.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(httppost);
            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    rspData= EntityUtils.toString(resEntity, encoding);
                    logger.info("Response content: [" + rspData+"]");
                }
            } finally {
                response.close();
            }

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
            }
        }
        return rspData;
    }

    public String postJson(String json,String reqUrl, String encoding){
        String rspData="";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(reqUrl);

        StringEntity entity;
        try {

            logger.info("postJson json: [" + json+"],url: ["+reqUrl+"]");

            httppost.setHeader("Content-Type", "application/json;charset="+encoding);

            entity=new StringEntity(json, encoding);
            entity.setContentType("text/json");

            httppost.setEntity(entity);

            CloseableHttpResponse response = httpClient.execute(httppost);
            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    rspData=EntityUtils.toString(resEntity, encoding);
                    logger.info("Response content: [" + rspData+"]");
                }
            } finally {
                response.close();
            }

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
            }
        }

        return rspData;
    }

    public String postJson(String json,String reqUrl, String encoding,Map<String,String> headers){
        String rspData="";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(reqUrl);

        StringEntity entity;
        try {

            logger.info("postJson json: [" + json+"],url: ["+reqUrl+"]");

            httppost.setHeader("Content-Type", "application/json;charset="+encoding);

            headers.entrySet().forEach(h->{
                httppost.setHeader(h.getKey(),h.getValue());
            });

            entity=new StringEntity(json, encoding);
            entity.setContentType("text/json");

            httppost.setEntity(entity);

            CloseableHttpResponse response = httpClient.execute(httppost);
            try {

                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    rspData=EntityUtils.toString(resEntity, encoding);
                    logger.info("Response content: [" + rspData+"]");
                }
            } finally {
                response.close();
            }

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
            }
        }

        return rspData;
    }

    public String SSLGet(Map<String,String> reqData,String reqUrl, String encoding,InputStream cer){
        String rspData="";

        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<>();
        for(String key:reqData.keySet()){
            formparams.add(new BasicNameValuePair(key,reqData.get(key)));
        }

        CloseableHttpClient httpClient=null;

        try {
            String paramsStr = EntityUtils.toString(new UrlEncodedFormEntity(formparams, encoding));
            // 创建httpget.
            HttpGet httpget = new HttpGet(reqUrl+"?"+paramsStr);
            if(cer==null) {
                httpClient = getHttpsHttpClient();
            } else {
                httpClient = getHttpsHttpClient(cer);
            }

            CloseableHttpResponse response =httpClient.execute(httpget);

            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    rspData=EntityUtils.toString(resEntity, encoding);
                    logger.info("Response content: [" + rspData+"]");
                }
            } finally {
                response.close();
            }

        } catch (Exception ex){

            logger.info(ex.getMessage(),ex);
        } finally {
            if(httpClient!=null){
                // 关闭连接,释放资源
                try {
                    httpClient.close();
                } catch (Exception e) {
                    logger.info(e.getMessage(), e);
                }

            }
        }

        return rspData;

    }

    public String getJson(Map<String,String> reqData,String reqUrl, String encoding){
        String rspData="";

        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<>();
        for(String key:reqData.keySet()){
            formparams.add(new BasicNameValuePair(key,reqData.get(key)));
        }

        try {
            String paramsStr = EntityUtils.toString(new UrlEncodedFormEntity(formparams, encoding));
            // 创建httpget.
            HttpGet httpget = new HttpGet(reqUrl+"?"+paramsStr);
            CloseableHttpResponse response = httpClient.execute(httpget);
            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    rspData=EntityUtils.toString(resEntity, encoding);
                    logger.info("Response content: [" + rspData+"]");
                }
            } finally {
                response.close();
            }

        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        } finally {
            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.info(e.getMessage(), e);
            }
        }
        return rspData;
    }
}
