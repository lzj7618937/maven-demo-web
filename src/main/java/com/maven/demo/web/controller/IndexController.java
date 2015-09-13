package com.maven.demo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven.demo.entity.User;

/**
 * @author Zhangkaitao
 * @version 1.0
 */
@Controller("indexController")
public class IndexController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, Model model) {
		String data = "test";
		model.addAttribute("data", data);
//		User user = new User();
//		user.setUserName("lzj7618937");
//		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request, Model model) {
		return "test";
	}
	
	@RequestMapping(value = "/")
	public String defaultHtml(HttpServletRequest request, Model model) {
		User user = new User();
		user.setUserName("lzj7618937");
//		model.addAttribute("user", user);
		return "default";
	}
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(HttpServletRequest request, Model model) {
		return "test";
	}

    @RequestMapping(value = "/go404")
    public String go404(HttpServletRequest request, Model model) {
        return "go404";
    }

    @RequestMapping(value = "/go500")
    public String go500(HttpServletRequest request, Model model) {
        return "go500";
    }
}
