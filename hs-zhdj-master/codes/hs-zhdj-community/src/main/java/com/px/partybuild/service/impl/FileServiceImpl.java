package com.px.partybuild.service.impl;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.px.partybuild.mapper.CfFileCQuery;
import com.px.partybuild.util.BASE64DecodedMultipartFile;
import com.px.partybuild.vo.ImageBase64Vo;
import com.px.partybuild.vo.UploadFileBase64Vo;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.CfFileMapper;
import com.px.partybuild.model.CfFile;
import com.px.partybuild.model.CfFileExample;
import com.px.partybuild.service.FileService;
import com.px.partybuild.util.FtpHelper;
import com.px.partybuild.util.MapUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;

@Service("fileService")
public class FileServiceImpl implements FileService {

    @Autowired
    FtpHelper ftpHelper;

    @Autowired
    CfFileMapper cfFileMapper;

    @Autowired
    CfFileCQuery cfFileCQuery;

    @Autowired
    private MapUtils mapUtils;

    private final Logger logger;

    private String ENCODE = "utf-8";

    private List<String> imageTypes = new ArrayList<>();

    public FileServiceImpl() {
        logger = LoggerFactory.getLogger(this.getClass());
        this.imageTypes.add("jpg");
        this.imageTypes.add("bmp");
        this.imageTypes.add("jpeg");
        this.imageTypes.add("png");
        this.imageTypes.add("gif");
        this.imageTypes.add("jpe");

    }

    @Override
    public String createServeDir(Date date, FTPClient ftpClient) throws IOException {

        String fileDir = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMM"));

        FTPFile[] ftpFiles = ftpClient.listFiles(fileDir);
        if (ftpFiles.length == 0) {
            ftpClient.makeDirectory(fileDir);
        }

        return fileDir;
    }

    @Override
    public String saveFile(byte[] byteArr, String fileName, String fileRefID, String uid, Integer fileType) {

        CfFile cfFile = new CfFile();
        FTPClient ftpClient = new FTPClient();
        String fileId = "";
        InputStream fileStream = null;
        try {

            cfFile.setFilesuffix(fileName.substring(fileName.lastIndexOf(".")));

            if (this.imageTypes.contains(cfFile.getFilesuffix().replace(".", "").toLowerCase())) {
                byte[] inform = informImage(byteArr);
                fileStream = new ByteArrayInputStream(inform);
            } else {
                fileStream = new ByteArrayInputStream(byteArr);
            }

            fileId = UUID.randomUUID().toString();
            ftpHelper.connectToServer(ftpClient);

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            cfFile.setFileid(fileId);
            cfFile.setUserid(uid);
            cfFile.setFiletype(fileType);
            cfFile.setFilerefid(fileRefID);
            cfFile.setCreatetime(new Date());
            String filePath = createServeDir(cfFile.getCreatetime(), ftpClient);

            cfFile.setFilename(fileName);
            cfFile.setFileurl(filePath + "/" + fileId + cfFile.getFilesuffix());
            cfFile.setOperatestate("A");
            cfFile.setOperatetime(new Date());
            cfFile.setSyncstate("N");

            ftpClient.changeWorkingDirectory(filePath);

            ftpClient.storeFile(fileId + cfFile.getFilesuffix(), fileStream);

            ftpHelper.closeConnect(ftpClient);

            cfFileMapper.insert(cfFile);

        } catch (Exception ex) {
            logger.error("saveFile，保存表和上传文件到ftp。", ex);
            fileId = "";
        }

        return fileId;
    }

    @Override
    public String SaveFile(String file, String fileName, String fileRefID, String uid, Integer fileType) {

        CfFile cfFile = new CfFile();
        FTPClient ftpClient = new FTPClient();
        String fileId = "";

        if (StringUtils.isBlank(file)) {
            return fileId;
        }
        //logger.info("file:"+file.length());
        //logger.info(file);

        try {

            fileId = UUID.randomUUID().toString();
            ftpHelper.connectToServer(ftpClient);

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            cfFile.setFileid(fileId);
            cfFile.setUserid(uid);
            cfFile.setFiletype(fileType);
            cfFile.setFilerefid(fileRefID);
            cfFile.setCreatetime(new Date());
            String filePath = createServeDir(cfFile.getCreatetime(), ftpClient);
            if (fileName.indexOf(".") >= 0) {
                cfFile.setFilesuffix(fileName.substring(fileName.lastIndexOf(".")));
            } else {
                cfFile.setFilesuffix("");
            }
            cfFile.setFilename(fileName);
            cfFile.setFileurl(filePath + "/" + fileId + cfFile.getFilesuffix());
            cfFile.setOperatestate("A");
            cfFile.setOperatetime(new Date());
            cfFile.setSyncstate("N");

            int indexBase = file.indexOf("base64,");
            if (indexBase > 0) {
                file = file.substring(indexBase + "base64,".length());
            }

            //byte[] bufImg = new BASE64Decoder().decodeBuffer(file);
            byte[] bufImg = Base64.getDecoder().decode(file);

            ftpClient.changeWorkingDirectory(filePath);

            ftpClient.storeFile(fileId + cfFile.getFilesuffix(), new ByteArrayInputStream(bufImg));

            //ftpClient.retrieveFile("",)

            ftpHelper.closeConnect(ftpClient);

            cfFileMapper.insert(cfFile);

        } catch (Exception ex) {
            logger.error("SaveFile，保存表和上传文件到ftp。", ex);
            fileId = "";
        }


        return fileId;
    }

