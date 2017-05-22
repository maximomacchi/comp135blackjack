import java.util.Random;

public class Blackjack {
	private static final int JACK = 10;
	private static final int QUEEN = 10;
	private static final int KING = 10;
	
	private int playerTotal = 0;
	private int compTotal = 0;
	
	public void dealFirstCards() {
		// Deal player cards
		for (int i = 0; i < 2; i++) {
			int num = generateRandNum();
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
			int num = generateRandNum();
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
		}
	}
	
	public void dealPlayerCard() {
		int num = generateRandNum();
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
	
	public void dealCompCard() {
		int num = generateRandNum();
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
	}
	
	public int generateRandNum() {
		Random rand = new Random();
		int num = rand.nextInt(13) + 1;
		return num;
	}
	
}
