package com.px.partybuild;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author H
 * @date 2024-08
 */
@Component
public class AppConfig {
    @Value("${appconfig.appid}")
    public String appId;

    @Value("${appconfig.secret}")
    public String secret;



    @Value("${appconfig.uploadfile-url}")
    public String uploadfileUrl;


    @Value("${appconfig.isDev}")
    public String isDev;

    @Value("${appconfig.canLog}")
    public String canLog;

    @Value("${appconfig.canLoadDbImg}")
    public String canLoadDbImg;

    @Value("${appconfig.isBackService}")
    public boolean isBackService;

    @Value("${appconfig.desKey}")
    public String desKey;

    public String localPasssword;

    @Value("${appconfig.fileMgr-url}")
    public String fileMgrUrl;

    @Value("${appconfig.payCert-url}")
    public String certPath;

    @Value("${appconfig.gddwdm}")
    public String gddwdm;

    @Value("${appconfig.sys-name}")
    public String sysName;

    @Value("${appconfig.ftp-host}")
    public String ftpHost;

    @Value("${appconfig.ftp-port}")
    public int ftpPort;

    @Value("${appconfig.ftp-user}")
    public String ftpUser;

    @Value("${appconfig.ftp-pwd}")
    public String ftpPwd;

    @Value("${appconfig.app-des-secret}")
    public String appDesSecret;

    @Value("${appconfig.app-des-vi}")
    public String appDesVi;

    @Value("${appconfig.app-login-url}")
    public String appLoginUrl;

    @Value("${appconfig.app-saveCheckMessage-url}")
    public String appSaveCheckMessageUrl;

    @Value("${appconfig.app-updateCheckMessage-url}")
    public String appUpdateCheckMessageUrl;

    @Value("${appconfig.app-fromSys}")
    public String appFromSys;



    @Value("${appconfig.menu-dwids}")
    public String menuDwids;

    /**
     * 基层秘书角色id
     */
    @Value("${appconfig.jcms-roleId}")
    public String jcmsRoleId;

    @Value("${appconfig.safe-ext}")
    public ArrayList<String> safeExts;


    @Value("${appconfig.jxCasUrl}")
    public String jxCasUrl;

    @Value("${appconfig.jxLocationUrl}")
    public String jxLocationUrl;


    @Value("${appconfig.corsUrl}")
    public String corsUrl;

    /**
     * 微信支付参数配置
     */
    @Value("${wechat-pay-config.appId}")
    public String wechatAppId;
    @Value("${wechat-pay-config.mchId}")
    public String mchId;
    @Value("${wechat-pay-config.mchKey}")
    public String mchKey;
    @Value("${wechat-pay-config.keyPath}")
    public String keyPath;
    @Value("${wechat-pay-config.notifyUrl}")
    public String notifyUrl;
    @Value("${wechat-pay-config.appSecret}")
    public String wechatSecret;
    @Value("${wechat-pay-config.redirectURI}")
    public String redirectURI;
    @Value("${wechat-pay-config.accessScope}")
    public String accessScope;

    /**
     * @Description //TODO 静态文件路径
     * @date 2024-08
     * @Param 
     **/
    @Value("${spring.resources.static-locations}")
    public String staticLocations;



    public String getConfig(String FieldName) {
        String FieldValue = "";
        try {
            Field field = this.getClass().getField(FieldName);
            FieldValue = (String) field.get(this);
        } catch (Exception ex) {
            FieldValue = null;
        }
        return FieldValue;
    }

}
