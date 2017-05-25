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
	
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}
	
	public void run() {
		menuScreen = new MenuScreen(this);
		switchToMenu();
	}
	
	public void switchToMenu() {
		switchToScreen(menuScreen);
	}
}
