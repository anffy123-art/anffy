package com.px.partybuild.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.pagehelper.PageInfo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.px.partybuild.AppConfig;
import com.px.partybuild.controller.jsonmodel.DesModel;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.CfDictionary;
import com.px.partybuild.model.CfFile;
import com.px.partybuild.model.CfUsers;
import com.px.partybuild.model.CfUsersinfo;
import com.px.partybuild.service.*;
import com.px.partybuild.shiro.JwtUtils;
import com.px.partybuild.util.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/home")
public class HomeController {
    @Autowired
    private LogService logService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private ExcelHelper excelHelper;

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    FtpHelper ftpHelper;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private com.px.partybuild.util.StringUtils stringUtils;


    @GetMapping("/login")
    @ResponseBody
    public RequsetData<String> Login(HttpServletResponse response, @RequestParam("uid") String uid, @RequestParam("pwd") String pwd){
        RequsetData<String> res = new RequsetData<>();

        //添加Licencing验证
        /*
        boolean isLinensing=commonService.IsLisense();
        if(!isLinensing){
            res.setSuccess(false);
            res.setMsg("授权验证失败，请联系厂商！");
            return res;
        }*/

        UsernamePasswordToken token = new UsernamePasswordToken(uid, DigestUtils.md5DigestAsHex(pwd.getBytes()).toUpperCase());

        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();

        try {

            currentUser.login(token);

            CfUsers user = userService.getEnableUserByKey(uid);

            //res.setItem(jwtUtils.generateToken(uid));
            res.setItem(jwtUtils.generateToken(user.getUserid()));
            Cookie cookie = new Cookie(jwtUtils.getTokenName(), res.getItem());
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
            res.setMsg("登陆成功！");

            CfUsersinfo curUser = userService.getUserInfobyId(user.getUserid());

            if (stringUtils.IsNullOrEmpty(curUser.getId()))
                throw new AuthenticationException("用户无效");

            List<HashMap<String, Object>> roleList = this.roleService.getRoleByUserName(uid);
            if (roleList == null || roleList.isEmpty()) {
                this.roleService.insertUserRole(uid, "0b45886a-a8db-4f85-af76-61a8ea7c1dab");
            }
            //CfUsers user=userService.getUserByKey(uid);
            userService.loginForceStatu(user.getUserid(), 0);

            logService.log("用户登录", user.getUserid(), "login");
        } catch (AuthenticationException e) {

            token.clear();

            //res.setMsg("登陆失败：" + e.getMessage());
            res.setMsg("登陆失败：登录账号或密码不正确，请重新输入！");
            res.setSuccess(false);
        }


        return res;
    }

    public RequsetData<String> LoginApi(HttpServletResponse response, String lid, String pwd) {
        RequsetData<String> res = new RequsetData<>();
        //String a =Charset.forName("UTF-8").decode(ByteBuffer.wrap(Base64.getUrlDecoder().decode(""))).toString();

        try {

            CfUsers User = userService.loginApiToUserId(lid, pwd);

            if (User != null && StringUtils.isNotBlank(User.getUsername())) {
                res.setItem(jwtUtils.generateToken(User.getUserid()));
                Cookie cookie = new Cookie(jwtUtils.getTokenName(), res.getItem());
                cookie.setHttpOnly(true);
                cookie.setPath("/");
                response.addCookie(cookie);
                res.setMsg("登陆成功！");

                List<HashMap<String, Object>> roleList = this.roleService.getRoleByUserName(User.getUsername());
                if (roleList == null || roleList.isEmpty()) {
                    this.roleService.insertUserRole(User.getUsername(), "0b45886a-a8db-4f85-af76-61a8ea7c1dab");
                }

                userService.loginForceStatu(User.getUserid(), 0);

                logService.log("用户登录", User.getUserid(), "login");
            } else {
                res.setMsg("登陆失败：登陆无相关账号记录！");
                res.setSuccess(false);
            }
        } catch (Exception e) {

            res.setMsg("登陆失败：远程api失败," + e.getMessage());
            res.setSuccess(false);
        }


        return res;
    }

