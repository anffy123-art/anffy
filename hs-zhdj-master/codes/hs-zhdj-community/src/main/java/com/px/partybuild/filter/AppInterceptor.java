package com.px.partybuild.filter;

import com.px.partybuild.AppConfig;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.service.CommonService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class AppInterceptor implements HandlerInterceptor {

    @Autowired
    CommonService commonService;

    @Autowired
    private AppConfig appConfig;

    private String dateFormat="yyyy-MM-dd hh:mm:ss";

    private String dateIsoFormat="yyyy-MM-dd'T'HH:mm:ss";

    @Autowired
    DateUtils dateUtils;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean valid=false;

        String token,tn;

        token=request.getParameter("token");
        tn=request.getParameter("tn");

        log.info("preHandle,tn="+tn+",token="+token);
        valid=true;
        /*
        if(StringUtils.isNotBlank(token)&&StringUtils.isNotBlank(tn)){

            //Date tnData=DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.parse(tn);
            Date tnData=org.apache.commons.lang3.time.DateUtils.parseDate(tn,dateIsoFormat);

            log.info("preHandle,tn="+tn+",token="+token);

            if(Math.abs(dateUtils.getMinuteDiff(tnData,new Date()))<=2) {

                //if(DateUtils.toCalendar(tnData).)
                String localWord = appConfig.appId + "," + DateFormatUtils.format(tnData, dateFormat);

                String desWord = commonService.DesDeCode(token, appConfig.secret);

                valid = localWord.equals(desWord);

                if(!valid){
                    log.info("preHandle,解完字符："+desWord);
                }

            } else {

                log.info("preHandle,时间超过2分钟。");

            }

        }*/

        if(!valid) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpStatus.OK.value());

            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");

            try {
                RequsetData<String> res = new RequsetData<>();
                res.setSuccess(false);
                res.setMsg("App权限验证失败！");
                response.getWriter().append(JsonMapper.GetObjectMapper().writeValueAsString(res));
            } catch (Exception e) {
                //LOGGER.error(e.getMessage(), e);
            }
        }

        return valid;
    }

}
