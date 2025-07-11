package com.px.partybuild.shiro;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Slf4j
@Component
public class JwtFilter extends FormAuthenticationFilter {

    private final static String USER_ID = "UserLoginId";

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private UserService userService;

    @Bean
    public FilterRegistrationBean registration(JwtFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    /**
     * shiro权限拦截核心方法 返回true允许访问resource，
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        /*
        if(isLoginRequest(request,response)) {
            return true;
        }
        */

        String token = jwtUtils.getRequestToken((HttpServletRequest) request);

        try {
            // 检查 token 有效性
            //ExpiredJwtException JWT已过期
            //SignatureException JWT可能被篡改
            Jwts.parser().setSigningKey(jwtUtils.getSecret()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            // 身份验证失败，返回 false 将进入onAccessDenied 判断是否登陆。
            //onLoginFail(response);
            return false;
        }
        //((HttpServletRequest) request).getRequestURI().

        String userLId = jwtUtils.getUserIdFromToken(token);
        // 存入到 request 中，在后面的业务处理中可以使用
        request.setAttribute(USER_ID, userLId);

        //读取表权限判断
        //boolean isPower = userService.isUrlInRole(((HttpServletRequest) request).getRequestURI(), userLId);
        boolean isPower=true;

        return isPower;
    }

    /**
     * 当访问拒绝时是否已经处理了；
     * 如果返回true表示需要继续处理；
     * 如果返回false表示该拦截器实例已经处理完成了，将直接返回即可。
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            /*
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }*/
            return true;
        } else {
            //request.getLocale();
            //log.info ("onAccessDenied,fail:"+((HttpServletRequest)request).getRequestURI());
            onLoginFail(response);
            return false;
        }
    }

    /**
     * 鉴定失败，返回错误信息
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    /*
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        try {
            ((HttpServletResponse) response).setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().print("账号活密码错误");
        } catch (IOException e1) {
            //LOGGER.error(e1.getMessage(), e1);
        }
        return false;
    }
    */
    /*
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {

        return false;
    }
    */

    /**
     * token 认证失败
     *
     * @param response
     */
    private void onLoginFail(ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpStatus.OK.value());
        ObjectMapper mapper = new ObjectMapper();
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.addHeader("Pragma", "no-cache");
        httpResponse.addHeader("Cache-Control", "no-cache");
        try {
            RequsetData<String> res = new RequsetData<>();
            res.setSuccess(false);
            res.setMsg("验证权限失败！");
            response.getWriter().append(mapper.writeValueAsString(res));
        } catch (Exception e) {
            //LOGGER.error(e.getMessage(), e);
        }
    }


}
