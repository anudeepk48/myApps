package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.annotation.Admin;
import com.model.City;
import com.model.Person;
import com.model.User;
import com.service.CityRepository;
import com.service.PersonRepository;
import com.service.UserRepository;
import com.util.Test;

@Controller
public class TestController {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Admin
	@RequestMapping("/saveCity")
	public String test(ModelMap model,@RequestParam("name")String name,@RequestParam("pin")String pincode){
		model.addAttribute("msg", "hello world");
		return "test";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(){
		userRepository.delete(1L);
		return "test";
	}
	
	@com.annotation.User
	@RequestMapping("/test")
	public String testView(){
		return "test";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView getLoginPagePOst(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "success", error);
    }
	
	@RequestMapping("/findByName")
	public String byName(ModelMap model,@RequestParam("name")String name,@RequestParam("pin")String pincode){
		City city = cityRepository.findByNameAndPincode(name,pincode);
		model.addAttribute("msg", "city find by id : "+city.getId());
		return "test";
	}
	
	@RequestMapping(value="/findAll")
	@ResponseBody
	public List<City> findAll(ModelMap model,Pageable pageable){
		//Page<City> pageCity = cityRepository.findAll(new PageRequest(1, 10));
		Page<City> pageCity = cityRepository.findAll(pageable);
		Iterator<City> cityIterator = pageCity.iterator();
		List<City> cityList = new ArrayList<City>();
		while(cityIterator.hasNext()){
			City city = cityIterator.next();
			System.out.println(city.getName());
			cityList.add(city);
		}
		return cityList;
	}
	
	@RequestMapping("/findAllQuery")
	public String findAllQuery(ModelMap model){
		List<City> listCity = cityRepository.findAllCityByName("india");
		for(City city:listCity){
			System.out.println(city.getName());
		}
		return "test";
	}
	
	@RequestMapping("/findAllNamedQuery")
	public String findAllNamedQuery(ModelMap model){
		TypedQuery<City> query = entityManager.createNamedQuery("City.findAll", City.class);
		List<City> listCity = query.getResultList();
		for(City city:listCity){
			System.out.println(city.getName());
		}
		return "test";
	}
	
	 @RequestMapping(value = "/userForm", method = RequestMethod.GET)
	   public ModelAndView student() {
		 ModelAndView mv = new ModelAndView("userForm");
		 mv.addObject("user", new User());
	      return mv;
	   }
	   
	   @RequestMapping(value = "/userForm", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("user")User user, 
	   ModelMap model) {
	      model.addAttribute("user", user);
	      return "userForm";
	   }
	   
	   @RequestMapping(value = "/personForm", method = RequestMethod.GET)
		public ModelAndView printWelcome(@ModelAttribute("user") Person person) {
			ModelAndView mav = new ModelAndView("ajaxUserForm");
			mav.addObject("message", "Hello World!!!");
			mav.addObject("person", person);
			return mav;
	 
		}
	 
		@RequestMapping(value="/personForm", method = RequestMethod.POST)
	    public @ResponseBody Person  submittedFromData(@RequestBody Person person, HttpServletRequest request) {
			personRepository.save(person);
			return person;
		}
		
		@RequestMapping(value = "/serialization")
		public String serialization(@RequestParam("name")String name,@RequestParam("pin")String pincode) throws IOException {
			return "test";
		}
		
		@RequestMapping(value = "/deSerialization")
		public String deSerialization() throws IOException, ClassNotFoundException {
			return "test";
		}
		
		@RequestMapping(value = "/thread")
		public String thread() throws IOException, ClassNotFoundException {
			Test test = new Test();
			Thread t1=new Thread(test);
			t1.start();
			return "test";
		}
	
}
