package com.kai.diy;

public class DiyPointCut {

    public void before(){
        System.out.println("自定义切面,方法执行前");
    }
    public void after(){
        System.out.println("自定义切面,方法执行后");
    }
}
