package com.ZhangShuo.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log {
	
	@Before("execution(* Admin.com.Admin.Interface.op_Something.add(..))")
	public void beforeAdd(JoinPoint joinpoint) {
		System.out.println("add method");
	}
	@After("execution(* Admin.com.Admin.Interface.op_Something.add(..))")
	public void afterAdd(JoinPoint joinpoint) {
		
	}
	
	@Before("execution(* Admin.com.Admin.Interface.op_Something.update(..))")
	public void beforeUpdate(JoinPoint joinpoint) {
		
	}
	@After("execution(* Admin.com.Admin.Interface.op_Something.update(..))")
	public void afterUpdate(JoinPoint joinpoint) {
		
	}
}
