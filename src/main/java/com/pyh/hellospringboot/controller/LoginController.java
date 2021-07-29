package com.pyh.hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/dologin")
    public String login(@RequestParam String name,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        if (password.equalsIgnoreCase("6"))
        {
            session.setAttribute("loginuser",name);
            return "redirect:/index.html";
        } else
        {
            model.addAttribute("msg", "用户名或密码错误！");
            return "login";
        }
    }

}
