import java.util.ArrayList;

public class Game {

    private static int MIN_LIMIT = 1;
    private static int MAX_LIMIT = 13;
    private static int NO_OF_PLAYERS = 2;
    private static int userScore = 0;
    private static int pcScore = 0;

    public ArrayList<Card> getOnlyDiamonds(ArrayList<Card> cards) {
        ArrayList<Card> diamondCards = new ArrayList<Card>();
        for (Card c : cards) {
            if (c.getSuit() == c.getSuit().DIAMONDS) {
                diamondCards.add(c);
            }
        }
        return diamondCards;
    }

    public ArrayList<Card> getPlayingDeck(ArrayList<Card> cards) {
        ArrayList<Card> cardsMinusDiamonds = new ArrayList<Card>();
        for (Card c : cards) {
            if (c.getSuit() != Card.Suit.DIAMONDS || c.getSuit() != Card.Suit.HEARTS) {
                cardsMinusDiamonds.add(c);
            }
        }
        return cardsMinusDiamonds;
    }

    public Hand getHand(ArrayList<Card> cards, Card.Suit s) {
        Hand hand = new Hand(13);
        for (Card c : cards) {
            if (c.getSuit() == s) {
                hand.addCard(c);
            }
        }
        return hand;
    }

    public void updateScore(Card playercard, Card pcCard, Card diamondCard) {
        if (playercard.getFaceValue() > pcCard.getFaceValue())
            userScore += diamondCard.getFaceValue();

        else if (playercard.getFaceValue() < pcCard.getFaceValue())
            pcScore += diamondCard.getFaceValue();
        else {
            userScore += (diamondCard.getFaceValue() / 2);
            pcScore += (diamondCard.getFaceValue() / 2);
        }

    }

    public static void main(String[] args) {
        int noOfCards = MAX_LIMIT - MIN_LIMIT + 1;
        ArrayList<Hand> hands = new ArrayList<>();
        DiamondStrategy currentStrategy = new DiamondStrategy1();


        //getPCvalue();

        //updateScore(playerCard,pcCard,diamondCard);
    }
}
