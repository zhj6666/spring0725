package com.zhj.spring0725.service;

import com.zhj.spring0725.dao.MenuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;


    @Override
    public List<Map> query(Integer id) {
        return menuDao.query(id);
    }
}
