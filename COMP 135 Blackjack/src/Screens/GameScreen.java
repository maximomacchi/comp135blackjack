package Screens;

import java.awt.Color;
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
	// private GLabel compScore;
	private GButton hitButton;
	private GButton standButton;
	private GLabel compTotalScore;
	private GLabel playerTotalScore;
	
	private static final double HIT_X = 41;
	private static final double HIT_Y = 506;
	private static final double HIT_SIZE_WIDTH = 110;
	private static final double HIT_SIZE_HEIGHT = 76;
	private static final double STAND_X = 845;
	private static final double STAND_Y = 506;
	private static final double STAND_SIZE_WIDTH = 118;
	private static final double STAND_SIZE_HEIGHT = 81;
	private static final double PLAYERSCORE_X = 473;
	private static final double PLAYERSCORE_Y = 417;
	private static final double COMPSCORE_X = 469;
	private static final double COMPSCORE_Y = 165;
	private static final double COMP_TOTAL_SCORE_X = 939;
	private static final double COMP_TOTAL_SCORE_Y = 94;
	private static final double PLAYER_TOTAL_SCORE_X = 900;
	private static final double PLAYER_TOTAL_SCORE_Y = 148;
	
	public GameScreen(main app) {
		program = app;
		background = new GImage("files/Card Dealt.png", 0, 0);
		hitButton = new GButton(HIT_X, HIT_Y, HIT_SIZE_WIDTH, HIT_SIZE_HEIGHT, false);
		standButton = new GButton(STAND_X, STAND_Y, STAND_SIZE_WIDTH, STAND_SIZE_HEIGHT, false);
		playerScore = new GLabel(Integer.toString(program.getBlackjack().getPlayerTotal()), PLAYERSCORE_X, PLAYERSCORE_Y);
		playerScore.setFont("Arial-50");
		// compScore = new GLabel(Integer.toString(program.getBlackjack().getCompTotal()), COMPSCORE_X, COMPSCORE_Y);
		// compScore.setFont("Arial-30");
		compTotalScore = new GLabel(Integer.toString(program.getCompScore()), COMP_TOTAL_SCORE_X, COMP_TOTAL_SCORE_Y);
		compTotalScore.setFont("Arial-30");
		compTotalScore.setColor(Color.white);
		playerTotalScore = new GLabel(Integer.toString(program.getPlayerScore()), PLAYER_TOTAL_SCORE_X, PLAYER_TOTAL_SCORE_Y);
		playerTotalScore.setFont("Arial-30");
		playerTotalScore.setColor(Color.white);
	}
	
	@Override
	public void showContents() {
		dealInitialCards();
		compTotalScore.setLabel(Integer.toString(program.getCompScore()));
		playerTotalScore.setLabel(Integer.toString(program.getPlayerScore()));
		program.add(background);
		program.add(hitButton);
		program.add(standButton);
		program.add(playerScore);
		// program.add(compScore);
		program.add(compTotalScore);
		program.add(playerTotalScore);
	}
	
	@Override
	public void hideContents() {
		program.remove(background);
		program.remove(hitButton);
		program.remove(standButton);
		program.remove(playerScore);
		// program.remove(compScore);
		program.remove(compTotalScore);
		program.remove(playerTotalScore);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == hitButton) {
			program.getBlackjack().dealPlayerCard();
			program.getBlackjack().dealCompCard();
			// updateLabel(program.getBlackjack().getCompTotal(), compScore);
			if (program.getBlackjack().getPlayerTotal() == 21) {
				program.switchToVictory();
				return;
			}
			else if (program.getBlackjack().playerWon()) {
				updateLabel(program.getBlackjack().getPlayerTotal(), playerScore);
			}
			else {
				program.switchToDefeat();
				return;
			}
			/* if (program.getBlackjack().compWon()) {
			//	updateLabel(program.getBlackjack().getCompTotal(), compScore);
			}
			else {
				program.switchToVictory();
				return;
			}
			*/
		}
		
		if(obj == standButton) {
			while (program.getBlackjack().getPlayerTotal() < 17) {
				program.getBlackjack().dealPlayerCard();
			}
			while (program.getBlackjack().getCompTotal() < 17) {
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
	
	public void dealInitialCards() {
		program.getBlackjack().setPlayerTotal(0);
		program.getBlackjack().setCompTotal(0);
		program.getBlackjack().dealFirstCards();
		playerScore.setLabel(Integer.toString(program.getBlackjack().getPlayerTotal()));
		// compScore.setLabel(Integer.toString(program.getBlackjack().getCompTotal()));
	}
	
	public int getPlayerTotal() {
		return program.getBlackjack().getPlayerTotal();
	}
	
	public int getCompTotal() {
		return program.getBlackjack().getCompTotal();
	}

	@Override
	public main getProgram() {
		return program;
	}
}
