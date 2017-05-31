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
	private GButton standButton;
	
	private static final double HIT_X = 32;
	private static final double HIT_Y = 489;
	private static final double HIT_SIZE_WIDTH = 106;
	private static final double HIT_SIZE_HEIGHT = 72;
	private static final double STAND_X = 814;
	private static final double STAND_Y = 483;
	private static final double STAND_SIZE_WIDTH = 105;
	private static final double STAND_SIZE_HEIGHT = 81;
	private static final double PLAYERSCORE_X = 469;
	private static final double PLAYERSCORE_Y = 417;
	private static final double COMPSCORE_X = 469;
	private static final double COMPSCORE_Y = 165;
	
	public GameScreen(main app) {
		program = app;
		program.getBlackjack().dealFirstCards();
		background = new GImage("files/Card Dealt.png", 0, 0);
		hitButton = new GButton(HIT_X, HIT_Y, HIT_SIZE_WIDTH, HIT_SIZE_HEIGHT, false);
		standButton = new GButton(STAND_X, STAND_Y, STAND_SIZE_WIDTH, STAND_SIZE_HEIGHT, false);
		playerScore = new GLabel(Integer.toString(program.getBlackjack().getPlayerTotal()), PLAYERSCORE_X, PLAYERSCORE_Y);
		playerScore.setFont("Arial-30");
		compScore = new GLabel(Integer.toString(program.getBlackjack().getCompTotal()), COMPSCORE_X, COMPSCORE_Y);
		compScore.setFont("Arial-30");
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(hitButton);
		program.add(standButton);
		program.add(playerScore);
		program.add(compScore);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(hitButton);
		program.remove(standButton);
		program.remove(playerScore);
		program.remove(compScore);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == hitButton) {
			program.getBlackjack().dealPlayerCard();
			if (program.getBlackjack().playerWon()) {
				updateLabel(program.getBlackjack().getPlayerTotal(), playerScore);
			}
			else {
				program.switchToDefeat();
				return;
			}
			program.getBlackjack().dealCompCard();
			if (program.getBlackjack().compWon()) {
				updateLabel(program.getBlackjack().getCompTotal(), compScore);
			}
			else {
				program.switchToVictory();
				return;
			}
		}
		
		if(obj == standButton) {
			while (program.getBlackjack().getPlayerTotal() < 16) {
				program.getBlackjack().dealPlayerCard();
			}
			while (program.getBlackjack().getCompTotal() < 16) {
				program.getBlackjack().dealCompCard();
			}
			if ((program.getBlackjack().getCompTotal() > 21) && (program.getBlackjack().getPlayerTotal() < 21)) {
				program.switchToVictory();
			}
			else if ((program.getBlackjack().getPlayerTotal() > program.getBlackjack().getCompTotal()) && program.getBlackjack().getPlayerTotal() <= 21) {
				program.switchToVictory();
			}
			else if ((program.getBlackjack().getPlayerTotal() == program.getBlackjack().getCompTotal()) && program.getBlackjack().getPlayerTotal() <= 21) {
				program.switchToVictory();
			}
			else {
				program.switchToDefeat();
			}
		}
	}
	
	public void updateLabel(int newValue, GLabel label) {
		program.remove(label);
		label.setLabel(Integer.toString(newValue));
		program.add(label);
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
