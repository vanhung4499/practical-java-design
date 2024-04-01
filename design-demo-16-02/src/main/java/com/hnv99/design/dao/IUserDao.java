package com.hnv99.design.dao;

import com.hnv99.design.po.User;

public interface IUserDao {

    User queryUserInfoById(Long id);

}
