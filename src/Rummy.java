//import java.util.Collections;
//
//class Rummy extends Game {
//
//
//	public Rummy(int joker) {
//		this.numberOfCards=13;
//		deck = new Deck(1);
//		deck.shuffle();
//		hand = new Hand(deck,numberOfCards);
//		this.numberOfCards = numberOfCards;
//	}
//
//	@Override
//	void evaluate(Hand hand) {
//		CardUtils.sortCardsOnSuite(hand);
//		for(int i=0;i<hand.hand.size();i++) {
//			System.out.println(hand.hand.get(i).toString());
//		}
//
//	}
//
//	public static void debug() {
//		Rummy r = new Rummy(0);
//		r.evaluate(r.hand);
//	}
//
//	public static void main(String[] args) {
//		debug();
//	}
//
//}