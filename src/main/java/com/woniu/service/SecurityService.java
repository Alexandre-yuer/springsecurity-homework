package com.woniu.service;

import com.woniu.dao.UserDao;
import com.woniu.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userDao.queryUserByAccount(username);

        try {
            // 模拟从数据库拿到信息与页面输入信息比较是否相同
            return new User(users.getUsername(),passwordEncoder.encode(users.getPassword()),
                    AuthorityUtils.commaSeparatedStringToAuthorityList("admin,insert,update,delete,select"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("用户名或密码错误!!!");
        }
    }
}
