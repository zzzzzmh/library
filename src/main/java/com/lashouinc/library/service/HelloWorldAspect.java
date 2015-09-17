package com.lashouinc.library.service;

public class HelloWorldAspect {
	public void beforeAdvice() {  
	    System.out.println("===========before advice");  
	}  
	//后置最终通知  
    public void afterFinallyAdvice() {  
        System.out.println("===========after finally advice");  
    }   
}
