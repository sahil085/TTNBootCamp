package com.spring.component;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyClass1 {

    public void display(){

        System.out.println("MyClass1");
    }
    public void display2(){

        System.out.println("MyClass1 display2");
    }
    public void exceptionThrowMethod() throws IOException {
        System.out.println("throws exception");
        throw new IOException("ioexception");
    }

    @Deprecated
    public void run(){
        System.out.println("method running");
    }

    public void displayNumber(Integer integer){
        System.out.println("Number is "+integer);
    }
}
