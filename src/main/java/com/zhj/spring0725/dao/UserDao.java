package com.zhj.spring0725.dao;

import com.zhj.spring0725.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    @Select(" select * from user")
    public List<User> selectUser();
    @Select("select * from user where userPhone=#{userPhone} and userPassword=#{userPassword}")
    public User selectUserByPwd(User user);
}
