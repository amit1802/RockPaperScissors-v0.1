package com.game.process;

import org.springframework.stereotype.Component;


public class Players 
{
	private String playerChoice;
	private String[] outcome;

	
	public String[] getOutcome() {
		return outcome;
	}

	public void setOutcome(String[] outcome) {
		this.outcome = outcome;
	}

	public String getPlayerChoice() {
		return playerChoice;
	}

	public void setPlayerChoice(String playerChoice) {
		this.playerChoice = playerChoice;
	}
	
}
