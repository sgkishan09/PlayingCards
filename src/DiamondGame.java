import java.util.*;

public class DiamondGame {

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
            if (c.getSuit() != Card.Suit.DIAMONDS && c.getSuit() != Card.Suit.HEARTS) {
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

    public static Card getDiamondCard(ArrayList<Card> cards) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(cards.size());
        Card c = cards.get(index);
        return c;
    }

    public static ArrayList<Card> userRemainingCards(Card userCard, ArrayList<Card> userCards) {
        userCards.remove(userCard);
        return userCards;
    }

    public static void main(String[] args) {

        DiamondStrategy currentStrategy = new DiamondStrategy1();

        Deck deck = new Deck(1, 0);

        ArrayList<Card> diamondCards = getOnlyDiamonds(deck.cards());
        Hand playerCards = getHand(deck.cards(), Card.Suit.CLUBS);

        Hand pcCards = getHand(deck.cards(), Card.Suit.SPADES);
        PCPlayer newPlayer = new PCPlayer(currentStrategy, pcCards.getCards());

        Scanner scanner = new Scanner(System.in);

        while (diamondCards.size() > 0) {
            Card faceUpCard = getDiamondCard(diamondCards);
            diamondCards.remove(faceUpCard);
            System.out.println("Face up card: " + faceUpCard);
            System.out.println("Player cards: " + playerCards.getCards());
            Card currentPCCard = newPlayer.getNextMove(faceUpCard);
            System.out.println("Enter face value to bid: ");
            String userCardString = scanner.nextLine();
            Card userCard = new Card(userCardString, Card.Suit.CLUBS);
            CardUtils.containsFace(playerCards.getCards(), userCard.getFaceValue());
            playerCards.removeCard(userCard);
            updateScore(userCard, currentPCCard, faceUpCard);
            System.out.println("PC bid - " + currentPCCard);
            System.out.println("User score - " + userScore + "\nPC score - " + pcScore);
        }


    }
}
