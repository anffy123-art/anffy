package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.DsjFilemrg;
import com.px.partybuild.model.DsjFiletype;
import com.px.partybuild.vo.DsjTreeFiletype;

import java.util.List;
import java.util.Map;

/**
 *
 * @author H
 * @date 2024-08
 */
public interface FileMgrService {

    /**
     * 文件类型
     * @param fileTypeId id
     * @param fileName fn
     * @param pageIndex pi
     * @param pageSize ps
     * @return list
     */
    PageInfo<DsjFilemrg> getFilesByType(String fileTypeId, String fileName, int pageIndex, int pageSize);

    /**
     * 获取文件
     * @return list
     */
    List<Map<String, Object>> selectAllFile();

    /**
     * 获取根
     * @return
     */
    List<DsjFiletype> getFileTypeRoot();

    /**
     * 获取文件类型1
     * @param parentId
     * @return list
     */
    List<DsjFiletype> getFileTypeByParent(String parentId);

    /**
     * 获取文件树
     * @param parentId 父id
     * @return 文件
     */
    List<DsjTreeFiletype> getFileTreeByParent(String parentId,List<String> typeIds,List<String> passTypeIds);

    /**
     * 获取文件树
     * @param parentId 父id
     * @return 文件
     */
    PageInfo<Map<String, Object>> selectFiletypeList(String typename,String parentId ,int pageIndex, int pageSize);
    /**
     * 获取文件类型
     * @param typeid
     * @return 文件类型
     */
    DsjFiletype getFiletype(String typeid);

    /**
     * 删除文件类型
     * @param id
     * @return
     */
    int deleteFiletype(String id);
    /**
     * 保存文件类型
     * @param model
     * @return
     */
    RequsetData<String>  saveFiletype(DsjFiletype model);
    /**
     * 获取文件信息
     * @param fileId id
     * @return m
     */
    DsjFilemrg getFileInfo(String fileId);

    /**
     * 查询cf_file表附件
     * @date 2024-08
     * @param fileRefID id
     * @param fileTypeId 1
     * @param pageIndex 1
     * @param pageSize 1
     * @return 附件
     */
    PageInfo<Map<String, Object>> getFileList(String fileRefID, Integer fileTypeId, int pageIndex, int pageSize);

    /**
     * 查询方法
     * @param fileName 文件名 key
     * @param pageIndex 1
     * @param pageSize 10
     * @return list
     */
    PageInfo<DsjFilemrg> getFilesByKey(String fileName, int pageIndex, int pageSize);

    /**
     * 删除方法
     * @param id 10
     * @return list
     */
    int deleteFile(String id);

    /**
     * 保存方法
     * @param model 10
     * @return list
     */
    RequsetData<String> saveFile(DsjFilemrg model);

    PageInfo<Map<String,Object>> FindFilesApp(String fileName, String fileTypeId, int pageIndex, int pageSize);
}
