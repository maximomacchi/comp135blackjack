package Blackjack;

import Screens.DefeatScreen;
import Screens.GameScreen;
import Screens.Instructions;
import Screens.MenuScreen;
import Screens.VictoryScreen;

public class main extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	
	private GraphicsPane defeatScreen;
	private GraphicsPane gameScreen;
	private GraphicsPane menuScreen;
	private GraphicsPane victoryScreen;
	private GraphicsPane instructionsScreen;
	private Blackjack blackjack;
	private int playerScore = 0;
	private int compScore = 0;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		blackjack = new Blackjack();
	}
	
	public void run() {
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		victoryScreen = new VictoryScreen(this);
		defeatScreen = new DefeatScreen(this);
		instructionsScreen = new Instructions(this);
		setupInteractions();
		switchToMenu();
	}
	
	private void setupInteractions() {
		requestFocus();
		addKeyListeners();
		addMouseListeners();
	}
	
	public void switchToMenu() {
		switchToScreen(menuScreen);
	}
	
	public void switchToInstructions() {
		switchToScreen(instructionsScreen);
	}
	
	public void switchToGame() {
		switchToScreen(gameScreen);
	}
	
	public void switchToVictory() {
		incrementPlayerScore();
		switchToScreen(victoryScreen);
	}
	
	public void switchToDefeat() {
		incrementCompScore();
		switchToScreen(defeatScreen);
	}
	
	public Blackjack getBlackjack() {
		return blackjack;
	}
	
	public GraphicsPane getMenuScreen() {
		return menuScreen;
	}
	
	public GraphicsPane getGameScreen() {
		return gameScreen;
	}
	
	public GraphicsPane getVictoryScreen() {
		return victoryScreen;
	}
	
	public GraphicsPane getDefeatScreen() {
		return defeatScreen;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public int getCompScore() {
		return compScore;
	}
	
	public void setPlayerScore(int value) {
		playerScore = value;
	}
	
	public void setCompScore(int value) {
		compScore = value;
	}
	
	public void incrementPlayerScore() {
		playerScore++;
	}
	
	public void incrementCompScore() {
		compScore++;
	}

}
