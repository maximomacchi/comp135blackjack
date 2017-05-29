package Screens;

import java.awt.event.MouseEvent;

import Blackjack.GButton;
import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class GameScreen extends GraphicsPane {
	private main program;
	private GImage background;
	private GLabel playerScore;
	private GLabel compScore;
	private GButton hitButton;
	
	public GameScreen(main app) {
		program = app;
		background = new GImage("files/Card Dealt.png", 0, 0);
		hitButton = new GButton(32, 489, 106, 72, false);
		playerScore = new GLabel(Integer.toString(0), 469, 417);
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
	
	public void updateLabel(int newValue, GLabel label) {
		program.remove(label);
		GLabel newLabel = new GLabel(Integer.toString(newValue), label.getX(), label.getY());
		program.add(newLabel);
		return;
	}
}
