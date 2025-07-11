package com.px.partybuild.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {
    public boolean IsNullOrEmpty(String value) {
        return value == null || value.length() == 0;
    }

    public String valueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }
}
