package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;
import com.service.UserImpl;

@Controller
public class UserController {
	
	@Autowired
	UserImpl userImpl;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String userInfo(ModelMap mapData){
		List<User> userList = userImpl.list();
		mapData.addAttribute("users", userList);
		return "users";
	}
	
	@RequestMapping(value="/saveUser",method=RequestMethod.GET)
	public String saveUserGet(ModelMap mapData){
		mapData.addAttribute("user", new User());
		return "userForm";
	}
	
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public String saveUserPost(@Valid @ModelAttribute("user")User user,BindingResult br){
	    userImpl.save(user);
		return "redirect:users";
	}
	
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String showUserGet(@RequestParam("id")Long id,ModelMap mapData){
	    User user = userImpl.get(id);
	    mapData.addAttribute("user", user);
		return "userForm";
	}
	
	@RequestMapping(value="/userListJSON")
	public @ResponseBody List<User> listUserJson(){
		List<User> userList = userImpl.list();
		return userList;
	}
	
	

}
