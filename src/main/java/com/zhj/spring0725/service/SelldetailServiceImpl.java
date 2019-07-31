package com.zhj.spring0725.service;

import com.zhj.spring0725.dao.SelldetailDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class SelldetailServiceImpl implements SelldetailService{
    @Resource
    private SelldetailDao selldetailDao;

    @Override
    public List<Map> selectSell() {
        return selldetailDao.selectSell();
    }
}
