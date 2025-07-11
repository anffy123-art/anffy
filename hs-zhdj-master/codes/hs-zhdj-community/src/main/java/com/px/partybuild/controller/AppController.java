package com.px.partybuild.controller;

import com.px.partybuild.AppConfig;
import com.px.partybuild.model.CfUsers;
import com.px.partybuild.service.LogService;
import com.px.partybuild.service.RoleService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.shiro.JwtUtils;
import com.px.partybuild.util.RemoteHelper;
import com.px.partybuild.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = "/")
public class AppController {

    private final Logger logger;
    @Autowired
    private AppConfig appConfig;

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private RoleService roleService;

    @Autowired
    private LogService logService;

    @Autowired
    RemoteHelper remoteHelper;

    @Autowired
    private StringUtils stringUtils;

    public AppController() {
        logger = LoggerFactory.getLogger(this.getClass());
    }


    @GetMapping("")
    public String Web(HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/app/main/index.html";
    }

    @GetMapping("web")
    public String Web() {
        return "redirect:/app/main/index.html";
    }

    @GetMapping("mobile")
    public String mobile(String routePath, String code) throws UnsupportedEncodingException {
        log.info("mobile：routePath=" + routePath + "，code=" + code);
        if (!stringUtils.IsNullOrEmpty(routePath))
            return "redirect:/mobile/index.html/#/index?routePath=" + URLEncoder.encode(routePath, "UTF-8") + "&code=" + code;

        return "redirect:/mobile/index.html/#/index?code=" + (!stringUtils.IsNullOrEmpty(code) ? code : "");
    }

}
