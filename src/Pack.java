import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Pack {
	private ArrayList<Card> pack;
	
	/**
	 * Constructor for Pack. Makes a normal pack.
	 */
	public Pack() {
		pack = new ArrayList<Card>();

		String[] cards = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		for (String card: cards) {
			pack.add(new Card(card,Card.Suites.SPADES));
			pack.add(new Card(card,Card.Suites.HEARTS));
			pack.add(new Card(card,Card.Suites.DIAMONDS));
			pack.add(new Card(card,Card.Suites.CLUBS));
		}
		
	}
	
	/**
     * Returns the List of cards in pack
     *
     * @return List<Card>
     */
    protected List<Card> getPack() {
        return pack;
    }

	
	/**
     * Shuffle the pack. Randomly re-orders the cards.
     *
     * @return void
     */
    public void shuffle() {
        Collections.shuffle(pack);
    }

    /**
     * Draw a Card from the pack. Removes from the "top" (beginning of ArrayList).
     *
     * @return A Card object from the pack.
     */
    public Card draw() {
        return pack.remove(0);
    }

    /**
     * Check if two packs are the same.
     *
     * @param other Another pack of cards.
     * @return True or false.
     */
    public boolean equals(Pack other) {
        return this.toString().equals(other.toString());
    }

    /**
     * Get the ArrayList of Cards.
     *
     * @return The Cards.
     */
    public ArrayList<Card> cards() {
        return pack;
    }

    /**
     * Get the string representation of a pack.
     *
     * @return A string representation of a pack.
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < pack.size(); i++) {
            result += pack.get(i).toString() + " ";
            if (i < pack.size() - 1) {
                result += "--";
            }
        }
        return result;
    }
}