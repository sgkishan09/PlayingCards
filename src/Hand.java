import java.util.ArrayList;

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

	public ArrayList<Card> getCards(){
	    return cards;
    }

    public boolean removeCard(Card card){
        for(Card iCard : cards){
        	if(card.equals(iCard))
				return cards.remove(iCard);
		}
		return false;
    }

}