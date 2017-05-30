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
		switchToScreen(defeatScreen);
	}
	
	public Blackjack getBlackjack() {
		return blackjack;
	}

}
