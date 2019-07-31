package com.zhj.spring0725.service;

import com.zhj.spring0725.bean.Stu;

import java.util.List;
import java.util.Map;

public interface StuService {
    List<Map> selectStu();
    void addStu(Stu stu);
    void delStu(int id);
    void updateStu(Stu stu);
}

