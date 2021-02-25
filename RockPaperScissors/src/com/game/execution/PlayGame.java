package com.game.execution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.game.process.ResultProcessing;

public class PlayGame {

	public static void main(String[] args) 
	{
		AbstractApplicationContext context  = new ClassPathXmlApplicationContext("springMapping.xml");
		
		ResultProcessing result = context.getBean("resultProcessing", ResultProcessing.class);
		for(int i = 1; i<=50; i++) {result.processing();}
		context.close();
	}

}
