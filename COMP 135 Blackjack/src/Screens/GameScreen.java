package Screens;

import java.awt.event.MouseEvent;

import Blackjack.GButton;
import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;
import acm.graphics.GObject;

public class GameScreen extends GraphicsPane {
	private main program;
	private GImage background;
	private GButton hitButton;
	
	public GameScreen(main app) {
		program = app;
		background = new GImage("files/Card Dealt.png", 0, 0);
		hitButton = new GButton(32, 489, 106, 72, false);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(hitButton);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(hitButton);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == hitButton) {
			program.getBlackjack().dealPlayerCard();
			if (program.getBlackjack().playerWon()) {
				
			}
		}
	}
}
