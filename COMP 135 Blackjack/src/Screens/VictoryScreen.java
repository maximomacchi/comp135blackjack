package Screens;

import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;

public class VictoryScreen extends GraphicsPane {
	private main program;
	private GImage background;
	
	public VictoryScreen(main app) {
		program = app;
		background = new GImage("files/Victory.png", 0, 0);
	}
	
	@Override
	public void showContents() {
		program.add(background);
	}

	@Override
	public void hideContents() {
		program.remove(background);
	}
	
}
