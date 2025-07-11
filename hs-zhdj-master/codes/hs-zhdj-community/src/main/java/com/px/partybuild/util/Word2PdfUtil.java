package com.px.partybuild.util;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.OutputStream;

@Component
public class Word2PdfUtil {

    private final Logger logger;

    public Word2PdfUtil() {
        logger = LoggerFactory.getLogger(this.getClass());
        LoadLicense();
    }

    protected Boolean LoadLicense() {

        Boolean result = true;
        logger.info("初始化 -> [aspose words License]");
        try {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
        } catch (Exception ex) {
            logger.error("LoadLicense error:" + ex.getMessage());
        }

        return result;

    }

    public void doc2pdf(InputStream isDoc, OutputStream osPdf) {
        try {
            long old = System.currentTimeMillis();
            Document doc = new Document(isDoc); // Address是将要被转化的word文档
            doc.save(osPdf, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
            long now = System.currentTimeMillis();
            logger.info("共耗时：" + (now - old) + "ms"); // 转化用时

        } catch (Exception ex) {
            logger.error("LoadLicense error:" + ex.getMessage());
        }
    }

}
