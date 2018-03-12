package com.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;

@Aspect
public class MyAspect {

    //Spring Aop Question 1
    //Spring Aop Question 6
    @Pointcut("execution(* *.*(..))")
    void displayAdvice() {
    }

    //Spring Aop Question 2
    @Before("displayAdvice()")
    void beforedisplayInvoked() {
        System.out.println("Before Display Called");
    }

    @After("displayAdvice()")
    void afterdisplayInvoked() {
        System.out.println("After Display Called");
    }

    //Spring Aop Question 3
    @AfterThrowing(pointcut = "execution(void exceptionThrowMethod())", throwing = "ex")
    void afterThrowing(IOException ex) {
        System.out.println("Exception raised " + ex);
    }

    //Spring Aop Question 4
    @Around("execution(@Deprecated * *(..))")
    void methodWithDeprecatedAnnotation() {
        System.out.println("method with deprecated annotation called");
    }

    //Spring Aop Question 5
    @Before("execution(void display())")
    void beforeInvoked() {
        System.out.println("Before Display Called");
    }

    @After("within(com.spring.component.*)")
    void afterEveryInvoked() {
        System.out.println("After every method Called");
    }

    @After("bean(myClass3))")
    void afterAdvice() {
        System.out.println("Running after advice");
    }

    @After("args(Integer)")
    void checkNumber() {
        System.out.println("runs after method with integer parameter");
    }

    @Before("this(com.spring.demo.Main)")
    void beforeAdvice() {
        System.out.println("Running before advice");
    }

    //Spring Aop Question 7
//    @Before("displayAdvice()")
//    void displayInvoked(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getThis());
//        System.out.println("display  invoked for ::" + joinPoint.getSignature());
//    }
//
//    @After("execution(void display())")
//    void displayAfterInvoked(){
//        System.out.println("display after invoked");
//    }

//    @AfterReturning(pointcut = "execution(* display())",returning = "returnValue")
//    void afterReturning(Integer returnValue){
//        System.out.println("return value "+returnValue);
//    }

//    @AfterThrowing(pointcut = "execution(void display())",throwing = "ex")
//    void afterThrowing(Exception ex){
//        System.out.println("Exception raised "+ ex);
//    }

//    @Around("execution(void display())")
//    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        System.out.println("Before");
//            proceedingJoinPoint.proceed();
//        System.out.println("After");
//    }
}