    @PostMapping("/login")
    @ResponseBody
    public RequsetData<String> LoginDes(HttpServletResponse response, @RequestBody DesModel model, HttpServletRequest request) {

        String data = commonService.DesTokenData(model.getToken(), dateUtils.DateToDateTime(model.getTm()));
        String[] loginData = data.split("\\|");
        request.setAttribute("UserLoginId", loginData[0]);

        RequsetData<String> res = LoginApi(response, loginData[0], loginData[1]);

        return res;
    }

    @PostMapping("/locallogin")
    @ResponseBody
    public RequsetData<String> localLogin(HttpServletResponse response, @RequestBody DesModel model, HttpServletRequest request) {

        String data = commonService.DesTokenData(model.getToken(), dateUtils.DateToDateTime(model.getTm()));
        String[] loginData = data.split("\\|");
        request.setAttribute("UserLoginId", loginData[0]);
        RequsetData<String> res = Login(response, loginData[0], loginData[1]);

        return res;
    }


    @GetMapping("/error")
    @ResponseBody
    public RequsetData<String> error() {

        RequsetData<String> res = new RequsetData<>();
        res.setItem("无权限访问");
        res.setSuccess(false);
        res.setMsg(res.getItem());
        return res;
    }

    @ResponseBody
    @GetMapping("/sysName")
    public RequsetData<String> sysName() {
        RequsetData<String> res = new RequsetData<>();

        res.setItem(appConfig.sysName);

        return res;
    }

    @GetMapping("/logout")
    @ResponseBody
    public RequsetData<String> logout(HttpServletResponse response, HttpServletRequest request, @RequestParam("uid") String uid) {
        RequsetData<String> res = new RequsetData<>();
        res.setSuccess(false);
        res.setMsg("退出失败！");

        try {
            //String uid = (String)request.getAttribute("UserLoginId");
            Date outTime = org.apache.commons.lang3.time.DateUtils.addMinutes(new Date(), -5);

            userService.changeOnlineActivityDate(uid, outTime);

            for (Cookie ck : request.getCookies()) {
                if (ck.getName().equals(jwtUtils.getTokenName())) {
                    ck.setMaxAge(0);
                    ck.setPath("/");
                    ck.setHttpOnly(true);
                    response.addCookie(ck);
                    res.setMsg("退出成功！");
                    res.setSuccess(true);
                }
            }

        } catch (Exception ex) {
            log.error("logout,changeOnlineActivityDate", ex);
            res.setMsg("退出失败:" + ex.getMessage());
        }

        return res;
    }

    @ResponseBody
    @GetMapping("/selectlist")
    public RequsetData<PageInfo<CfDictionary>> selectlist(@RequestParam("dictypekey") String dicTypeKey, @RequestParam("dicvalue") String dicValue, @RequestParam("pageindex") Integer pageIndex, @RequestParam("pagesize") Integer pageSize) {
        RequsetData<PageInfo<CfDictionary>> res = new RequsetData<>();

        PageInfo<CfDictionary> datas = dictionaryService.findDictionaryList(dicTypeKey, dicValue, pageIndex, pageSize);
        res.setItem(datas);

        return res;
    }

