package edu.ssafy.exception;

public class MyException extends Exception {
	public MyException() {
		// TODO Auto-generated constructor stub
		super("MyException");
	}
	public void trace() {
		this.trace();
	}
}
