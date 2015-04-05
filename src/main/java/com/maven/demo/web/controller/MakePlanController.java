package com.maven.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jaylee on 15-4-5.
 */
@Controller("makePlanController")
@RequestMapping("/plan")
public class MakePlanController {

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model) {
        return "makeplan/makeplan";
    }
}
