package com.gitub.xl137010393.controller;

import com.gitub.xl137010393.entity.User;
import com.gitub.xl137010393.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = {"","/","index"})
    @ResponseBody
    public List<User> index(){
        List<User> list = userService.findAll();
        return list;
    }
}
