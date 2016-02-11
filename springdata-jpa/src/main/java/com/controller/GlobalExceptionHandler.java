package com.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;



@ControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(Exception.class)
	  public ModelAndView myError(Exception exception) {
	    System.out.println("----Caught IOException----");
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.setViewName("globalerror");
	    return mav;
	  }
	
	@ExceptionHandler(AccessDeniedException.class)
	public String notFound() {
          System.out.println("----Caught KeywordNotFoundException----");
          return "404";
	  }
	
	 
	  
}
