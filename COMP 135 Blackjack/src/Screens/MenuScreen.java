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
	
	private static final double INSTRUCTIONS_WIDTH_FACTOR = 2.354;
	private static final double INSTRUCTIONS_HEIGHT_FACTOR = 1.816;
	private static final double INSTRUCTIONS_SIZE_WIDTH = 117;
	private static final double INSTRUCTIONS_SIZE_HEIGHT = 82;
	private static final double INSTRUCTIONS_X = 435;
	private static final double INSTRUCTIONS_Y = 423;
	private final double INSTRUCTIONS_WIDTH_OFFSET = program.WINDOW_WIDTH/INSTRUCTIONS_WIDTH_FACTOR;
	private final double INSTRUCTIONS_HEIGHT_OFFSET = program.WINDOW_HEIGHT/INSTRUCTIONS_HEIGHT_FACTOR;
	
	public MenuScreen(main app) {
		program = app;
		background = new GImage("files/Start Screen.png", 0, 0);
		instructionsButton = new GButton(INSTRUCTIONS_X, INSTRUCTIONS_Y, INSTRUCTIONS_SIZE_WIDTH, INSTRUCTIONS_SIZE_HEIGHT, false);
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(instructionsButton);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(instructionsButton);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == instructionsButton) {
			program.switchToInstructions();
		}
	}

	@Override
	public main getProgram() {
		// TODO Auto-generated method stub
		return program;
	}
}
