import java.util.ArrayList;
import java.util.Random;

public class Game {

    private static int MIN_LIMIT = 2;
    private static int MAX_LIMIT = 14;
    private static int NO_OF_PLAYERS = 2;
    private static int userScore = 0;
    private static int pcScore = 0;

    public static ArrayList<Card> getOnlyDiamonds(ArrayList<Card> cards) {
        ArrayList<Card> diamondCards = new ArrayList<Card>();
        for (Card c : cards) {
            if (c.getSuit() == c.getSuit().DIAMONDS) {
                diamondCards.add(c);
            }
        }
        return diamondCards;
    }

    public static ArrayList<Card> getPlayingDeck(ArrayList<Card> cards) {
        ArrayList<Card> cardsMinusDiamonds = new ArrayList<Card>();
        for (Card c : cards) {
            if (c.getSuit() != Card.Suit.DIAMONDS || c.getSuit() != Card.Suit.HEARTS) {
                cardsMinusDiamonds.add(c);
            }
        }
        return cardsMinusDiamonds;
    }

    public static Hand getHand(ArrayList<Card> cards, Card.Suit s) {
        Hand hand = new Hand(13);
        for (Card c : cards) {
            if (c.getSuit() == s) {
                hand.addCard(c);
            }
        }
        return hand;
    }

    public static void updateScore(Card playercard, Card pcCard, Card diamondCard) {
        if (playercard.getFaceValue() > pcCard.getFaceValue())
            userScore += diamondCard.getFaceValue();

        else if (playercard.getFaceValue() < pcCard.getFaceValue())
            pcScore += diamondCard.getFaceValue();
        else {
            userScore += (diamondCard.getFaceValue() / 2);
            pcScore += (diamondCard.getFaceValue() / 2);
        }

    }

    public Card getDiamondCard(ArrayList<Card> cards)
    {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(cards.size());
        Card c = cards.get(index);
        return c;
    }

    public static ArrayList<Card> userRemainingCards(Card userCard,ArrayList<Card>userCards)
    {
        userCards.remove(userCard);
        return userCards;
    }

    public static void main(String[] args) {
        int noOfCards = MAX_LIMIT - MIN_LIMIT + 1;
        ArrayList<Hand> hands = new ArrayList<>();
        DiamondStrategy currentStrategy = new DiamondStrategy1();


        //getPCvalue();

        //updateScore(playerCard,pcCard,diamondCard);
        Deck deck = new Deck(1,0);
        ArrayList<Card> diamondCards = getOnlyDiamonds(deck.cards());
        ArrayList<Card> bothPlayerCards = getPlayingDeck(new Deck(1,0).cards());
        Hand playerCards = getHand(bothPlayerCards, Card.Suit.CLUBS);

    }
}
