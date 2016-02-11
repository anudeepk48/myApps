package com.util;

import org.springframework.stereotype.Component;

@Component
public class Test1 extends Base {

	public String toString(){
		return cityRepository.toString();
	}
	
}
