package edu.ssafy.aop;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class Girl implements Iperson{

	@Override
	public void doSomething() throws RuntimeException {
		// TODO Auto-generated method stub
		System.out.println("로봇을 가지고 논다.");
		if(new Random().nextBoolean()) throw new RuntimeException("화재발생");
	}

}
