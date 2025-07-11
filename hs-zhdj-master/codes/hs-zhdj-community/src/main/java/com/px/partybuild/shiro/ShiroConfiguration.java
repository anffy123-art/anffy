package com.px.partybuild.shiro;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {


    @Autowired
    private JwtFilter jwtFilter;
    /*
    @Autowired
    private MyRealm myRealm;*/
    /*
    @Bean(name = "myShiroRealm")
    public MyRealm myShiroRealm(){
        //MyRealm myShiroRealm = new MyRealm();
        return myRealm;
    }
    */

    @Bean
    public DefaultWebSecurityManager securityManager(MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        /*
         * 关闭shiro自带的session，详情见文档
         * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();//获取filters

        filters.put("authc", jwtFilter);//将自定义 的FormAuthenticationFilter注入shiroFilter中
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        //filterChainDefinitionMap.put("/logout", "logout");

        //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/KongLogin", "anon");
        filterChainDefinitionMap.put("/jxCasLogin","anon");
        filterChainDefinitionMap.put("/*.txt", "anon");
        filterChainDefinitionMap.put("/scripts/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/content/**", "anon");
        filterChainDefinitionMap.put("/app/**", "anon");
        filterChainDefinitionMap.put("/api/news/**", "anon");
        filterChainDefinitionMap.put("/public/**", "anon");
        filterChainDefinitionMap.put("/mobile/**", "anon");
        filterChainDefinitionMap.put("/appApi/home/**", "anon");
        filterChainDefinitionMap.put("/appApi/log/**", "anon");
        filterChainDefinitionMap.put("/api/home/sysName", "anon");

        /*filterChainDefinitionMap.put("/appApi/**", "anon");
        filterChainDefinitionMap.put("/wxapi/**", "anon");*/
        /*
        filterChainDefinitionMap.put("/api/home/forgotPassword", "anon");
        filterChainDefinitionMap.put("/api/home/sendPassword", "anon");
        filterChainDefinitionMap.put("/api/user/getUserByID", "anon");
        filterChainDefinitionMap.put("/api/user/ValidUserInfo","anon");
        filterChainDefinitionMap.put("/api/user/getUserByUserid","anon");
        filterChainDefinitionMap.put("/api/user/getPartyInfo","anon");*/
        filterChainDefinitionMap.put("/partyweb/**","anon");
        /*
        filterChainDefinitionMap.put("/api/user/getPartyUserList","anon");
        filterChainDefinitionMap.put("/api/user/getDxzUserList","anon");
        filterChainDefinitionMap.put("/api/user/getLeaderUserList","anon");
        filterChainDefinitionMap.put("/api/user/getPartyTreeList","anon");
        filterChainDefinitionMap.put("/api/partyUser/getPartyUserList","anon");
        filterChainDefinitionMap.put("/api/party/getPartyList","anon");
        filterChainDefinitionMap.put("/api/Zgyg/remindJsdw","anon");*/
        filterChainDefinitionMap.put("/api/partyDic/getNationList", "anon");
        filterChainDefinitionMap.put("/api/partyDic/getEducationList", "anon");
        filterChainDefinitionMap.put("/api/party/getTree", "anon");
        filterChainDefinitionMap.put("/api/partyUserAdmit/register", "anon");
        filterChainDefinitionMap.put("/api/home/postFile", "anon");
        filterChainDefinitionMap.put("/api/home/findFileList", "anon");
        filterChainDefinitionMap.put("/api/filemgr/getFileList", "anon");

        filterChainDefinitionMap.put("/api/home/locallogin", "anon");
        filterChainDefinitionMap.put("/api/home/logout", "anon");
        filterChainDefinitionMap.put("/api/news/newsWithPicList", "anon");
        filterChainDefinitionMap.put("/api/home/showImg/**", "anon");
        filterChainDefinitionMap.put("/api/mh/getLinkList", "anon");
        filterChainDefinitionMap.put("/api/mh/getSubjectList", "anon");
        filterChainDefinitionMap.put("/wxapi/pay/order/notify", "anon");
        filterChainDefinitionMap.put("/wxapi/pay/OAuth", "anon");
        filterChainDefinitionMap.put("/wxapi/pay/getOpenID", "anon");
        filterChainDefinitionMap.put("/appApi/fileMgr/showDoc/**", "anon");
        filterChainDefinitionMap.put("/wxapi/cp/**", "anon");
        filterChainDefinitionMap.put("/**", "authc");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/api/home/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/app/main/index.html");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/api/home/error");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 下面的代码是添加注解支持
     */
     /*
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();

        // 强制使用cglib，防止重复代理和可能引起代理出错的问题

        // https://zhuanlan.zhihu.com/p/29161098

        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);

        return defaultAdvisorAutoProxyCreator;

    }



    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {

        return new LifecycleBeanPostProcessor();

    }



    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {

        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();

        advisor.setSecurityManager(securityManager);

        return advisor;

    }
*/


}
