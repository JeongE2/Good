package com.example.good.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/index")
    public ModelAndView main(){
        return new ModelAndView("index");//?무슨 차이인가
    }

    @GetMapping("/food")
    public String food(){
        return "foodPages/food";
    }

    @GetMapping("/health")
    public String health(){
        return "functionalPages/functional";
    }

    @GetMapping("/drug")
    public String drug(){
        return "drugPages/drug";
    }

    @GetMapping("/my")
    public String my(){
        return "mypagePages/mypage";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }
}
