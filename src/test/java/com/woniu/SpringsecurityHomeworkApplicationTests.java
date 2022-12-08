package com.woniu;

import com.woniu.dao.UserDao;
import com.woniu.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringsecurityHomeworkApplicationTests {

    @Autowired(required = false)
    private UserDao userDao;

    @Test
    void contextLoads() {
        Users admin = userDao.queryUserByAccount("admin");
        System.out.println(admin);
    }

}
