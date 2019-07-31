package com.zhj.spring0725.service;

import com.zhj.spring0725.dao.GoodsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements  GoodsService{
    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<Map> selectGoods() {
        return goodsDao.selectGoods();
    }
}
