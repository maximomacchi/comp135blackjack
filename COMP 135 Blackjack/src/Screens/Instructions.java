package Screens;

import java.awt.event.MouseEvent;

import Blackjack.GButton;
import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;
import acm.graphics.GObject;

public class Instructions extends GraphicsPane {
	private main program;
	private GImage background;
	private GButton playButton;
	
	private static final double PLAY_SIZE_WIDTH = 149;
	private static final double PLAY_SIZE_HEIGHT = 75;
	private static final double PLAY_X = 803;
	private static final double PLAY_Y = 23;
	
	public Instructions (main app) {
		program = app;
		background = new GImage("files/Instructions.png", 0, 0);
		playButton = new GButton(PLAY_X, PLAY_Y, PLAY_SIZE_WIDTH, PLAY_SIZE_HEIGHT, false);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(playButton);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(playButton);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == playButton) {
			program.switchToGame();
		}
	}
	
	@Override
	public main getProgram() {
		return program;
	}
}
