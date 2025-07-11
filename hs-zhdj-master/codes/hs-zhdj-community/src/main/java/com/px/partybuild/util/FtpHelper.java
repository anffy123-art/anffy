package com.px.partybuild.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.px.partybuild.AppConfig;

@Scope(value = "request",proxyMode=org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS)
@Component
public class FtpHelper {

    @Autowired
    AppConfig appConfig;
    private final Logger logger;

    public FtpHelper(){
        logger = LoggerFactory.getLogger(this.getClass());
    }

    /**
     * 连接FTP
     * @throws FTPConnectionClosedException
     * @throws Exception
     */
    public void connectToServer(FTPClient ftpClient) throws FTPConnectionClosedException,Exception{
        if (!ftpClient.isConnected()) {
            int reply;
            try {
                ftpClient.setControlEncoding("utf-8");
                ftpClient.connect(appConfig.ftpHost,appConfig.ftpPort);
                ftpClient.login(appConfig.ftpUser,appConfig.ftpPwd);
                reply = ftpClient.getReplyCode();

                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftpClient.disconnect();
                    logger.info("connectToServer FTP server refused connection.");
                }

                ftpClient.enterLocalPassiveMode();
            }catch(FTPConnectionClosedException ex){
                logger.error("服务器:IP："+appConfig.ftpHost+"没有连接数！there are too many connected users,please try later", ex);
                throw ex;
            }catch (Exception e) {
                logger.error("登录ftp服务器【"+appConfig.ftpHost+"】失败", e);
                throw e;
            }
        }

    }

    /**
     * 关闭FTP连接
     */
    public void closeConnect(FTPClient ftpClient) {
        try {
            if (ftpClient != null && ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (Exception e) {
            logger.error("ftp连接关闭失败！", e);
        }
    }


}