    @ResponseBody
    @GetMapping("/findFileList")
    public RequsetData<PageInfo<Map<String, Object>>> FindFileList(@RequestParam("FileRefID") String fileRefID, @RequestParam("pageindex") Integer pageIndex, @RequestParam("pagesize") Integer pageSize, @RequestParam(required = false) Integer fileType
            , @RequestParam(required = false) String userId, @RequestParam(required = false) String filetypecode) {
        RequsetData<PageInfo<Map<String, Object>>> res = new RequsetData<>();

        PageInfo<CfFile> pList = commonService.FindFileList(fileRefID, pageIndex, pageSize, fileType, userId);
        List<CfFile> filelist = pList.getList();

        List<CfDictionary> dic_FileType = new ArrayList<>();
        if (!stringUtils.IsNullOrEmpty(filetypecode)) {
            dic_FileType = dictionaryService.getDictionaryListByDicTypeKey(filetypecode);
        }

        PageInfo<Map<String, Object>> result = new PageInfo<>();
        List<Map<String, Object>> maplist = new ArrayList<>();
        for (CfFile file : filelist) {
            Map<String, Object> map = mapUtils.objectToMap(file);
            map.put("username", userService.getUserInfobyId(file.getUserid()).getName());


            if (dic_FileType.size() > 0) {
                if (file.getFiletype() != null) {
                    map.put("filetypename", dictionaryService.getDicByKey(Integer.parseInt(file.getFiletype().toString()), dic_FileType).getDicvalue());
                }
            }

            maplist.add(map);
        }
        result.setTotal(pList.getTotal());
        result.setList(maplist);
        res.setItem(result);
        return res;
    }

    @ResponseBody
    @PostMapping("/postFile")
    public RequsetData<Object> PostFile(@RequestParam("file") MultipartFile file, @RequestParam("fileRefID") String fileRefID, @RequestParam(required = false) String uid, @RequestParam("filetype") int fileType) {
        RequsetData<Object> res = new RequsetData<>();

        byte[] byteArr = null;
        try {
            byteArr = file.getBytes();
            log.info("PostFile，上传文件大小" + byteArr.length);

            String fileName = file.getOriginalFilename();

            String fileExt = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();

            if (!appConfig.safeExts.contains(fileExt)) {
                res.setSuccess(false);
                res.setMsg("上传失败：文件扩展在不允许范围内！");
                return res;
            }

            String fileId = fileService.saveFile(byteArr, fileName, fileRefID, uid, fileType);
            if (!"".equals(fileId)) {
                res.setItem(fileId);
                res.setSuccess(true);
                res.setMsg("上传成功！");
            } else {
                res.setSuccess(false);
                res.setMsg("上传失败,添加失败！");
            }

        } catch (IOException e) {
            log.error("HomeController-postFile-IOException", e);
            res.setSuccess(false);
            res.setMsg("上传失败：" + e.getMessage());
        }

        return res;
    }

    @GetMapping("/delfile")
    public RequsetData<Integer> Delfile(@RequestParam("fileId") String fileId) {
        RequsetData<Integer> res = new RequsetData<>();
        try {
            res.setItem(commonService.DeleteFile(fileId));
            res.setMsg("删除成功！");
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("删除失败：" + ex.getMessage());
        }
        return res;
    }

    @GetMapping("/getFileByRefID")
    public RequsetData<CfFile> GetFileByRefID(@RequestParam("fileId") String fileId) {
        RequsetData<CfFile> res = new RequsetData<>();
        try {
            res.setItem(commonService.GetFileByRefID(fileId));
        } catch (Exception ex) {
            res.setSuccess(false);
        }
        return res;
    }

    @GetMapping("/delfileByRefID")
    public RequsetData<Integer> DelfileByRefID(@RequestParam("fileId") String fileId, @RequestParam("fileRefId") String fileRefId) {
        RequsetData<Integer> res = new RequsetData<>();
        try {
            res.setItem(commonService.DeleteFileByRefID(fileId, fileRefId));
            res.setMsg("删除成功！");
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg("删除失败：" + ex.getMessage());
        }
        return res;
    }

