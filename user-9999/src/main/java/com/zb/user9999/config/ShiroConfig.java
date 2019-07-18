package com.zb.user9999.config;


import com.zb.user9999.shiro.UserRealm;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zb
 * @date 2019/6/26 19:28
 **/
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactionryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactionryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        /**
         * Shiro内置过滤器：
         *      anon:无需认证（登录）可以访问
         *      authc:必须认证才可以访问
         *      user: 如果使用rememberMe的功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        filterMap.put("/test", "user");
        filterMap.put("/login", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建defaultwebsecurityManager
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        defaultWebSecurityManager.setRealm(userRealm);
        defaultWebSecurityManager.setRememberMeManager(getRemember());

        return defaultWebSecurityManager;
    }

    //rememberme时间设为1个月
    public RememberMeManager getRemember() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        Cookie cookie = new SimpleCookie("rememberMe");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(2592000);
        cookieRememberMeManager.setCookie(cookie);
        return cookieRememberMeManager;
    }

    /**
     * 创建Realm
     */
    @Bean("userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

}
