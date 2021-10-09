package BlackJack;

import java.util.Scanner;

public class BlackJack {
	private static Deck deck;
	private Player[] players;
	private static Dealer dealer;
	private int playerNum = 0;
	public BlackJack() {
		deck = new Deck(6);
		players = new Player[6];
		dealer = new Dealer();
	}
	public void addPlayer(int bank, String name) {
		players[playerNum] = new Player(bank, name);
		playerNum++;
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		BlackJack bj = new BlackJack();
		System.out.println("welcome to play blckjack training game");
		Scanner sc = new Scanner(System.in);
		System.out.println("what is your name?");
		String name = sc.nextLine();
		System.out.println("how much you have?");
		int bank = sc.nextInt();
		bj.addPlayer(bank, name);
		Player player1 = bj.players[0];
		
		boolean stop = false;
		while(!stop) {
			System.out.println("how much you bet? or you could [q]uit now");
			if(sc.hasNextInt()) {
				int bet = sc.nextInt();
				player1.setBet(bet);
				boolean nextGame = false;
				while(!nextGame) {
					if(bet < player1.getBank()) {
						player1.getHand().addCard(deck.getNextCard());
						player1.getHand().addCard(deck.getNextCard());
						dealer.getHand().addCard(deck.getNextCard());
						dealer.getHand().addCard(deck.getNextCard());
						System.out.println(dealer.getHandString());
						System.out.println(player1.getHandString());
					}
					int count = player1.getHand().calculateTotal();
					if(count == 21) {
						System.out.println("blackJeck!!!");
						player1.blackjack();
						nextGame = true;
					}
					boolean stand = false;
					while(!stand && count < 21) {
						System.out.println("what do you want to do? [h]it,[d]ouble,[s]tand");//add split later
						String move = sc.nextLine();
						if(move.equals("h")) {
							player1.getHand().addCard(deck.getNextCard());
							System.out.println(player1.getHandString());
							count = player1.getHand().calculateTotal();
						}
//						if(move.equals("t")) {
//							Hand hand2 = new Hand();
//							hand2= player1.getHand();
//							hand2.getCard()[1] = deck.getNextCard();
//							player1.getHand().getCard()[1] = deck.getNextCard();
//							System.out.println(player1.getHandString());
//							count = player1.getHand().calculateTotal();
//							int count2 = hand2.calculateTotal();
//							if(count == 21) {
//								System.out.println("blackJeck!!!");
//								player1.blackjack();
//							}
//							if(count2 == 21) {
//								
//							}
//						}
						else if(move.equals("d")) {
							player1.setBet(player1.getBet()*2);
							player1.getHand().addCard(deck.getNextCard());
							System.out.println(player1.getHandString());
							count = player1.getHand().calculateTotal();
							break;
						}
						else if(move.equals("s")) {
							stand = true;
						}
					}
					if(count > 21) {
						System.out.println("you bust!");
						player1.bust();
						System.err.println(count);
						player1.getHand().clearHand();
						dealer.getHand().clearHand();
						nextGame = true;
					}
					else {
						int count2 = dealer.calculateTotal();
						while(count2 < 16) {
							dealer.getHand().addCard(deck.getNextCard());
							count2 = dealer.calculateTotal();
						}
						if(count2 > 21) {
							player1.win();
							player1.getHand().clearHand();
							dealer.getHand().clearHand();
							nextGame = true;
						}
					}
				}
			}
			else {
				
				stop = true;
			}
			
		}
		sc.close();
		
	}
}
