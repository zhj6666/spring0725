package com.zhj.spring0725.service;

import com.zhj.spring0725.bean.Stu;
import com.zhj.spring0725.dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StuServiceImpl implements StuService{
    @Autowired
    private StuDao stuDao;
    @Override
    public List<Map> selectStu() {

        return stuDao.selectStu();
    }

    @Override
    public void addStu(Stu stu) {
         stuDao.addStu(stu);
    }

    @Override
    public void delStu(int id) {
         stuDao.delStu(id);
    }

    @Override
    public void updateStu(Stu stu) {
        stuDao.updateStu(stu);
    }
}
