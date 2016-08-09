import java.util.ArrayList;
import java.util.List;

class Hand {
	
	private List<Card> hand;
	
	/**
	 * Constructor for Hand. Makes a hand based on given deck and number of cards in hand for the game
	 */
	public Hand(Deck deck, int noOfCards) {
		hand = new ArrayList<>();
		for(int i=0;i<noOfCards;i++) {
			hand.add(deck.draw());
		}
	}
	
	/**
     * Returns the List of cards in hand
     *
     * @return List<Card>
     */
	protected List<Card> getHand() {
		return hand;
	}
	
}