import java.util.*;


public class Deck {
    protected ArrayList<Card> deck;

    /**
     * Constructor for Deck. Makes a normal deck.
     */
    public Deck(int numOfPacks, boolean isJokerDeck) {
    	deck = new ArrayList<>();
    	for(int i=0;i<numOfPacks;i++) {
    		Pack p = new Pack(isJokerDeck);
    		deck.addAll(p.getCards());
    	}
    }

    /**
     * Shuffle the deck. Randomly re-orders the cards.
     *
     * @return void
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Draw a Card from the deck. Removes from the "top" (beginning of ArrayList).
     *
     * @return A Card object from the deck.
     */
    public Card draw() {
        return deck.remove(0);
    }

    /**
     * Check if two decks are the same.
     *
     * @param other Another deck of cards.
     * @return True or false.
     */
    public boolean equals(Deck other) {
        return this.toString().equals(other.toString());
    }

    /**
     * Get the ArrayList of Cards.
     *
     * @return The Cards.
     */
    public ArrayList<Card> cards() {
        return deck;
    }

    /**
     * Get the string representation of a Deck.
     *
     * @return A string representation of a Deck.
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < deck.size(); i++) {
            result += deck.get(i).toString() + " ";
            if (i < deck.size() - 1) {
                result += "--";
            }
        }
        return result;
    }
}