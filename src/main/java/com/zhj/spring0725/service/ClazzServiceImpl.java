package com.zhj.spring0725.service;

import com.zhj.spring0725.dao.ClazzDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClazzServiceImpl implements ClazzService{
    @Autowired
    private ClazzDao clazzDao;

    @Override
    public List<Map> selectClazz() {
        return clazzDao.selectClazz();
    }
}
