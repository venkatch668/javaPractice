package com.example.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.thymeleaf.pojo.User;

import org.springframework.ui.Model;


@Controller
public class ThymeLeafController {
	
	@RequestMapping(value="/index")
	public String index() {
		return "welcome";
	}
	
	@GetMapping("/view")
    public String modelAttributes(Model model) {
//		List<User> ls= new ArrayList<User>();
//		User user = new User();
//		user.setNo(1);
//		user.setName("venkat");
//        ls.add(user);
//        ls.add(user);
//        model.addAttribute("message", "Hello World!");
//        model.addAttribute("ls", ls);
        return "index.html";
    }
	
	@RequestMapping(value= {"/login"}, method=RequestMethod.POST)
//	@PostMapping("/login")
    public ModelAndView  submitForm(User ls) {
		System.out.println("first name - "+ls.getUsername());
		System.out.println("last name - "+ls.getPassword());
		ModelAndView mv = new ModelAndView();
        mv.setViewName("submitForm");
		mv.addObject("ls", ls);
        return mv;
    }
}
