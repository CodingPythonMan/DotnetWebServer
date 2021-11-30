package com.spring.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.spring..*Impl.*(..))")
	public void allPointcut() {}

	@Pointcut("execution(* com.spring..*Impl.get*(..))")
	public void getPointcut() {}
}
