package com.px.partybuild.service;

import com.px.partybuild.controller.jsonmodel.DesModel;
import com.px.partybuild.model.CfFile;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface CommonService {

    /**
     * 获取序列号
     * @param key 1
     * @param Prefix 33
     * @return xxx
     */
    String createSNbyMonth(String key, String Prefix);

    /**
     * 保存文件
     * @param file 1
     * @return 2
     */
    Integer SaveFile(CfFile file);

    /**
     * updateFile
     * @param file
     * @return 1
     */
    Integer updateFile(CfFile file);

    /**
     * 1
     * @param fileName 1
     * @return a
     */
    CfFile CreateCfFile(String fileName);


    /**
     * 创建文件
     * @param fileName 文件名
     * @return 地址
     */
    String CreateServeFile(String fileName);

    /**
     * 创建文件全名
     * @param fileName 文件名
     * @return 成功地址
     */
    String CreateFileFullName(String fileName);

    /**
     * 文件列表
     * @param fileRefID 关系ID
     * @param pageIndex 序号
     * @param pageSize 数量
     * @param fileType 文件类型
     * @return 列表
     */
    PageInfo<CfFile> FindFileList(String fileRefID, Integer pageIndex, Integer pageSize,Integer fileType,String userId);

    /**
     * 单个文件
     * @param fileId 文件id
     * @return 文件实体
     */
    CfFile GetFile(String fileId);

    /**
     *  GetFileByRefID
     * @param fileRefId id
     * @return m
     */
    CfFile GetFileByRefID(String fileRefId);

    /**
     * DeleteFile
     * @param fileId
     * @return xxx
     * @throws IOException fileEX
     */
    Integer DeleteFile(String fileId) throws IOException;

    List<CfFile> GetFileList(String fileRefId);

    List<CfFile> GetFileList(List<String> fileRefId);

    /**
     *  DeleteFileByRefID
     * @param fileId id
     * @param fileRefId refId
     * @return 影响row
     */
    Integer DeleteFileByRefID(String fileId, String fileRefId);

    /**
     * BASE64Encode
     * @param word 文本
     * @return 密文
     */
    String BASE64Encode(String word);

    /**
     * BASE64Descode
     * @param word 密文
     * @return 明文
     */
    String BASE64Descode(String word);

    /**
     * des加密
     * @param words 文字
     * @param key 密码
     * @return 密文
     */
    String DesEnCode(String words, String key);

    /**
     * des解密
     * @param token 密文
     * @param key 密码
     * @return 明文
     */
    String DesDeCode(String token, String key);

    /**
     *  desToken
     * @param token token
     * @param tm 时间
     * @return 密文
     */
    String DesTokenData(String token, LocalDateTime tm);

    /**
     * 生成des token
     * @param data 字符
     * @return token
     */
    DesModel CreateDESToken(String data);

    /**
     * AppDesEncode
     * @param message 文字
     * @param key key
     * @param vi 偏移
     * @return 密文
     */
    String AppDesEncode(String message, String key,String vi);

    /**
     * 获取人员
     * @param rybm 人员编号
     * @return 字节
     */
    byte[] getDbImgbyRybm(String rybm);

    /**
     * 添加图片到库
     * @param fileId id
     * @param rybm 人员编号
     * @param imgBytes 字节
     * @return 影响行数
     */
    int addDbImgData(String fileId,String rybm,byte[] imgBytes);

    /**
     * app des解密专用
     * @param words
     * @param key
     * @param vi
     * @return
     */
    String AppDesDecodeVi(String words,String key,String vi);


}
