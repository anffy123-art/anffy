package com.px.partybuild.service.workresourcelibrary;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.DjWorkresourcelibrary;
import com.px.partybuild.model.DjWorkresourcelibrarytype;
import com.px.partybuild.vo.DjWorkresourcelibraryVo;
import com.px.partybuild.vo.DsjTreeFiletype;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author H
 * @date 2024-08
 */
public interface WorkResourceLibraryService {

    /**
     * 文件类型
     *
     * @param fileTypeId id
     * @param fileName   fn
     * @param pageIndex  pi
     * @param pageSize   ps
     * @return list
     */
    PageInfo<DjWorkresourcelibraryVo> getFilesByType(String fileTypeId, String fileName, int pageIndex, int pageSize);

    /**
     * 获取文件
     *
     * @return list
     */
    List<Map<String, Object>> selectAllFile();

    /**
     * 获取文件树
     *
     * @param parentId 父id
     * @return 文件
     */
    List<DsjTreeFiletype> getFileTreeByParent(String parentId, List<String> typeIds, List<String> passTypeIds);

    /**
     * 获取文件树
     *
     * @param parentId 父id
     * @return 文件
     */
    PageInfo<Map<String, Object>> selectFiletypeList(String typename, String parentId, int pageIndex, int pageSize);

    /**
     * 获取文件类型
     *
     * @param typeid
     * @return 文件类型
     */
    DjWorkresourcelibrarytype getFiletype(String typeid);

    /**
     * 删除文件类型
     *
     * @param id
     * @return
     */
    int deleteFiletype(String id);

    /**
     * 保存文件类型
     *
     * @param model
     * @return
     */
    RequsetData<String> saveFiletype(DjWorkresourcelibrarytype model);

    /**
     * 获取文件信息
     *
     * @param fileId id
     * @return m
     */
    DjWorkresourcelibrary getFileInfo(String fileId);

    /**
     * 查询cf_file表附件
     *
     * @param fileRefID  id
     * @param fileTypeId 1
     * @param pageIndex  1
     * @param pageSize   1
     * @return 附件
     * @date 2024-08
     */
    PageInfo<Map<String, Object>> getFileList(String fileRefID, Integer fileTypeId, int pageIndex, int pageSize);

    /**
     * 查询方法
     *
     * @param fileName  文件名 key
     * @param pageIndex 1
     * @param pageSize  10
     * @return list
     */
    PageInfo<DjWorkresourcelibraryVo> getFilesByKey(String fileName, int pageIndex, int pageSize);

    /**
     * 删除方法
     *
     * @param id 10
     * @return list
     */
    int deleteFile(String id);

    /**
     * 保存方法
     *
     * @param model 10
     * @return list
     */
    RequsetData<String> saveFile(DjWorkresourcelibrary model, String userId);
}
