package com.px.partybuild.util;

import com.px.partybuild.AppConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Component
public class WordUtil {

    private final Logger logger;
    private String staticLocations = "";

    public WordUtil(AppConfig appConfig) {
        logger = LoggerFactory.getLogger(this.getClass());
        this.staticLocations = appConfig.staticLocations.replace("file:", "");
    }

    /**
     * @Description //TODO 导出word
     * @date 2024-08
     * @Param [response, dataMap：word文件map数据, templateName：ftl模板文件名称, fileName：输出文件名称]
     **/
    public void createWord(HttpServletResponse response, Map dataMap, String templateName, String fileName) {
        try {

            //创建配置实例
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
            //设置编码
            configuration.setDefaultEncoding("UTF-8");
            //ftl模板文件
            configuration.setDirectoryForTemplateLoading(new File(this.staticLocations + "doc/template/"));

            //获取模板
            Template template = configuration.getTemplate(templateName + ".ftl");

            //输出文件
            String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            response.setHeader("content-Type", "application/msword");
            response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(fileName + format + ".doc", "utf-8"));
            Writer out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"));

            //生成文件
            template.process(dataMap, out);

        } catch (Exception e) {
            logger.error("导出报错：", e);
        }
    }

    /**
     * @Description //TODO 导出excel
     * @date 2024-08
     * @Param [response, dataMap：word文件map数据, templateName：ftl模板文件名称, fileName：输出文件名称]
     **/
    public void createExcel(HttpServletResponse response, Map dataMap, String templateName, String fileName) {
        try {

            //创建配置实例
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
            //设置编码
            configuration.setDefaultEncoding("UTF-8");
            //ftl模板文件
            configuration.setDirectoryForTemplateLoading(new File(this.staticLocations + "doc/template/"));

            //获取模板
            Template template = configuration.getTemplate(templateName + ".ftl");

            //输出文件
            String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            response.setContentType("application/msexcel;charset=UTF-8");
            //response.setHeader("Content-disposition","attachment;filename=\""+new String((fileName+".xls").getBytes("GBK"),"ISO8859-1")+"\"");
            response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(fileName + format + ".xls", "utf-8"));
            Writer out = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"));

            //生成文件
            template.process(dataMap, out);

        } catch (Exception e) {
            logger.error("导出报错：", e);
        }
    }

}
