package com.game.process;

public class GeneratingChoice
{
	static String[] choices = {"Rock", "Paper", "Scissor", "Paper", "Scissor","Rock"};
	
	public static String choice()
	{
	String out ="";
	int i = 1,randomNum;
	
	while(i >= 0)
	{
	randomNum = (int)(Math.random()*10);
	if(randomNum > 5) continue;
	out = choices[randomNum];
	break;
	}
	
	return out;
	}

}
