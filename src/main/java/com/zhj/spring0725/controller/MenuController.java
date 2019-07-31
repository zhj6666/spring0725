package com.zhj.spring0725.controller;

import com.zhj.spring0725.bean.User;
import com.zhj.spring0725.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {
    @Resource
    private MenuService menuService;
    @RequestMapping("/menu")
    @ResponseBody
    public List<Map> query(HttpSession httpSession){
        User user=(User) httpSession.getAttribute("userInfo");
          return menuService.query(user.getUserId());

    }


    //跳转到采购页面
    @RequestMapping("/toBuyIn")
    public String toRe(){
        return "backstage/buyIn";

    }

}