    public byte[] informImage(byte[] byteArr) {

        byte[] result = null;
        //设置处理大小500K
        int imageSize = 1024 * 1024 / 2;

        if (byteArr.length < imageSize) {
            result = byteArr;
        } else {
            InputStream sourceImage = new ByteArrayInputStream(byteArr);
            ByteArrayOutputStream osImage = null;
            try {

                osImage = changeImageSize(sourceImage);

                while (osImage.size() > imageSize) {

                    osImage = changeImageQuality(new ByteArrayInputStream(osImage.toByteArray()));

                }

                result = osImage.toByteArray();

            } catch (Exception ex) {
                logger.error("informImage，图片读取失败！", ex);
            }


        }

        logger.info("informImage,ftp上传压缩图片大小为：" + result.length);

        return result;
    }

    public ByteArrayOutputStream changeImageSize(InputStream imageStream) {

        ByteArrayOutputStream outArray = new ByteArrayOutputStream();
        try {
            Thumbnails.of(imageStream).size(1920, 1080).toOutputStream(outArray);
        } catch (Exception ex) {
            logger.error("ImageChangeSize，图片大小失败！", ex);
        }
        return outArray;
    }

    public ByteArrayOutputStream changeImageQuality(InputStream imageStream) {

        ByteArrayOutputStream outArray = new ByteArrayOutputStream();
        try {
            Thumbnails.of(imageStream).outputQuality(0.75f).toOutputStream(outArray);
        } catch (Exception ex) {
            logger.error("changeImageQuality，图片质量失败！", ex);
        }

        return outArray;
    }

    protected String GetParentPath(String fileUrl) {
        int len = fileUrl.lastIndexOf("/");
        return fileUrl.substring(0, len);
    }

    @Override
    public CfFile downFtpFile(String id, OutputStream os) {
        CfFile file = cfFileMapper.selectByPrimaryKey(id);

        try {
            FTPClient ftpClient = new FTPClient();
            ftpHelper.connectToServer(ftpClient);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            ftpClient.retrieveFile(file.getFileurl(), os);
            /*
            FTPFile[] files = ftpClient.listFiles(file.getFileurl());

            if(files.length>0){

                String filePath=GetParentPath(file.getFileurl());

                ftpClient.changeWorkingDirectory(filePath);


            }*/

            ftpHelper.closeConnect(ftpClient);

        } catch (Exception ex) {
            logger.error("downFtpFile，下载文件失败！", ex);
            file = null;
        }

        return file;
    }

    @Override
    public CfFile downFtpFile2(String id, OutputStream os) {
        CfFileExample emp = new CfFileExample();
        emp.or().andFilerefidEqualTo(id);
        emp.setOrderByClause("createtime");
        CfFile file = cfFileMapper.selectByExample(emp).stream().findFirst().orElse(null);

        if(file == null){
            return null;
        }

        try {
            FTPClient ftpClient = new FTPClient();
            ftpHelper.connectToServer(ftpClient);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            ftpClient.retrieveFile(file.getFileurl(), os);
            /*
            FTPFile[] files = ftpClient.listFiles(file.getFileurl());

            if(files.length>0){

                String filePath=GetParentPath(file.getFileurl());

                ftpClient.changeWorkingDirectory(filePath);


            }*/

            ftpHelper.closeConnect(ftpClient);

        } catch (Exception ex) {
            logger.error("downFtpFile，下载文件失败！", ex);
            file = null;
        }

        return file;
    }

    @Override
    public PageInfo<Map<String, Object>> getFileList(String fileRefID, Integer fileTypeId, int pageIndex, int pageSize) {

        //List<CfDictionary> dic_ztType=dictionaryService.getDictionaryListByDicTypeKey("FileMgrType");

        PageHelper.startPage(pageIndex, pageSize);

        CfFileExample exp = new CfFileExample();
        CfFileExample.Criteria cri = exp.or();
        if (fileTypeId != null) {
            cri.andFiletypeEqualTo(fileTypeId);
        }
        cri.andFilerefidEqualTo(fileRefID);
        cri.andOperatestateNotEqualTo("D");

        List<CfFile> flist = cfFileMapper.selectByExample(exp);
        List<Map<String, Object>> mList = new ArrayList<>();

        for (CfFile it : flist) {
            Map<String, Object> mit = mapUtils.objectToMap(it);
            mList.add(mit);
        }

        PageInfo<Map<String, Object>> pList = new PageInfo(mList);
        return pList;
    }

