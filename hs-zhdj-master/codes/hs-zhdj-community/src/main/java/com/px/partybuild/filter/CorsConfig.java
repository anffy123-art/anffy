package com.px.partybuild.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Autowired
    private PageNoCacheInterceptor pageNoCacheInterceptor;
    @Autowired
    private HttpGlobalLogInterceptor httpGlobalLogInterceptor;

    @Autowired
    AppInterceptor appInterceptor;
    //@Autowired
    //private WXRouterInterceptor wxRouterInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pageNoCacheInterceptor)
                .addPathPatterns("/api/**", "/appApi/**").excludePathPatterns("/api/home/showImg/*");
        registry.addInterceptor(httpGlobalLogInterceptor).addPathPatterns("/api/**");
        registry.addInterceptor(appInterceptor).addPathPatterns("/appApi/**").excludePathPatterns("/appApi/home/test*");
        //registry.addInterceptor(wxRouterInterceptor).addPathPatterns("/app/wechat/**");

    }


    /*拦截器跟跨域配置执行先后顺序问题 下面配置无效，跨域配置需要在拦截器之前，改成CorsFilter*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .maxAge(3600);
    }

}
