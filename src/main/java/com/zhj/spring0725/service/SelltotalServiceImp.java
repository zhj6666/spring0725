package com.zhj.spring0725.service;

import com.zhj.spring0725.dao.SelltotalDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SelltotalServiceImp implements SelltotalService{
    @Resource
    private SelltotalDao selltotalDao;

    @Override
    public List<Map> selectSellTal() {
        return selltotalDao.selectSellTal();
    }
}
