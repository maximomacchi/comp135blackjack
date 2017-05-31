package Screens;

import java.awt.Color;

import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;
import acm.graphics.GLabel;

public class DefeatScreen extends GraphicsPane {
	private main program;
	private GImage background;
	private GLabel playerScore;
	private GLabel compScore;
	
	public DefeatScreen(main app) {
		program = app;
		background = new GImage("files/Defeat.png", 0, 0);
	}
	
	@Override
	public void showContents() {
		program.getBlackjack().setPlayerTotal(program.getGameScreen().getProgram().getBlackjack().getPlayerTotal());
		program.getBlackjack().setCompTotal(program.getGameScreen().getProgram().getBlackjack().getCompTotal());
		playerScore = new GLabel(Integer.toString(program.getBlackjack().getPlayerTotal()), 300, 200);
		compScore = new GLabel(Integer.toString(program.getBlackjack().getCompTotal()), 500, 200);
		playerScore.setFont("Arial-30");
		playerScore.setColor(Color.white);
		compScore.setFont("Arial-30");
		compScore.setColor(Color.white);
		program.add(background);
		program.add(playerScore);
		program.add(compScore);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(playerScore);
		program.remove(compScore);
	}
	
	public int getPlayerTotal() {
		return program.getBlackjack().getPlayerTotal();
	}
	
	public int getCompTotal() {
		return program.getBlackjack().getCompTotal();
	}

	@Override
	public main getProgram() {
		// TODO Auto-generated method stub
		return program;
	}

}
