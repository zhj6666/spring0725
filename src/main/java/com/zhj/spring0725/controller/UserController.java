package com.zhj.spring0725.controller;

import com.zhj.spring0725.bean.User;
import com.zhj.spring0725.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/selectUser")
    @ResponseBody
    public List<User> userLogin(){

       return userService.selectUser();

    }


    @RequestMapping("/userLogin")
    @ResponseBody
    public String selectUserByPwd(User user, HttpSession httpSession){
        User userlogin=userService.selectUserByPwd(user);

        System.out.println(userlogin);
        if (userlogin!=null){

            httpSession.setAttribute("userInfo",userlogin);
            return "true";
        }else {
            return "false";
        }

    }


    @RequestMapping("/toback")

    public String toback(){

        return "backstage/backIndex";

    }
}
