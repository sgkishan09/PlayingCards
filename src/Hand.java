import java.util.ArrayList;
import java.util.List;

public class Hand implements Cloneable {
    private ArrayList<Card> cards;
    private int noOfCards;

    public Hand(int noOfCards) {
        this.noOfCards = noOfCards;
        this.cards = new ArrayList<>();
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public String toString() {
        return cards.toString();
    }

    @Override
    public Object clone() {
        Hand clone = new Hand(this.noOfCards);
        clone.addCards(this.cards);
        return clone;
    }

    public void subtractHand(Hand hand) {
        this.cards.removeAll(hand.cards);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean removeCard(Card card) {
        for (Card iCard : cards) {
            if (card.equals(iCard))
                return cards.remove(iCard);
        }
        return false;
    }

}