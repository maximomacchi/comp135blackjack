package Screens;

import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;

public class GameScreen extends GraphicsPane {
	private main program;
	private GImage background;
	
	public GameScreen(main app) {
		program = app;
		background = new GImage("files/Card Dealt.png", 0, 0);
	}
	
	public void showContents() {
		program.add(background);
	}
	
	public void hideContents() {
		program.remove(background);
	}
}
