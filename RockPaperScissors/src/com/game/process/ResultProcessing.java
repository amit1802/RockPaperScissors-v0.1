package com.game.process;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultProcessing 
{
	
	@Autowired
	Players player1, player2, player3, player4;
	
	List<Players> playList = new ArrayList<Players>();
	public void processing()
	{
		playList.add(player1);
		playList.add(player2);
		playList.add(player3);
		playList.add(player4);
		
		for(int i = 0; i < 4; i++) 
		{
			playList.get(i).setPlayerChoice(GeneratingChoice.choice());
		}
		
		player1.setOutcome(ChoiceComparison(player1, player2, player3, player4));
		player2.setOutcome(ChoiceComparison(player2, player1, player3, player4));
		player3.setOutcome(ChoiceComparison(player3, player2, player1, player4));
		player4.setOutcome(ChoiceComparison(player4, player2, player3, player1));
		
		display();
		
		
	}
	
	
	
	public String[] ChoiceComparison(Players p1, Players p2, Players p3, Players p4) 
	{
		String[] result = new String[4];
		String buff = "";
		result[0] = outcomeCalculate(p1,p1);
		result[1] = outcomeCalculate(p1,p2);
		result[2] = outcomeCalculate(p1,p3);
		result[3] = outcomeCalculate(p1,p4);
		
		if(p1.equals(player2)) 
		{
			buff=result[0];
			result[0] = result[1];
			result[1] = buff;
		}
		
		else if(p1.equals(player3)) 
		{
			buff = result[0];
			result[0] = result[2];
			result[2] = buff;
		}
		
		else if(p1.equals(player4)) 
		{
			buff = result[0];
			result[0] = result[3];
			result[3] = buff;
		}
		
		return result;
		
	}
	
	public String outcomeCalculate(Players p1, Players p2)
	{
		if(p1.getPlayerChoice().equals(p2.getPlayerChoice())) return "-";
	
		else if(p1.getPlayerChoice().equals("Rock"))
		{
			return p2.getPlayerChoice().equals("Paper")?"0":"1";
		}
		
		else if(p1.getPlayerChoice().equals("Paper"))
		{
			return p2.getPlayerChoice().equals("Scissor")?"0":"1";
		}
		
		else if(p1.getPlayerChoice().equals("Scissor"))
		{
			return p2.getPlayerChoice().equals("Rock")?"0":"1";
		}
		
		return "";
	}
	
	public void display()
	{
		for(int j = 0; j<4; j++)
		{
			System.out.print("Player"+(j+1)+"  ");
			System.out.println(playList.get(j).getPlayerChoice());
		}
		System.out.println("\n");
		
		System.out.println("\tPlayer1   Player2   Player3   Player4");
		
		for(int k = 0;k<4;k++)
		{
			System.out.print("Player"+(k+1)+"  ");
			for(String res : playList.get(k).getOutcome())
			{
				System.out.print(res+"         ");
			}
			System.out.println();
			
		}
		System.out.println("\n");
	}
}
