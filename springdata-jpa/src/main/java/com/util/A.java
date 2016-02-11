package com.util;

import org.springframework.stereotype.Component;

@Component("beanA")
public class A implements IA {

	public String msgA = "From A";
	
	@Override
	public String show() {
		return msgA;
	}

	@Override
	public String showA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String showB() {
		// TODO Auto-generated method stub
		return null;
	}

}
