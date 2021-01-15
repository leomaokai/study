package com.kai.diy;


//方式三:使用注解实现AOP

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//标注这个类是一个切面
@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.kai.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("注解方式,方法执行前");
    }

    @After("execution(* com.kai.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("注解方式,方法执行后");
    }

    //再环绕增强中,我们可以给定一个参数,代表我们要获取切入的店
    @Around("execution(* com.kai.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");

        Signature signature = jp.getSignature();
        System.out.println("signature"+signature);

        Object proceed = jp.proceed();
        System.out.println("环绕后");

        System.out.println(proceed);
    }
}
