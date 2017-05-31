package Screens;

import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;
import acm.graphics.GLabel;

public class VictoryScreen extends GraphicsPane {
	private main program;
	private GImage background;
	private GLabel playerScore;
	private GLabel compScore;
	
	public VictoryScreen(main app) {
		program = app;
		background = new GImage("files/Victory.png", 0, 0);
	}
	
	@Override
	public void showContents() {
		program.getBlackjack().setPlayerTotal(program.getGameScreen().getProgram().getBlackjack().getPlayerTotal());
		program.getBlackjack().setCompTotal(program.getGameScreen().getProgram().getBlackjack().getCompTotal());
		playerScore = new GLabel(Integer.toString(program.getBlackjack().getPlayerTotal()), 469, 417);
		compScore = new GLabel(Integer.toString(program.getBlackjack().getCompTotal()), 469, 165);
		program.add(background);
		program.add(playerScore);
		program.add(compScore);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.add(playerScore);
		program.add(compScore);
	}
	
	public int getPlayerTotal() {
		return program.getBlackjack().getPlayerTotal();
	}
	
	public int getCompTotal() {
		return program.getBlackjack().getCompTotal();
	}
	
	public main getProgram() {
		return program;
	}
	
}
