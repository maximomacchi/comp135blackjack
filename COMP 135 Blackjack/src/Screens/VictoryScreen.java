package Screens;

import java.awt.Color;
import java.awt.event.MouseEvent;

import Blackjack.GButton;
import Blackjack.GraphicsPane;
import Blackjack.main;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class VictoryScreen extends GraphicsPane {
	private main program;
	private GImage background;
	private GLabel playerScore;
	private GLabel compScore;
	private GButton exitButton;
	private GButton playAgainButton;
	
	private static final double EXIT_X = 531;
	private static final double EXIT_Y = 420;
	private static final double EXIT_HEIGHT = 106;
	private static final double EXIT_WIDTH = 180;
	private static final double PLAY_AGAIN_X = 313;
	private static final double PLAY_AGAIN_Y = 422;
	private static final double PLAY_AGAIN_HEIGHT = 107;
	private static final double PLAY_AGAIN_WIDTH = 185;
	
	public VictoryScreen(main app) {
		program = app;
		background = new GImage("files/Victory.png", 0, 0);
		exitButton = new GButton(EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT, false);
		playAgainButton = new GButton(PLAY_AGAIN_X, PLAY_AGAIN_Y, PLAY_AGAIN_WIDTH, PLAY_AGAIN_HEIGHT, false);
	}
	
	@Override
	public void showContents() {
		program.getBlackjack().setPlayerTotal(program.getGameScreen().getProgram().getBlackjack().getPlayerTotal());
		program.getBlackjack().setCompTotal(program.getGameScreen().getProgram().getBlackjack().getCompTotal());
		playerScore = new GLabel("Player Sum: " + Integer.toString(program.getBlackjack().getPlayerTotal()), 300, 225);
		compScore = new GLabel("Dealer Sum: " + Integer.toString(program.getBlackjack().getCompTotal()), 550, 225);
		playerScore.setFont("Arial-30");
		playerScore.setColor(Color.white);
		compScore.setFont("Arial-30");
		compScore.setColor(Color.white);
		program.add(background);
		program.add(playerScore);
		program.add(compScore);
		program.add(exitButton);
		program.add(playAgainButton);
	}

	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(playerScore);
		program.remove(compScore);
		program.remove(exitButton);
		program.remove(playAgainButton);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == exitButton) {
			System.exit(1);
		}
		if (obj == playAgainButton) {
			program.switchToGame();
		}
	}
	
	public int getPlayerTotal() {
		return program.getBlackjack().getPlayerTotal();
	}
	
	public int getCompTotal() {
		return program.getBlackjack().getCompTotal();
	}
	
	public main getProgram() {
		return program;
	}
	
}
