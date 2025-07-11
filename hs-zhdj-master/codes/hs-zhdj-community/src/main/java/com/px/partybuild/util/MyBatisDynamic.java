package com.px.partybuild.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MyBatisDynamic {
    @Autowired
    private ApplicationContext applicationContext;

    private final Logger logger;

    public MyBatisDynamic() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public String FieldNameFormat(String Name) {
        return Name.substring(0, 1).toUpperCase() + Name.substring(1);
    }

    //获取方法值
    public <T> T GetModelFieldValue(Object data, String name, Class<T> tClass) {
        try {
            String methodName = "get" + FieldNameFormat(name);
            Method methodGet = data.getClass().getMethod(methodName);

            return (T) methodGet.invoke(data);

        } catch (Exception ex) {
            logger.error("GetModelFieldValue," + name + ":" + ex.getMessage());
        }

        return null;
    }

    //贬值方法
    public void SetModelFieldValue(Object data, String name, Object value) {
        try {
            String methodName = "set" + FieldNameFormat(name);
            Method methodSet = data.getClass().getMethod(methodName, value.getClass());

            methodSet.invoke(data, value);

        } catch (Exception ex) {
            logger.error("SetModelFieldValue," + name + ":" + ex.getMessage());
        }

    }

    //执行反射方法
    public Object DoMethod(Class<?> clType, Object clBean, String methodName, Object... objects) {

        try {

            Class[] ClassArry = new Class[objects.length];

            java.util.Arrays.asList(objects).stream().map(m -> m.getClass()).collect(Collectors.toList()).toArray(ClassArry);

            Method method = clType.getMethod(methodName, ClassArry);

            return method.invoke(clBean, objects);

        } catch (Exception ex) {
            logger.error("DoMethod," + clType.getName() + "," + methodName + ":" + ex.getMessage());
        }

        return null;
    }

    //执行反射方法
    public Object DoMethod(Class<?> clType, Object clBean, String methodName, Map<Class<?>, Object> mapTypeValue) {

        try {

            Class[] ClassArry = new Class[mapTypeValue.size()];
            mapTypeValue.keySet().toArray(ClassArry);
            Method method = clType.getMethod(methodName, ClassArry);
            Object[] objects = mapTypeValue.entrySet().stream().map(e -> e.getValue()).toArray();

            return method.invoke(clBean, objects);

        } catch (Exception ex) {
            logger.error("DoMethod," + clType.getName() + "," + methodName + ":" + ex.getMessage());
        }

        return null;
    }

    /**
     * 执行反射方法
     * @param serviceName 注解服务名称 如：@Service("服务名称")
     * @param methodName 方法名称 getPartyDuesAmount
     * @param argsClass  参数类型 new Class[]{Class.forName("java.lang.String")}
     * @param args 参数 new Object[]{"sssssss"}
     * @return
     * @throws Exception
     */
    public Object invokeMethod(String serviceName, String methodName, Class[] argsClass, Object[] args) throws Exception {
        Object bean = applicationContext.getBean(serviceName);
        Class<?> clazz = bean.getClass();
        Method method = clazz.getDeclaredMethod(methodName, argsClass);
        Object objRtn = method.invoke(bean, args);
        return objRtn;
    }
}
