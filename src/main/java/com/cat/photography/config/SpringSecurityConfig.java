package com.cat.photography.config;

import com.cat.photography.config.security.jwt.JwtAuthenticationEntryPoint;
import com.cat.photography.config.security.jwt.JwtAuthenticationTokenFilter;
import com.cat.photography.config.security.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

/**
 * @author : 披荆斩棘
 * @date : 2017/6/8
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Value( "${jwt.header:Authorization}" )
    private String tokenHeader;


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration ,
                                                       AuthenticationManagerBuilder authenticationManagerBuilder ,
                                                       UserDetailsService userDetailsService
    ) throws
      Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ,
                                                   JwtTokenUtil jwtTokenUtil ,
                                                   JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint ,
                                                   UserDetailsService userDetailsService
    ) throws Exception {
        http
                // jwt不需要csrf
                .csrf().disable()
                // 开启 cors 的支持
                .cors().and()
                // jwt不需要session , 所以不创建会话
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 异常处理
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
                .authorizeHttpRequests()
                .requestMatchers("/**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter(
                userDetailsService ,
                jwtTokenUtil ,
                tokenHeader
        );
        // 基于定制JWT安全过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter , UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(new ExceptionHandlerFilter() , LogoutFilter.class);
        // 禁用页面缓存
        http.headers().cacheControl();
        return http.build();
    }


}
