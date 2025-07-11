package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.DsjFilemrg;
import com.px.partybuild.model.DsjFiletype;
import com.px.partybuild.service.FileMgrService;
import com.px.partybuild.util.Word2PdfUtil;
import com.px.partybuild.vo.DsjTreeFiletype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//import com.px.partybuild.util.HdfsConfig;
//import org.apache.hadoop.fs.FSDataInputStream;

//import org.apache.hadoop.fs.FileSystem;

@RestController
@RequestMapping(value = "/api/filemgr")
public class FileMgrController {

    private final Logger logger;

    public FileMgrController() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Autowired
    private FileMgrService fileMgrService;

    @Autowired
    private Word2PdfUtil word2PdfUtil;

    @Autowired
    private AppConfig appConfig;


    //@Autowired
    //private FileSystem fileSystem;

    @GetMapping("/GetFilesByType")
    @ResponseBody
    public RequsetData<PageInfo<DsjFilemrg>> GetFilesByType(@RequestParam("filetypeid") String fileTypeId, @RequestParam(required = false) String fileName , @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {
        RequsetData<PageInfo<DsjFilemrg>> res = new RequsetData<>();

        res.setItem(fileMgrService.getFilesByType(fileTypeId,fileName,pageIndex, pageSize));

        return res;
    }
    @ResponseBody
    @GetMapping("/getFile")
    public RequsetData<DsjFilemrg> getFile(@RequestParam(required = false) String fileId) {
        RequsetData<DsjFilemrg> result = new RequsetData<>();
        DsjFilemrg model = fileMgrService.getFileInfo(fileId);
        if (model==null) {
            model=new DsjFilemrg();
            model.setFileid(UUID.randomUUID().toString());
        }
        result.setItem(model);
        return result;
    }
    @ResponseBody
    @PostMapping("/saveFile")
    public RequsetData<String> saveFile(@RequestBody DsjFilemrg model) {

        RequsetData<String> result = new RequsetData<>();
        model.setCreatedatetime(new Date());
        model.setFileurl(model.getFileid());
        model.setExtendedname(".pdf");
        result = fileMgrService.saveFile(model);

        return result;
    }
    @ResponseBody
    @GetMapping("/deleteFile")
    public RequsetData<Integer> deleteFile(@RequestParam("fileId") String fileId) {

        RequsetData<Integer> result = new RequsetData<>();
        int row = fileMgrService.deleteFile(fileId);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }
    @GetMapping("/GetFilesByKey")
    @ResponseBody
    public RequsetData<PageInfo<DsjFilemrg>> GetFilesByKey(@RequestParam("fileName") String fileName, @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {
        RequsetData<PageInfo<DsjFilemrg>> res = new RequsetData<>();

        res.setItem(fileMgrService.getFilesByKey(fileName, pageIndex, pageSize));

        return res;
    }

    @GetMapping("/GetFileTypeRoot")
    @ResponseBody
    public RequsetData<List<DsjTreeFiletype>> GetFileTypeRoot() {
        RequsetData<List<DsjTreeFiletype>> res = new RequsetData<>();
        //res.setItem(fileMgrService.getFileTypeRoot());
        res.setItem(fileMgrService.getFileTreeByParent("",null,null));
        return res;
    }

    @GetMapping("/GetFileTypesByParent")
    @ResponseBody
    public RequsetData<List<DsjTreeFiletype>> GetFileTypesByParent(@RequestParam("parentid") String parentId) {
        RequsetData<List<DsjTreeFiletype>> res = new RequsetData<>();
        //List<DsjFiletype> parents = fileMgrService.getFileTypeByParent(parentId);
        List<DsjTreeFiletype> parents = fileMgrService.getFileTreeByParent(parentId,null,null);
        res.setItem(parents);
        return res;
    }
    @GetMapping("/getFiletypeList")
    @ResponseBody
    public RequsetData<PageInfo<Map<String, Object>>> getFiletypeList(@RequestParam(required=false) String typename,@RequestParam(required=false) String parentId,@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {
        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();
        PageInfo<Map<String, Object>> list = fileMgrService.selectFiletypeList(typename,parentId,pageIndex, pageSize);
        res.setItem(list);
        return res;
    }
    @ResponseBody
    @GetMapping("/getFiletype")
    public RequsetData<DsjFiletype> getFiletype(@RequestParam(required = false) String typeid) {
        RequsetData<DsjFiletype> result = new RequsetData<>();

        DsjFiletype filetype = fileMgrService.getFiletype(typeid);
        if (filetype!=null) {
            result.setSuccess(true);
            result.setItem(filetype);
        } else {
            result.setSuccess(false);
            result.setMsg("查找不到记录！");
        }
        return result;
    }
    @ResponseBody
    @GetMapping("/deleteFiletype")
    public RequsetData<Integer> deleteFiletype(@RequestParam("typeid") String typeid) {

        RequsetData<Integer> result = new RequsetData<>();
        int row = fileMgrService.deleteFiletype(typeid);
        result.setItem(row);
        if (row == 0) {
            result.setSuccess(false);
            result.setMsg("删除失败！");
        } else {
            result.setMsg("删除成功！");
        }
        return result;
    }
    @ResponseBody
    @PostMapping("/saveFiletype")
    public RequsetData<String> saveFiletype(@RequestBody DsjFiletype model) {

        RequsetData<String> result = new RequsetData<>();
        result = fileMgrService.saveFiletype(model);

        return result;
    }
    @RequestMapping({"/showDoc/{fileId}"})
    @ResponseBody
    public String showDoc(HttpServletResponse response, @PathVariable("fileId") String fileId) {
        response.setContentType("application/pdf");
        //response.setContentType("text/html");
        DsjFilemrg file = fileMgrService.getFileInfo(fileId);
        if (file != null) {
            try {
                /**
                 切换为读取hapoo的文件
                 Path pFileName= Paths.get(appConfig.fileMgrUrl,file.getFileurl()+file.getExtendedname());
                 if (Files.exists(pFileName)) {
                 InputStream doc =Files.newInputStream(pFileName);
                 OutputStream os = response.getOutputStream();
                 word2PdfUtil.doc2pdf(doc,os);
                 }*/
                /*
                Path pFileName = Paths.get(appConfig.fileMgrUrl, file.getFileurl() + file.getExtendedname());
                if (Files.exists(pFileName)) {
                    InputStream doc = Files.newInputStream(pFileName);
                    OutputStream os = response.getOutputStream();
                    word2PdfUtil.doc2pdf(doc, os);
                }*/
                Path pFileName = Paths.get(appConfig.fileMgrUrl, file.getFileurl() + file.getExtendedname());
                if (Files.exists(pFileName)) {
                    OutputStream os = response.getOutputStream();
                    Files.copy(pFileName, os);
                }

            } catch (Exception ex) {
                fileId = ex.getMessage();
                logger.info("showPDS失败:" + ex.getMessage());
            }
        }
        return fileId;
    }

    @ResponseBody
    @PostMapping("/postFile")
    public RequsetData<Object> PostFile(@RequestParam("file") MultipartFile file, @RequestParam("fileId") String fileId) {
        RequsetData<Object> res = new RequsetData<>();

        //byte[] byteArr = null;
        try {
            //byteArr = file.getBytes();
            String fileName=file.getOriginalFilename();

            String fileExt=fileName.substring(fileName.lastIndexOf(".")).toLowerCase();

            if(!appConfig.safeExts.contains(fileExt)){
                res.setSuccess(false);
                res.setMsg("上传失败：只能是pdf文件！");
                return res;
            }

            Path pFileName = Paths.get(appConfig.fileMgrUrl, fileId+".pdf");
            if(Files.exists(pFileName)){
                Files.delete(pFileName);
            }
            //Files.copy(pFileName,);
            file.transferTo(pFileName);
            res.setMsg("上传成功！");
        } catch (IOException e) {

            res.setSuccess(false);
            res.setMsg("上传失败："+e.getMessage());
        }

        return res;
    }

    @RequestMapping({"/downDoc/{fileId}"})
    @ResponseBody
    public String downDoc(HttpServletResponse response, HttpServletRequest request, @PathVariable("fileId") String fileId) {

        DsjFilemrg file = fileMgrService.getFileInfo(fileId);
        if (file != null) {
            Path pFileName = Paths.get(appConfig.fileMgrUrl, file.getFileurl() + file.getExtendedname());
            try {
                if (Files.exists(pFileName)) {
                    response.setContentType("application/force-download");// 设置强制下载不打开
                    response.setContentType("multipart/form-data;charset=UTF-8");

                    String fileName = file.getFilename() + file.getExtendedname();
                    String downloadFileName;
                    String agent = request.getHeader("USER-AGENT");
                    if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
                        downloadFileName = "=?UTF-8?B?" + (new String(Base64.getEncoder().encodeToString(fileName.getBytes("UTF-8")))) + "?=";
                    } else {
                        downloadFileName = URLEncoder.encode(fileName, "UTF-8");
                    }

                    response.addHeader("Content-Disposition",
                            "attachment;fileName=" + downloadFileName);// 设置文件名


                    OutputStream os = response.getOutputStream();
                    Files.copy(pFileName, os);
                }

            } catch (Exception ex) {
                fileId = ex.getMessage();
                logger.info("downDoc:" + ex.getMessage());
            }
        }
        return fileId;
    }


    /**
     * @Description //TODO 查询cf_file表附件
     * @date 2024-08
     * @Param [fileRefID, fileTypeId, pageIndex, pageSize]
     **/
    @GetMapping("/getFileList")
    @ResponseBody
    public RequsetData<PageInfo<Map<String, Object>>> GetFileList(@RequestParam("filerefid") String fileRefID, @RequestParam(required = false) Integer fileTypeId, @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {
        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();

        res.setItem(fileMgrService.getFileList(fileRefID, fileTypeId, pageIndex, pageSize));

        return res;
    }

    @GetMapping("/selectAllFile")
    @ResponseBody
    public RequsetData<List<Map<String, Object>>> selectAllFile() {
        RequsetData<List<Map<String, Object>>> res = new RequsetData<>();

        res.setItem(fileMgrService.selectAllFile());

        return res;
    }



}
