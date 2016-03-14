package edu.mum.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TraceAdvice {
	@After("execution(public * edu.mum.service.*.*(..))")
	public void traceMethod(JoinPoint joinPoint) {
		System.out.println("Message = " + joinPoint.getSignature().getName());
	}

	@After("execution(* edu.mum.service.MealServiceImpl.deleteMeal(..))")
	public void deleteTraceMethod(JoinPoint joinPoint) {
		System.out.println("Message = " + joinPoint.getSignature().getName());
		System.out.println("1 meal is deleted successfully ");
	}

}
