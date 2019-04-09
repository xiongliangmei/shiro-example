package com.gitub.xl137010393;

import com.gitub.xl137010393.entity.User;
import com.gitub.xl137010393.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring-datasource.xml");

        IUserService userService = (IUserService) app.getBean("userService");
        List<User> list =  userService.findAll();
        System.out.println(list.get(0).toString());
    }
}
