package edu.ssafy.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(public void edu.ssafy.aop.*.doSomething())")
	public void mypt() {
		
	}
	@Before(value = "mypt()") //공통핵심사항
	public void doBefore() {
		System.out.println("문을 열고 집에 들어간다.");
	}
	@AfterReturning(value = "mypt()") //예외 안 끝나고 끝나면(정상적으로), try안 느낌
	public void doAfterReturning() {
		System.out.println("불을 끄고 잔다.");
	}
	@AfterThrowing(value = "mypt()", throwing="th") //예외발생시, catch안 느낌
	//throwable이 exception의 부모이다. 
	public void doAfterThrowing(Throwable th) {
		System.out.println(th.getMessage()+":"+"119에 신고한다.");
	}
	@After("mypt()") //끝나면 무조건, finally 안 느낌
	public void doAfter() {
		System.out.println("문을 열고 집을 나온다.");
	}
}
