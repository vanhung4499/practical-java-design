package com.hnv99.design;


import com.hnv99.design.agent.Select;

public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}
