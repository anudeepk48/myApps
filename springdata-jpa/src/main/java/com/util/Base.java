package com.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.CityRepository;

public class Base {
	@Autowired
	CityRepository cityRepository;
}
