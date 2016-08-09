import java.util.*;


public class Deck {
    private ArrayList<Card> deck;

    /**
     * Constructor for Deck. Makes a normal deck.
     */
    public Deck() {
        deck = new ArrayList<Card>();

        String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String card : cards) {
            deck.add(new Card(card, Card.Suites.SPADES));
            deck.add(new Card(card, Card.Suites.HEARTS));
            deck.add(new Card(card, Card.Suites.DIAMONDS));
            deck.add(new Card(card, Card.Suites.CLUBS));
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