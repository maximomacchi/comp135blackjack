package Screens;

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
		playerScore = new GLabel(Integer.toString(program.getBlackjack().getPlayerTotal()), 469, 417);
		compScore = new GLabel(Integer.toString(program.getBlackjack().getCompTotal()), 469, 165);
	}
	
	@Override
	public void showContents() {
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

}