    @RequestMapping("/downloadFile/{fileId}")
    public String downloadFile(HttpServletResponse response, @PathVariable("fileId") String fileId, HttpServletRequest request) {
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.setContentType("multipart/form-data;charset=UTF-8");
        OutputStream os = null;
        InputStream ins = null;
        BufferedInputStream bis = null;
        FTPClient ftpClient = new FTPClient();
        try {
            CfFile file = commonService.GetFile(fileId);
            if (file == null) {
                file = commonService.GetFileByRefID(fileId);
            }
            String fileName = file.getFilename();
            String downloadFileName = "";
            String agent = request.getHeader("USER-AGENT");
            if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
                downloadFileName = "=?UTF-8?B?" + (new String(Base64.getEncoder().encodeToString(fileName.getBytes("UTF-8")))) + "?=";
            } else {
                downloadFileName = URLEncoder.encode(fileName, "UTF-8");
            }
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + downloadFileName);// 设置文件名
            os = response.getOutputStream();
            ftpHelper.connectToServer(ftpClient);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            ftpClient.retrieveFile(file.getFileurl(), os);

            if (null != os) {
                os.flush();
                os.close();
            }
            if (null != ins) {
                ins.close();
            }
            if (null != bis) {
                bis.close();
            }
            ftpHelper.closeConnect(ftpClient);
            log.info("HomeController-downloadFile-end");
        } catch (Exception ex) {
            log.error("HomeController-downloadFile-Exception-fileId:" + fileId, ex);
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    log.error("HomeController-downloadFile-os关闭异常", e);
                }
            }
            if (null != ins) {
                try {
                    ins.close();
                } catch (IOException e) {
                    log.error("HomeController-downloadFile-ins关闭异常", e);
                }
            }
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    log.error("HomeController-downloadFile-bis关闭异常", e);
                }
            }
            ftpHelper.closeConnect(ftpClient);
        }
        return fileId;
    }

    @RequestMapping("/zipdownloadFile/{fileId}/{fileName}")
    public String zipdownloadFile(HttpServletResponse response, @PathVariable("fileId") String fileId, @PathVariable("fileName") String fileName, HttpServletRequest request) {
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.setContentType("multipart/form-data;charset=UTF-8");
        //java.io.File tempFile;
        ZipOutputStream out = null;
        fileName = dateUtils.dateToStrFormat(new Date(), "yyyy-MM-dd") + fileName + ".zip";
        FTPClient ftpClient = new FTPClient();
        try {

            ftpHelper.connectToServer(ftpClient);
            ByteArrayOutputStream fileOStream = new ByteArrayOutputStream();

            out = new ZipOutputStream(fileOStream);
            out.setEncoding("gbk");
            List<CfFile> files = commonService.GetFileList(fileId);
            int count = 0;
            for (CfFile file : files) {
                //打包显示的文件名
                String username = userService.getUserInfobyId(file.getUserid()).getName();
//                out.putNextEntry(new ZipEntry((++count) + "-" + file.getFilename()));
                out.putNextEntry(new ZipEntry(username + "-" + file.getFilename()));
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.retrieveFile(file.getFileurl(), out);
                out.flush();
                out.closeEntry();
            }
            //所有文件写完后一定要关闭输出流，否则文件下载会不完整。
            out.flush();
            out.close();
            ftpHelper.closeConnect(ftpClient);

            //将zip文件写入响应
            String name;
            String agent = request.getHeader("USER-AGENT");
            if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
                name = "=?UTF-8?B?" + (Base64.getEncoder().encodeToString(fileName.getBytes("UTF-8"))) + "?=";
            } else {
                name = URLEncoder.encode(fileName, "UTF-8");
            }
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + name);

            OutputStream os = response.getOutputStream();
            fileOStream.writeTo(os);

            os.flush();


        } catch (Exception e) {
            e.printStackTrace();
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
            throw new RuntimeException();
        }
        return fileId;
    }

    @RequestMapping("/zipdownloadFiles/{fileId}/{fileName}")
    public List<String> zipdownloadFiles(HttpServletResponse response, @PathVariable("fileId") List<String> fileId, @PathVariable("fileName") String fileName, HttpServletRequest request) {
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.setContentType("multipart/form-data;charset=UTF-8");
        //java.io.File tempFile;
        ZipOutputStream out = null;
        fileName = dateUtils.dateToStrFormat(new Date(), "yyyy-MM-dd") + fileName + ".zip";
        FTPClient ftpClient = new FTPClient();
        try {

            ftpHelper.connectToServer(ftpClient);
            ByteArrayOutputStream fileOStream = new ByteArrayOutputStream();

            out = new ZipOutputStream(fileOStream);
            out.setEncoding("gbk");
            List<CfFile> files = commonService.GetFileList(fileId);
            int count = 0;
            for (CfFile file : files) {
                //打包显示的文件名
                String username = userService.getUserInfobyId(file.getUserid()).getName();
//                out.putNextEntry(new ZipEntry((++count) + "-" + file.getFilename()));
                out.putNextEntry(new ZipEntry(username + "-" + file.getFilename()));
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.retrieveFile(file.getFileurl(), out);
                out.flush();
                out.closeEntry();
            }
            //所有文件写完后一定要关闭输出流，否则文件下载会不完整。
            out.flush();
            out.close();
            ftpHelper.closeConnect(ftpClient);

            //将zip文件写入响应
            String name;
            String agent = request.getHeader("USER-AGENT");
            if (agent != null && agent.toLowerCase().indexOf("firefox") > 0) {
                name = "=?UTF-8?B?" + (Base64.getEncoder().encodeToString(fileName.getBytes("UTF-8"))) + "?=";
            } else {
                name = URLEncoder.encode(fileName, "UTF-8");
            }
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + name);

            OutputStream os = response.getOutputStream();
            fileOStream.writeTo(os);

            os.flush();


        } catch (Exception e) {
            e.printStackTrace();
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
            throw new RuntimeException();
        }
        return fileId;
    }

    @RequestMapping("/downloadTemplate/{fileurl}")
    public String downloadTemplate(HttpServletResponse response, @PathVariable("fileurl") String fileurl) {
        Path fileServeUrl = Paths.get(commonService.CreateFileFullName("temp/" + fileurl));

        if (Files.exists(fileServeUrl)) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.setContentType("multipart/form-data;charset=UTF-8");
            try {
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + URLEncoder.encode(new File(fileServeUrl.toUri()).getName(), "utf-8"));// 设置文件名
            } catch (Exception ex) {
                fileurl = ex.getMessage();
            }
            try {
                OutputStream os = response.getOutputStream();
                Files.copy(fileServeUrl, os);
            } catch (IOException ex) {
                //ex.printStackTrace();
                fileurl = ex.getMessage();
                log.error("downloadTemplate错误", ex);
            }
        }


        return fileurl;
    }

    @RequestMapping({"/showImg/{fileId}"})
    @ResponseBody
    public String showImg(HttpServletResponse response, @PathVariable("fileId") String fileId) {
        /*String imgType = "image/";
        CfFile file = commonService.GetFileByRefID(fileId);

        if (file == null)
            return "";
        Path fileServeUrl = Paths.get(commonService.CreateFileFullName(file.getFileurl()));

        if (Files.exists(fileServeUrl)) {
            response.setContentType(imgType + file.getFilesuffix().substring(1));

            try {

                OutputStream os = response.getOutputStream();
                Files.copy(fileServeUrl, os);
            } catch (IOException ex) {
                //ex.printStackTrace();
                fileId = ex.getMessage();
            }
        }

        return fileId;*/
        String imgType = "image/";

        try {
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            CfFile file = fileService.downFtpFile(fileId, os);
            response.setContentType(imgType + file.getFilesuffix().substring(1));
            os.flush();

        } catch (Exception ex) {
            log.error("showImg错误", ex);
        }

        return fileId;
    }

    @RequestMapping({"/showDbImg/{rybm}"})
    @ResponseBody
    public String showDbImg(HttpServletResponse response, @PathVariable("rybm") String rybm) {

        String imgType = "image/";

        try {
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            byte[] imgBytes = commonService.getDbImgbyRybm(rybm);
            if (imgBytes != null) {
                os.write(imgBytes);
                os.flush();
            }
            //os.write();
            //Files.copy()
            //CfFile file = fileService.downFtpFile(fileId, os);
            //response.setContentType(imgType + file.getFilesuffix().substring(1));

        } catch (Exception ex) {
            log.error("showDbImg错误", ex);
        }

        return rybm;
    }

    @RequestMapping({"/showPDF/{fileId}"})
    @ResponseBody
    public String showPDF(HttpServletResponse response, @PathVariable("fileId") String fileId) {

        try {
            response.setContentType("application/pdf");
            OutputStream os = response.getOutputStream();

            CfFile file = fileService.downFtpFile(fileId, os);


        } catch (Exception ex) {
            log.error("showPDF错误", ex);
        }

        return fileId;
    }

    @GetMapping("/addDbImg")
    @ResponseBody
    public RequsetData<String> addDbImg(@RequestParam("fileId") String fileId, @RequestParam("rybm") String rybm) {

        RequsetData<String> res = new RequsetData<>();
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            CfFile file = fileService.downFtpFile(fileId, bos);

            Integer row = commonService.addDbImgData(fileId, rybm, bos.toByteArray());
            res.setItem(row.toString());

        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }


        return res;
    }


    @GetMapping("/loadExcelRows")
    public RequsetData<Object> loadExcelRows(@RequestParam("fileRefId") String fileRefId) throws IOException {
        RequsetData<Object> res = new RequsetData<>();
        CfFile file = commonService.GetFileByRefID(fileRefId);
        if (file == null) {
            return res;
        }
        InputStream input = new FileInputStream(new File(commonService.CreateFileFullName(file.getFileurl())));
        Map<String, Object> columns = columns = new TreeMap<String, Object>(
                new Comparator<String>() {
                    @Override
                    public int compare(String obj1, String obj2) {
                        return obj1.compareTo(obj2);
                    }
                });
        ArrayList<Map<String, String>> mapList = excelHelper.readExcel(input, file.getFilename(), columns);
        if (mapList.size() > 0) {
            res.setItem(mapList);
            res.setExtdata(columns);
        } else {
            res.setSuccess(false);
        }
        return res;
    }

    @RequestMapping("/testdate")
    public RequsetData<Date> testDate(HttpServletResponse response) {
        RequsetData<Date> res = new RequsetData<>();
        res.setItem(new Date());
        CfUsers result = userService.getCfuserByUsername("管理员");
        res.setMsg(result.getUsername());

        return res;
    }

    @ResponseBody
    @PostMapping("/importExcel")
    public RequsetData<Object> importExcel(@RequestParam("file") MultipartFile file, @RequestParam(required = false) Map<String, Object> columns) throws IOException {
        RequsetData<Object> res = new RequsetData<>();
        ArrayList<Map<String, String>> mapList = new ArrayList<>();
        String message = "";
        try {
            mapList = excelHelper.readExcel(file.getInputStream(), file.getOriginalFilename(), columns);
        } catch (Exception e) {
            message = "文件读取错误:" + e.toString();
        }
        if (mapList.size() > 0) {
            res.setItem(mapList);
            res.setMsg("导入成功！");

        } else {
            res.setSuccess(false);
            res.setMsg("导入失败！" + message);
        }
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "/exportErrorExcel", method = RequestMethod.POST)
    public void exportErrorExcel(HttpServletResponse response,
                                 String columns,
                                 String text) throws Exception {
        /*HashMap<String, String> columnList = JsonMapper.jsonToObject(columns, new TypeReference<HashMap<String, String>>() {
        });*/
        //Map<String,String> columnList = (Map) JSON.parse(columns, Feature.OrderedField);

        List<HashMap<String, String>> mapDataList = JsonMapper.jsonToObject(text, new TypeReference<List<HashMap<String, String>>>() {
        });
        List<String> fieldList = new ArrayList<>();
        List<String> keyList = new ArrayList<>();

        JsonNode result = JsonMapper.GetJsonNode(columns);
        result.fields().forEachRemaining(it -> {
            keyList.add(it.getKey());
            fieldList.add(it.getValue().asText());
        });

        ExcelHelper excelHelper = new ExcelHelper();
        ExcelHelper.ExcelData data = excelHelper.new ExcelData();

        //列名
        data.setName("错误信息");
        List<String> titles = new ArrayList();
        for (String item : fieldList) {
            titles.add(item);
        }
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        for (HashMap<String, String> item : mapDataList) {
            List<Object> row = new ArrayList();
            for (String key : keyList) {
                row.add(item.get(key));
            }

            rows.add(row);
        }
        data.setRows(rows);

        excelHelper.exportExcel(response, "错误信息导出.xlsx", data);
    }

    @ResponseBody
    @RequestMapping("/forgotPassword")
    public RequsetData<Object> ForgetPassword(HttpServletResponse response) {
        RequsetData<Object> res = new RequsetData<>();
        res.setSuccess(true);
        return res;
    }

    @ResponseBody
    @RequestMapping("/sendPassword")
    public RequsetData<Object> SendPassword(@RequestBody Map<String, Object> reqMap) {
        RequsetData<Object> res = new RequsetData<>();
        try {
            userService.sendPassword(reqMap.get("uid").toString(), reqMap.get("email").toString());
            res.setSuccess(true);
            res.setMsg("新密码已经发送至邮箱，请及时查看");
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }
        return res;
    }

    @PostMapping("/getLastActivityDate")
    @ResponseBody
    public RequsetData<String> GetLastActivityDate(String uid) {
        RequsetData<String> res = new RequsetData<>();

        try {
            //查看登录用户上次登录日期
            Timestamp lastActiveDate = userService.getLastActivityDate(uid);
            System.out.println(lastActiveDate);
            if (lastActiveDate != null) {
                res.setSuccess(true);

                res.setMsg("登陆成功！");
            } else {
                res.setSuccess(false);
            }

            /*更新lastActivityDate
            CfUsers cfUsers = new CfUsers();
            cfUsers.setUsername(uid);
            cfUsers.setLastactivitydate(new Timestamp(new Date().getTime()));
            userService.updateLastActivityDate(cfUsers);*/


        } catch (AuthenticationException e) {

            //res.setMsg("登陆失败：" + e.getMessage());
            res.setMsg("数据库异常");
            res.setSuccess(false);
        }


        return res;
    }

    @PostMapping("/setOnlineUser")
    @ResponseBody
    public RequsetData<Integer> setOnlineUser(@RequestBody Map<String, Object> reqMap) {
        RequsetData<Integer> res = new RequsetData<>();

        try {
            //查看登录用户上次登录日期
            String uid = reqMap.get("uid").toString();
            int forceStatu = userService.checkForceStatu(uid);
            //强制下线
            if (forceStatu == 1) {
                res.setItem(-1);
                res.setSuccess(false);

            } else {
                Integer rows = userService.changeOnlineActivityDate(uid, new Date());
                res.setItem(rows);
            }


        } catch (Exception e) {

            res.setMsg("数据库异常：" + e.getMessage());
            res.setSuccess(false);
        }


        return res;
    }

    @ResponseBody
    @GetMapping("/ShowQRCode")
    public RequsetData<String> ShowQRCode(HttpServletResponse response, @RequestParam("code") String code) {
        RequsetData<String> res = new RequsetData<>();
        int width = 400, height = 400;
        String format = "png", character_set = "UTF-8";

        response.setContentType("image/" + format);

        // 设置字符集编码
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, character_set);
        try {
            // 生成二维码矩阵
            BitMatrix bitMatrix = new MultiFormatWriter().encode(code, BarcodeFormat.QR_CODE, width, height, hints);
            OutputStream os = response.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, format, os);
            res.setItem(code);
            res.setMsg("生成成功！");
        } catch (Exception ex) {
            res.setSuccess(false);
            res.setMsg(ex.getMessage());
        }
        return res;
    }


}
