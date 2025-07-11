package com.px.partybuild.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.px.partybuild.vo.ImageBase64Vo;
import com.px.partybuild.vo.UploadFileBase64Vo;
import org.apache.commons.net.ftp.FTPClient;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.CfFile;
import org.bouncycastle.jcajce.provider.drbg.DRBG;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface FileService {
    /**
     * 文件目录
     * @param date
     * @param ftpClient
     * @return
     * @throws IOException
     */
    String createServeDir(Date date, FTPClient ftpClient) throws IOException;

    /**
     * save
     * @param byteArr
     * @param fileName
     * @param fileRefID
     * @param uid
     * @param fileType
     * @return
     */
    String saveFile(byte[] byteArr, String fileName, String fileRefID, String uid, Integer fileType);

    /**
     * 使用base64文件存储
     * @param file
     * @param fileName
     * @param fileRefID
     * @param uid
     * @param fileType
     * @return
     */
    String SaveFile(String file, String fileName, String fileRefID, String uid, Integer fileType);

    /**
     * down 根据fileId查询
     * @param fileId
     * @param os
     * @return
     */
    CfFile downFtpFile(String fileId, OutputStream os);

    /**
     * down 根据fileRefID查询 创建时间升序返回第一条数据
     * @param fileRefID
     * @param os
     * @return
     */
    CfFile downFtpFile2(String fileRefID, OutputStream os);

    /**
     * 查询cf_file表附件
     * @param fileRefID
     * @param fileTypeId
     * @param pageIndex
     * @param pageSize
     * @return
     * @date 2024-08
     */
    PageInfo<Map<String, Object>> getFileList(String fileRefID, Integer fileTypeId, int pageIndex, int pageSize);

    /**
     * delete
     * @param fileid
     * @return
     */
    int deleteFile(String fileid);

    int deleteFileByRefId(String fileRefId,Integer fileType);

    /**
     * down
     * @param beginTime
     * @return
     */
    List<Object> fileNeedDown(Date beginTime);

    /**
     * ftp uploda
     * @param ftpFileInfo [0]fileId,[1]fileBase64
     * @return
     */
    boolean ftpFileUplad(List<String> ftpFileInfo);

    Map<String,Object> FindTestResult(String fileRefId);

    String getFileBase64(String fileId) throws IOException;

    /**
     * 返回图片信息
     * @param id
     * @param type 1:fileId;2fileRefId
     * @return
     * */
    ImageBase64Vo getImageBase64(String id, String type) throws IOException;

    Integer uploadBase64(List<UploadFileBase64Vo> fileList, String userId) throws IOException;

}
