import java.util.HashMap;
import java.util.Map;

class Card {

    private static Map<String, Integer> NumericalValue = null;

    protected static enum Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS, JOKER
    }

    protected static enum Colors {
        BLACK, RED, JOKER
    }

    public static void setAceValue(int value) {
        NumericalValue.put("A", value);
    }


    private String face;
    private Colors color;
    private Suit suit;

    private static void createMap() {
        NumericalValue = new HashMap<>();
        NumericalValue.put("2", 2);
        NumericalValue.put("3", 3);
        NumericalValue.put("4", 4);
        NumericalValue.put("5", 5);
        NumericalValue.put("6", 6);
        NumericalValue.put("7", 7);
        NumericalValue.put("8", 8);
        NumericalValue.put("9", 9);
        NumericalValue.put("10", 10);
        NumericalValue.put("T", 10);
        NumericalValue.put("J", 11);
        NumericalValue.put("Q", 12);
        NumericalValue.put("K", 13);
        NumericalValue.put("A", 14);
        NumericalValue.put("JOKER", -1);
    }

    public Card(int cardNum) {
        if (cardNum == -1) {
            this.face = "JOKER";
            this.suit = Suit.JOKER;
        } else {
            String ref = "23456789TJQKA";
            int suit = cardNum / ref.length();
            int cardRank = cardNum - ref.length() * suit;
            String rank = "" + ref.charAt(cardRank);
            this.face = rank;
            Suit newSuit;
            if (suit == 0) newSuit = Suit.SPADES;
            else if (suit == 1) newSuit = Suit.HEARTS;
            else if (suit == 2) newSuit = Suit.DIAMONDS;
            else newSuit = Suit.CLUBS;
            this.suit = newSuit;
        }
    }

    @Override
    public int hashCode() {
        String ref = "23456789TJQKA";
        int suitRank = 0;
        if (this.getSuit() == Suit.JOKER) return -1;
        else if (this.getSuit() == Suit.SPADES) suitRank = 0;
        else if (this.getSuit() == Suit.HEARTS) suitRank = 1;
        else if (this.getSuit() == Suit.DIAMONDS) suitRank = 2;
        else suitRank = 3;
        return suitRank * ref.length() + ref.indexOf(this.getFace());
    }


    /*
     * 	Assessor functions
     *
     */
    protected int getFaceValue() {
        return NumericalValue.get(this.face);
    }

    protected String getFace() {
        return this.face;
    }

    protected Colors getColor() {
        return this.color;
    }

    protected Suit getSuit() {
        return this.suit;
    }


    public Card(String face, Suit suite) {
        if (NumericalValue == null) {
            createMap();
        }
        this.face = face.toUpperCase();
        this.suit = suite;
    }

    public String toString() {
        if (!face.equalsIgnoreCase("JOKER"))
            return getFace() + " of " + getSuit();
        else
            return "JOKER";
    }

    @Override
    public boolean equals(Object cards) {
        Card card = (Card) cards;
        return getFaceValue() == card.getFaceValue() && suit == card.getSuit();
    }


}