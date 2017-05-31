package Blackjack;

import Screens.DefeatScreen;
import Screens.GameScreen;
import Screens.MenuScreen;
import Screens.VictoryScreen;

public class main extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	
	private GraphicsPane defeatScreen;
	private GraphicsPane gameScreen;
	private GraphicsPane menuScreen;
	private GraphicsPane victoryScreen;
	private Blackjack blackjack;
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		blackjack = new Blackjack();
	}
	
	public void run() {
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		victoryScreen = new VictoryScreen(this);
		defeatScreen = new DefeatScreen(this);
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
	
	public void switchToGame() {
		switchToScreen(gameScreen);
	}
	
	public void switchToVictory() {
		switchToScreen(victoryScreen);
	}
	
	public void switchToDefeat() {
		victoryScreen.getProgram().getBlackjack().setPlayerTotal(gameScreen.getProgram().getBlackjack().getPlayerTotal());
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

}
