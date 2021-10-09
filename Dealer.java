package BlackJack;

public class Dealer {
	private Hand hand;

	public Dealer() {
		hand = new Hand();
	}
	// Determines if dealer has a blackjack
	public boolean isBlackjack(){
		if (hand.calculateTotal() == 21){
			return true;
		} else {
			return false;
		}
	}
	public Hand getHand() {
		return hand;
	}
//	// This automates the dealer's play
//	public void dealerPlay(){
//		
//		System.out.println("Dealer has " + hand.calculateTotal());
//		while (hand.calculateTotal() <= 16) {
//			System.out.println("Dealer has " + hand.calculateTotal()+ " and hits");
//			
//			hand.addCard(deck.getNextCard());
//			System.out.println("Dealer " + this.getHandString(true, false));
//		} 
//		if ( hand.calculateTotal() > 21) {
//			System.out.println("Dealer busts. " + this.getHandString(true, false));
//		} else {
//			System.out.println("Dealer stands. " + this.getHandString(true, false));
//		}
//	}
	

	
	// Calculates the dealer's hand total
	public int calculateTotal() {
		return hand.calculateTotal();
	}
	
	// Clears the dealer's hand
	public void clearDealerHand() {
		hand.clearHand();
	}
	
	public String getHandString() {
		String str = "Dealer Cards:" + hand.toString();

		return str;
	}
}
