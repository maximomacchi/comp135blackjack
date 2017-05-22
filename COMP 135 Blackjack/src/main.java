import java.util.Random;

public class main {
	
	private static final int JACK = 10;
	private static final int QUEEN = 10;
	private static final int KING = 10;
	
	public static void main(String[] args) {
		int randomNumber;
		int playerTotal = 0;
		int compTotal = 0;
		
		
	}
	
	public static int generateRandNum() {
		Random rand = new Random();
		int num = rand.nextInt(50) + 1;
		return num;
	}
	
}
