package com.zhj.spring0725.controller;

import com.zhj.spring0725.bean.Message;
import com.zhj.spring0725.bean.Stu;
import com.zhj.spring0725.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class StuController {
    @Autowired
    private StuService stuService;
    @RequestMapping("/selectStu")
    @ResponseBody
    public List<Map> selectStu(){

        return  stuService.selectStu();
    }
    @RequestMapping("/addStu")
    @ResponseBody
    public String addStu(Stu stu){
        //调用service添加
        System.out.printf(stu.toString());
        stuService.addStu(stu);
        return "添加成功";

    }
    @RequestMapping("/delStu")
    @ResponseBody
    public Message delStu(int id){
        stuService.delStu(id);
        Message msg=new Message("ture");
        return msg;
    }
    @RequestMapping("/updateStu")
    @ResponseBody
        public String updateStu(Stu stu){
        System.out.println(stu.toString());
        stuService.updateStu(stu);
        return "success";
    }
}
