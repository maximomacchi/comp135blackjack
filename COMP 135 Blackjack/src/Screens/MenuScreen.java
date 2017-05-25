package Screens;

import Blackjack.GButton;
import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;

public class MenuScreen extends GraphicsPane {
	private main program;
	private GImage background;
	private GButton playButton;
	
	private static final double PLAY_WIDTH_FACTOR = 117;
	private static final double PLAY_HEIGHT_FACTOR = 82;
	private final double PLAY_WIDTH_OFFSET = program.WINDOW_WIDTH/PLAY_WIDTH_FACTOR;
	private final double PLAY_HEIGHT_OFFSET = program.WINDOW_HEIGHT/PLAY_HEIGHT_FACTOR;
	
	public MenuScreen(main app) {
		program = app;
		background = new GImage("files/Start Screen.png", 0, 0);
	}
	
	public void showContents() {
		program.add(background);
	}
	
	public void hideContents() {
		program.remove(background);
	}
}
