package com.px.partybuild.filter;

import com.px.partybuild.service.LogService;
import com.px.partybuild.shiro.RolePermissionCode;
import com.px.partybuild.util.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class HttpGlobalLogInterceptor implements HandlerInterceptor {

    @Autowired
    private LogService logService;

    /**
     * 添加注解代码
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("actionTime",new Date());

        if (handler instanceof HandlerMethod) {

            RolePermissionCode rolePermissionCodeMethod = ((HandlerMethod) handler).getMethodAnnotation(RolePermissionCode.class);
            RolePermissionCode rolePermissionCodeClass=((HandlerMethod) handler).getMethod().getDeclaringClass().getAnnotation(RolePermissionCode.class);

            if(rolePermissionCodeMethod!=null){
                request.setAttribute("rolePermissionCode",rolePermissionCodeMethod.value());
            } else if(rolePermissionCodeClass!=null){
                request.setAttribute("rolePermissionCode",rolePermissionCodeClass.value());
            } else {
                request.setAttribute("rolePermissionCode","");
            }

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {

        Map<String, Object> mapLT = new HashMap<>();

        mapLT.put("url", request.getRequestURI());
        mapLT.put("method", request.getMethod());
        mapLT.put("params",request.getParameterMap());

        String uaData=request.getHeader("User-Agent");
        Date begin=(Date)request.getAttribute("actionTime");

        String userLid = "";

        userLid = (String) request.getAttribute("UserLoginId");
        String logTitle=(String) request.getAttribute("rolePermissionCode");

        String ip=logService.getIpAddress(request);

        logService.asyncLog("http请求", JsonMapper.objectToJson(mapLT), userLid, ip,logTitle,uaData,begin,0);
    }


}
