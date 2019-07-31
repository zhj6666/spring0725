package com.zhj.spring0725.service;

import com.zhj.spring0725.bean.User;
import com.zhj.spring0725.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override
    public List<User> selectUser() {
        return userDao.selectUser();
    }

    @Override
    public User selectUserByPwd(User user) {
        return userDao.selectUserByPwd(user);
    }
}
