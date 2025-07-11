package com.px.partybuild.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class MapUtils {

    @Autowired
    DateTimeConverter dateTimeConverter;

    public <T> T mapToObject(Map<String, Object> map, Class<T> beanClass) {

        if (map == null) {
            return null;
        }
        T obj = null;
        try {
            obj = beanClass.newInstance();

            //org.apache.commons.beanutils.BeanUtils.populate(obj, map);
            ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
            //onvertUtilsBean.deregister(Date.class);
            convertUtilsBean.register(dateTimeConverter, Date.class);
            //convertUtilsBean.register(new org.apache.commons.beanutils.converters.SqlDateConverter(null), java.sql.Date.class);
            //convertUtilsBean.register(new org.apache.commons.beanutils.converters.SqlDateConverter(null), java.util.Date.class);
            //convertUtilsBean.register(new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), java.sql.Timestamp.class);
            BeanUtilsBean beanUtilsBean = new BeanUtilsBean(convertUtilsBean, new PropertyUtilsBean());
            beanUtilsBean.populate(obj, map);

        } catch (Exception ex) {
            obj = null;
        }

        return obj;
    }

    public <T> Map<String, Object> objectToMap(T obj) {

        if (obj == null) {
            return null;
        }
        Map<?, ?> sourceMap = new org.apache.commons.beanutils.BeanMap(obj);

        Map<String, Object> result = new HashMap<>();

        for (Map.Entry<?, ?> entry : sourceMap.entrySet()) {
            result.put(entry.getKey().toString(), entry.getValue());
        }

        return result;
    }

    public <T> T map2Obj(Map<String,Object> map,Class<T> clz) throws Exception{
        if (map == null)
            return null;
        T obj = clz.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            Method setter = property.getWriteMethod();
            if (setter != null) {
                setter.invoke(obj, map.get(property.getName()));
            }
        }
        return obj;
    }
}
