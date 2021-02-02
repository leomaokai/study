package com.kai.springcloud.mapper;


import com.kai.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept getDept(Long id);

    List<Dept> listDepts();
}
