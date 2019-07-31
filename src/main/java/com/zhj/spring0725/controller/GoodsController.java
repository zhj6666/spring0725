package com.zhj.spring0725.controller;

import com.zhj.spring0725.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @RequestMapping("/selectGoods")
    @ResponseBody
    public List<Map> selectGoods(){

       return  goodsService.selectGoods();

    }

}
