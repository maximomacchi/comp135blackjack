package Screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import acm.program.*;
import acm.util.*;
import Blackjack.GButton;
import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;
import acm.graphics.GObject;

public class MenuScreen extends GraphicsPane {
	private main program;
	private GImage background;
	private GButton playButton;
	
	private static final double PLAY_WIDTH_FACTOR = 2.354;
	private static final double PLAY_HEIGHT_FACTOR = 1.816;
	private static final double PLAY_SIZE_WIDTH = 117;
	private static final double PLAY_SIZE_HEIGHT = 82;
	private static final double PLAY_X = 435;
	private static final double PLAY_Y = 423;
	private final double PLAY_WIDTH_OFFSET = program.WINDOW_WIDTH/PLAY_WIDTH_FACTOR;
	private final double PLAY_HEIGHT_OFFSET = program.WINDOW_HEIGHT/PLAY_HEIGHT_FACTOR;
	
	public MenuScreen(main app) {
		program = app;
		background = new GImage("files/Start Screen.png", 0, 0);
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
		// TODO Auto-generated method stub
		return program;
	}
}
