package com.zhj.spring0725.service;

import com.zhj.spring0725.bean.User;

import java.util.List;

public interface UserService {
    public List<User> selectUser();

    public User selectUserByPwd(User user);
}
