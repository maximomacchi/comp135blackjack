package Blackjack;
import java.util.Random;

public class Blackjack {
	private static final int JACK = 10;
	private static final int QUEEN = 10;
	private static final int KING = 10;
	
	private int playerTotal;
	private int compTotal;
	
	public Blackjack() {
		playerTotal = 0;
		compTotal = 0;
	}
	
	public void dealFirstCards() {
		// Deal player cards
		for (int i = 0; i < 2; i++) {
			int num = generateRandNum(1, 13);
			switch (num) {
			case 11:
				playerTotal += JACK;
				break;
			case 12:
				playerTotal += QUEEN;
				break;
			case 13:
				playerTotal += KING;
				break;
			default:
				playerTotal += num;
				break;
			}
		}
		
		// Deal computer cards
		for (int i = 0; i < 2; i++) {
			int num = generateRandNum(1, 13);
			switch (num) {
			case 11:
				compTotal += JACK;
				break;
			case 12:
				compTotal += QUEEN;
				break;
			case 13:
				compTotal += KING;
				break;
			default:
				compTotal += num;
				break;
			}
			return;
		}
	}
	
	public void dealPlayerCard() {
		int num = generateRandNum(1, 13);
		switch (num) {
		case 11:
			playerTotal += JACK;
			break;
		case 12:
			playerTotal += QUEEN;
			break;
		case 13:
			playerTotal += KING;
			break;
		default:
			playerTotal += num;
			break;
		}
		return;
	}
	
	public void dealCompCard() {
		int num = generateRandNum(1, 13);
		if (compTotal > 16) {
			return;
		}
		switch (num) {
		case 11:
			compTotal += JACK;
			break;
		case 12:
			compTotal += QUEEN;
			break;
		case 13:
			compTotal += KING;
			break;
		default:
			compTotal += num;
			break;
		}
		return;
	}
	
	public int generateRandNum(int min, int max) {
		// Generates random number between min and max
		Random rand = new Random();
		int num = rand.nextInt(max) + min;
		return num;
	}
	
	public boolean playerWon() {
		// If player sum is less than 21, return true
		if (playerTotal > 21)
			return false;
		return true;
	}
	
	public boolean compWon() {
		// If computer sum is less than 21, return true
		if (compTotal > 21) 
			return false;
		return true;
	}
	
	public int getPlayerTotal() {
		return playerTotal;
	}
	
	public void setPlayerTotal(int value) {
		playerTotal = value;
	}
	
	public int getCompTotal() {
		return compTotal;
	}
	
	public void setCompTotal(int value) {
		compTotal = value;
	}
	
}
