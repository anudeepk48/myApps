package com.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize; 

@Documented
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RUNTIME)
@PreAuthorize("hasAuthority('ADMIN')")
public @interface Admin {

} 
