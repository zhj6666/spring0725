package com.zhj.spring0725.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface GoodsDao {

    @Select("select * from goods join goodstype on goods.goodstypeid=goodstype.goodsTypeId")
    public List<Map> selectGoods();

}
