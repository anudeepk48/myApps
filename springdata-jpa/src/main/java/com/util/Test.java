package com.util;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;

public class Test implements Serializable,Runnable {
	
	private String name;
	
	private int age;
	
	
	public Test(){}
	
	public Test(String name,int age){
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public void run() {
		System.out.println("thread running");
		
	}
	
	@Override
	public boolean equals(Object obj) {
	    // TODO Auto-generated method stub
	    if(obj instanceof Test)
	    {
	        Test temp = (Test) obj;
	        if(this.name == temp.name && this.age== temp.age)
	            return true;
	    }
	    return false;

	}
	@Override
	public int hashCode() {
	    // TODO Auto-generated method stub

	    return (this.name.hashCode()*5);        
	}
}
