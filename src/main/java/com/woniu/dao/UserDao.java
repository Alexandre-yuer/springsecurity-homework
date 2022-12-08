package com.woniu.dao;

import com.woniu.domain.Users;

public interface UserDao {
    /**
     * 根据账户查询,用户信息,注意:账号在表中是唯一的存在
     * @param account
     * @return
     */
    Users queryUserByAccount(String account);
}
