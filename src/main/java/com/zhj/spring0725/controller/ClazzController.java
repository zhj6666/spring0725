package com.zhj.spring0725.controller;

import com.zhj.spring0725.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @RequestMapping("/selectClazz")
    @ResponseBody
    public List<Map> selectClazz(){


        return clazzService.selectClazz();
    }
}
