package com.pyh.hellospringboot.controller;

import com.pyh.hellospringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @Autowired
    private User user;

    @RequestMapping("/hello")
    public String hello()
    {
        return "hello,springboot";
    }

    @GetMapping("/index")
    public String index(Model model)
    {
        model.addAttribute("user",user);
        System.out.println(user);
        return "index";
    }
}
