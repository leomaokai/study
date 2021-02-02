package com.kai.springcloud.service;

import com.kai.springcloud.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {

    boolean addDept(Dept dept);

    Dept getDept(Long id);

    List<Dept> listDepts();
}
