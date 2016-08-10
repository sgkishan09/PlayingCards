import java.util.*;

public class Hand {
	private ArrayList<Card> cards;
	private int noOfCards;
	
	public Hand(int noOfCards) {
		this.noOfCards = noOfCards;
		this.cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}

}
