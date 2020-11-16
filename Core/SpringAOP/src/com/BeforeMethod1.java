package com;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeMethod1 implements MethodBeforeAdvice {
	
	@Override
	public void before(Method method,Object[] args,Object target) throws Throwable {
		System.out.println("Before Method is Called");
		
		
	}

}
