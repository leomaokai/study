package com.kai.springcloud.controller;


import com.kai.springcloud.pojo.Dept;
import com.kai.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/add")
    public boolean insertDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept selectDept(@PathVariable("id") Long id){
        return deptService.getDept(id);
    }

    @GetMapping("/list")
    public List<Dept> selectListDepts(){
        return deptService.listDepts();
    }

    //获取进来的微服务,获取一些消息
    @Autowired
    private DiscoveryClient client;
    @GetMapping("/dept/discovery")
    public Object discovery(){

        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println(services);

        //得到一个具体的微服务信息
        List<ServiceInstance> instances = client.getInstances("applicationName");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost());
        }

        return this.client;
    }

}
