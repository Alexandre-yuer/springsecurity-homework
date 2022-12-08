package com.woniu.config;

import com.woniu.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityService securityService;

    @Bean
    public PasswordEncoder getPassword(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //模拟登录----自定义用户名和密码并对密码进行加密进行密文传输,模拟给security指定用户名和密码
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String password = passwordEncoder.encode("123");
//        auth.inMemoryAuthentication().withUser("jjf")
//                .password(password)
//                .roles("admin");

        //真实指定用户名和密码
        auth.userDetailsService(securityService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//告诉security 使用自定义登录页面
                .loginPage("/login.html")//告诉security 页面在哪
                .loginProcessingUrl("/dologin")//告诉表单提交的地址
                .defaultSuccessUrl("/index.html")
                .permitAll();

        http.authorizeRequests()//配置请求权限
                .anyRequest().authenticated();//所有请求都拦截

        http.csrf().disable();//关闭跨站脚本攻击
    }

}
