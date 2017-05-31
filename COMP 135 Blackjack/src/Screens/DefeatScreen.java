package Screens;

import java.awt.Color;
import java.awt.event.MouseEvent;

import Blackjack.GButton;
import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class DefeatScreen extends GraphicsPane {
	private main program;
	private GImage background;
	private GLabel playerScore;
	private GLabel compScore;
	private GButton exitButton;
	
	private static final double EXIT_X = 524;
	private static final double EXIT_Y = 405;
	private static final double EXIT_HEIGHT = 102;
	private static final double EXIT_WIDTH = 186;
	
	public DefeatScreen(main app) {
		program = app;
		background = new GImage("files/Defeat.png", 0, 0);
		exitButton = new GButton(EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT, false);
	}
	
	@Override
	public void showContents() {
		program.getBlackjack().setPlayerTotal(program.getGameScreen().getProgram().getBlackjack().getPlayerTotal());
		program.getBlackjack().setCompTotal(program.getGameScreen().getProgram().getBlackjack().getCompTotal());
		playerScore = new GLabel(Integer.toString(program.getBlackjack().getPlayerTotal()), 300, 200);
		compScore = new GLabel(Integer.toString(program.getBlackjack().getCompTotal()), 500, 200);
		playerScore.setFont("Arial-30");
		playerScore.setColor(Color.white);
		compScore.setFont("Arial-30");
		compScore.setColor(Color.white);
		program.add(background);
		program.add(playerScore);
		program.add(compScore);
		program.add(exitButton);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(playerScore);
		program.remove(compScore);
		program.remove(exitButton);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == exitButton) {
			System.exit(1);
		}
	}
	
	public int getPlayerTotal() {
		return program.getBlackjack().getPlayerTotal();
	}
	
	public int getCompTotal() {
		return program.getBlackjack().getCompTotal();
	}

	@Override
	public main getProgram() {
		// TODO Auto-generated method stub
		return program;
	}

}
