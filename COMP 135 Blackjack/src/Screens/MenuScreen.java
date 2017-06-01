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
	private GButton instructionsButton;
	private GButton playButton;
	
	private static final double INSTRUCTIONS_SIZE_WIDTH = 225;
	private static final double INSTRUCTIONS_SIZE_HEIGHT = 108;
	private static final double INSTRUCTIONS_X = 776;
	private static final double INSTRUCTIONS_Y = 27;
	private static final double PLAY_SIZE_WIDTH = 114;
	private static final double PLAY_SIZE_HEIGHT = 77;
	private static final double PLAY_X = 452;
	private static final double PLAY_Y = 446;
	
	public MenuScreen(main app) {
		program = app;
		background = new GImage("files/Start Screen.png", 0, 0);
		instructionsButton = new GButton(INSTRUCTIONS_X, INSTRUCTIONS_Y, INSTRUCTIONS_SIZE_WIDTH, INSTRUCTIONS_SIZE_HEIGHT, false);
		playButton = new GButton(PLAY_X, PLAY_Y, PLAY_SIZE_WIDTH, PLAY_SIZE_HEIGHT, false);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(instructionsButton);
		program.add(playButton);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(instructionsButton);
		program.remove(playButton);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == instructionsButton) {
			program.switchToInstructions();
		}
		if (obj == playButton) {
			program.switchToGame();
		}
	}

	@Override
	public main getProgram() {
		// TODO Auto-generated method stub
		return program;
	}
}
