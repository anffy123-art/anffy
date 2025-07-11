package com.px.partybuild.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UrlUtils {

    @Autowired
    private StringUtils stringUtils;

    public String getUrl(String url, Map<String, String> params) {
        if (stringUtils.IsNullOrEmpty(url))
            return "";

        String fullUrl = url;

        if (fullUrl.indexOf("?") < 0)
            fullUrl = fullUrl + "?";

        for (Map.Entry<String, String> param : params.entrySet()) {
            if (!fullUrl.endsWith("?"))
                fullUrl += "&";

            fullUrl += (param.getKey() + "=" + param.getValue());
        }


        return fullUrl;
    }

}