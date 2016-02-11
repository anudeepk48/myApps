package com.util;

import org.springframework.stereotype.Service;

@Service
public class Test2 extends Base {

	public String toString(){
		return cityRepository.toString();
	}
	
}
