package com.zhj.spring0725.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OrderDao {

    public int getCount();
    //向总表进行添加
    public int addSelltotal(Map map);
    //向详情表中进行添加
    public int addSelldetail(List<Map> list);

}
