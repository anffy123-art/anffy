package com.px.partybuild.controller.workresourcelibrary;

import com.px.partybuild.AppConfig;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.DjWorkresourcelibrary;
import com.px.partybuild.model.DjWorkresourcelibrarytype;
import com.px.partybuild.service.UserService;
import com.px.partybuild.service.workresourcelibrary.WorkResourceLibraryService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.ExcelHelper;
import com.px.partybuild.util.Word2PdfUtil;
import com.px.partybuild.vo.DjWorkresourcelibraryVo;
import com.px.partybuild.vo.DsjTreeFiletype;
import com.github.pagehelper.PageInfo;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
 

@RestController
@RequestMapping(value = "/api/workresourcelibrary")
public class WorkResourceLibraryController {

    private final Logger logger;

    public WorkResourceLibraryController() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Autowired
    private WorkResourceLibraryService workResourceLibraryService;

    @Autowired
    private Word2PdfUtil word2PdfUtil;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private UserService userService;

    @GetMapping("/GetFilesByType")
    @ResponseBody
    public RequsetData<PageInfo<DjWorkresourcelibraryVo>> GetFilesByType(@RequestParam("filetypeid") String fileTypeId, @RequestParam(required = false) String fileName , @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {
        RequsetData<PageInfo<DjWorkresourcelibraryVo>> res = new RequsetData<>();

        res.setItem(workResourceLibraryService.getFilesByType(fileTypeId, fileName, pageIndex, pageSize));

        return res;
    }
    @ResponseBody
    @GetMapping("/getFile")
    public RequsetData<DjWorkresourcelibrary> getFile(@RequestParam(required = false) String fileId) {
        RequsetData<DjWorkresourcelibrary> result = new RequsetData<>();
        DjWorkresourcelibrary model = workResourceLibraryService.getFileInfo(fileId);
        if (model==null) {
            model=new DjWorkresourcelibrary();
            model.setFileid(UUID.randomUUID().toString());
        }
        result.setItem(model);
        return result;
    }
    @ResponseBody
    @PostMapping("/saveFile")
    public RequsetData<String> saveFile(@RequestBody DjWorkresourcelibrary model) {

        RequsetData<String> result = new RequsetData<>();
        model.setCreatedatetime(new Date());
        model.setFileurl(model.getFileid());
        model.setExtendedname(".pdf");
        result = workResourceLibraryService.saveFile(model, userService.getLoginUser().getUserid());

        return result;
    }
    @ResponseBody
    @GetMapping("/deleteFile")
    public RequsetData<Integer> deleteFile(@RequestParam("fileId") String fileId) {

        RequsetData<Integer> result = new RequsetData<>();
        int row = workResourceLibraryService.deleteFile(fileId);
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
    public RequsetData<PageInfo<DjWorkresourcelibraryVo>> GetFilesByKey(@RequestParam("fileName") String fileName, @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {
        RequsetData<PageInfo<DjWorkresourcelibraryVo>> res = new RequsetData<>();

        res.setItem(workResourceLibraryService.getFilesByKey(fileName, pageIndex, pageSize));

        return res;
    }

    @GetMapping("/GetFileTypeRoot")
    @ResponseBody
    public RequsetData<List<DsjTreeFiletype>> GetFileTypeRoot() {
        RequsetData<List<DsjTreeFiletype>> res = new RequsetData<>();
        //res.setItem(workResourceLibraryService.getFileTypeRoot());
        res.setItem(workResourceLibraryService.getFileTreeByParent("",null,null));
        return res;
    }

    @GetMapping("/GetFileTypesByParent")
    @ResponseBody
    public RequsetData<List<DsjTreeFiletype>> GetFileTypesByParent(@RequestParam("parentid") String parentId) {
        RequsetData<List<DsjTreeFiletype>> res = new RequsetData<>();
        //List<DjWorkresourcelibrarytype> parents = workResourceLibraryService.getFileTypeByParent(parentId);
        List<DsjTreeFiletype> parents = workResourceLibraryService.getFileTreeByParent(parentId,null,null);
        res.setItem(parents);
        return res;
    }
    @GetMapping("/getFiletypeList")
    @ResponseBody
    public RequsetData<PageInfo<Map<String, Object>>> getFiletypeList(@RequestParam(required=false) String typename,@RequestParam(required=false) String parentId,@RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) {
        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();
        PageInfo<Map<String, Object>> list = workResourceLibraryService.selectFiletypeList(typename,parentId,pageIndex, pageSize);
        res.setItem(list);
        return res;
    }
    @ResponseBody
    @GetMapping("/getFiletype")
    public RequsetData<DjWorkresourcelibrarytype> getFiletype(@RequestParam(required = false) String typeid) {
        RequsetData<DjWorkresourcelibrarytype> result = new RequsetData<>();

        DjWorkresourcelibrarytype filetype = workResourceLibraryService.getFiletype(typeid);
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
        int row = workResourceLibraryService.deleteFiletype(typeid);
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
    public RequsetData<String> saveFiletype(@RequestBody DjWorkresourcelibrarytype model) {

        RequsetData<String> result = new RequsetData<>();
        result = workResourceLibraryService.saveFiletype(model);

        return result;
    }
    @RequestMapping({"/showDoc/{fileId}"})
    @ResponseBody
    public String showDoc(HttpServletResponse response, @PathVariable("fileId") String fileId) {
        response.setContentType("application/pdf");
        //response.setContentType("text/html");
        DjWorkresourcelibrary file = workResourceLibraryService.getFileInfo(fileId);
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

        DjWorkresourcelibrary file = workResourceLibraryService.getFileInfo(fileId);
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

        res.setItem(workResourceLibraryService.getFileList(fileRefID, fileTypeId, pageIndex, pageSize));

        return res;
    }

    @GetMapping("/selectAllFile")
    @ResponseBody
    public RequsetData<List<Map<String, Object>>> selectAllFile() {
        RequsetData<List<Map<String, Object>>> res = new RequsetData<>();

        res.setItem(workResourceLibraryService.selectAllFile());

        return res;
    }


    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse response,
                                 @RequestParam("filetypeid") String fileTypeId,  @RequestParam(required = false) String fileName,
                                 @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize) throws Exception {
        /**查询数据**/
        List<DjWorkresourcelibraryVo> dataList = workResourceLibraryService.getFilesByType(fileTypeId, fileName, pageIndex, pageSize).getList();

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("党务工作资源库");
        sheet.setColumnWidth(1, 256 * 30);
        sheet.setColumnWidth(4, 256 * 15);

        try{
            List<String> titles = new ArrayList();
            titles.add("序号");
            titles.add("文件名称");
            titles.add("所属分类");
            titles.add("上传人");
            titles.add("最近修改时间");
            data.setTitles(titles);

            //数据
            List<List<Object>> rows = new ArrayList();
            List<List<XSSFCellStyle>> cellStyles = new ArrayList();
            XSSFCellStyle defaultStyle = excelHelper.setDefaultBorder(wb);

            int i = 0;
            for (DjWorkresourcelibraryVo item : dataList) {
                List<Object> row = new ArrayList();
                row.add(++i);
                row.add(item.getFilename());
                row.add(item.getSsfltypename());
                row.add(item.getUsername());
                row.add(dateUtils.dateToStrFormat(item.getUpdatedatetime(), "yyyy-MM-dd"));
                rows.add(row);

                List<XSSFCellStyle> styles= new ArrayList<>();
                for(int j=0;j<10;j++){
                    styles.add(defaultStyle);
                }
                cellStyles.add(styles);
            }

            data.setRows(rows);
            data.setStyleList(cellStyles);
        } catch (Exception ex) {
            wb.close();
        }

        excelHelper.exportExcelNew(wb , response,  "党务工作资源库.xlsx", data);
    }


}
