package com.zhj.spring0725.controller;

import com.zhj.spring0725.service.SelltotalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class SelltotalController {
    @Resource
    private SelltotalService selltotalService;
    @RequestMapping("selectTal")
    @ResponseBody
    public List<Map> selectTal(){

        return selltotalService.selectSellTal();
    }
    @RequestMapping("/toSell")
    public String toSell(){
        return "backstage/sellTotal";
    }

}