    @Override
    public int deleteFile(String fileid) {
        return cfFileMapper.deleteByPrimaryKey(fileid);
    }

    @Override
    public int deleteFileByRefId(String fileRefId, Integer fileType) {
        CfFileExample exp = new CfFileExample();
        CfFileExample.Criteria cri = exp.or();
        cri.andFilerefidEqualTo(fileRefId);
        if (fileType != null) {
            cri.andFiletypeEqualTo(fileType);
        }

        return cfFileMapper.deleteByExample(exp);
    }

    @Override
    public List<Object> fileNeedDown(Date beginTime) {
        List<Object> files = new ArrayList<>();
        CfFileExample exp = new CfFileExample();
        List<String> oStates = new ArrayList<>();
        oStates.add("A");
        oStates.add("M");

        exp.or().andOperatestateIn(oStates).andOperatetimeGreaterThan(beginTime);

        List<CfFile> cfFiles = cfFileMapper.selectByExample(exp);

        try {
            FTPClient ftpClient = new FTPClient();
            ftpHelper.connectToServer(ftpClient);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            cfFiles.forEach(f -> {
                try {
                    FTPFile[] ftpFiles = ftpClient.listFiles(f.getFileurl());
                    if (ftpFiles.length == 0) {
                        files.add(f.getFileid());
                    }

                } catch (Exception ex) {
                    logger.error("fileNeedDown，forEach检查文件id:" + f.getFileid(), ex);
                }
            });

            ftpHelper.closeConnect(ftpClient);

        } catch (Exception ex) {
            logger.error("fileNeedDown，检查文件失败！", ex);
        }

        return files;
    }

    @Override
    public boolean ftpFileUplad(List<String> ftpFileInfo) {

        boolean result = false;
        CfFile cfFile = cfFileMapper.selectByPrimaryKey(ftpFileInfo.get(0).replace("\"", ""));

        if (cfFile != null) {
            try {
                FTPClient ftpClient = new FTPClient();
                ftpHelper.connectToServer(ftpClient);
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                String urlFile = ftpFileInfo.get(1).replace("\"", "");

                //byte[] ftpBytes = new BASE64Decoder().decodeBuffer(base64File);
                String base64File = URLDecoder.decode(urlFile, ENCODE);
                //byte[] ftpBytes=new BASE64Decoder().decodeBuffer(base64File);
                byte[] ftpBytes = Base64.getDecoder().decode(base64File);

                String[] filePaths = cfFile.getFileurl().split("/");

                FTPFile[] ftpFiles = ftpClient.listFiles(filePaths[0]);
                if (ftpFiles.length == 0) {
                    ftpClient.makeDirectory(filePaths[0]);
                }

                ftpClient.changeWorkingDirectory(filePaths[0]);

                ftpClient.storeFile(filePaths[1], new ByteArrayInputStream(ftpBytes));

                ftpHelper.closeConnect(ftpClient);

                result = true;
            } catch (Exception ex) {
                logger.error("ftpFileUplad，ftp文件上传完", ex);
            }
        }

        return result;
    }

    @Override
    public Map<String, Object> FindTestResult(String fileRefId) {
        List<Map<String, Object>> results = cfFileCQuery.FindTestResult(fileRefId);

        if (results.size() > 0) {
            return results.get(0);
        }

        return null;
    }

    @Override
    public String getFileBase64(String fileId) throws IOException {
        String base64String = "";

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            this.downFtpFile(fileId, bos);

            byte[] bytes = bos.toByteArray();

            Base64.Encoder encoder = Base64.getEncoder();

            base64String = encoder.encodeToString(bytes);

        } catch (Exception ex) {

        } finally {
            bos.close();
        }

        return base64String;
    }

    @Override
    public ImageBase64Vo getImageBase64(String id, String type) throws IOException {
        ImageBase64Vo result = new ImageBase64Vo();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            if("1".equals(type)){
                this.downFtpFile(id, bos);
            }else {
                this.downFtpFile2(id, bos);
            }

            byte[] bytes = bos.toByteArray();

            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));

            result.base64 = Base64.getEncoder().encodeToString(bytes);
            result.height = image.getHeight();
            result.width = image.getWidth();

        } catch (Exception ex) {

        } finally {
            bos.close();
        }

        return result;
    }

    @Override
    public Integer uploadBase64(List<UploadFileBase64Vo> fileList, String userId) throws IOException {
        Integer result = 0;

        for (int i = 0; i < fileList.size(); i++) {
            UploadFileBase64Vo base64File = fileList.get(i);
            MultipartFile multipartFile = BASE64DecodedMultipartFile.base64ToMultipart(base64File.base64);
            MultipartFile[] files = new MultipartFile[]{multipartFile};

            String fileName = multipartFile.getOriginalFilename();

            this.saveFile(multipartFile.getBytes(), fileName, base64File.fileRefId, userId, base64File.fileType);

            result++;
        }

        return result;
    }

}
