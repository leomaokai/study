package com.kai.springcloud.service;

import com.kai.springcloud.mapper.DeptMapper;
import com.kai.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept getDept(Long id) {
        return deptMapper.getDept(id);
    }

    @Override
    public List<Dept> listDepts() {
        return deptMapper.listDepts();
    }
}
