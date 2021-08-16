package com.self.wxshop.config;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> pattern = new HashMap<>();
        pattern.put("/api/login", "anon");
        pattern.put("/api/code", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(pattern);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

//        securityManager.setRealm();
        securityManager.setCacheManager(new MemoryConstrainedCacheManager());
        securityManager.setSessionManager(new DefaultSessionManager());
        return securityManager;
    }

}


