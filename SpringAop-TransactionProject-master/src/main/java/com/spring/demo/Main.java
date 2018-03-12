package com.spring.demo;

import com.spring.component.MyClass1;
import com.spring.component.MyClass2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        //Spring AOP starts
        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("aop-spring-config.xml");
        MyClass1 myClass1 = (MyClass1)applicationContext2.getBean("myClass1");
        System.out.println("calling");
//        myClass1.display();
//        myClass1.display2();
//        myClass1.exceptionThrowMethod();
//        myClass1.run();
//        myClass1.displayNumber(4);
        //MyClass2 myClass2 = (MyClass2)applicationContext2.getBean("myClass2");
        //myClass2.display();

        //Spring Transaction starts
        UserAccount userAccount = new UserAccount();
        userAccount.setName("Kamini");
        userAccount.setBalance(75000);

        UserAccount userAccount2 = new UserAccount();
        userAccount2.setName("Ankur");
        userAccount2.setBalance(25000);

        UserAccount userAccount3 = new UserAccount();
        userAccount3.setName("Meeral");
        userAccount3.setBalance(45000);

        UserAccount userAccount4 = new UserAccount();
        userAccount4.setName("Tanuj");
        userAccount4.setBalance(50000);

        int balanceToTransfer = 5000;
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transactional-spring-config.xml");
        UserAccountService userAccountService=applicationContext.getBean(UserAccountService.class);

        //Spring Transaction Question 2
        String username = "Ankur";
        userAccountService.insertUser(userAccount);
        userAccountService.insertUser(userAccount2);
        userAccountService.insertUser(userAccount3);
        userAccountService.insertUser(userAccount4);
        userAccountService.updateUser(userAccount3,userAccount2,balanceToTransfer);
        userAccountService.readUser(username);
//      userAccountService.deleteUser(userAccount);

//        Spring Transaction Question 3
        userAccountService.updateUserUsingProgrammaticTransaction(userAccount,userAccount2,balanceToTransfer);

//        userAccountService.readAllUser();
        //Spring Transaction Question 4
        userAccountService.updateUser(userAccount,userAccount2,balanceToTransfer);
        userAccountService.readTransactions();
        userAccountService.updateUser(userAccount2,userAccount3,balanceToTransfer);
        userAccountService.readTransactions();
        userAccountService.updateUser(userAccount3,userAccount4,balanceToTransfer);
        userAccountService.readTransactions();

/*        userAccountService.readAllUser();
        userAccountService.updateUser(userAccount,userAccount4,balanceToTransfer);
        userAccountService.readAllUser();
        userAccountService.updateUser(userAccount2,userAccount3,balanceToTransfer);
        userAccountService.readAllUser();
        userAccountService.updateUser(userAccount4,userAccount,balanceToTransfer);
        userAccountService.readAllUser();
        userAccountService.readTransactions();

        System.out.println("Done");*/
    }
}
