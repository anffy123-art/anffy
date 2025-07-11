package com.px.partybuild.util;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Component
public class DateTimeConverter implements Converter {

    @Autowired
    private DateUtils dateUtils;

    @Override
    public Object convert(Class type, Object value) {
        if (value == null) {
            return null;
        } else if (type == Timestamp.class) {
            return convertToDate(type, value, "yyyy-MM-dd HH:mm:ss");
        } else if (type == Date.class) {
            return convertToDate(type, value, "yyyy-MM-dd");
        } else if (type == String.class) {
            return convertToString(type, value);
        }

        throw new ConversionException("不能转换 " + value.getClass().getName() + " 为 " + type.getName());
    }

    protected Object convertToDate(Class type, Object value, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if (value instanceof String) {
            try {
                if (StringUtils.isEmpty(value.toString())) {
                    return null;
                }
                Date date = sdf.parse((String) value);
                if (type.equals(Timestamp.class)) {
                    return new Timestamp(date.getTime());
                }
                return date;
            } catch (Exception pe) {
                return null;
            }
        } else if (value instanceof Date) {
            return value;
        }

        throw new ConversionException("不能转换 " + value.getClass().getName() + " 为 " + type.getName());
    }

    protected Object convertToString(Class type, Object value) {
        if (value instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if (value instanceof Timestamp) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }

            try {
                return sdf.format(value);
            } catch (Exception e) {
                throw new ConversionException("日期转换为字符串时出错！");
            }
        } else {
            return value.toString();
        }
    }

    public <T> T toDate(Class<T> type, Object value) {

        if (value == null || "".equals(value)) {
            return null;
        }
        if (value instanceof String) {
            String dateValue = value.toString().trim();

            if (type.equals(java.util.Date.class)) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                    LocalDateTime ldt = LocalDateTime.parse(dateValue, formatter);
                    return (T) dateUtils.DateTimeToDate(ldt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return (T) value;
    }


}
