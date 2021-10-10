package BlackJack;

public class BlackJack {

	public static void main(String[] args) throws Exception {

		BlackJackGame mygame = new BlackJackGame();

		mygame.initializeGame();
		do {
			mygame.shuffle();
			mygame.getBets();
			mygame.dealCards();
			mygame.printStatus();
			mygame.checkBlackjack();
			mygame.hitOrStand();
			mygame.dealerPlays();
			mygame.settleBets();
			mygame.printMoney();
			mygame.clearHands();
		} while (mygame.playAgain());
		//mygame.endGame();

	}
}