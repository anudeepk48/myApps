package com.util;

import org.springframework.stereotype.Component;

@Component
public  class C extends B {

	public String getMsg(){
		return msgB+" "+msgA;
	}
	
}
