package com.px.partybuild.service.impl;

import com.px.partybuild.AppConfig;
import com.px.partybuild.controller.jsonmodel.DesModel;
import com.px.partybuild.mapper.CfFileMapper;
import com.px.partybuild.mapper.CfSnMapper;
import com.px.partybuild.mapper.GgZgzpMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.CommonService;
import com.px.partybuild.util.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author H
 * @date 2024-08
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CfSnMapper cfSnMapper;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private CfFileMapper cfFileMapper;

    @Autowired
    private GgZgzpMapper ggZgzpMapper;

    private final Logger logger;

    public CommonServiceImpl() {
        logger = LoggerFactory.getLogger(this.getClass());
    }


    /**
     * 按月生成编号
     * @param key 1
     * @param Prefix 33
     * @return 格式：[Prefix]-yyyyMM[000001]
     */
    @Override
    public String createSNbyMonth(String key, String Prefix) {

        String sn = "", strFormat = "000000";
        DecimalFormat dfFormat = new DecimalFormat(strFormat);

        CfSnExample exp1 = new CfSnExample();
        exp1.or().andSnkeyEqualTo(key);
        CfSn cfSn;
        List<CfSn> cfSnList = cfSnMapper.selectByExample(exp1);

        if (cfSnList.size() > 0) {
            cfSn = cfSnList.get(0);
            LocalDateTime lResetTime = dateUtils.DateToDateTime(cfSn.getResettime());
            //直接算月数就行了
            if (lResetTime.getMonth() == LocalDateTime.now(dateUtils.getZoneId()).getMonth()) {

                cfSn.setSnnum(cfSn.getSnnum()+1);
            } else {
                cfSn.setSnnum(1);
            }
            cfSn.setPrefix(Prefix);
            cfSn.setResettime(dateUtils.DateTimeToDate(LocalDateTime.now(dateUtils.getZoneId())));

            cfSnMapper.updateByPrimaryKey(cfSn);


        } else {
            cfSn = new CfSn();
            cfSn.setSnid(UUID.randomUUID().toString());
            cfSn.setSnnum(1);
            cfSn.setSnkey(key);
            cfSn.setPrefix(Prefix);
            cfSn.setResettime(new Date());

            cfSnMapper.insert(cfSn);
        }

        sn = dfFormat.format(cfSn.getSnnum());
        LocalDateTime lDTRresetTime = dateUtils.DateToDateTime(cfSn.getResettime());
        sn = cfSn.getPrefix() + lDTRresetTime.format(DateTimeFormatter.ofPattern("yyyyMM")) + sn;

        return sn;
    }

    @Override
    public Integer SaveFile(CfFile file) {
        file.setFileid(UUID.randomUUID().toString());
        file.setCreatetime(new Date());
        return cfFileMapper.insert(file);
    }

    @Override
    public Integer updateFile(CfFile file) {
        return cfFileMapper.updateByPrimaryKey(file);
    }

    @Override
    public CfFile CreateCfFile(String fileName) {

        CfFile cfFile = new CfFile();
        cfFile.setFileurl(CreateServeFile(fileName));
        cfFile.setFilesuffix(fileName.substring(fileName.lastIndexOf(".")));
        cfFile.setFilename(fileName);

        return cfFile;
    }

    @Override
    public String CreateServeFile(String fileName) {
        String FillSuffix = fileName.substring(fileName.lastIndexOf("."));
        String fileDir = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMM"));

        return Paths.get(fileDir, UUID.randomUUID().toString() + FillSuffix).toString();
    }


    @Override
    public String CreateFileFullName(String fileName) {

        Path pFileName = Paths.get(appConfig.uploadfileUrl, fileName);

        if (!Files.exists(pFileName.getParent())) {
            try {
                Files.createDirectory(pFileName.getParent());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        String FileFullName = pFileName.toString();

        return FileFullName;
    }

    @Override
    public PageInfo<CfFile> FindFileList(String fileRefID, Integer pageIndex, Integer pageSize,Integer fileType,String userId) {

        PageHelper.startPage(pageIndex, pageSize);
        CfFileExample exp = new CfFileExample();
        CfFileExample.Criteria criteria=exp.or();
        criteria.andFilerefidEqualTo(fileRefID);
        exp.setOrderByClause("Createtime desc");
        if(fileType!=null){
            criteria.andFiletypeEqualTo(fileType);
        }
        if(userId!=null&&!userId.equals("")){
           List<String> userIds= new ArrayList<>(Arrays.asList(userId.split(",")));
            criteria.andUseridIn(userIds);
        }
        List<CfFile> list = cfFileMapper.selectByExample(exp);

        PageInfo<CfFile> result = new PageInfo(list);

        return result;
    }

    @Override
    public CfFile GetFile(String fileId) {
        return cfFileMapper.selectByPrimaryKey(fileId);
    }

    @Override
    public CfFile GetFileByRefID(String fileRefId) {
        CfFileExample example = new CfFileExample();
        example.or().andFilerefidEqualTo(fileRefId);
        example.or().andFileidEqualTo(fileRefId);
        List<CfFile> list = cfFileMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    @Override
    public List<CfFile> GetFileList(String fileRefId) {
        CfFileExample example = new CfFileExample();
        example.or().andFilerefidEqualTo(fileRefId);
        example.or().andFileidEqualTo(fileRefId);
        List<CfFile> list = cfFileMapper.selectByExample(example);

        return list;
    }
    @Override
    public List<CfFile> GetFileList(List<String> fileRefId) {
        CfFileExample example = new CfFileExample();
        example.or().andFilerefidIn(fileRefId);
        example.or().andFileidIn(fileRefId);
        List<CfFile> list = cfFileMapper.selectByExample(example);

        return list;
    }
    @Override
    public Integer DeleteFile(String fileId) throws IOException {
        CfFile cfFile = cfFileMapper.selectByPrimaryKey(fileId);
        Path filePath = Paths.get(CreateFileFullName(cfFile.getFileurl()));
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }

        return cfFileMapper.deleteByPrimaryKey(fileId);
    }

    @Override
    public Integer DeleteFileByRefID(String fileId, String fileRefId) {
        CfFileExample example = new CfFileExample();
        example.createCriteria().andFilerefidEqualTo(fileRefId).andFileidNotEqualTo(fileId);
        List<CfFile> list = cfFileMapper.selectByExample(example);
        list.forEach(cfFile -> {
            cfFileMapper.deleteByPrimaryKey(cfFile.getFileid());
            Path filePath = Paths.get(CreateFileFullName(cfFile.getFileurl()));
            if (Files.exists(filePath)) {
                try {
                    Files.delete(filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return 1;
    }

    private String ENCODE = "utf-8";
    private String desStr = "DES";
    private String desVi = "DES/ECB/PKCS5Padding";

    @Override
    public String DesEnCode(String words, String key) {
        String result = "";
        try {

            byte[] keys = key.getBytes(ENCODE);

            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(keys);
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(desStr);
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance(desVi);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            // 真正开始解密操作
            byte[] rBytes = cipher.doFinal(words.getBytes(ENCODE));
            result = new BASE64Encoder().encode(rBytes);
        } catch (Exception ex) {
            logger.error("DesEnCode:" + ex.getMessage());
        }
        return result;
    }

    @Override
    public String DesDeCode(String token, String key) {
        String result = "";
        try {
            //解base64
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] buftoken = decoder.decodeBuffer(token);

            byte[] keys = key.getBytes(ENCODE);

            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(keys);
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(desStr);
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance(desVi);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            byte[] rBytes = cipher.doFinal(buftoken);

            result = new String(rBytes, ENCODE);
        } catch (Exception ex) {
            logger.error("DesTokenData:" + ex.getMessage());
        }

        return result;
    }

    @Override
    public String BASE64Encode(String word) {
        String result = "";
        try {
            byte[] bword = word.getBytes(ENCODE);
            result = new BASE64Encoder().encode(bword);
        } catch (Exception ex) {
            logger.error("BASE64Encode,err:" + ex.getMessage());
        }

        return result;
    }

    @Override
    public String BASE64Descode(String word) {
        String result = "";
        try {
            byte[] buftoken = new BASE64Decoder().decodeBuffer(word);
            result = new String(buftoken, ENCODE);
        } catch (Exception ex) {
            logger.error("BASE64Encode,err:" + ex.getMessage());
        }

        return result;
    }

    /**
     * 用des解密
     **/
    @Override
    public String DesTokenData(String token, LocalDateTime tm) {
        String result = "";

        try {
            byte[] keys = tm.format(DateTimeFormatter.ofPattern(appConfig.desKey)).getBytes(ENCODE);
            //解base64
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] buftoken = decoder.decodeBuffer(token);
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(keys);
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(desStr);
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance(desVi);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            byte[] rBytes = cipher.doFinal(buftoken);
            result = new String(rBytes, ENCODE);

        } catch (Exception ex) {
            logger.error("DesTokenData:" + ex.getMessage());
        }

        return result;
    }

    /**
     * 用des加密
     **/
    @Override
    public DesModel CreateDESToken(String data) {
        DesModel result = new DesModel();
        LocalDateTime now;
        result.setTm(new Date());
        try {
            now = dateUtils.DateToDateTime(result.getTm());
            byte[] keys = now.format(DateTimeFormatter.ofPattern(appConfig.desKey)).getBytes(ENCODE);
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(keys);
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(desStr);
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance(desVi);
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            // 真正开始解密操作
            byte[] rBytes = cipher.doFinal(data.getBytes(ENCODE));
            //加base64
            result.setToken(new BASE64Encoder().encode(rBytes));
        } catch (Exception ex) {
            logger.error("CreateDESToken:" + ex.getMessage());
        }

        return result;
    }

    @Override
    public String AppDesEncode(String message, String key, String vi) {

        try {
            message = URLEncoder.encode(message, ENCODE);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(ENCODE));

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec ivsp = new IvParameterSpec(vi.substring(0, 8).getBytes(ENCODE));
            cipher.init(1, secretKey, ivsp);

            byte[] str = cipher.doFinal(message.getBytes(ENCODE));
            return toHexString(str).toUpperCase();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String toHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xFF & b[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }

        return hexString.toString();
    }

    @Override
    public byte[] getDbImgbyRybm(String rybm){

        byte[] imgBytes = null;
        if("true".equals(appConfig.canLoadDbImg.toLowerCase())) {
            GgZgzpExample example = new GgZgzpExample();
            example.or().andRybmEqualTo(rybm);

            List<GgZgzp> list = ggZgzpMapper.selectByExampleWithBLOBs(example);

            if (list.size() > 0) {
                imgBytes = list.get(0).getGrzp();
            }
        }

        return imgBytes;

    }

    @Override
    public int addDbImgData(String fileId,String rybm,byte[] imgBytes) {

        GgZgzp it=new GgZgzp();
        it.setZgzpbs(fileId.substring(0,12));
        it.setRybm(rybm);
        it.setGrzp(imgBytes);

        return ggZgzpMapper.insert(it);
    }

    @Override
    public String AppDesDecodeVi(String words, String key, String vi) {
        try
        {
            byte[] bytesrc = convertHexString(words);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(ENCODE));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(vi.substring(0, 8).getBytes(ENCODE));
            cipher.init(2, secretKey, iv);
            byte[] retByte = cipher.doFinal(bytesrc);
            return URLDecoder.decode(new String(retByte), ENCODE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    protected byte[] convertHexString(String ss) {
        byte[] digest = new byte[ss.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte)byteValue;
        }

        return digest;
    }


}
