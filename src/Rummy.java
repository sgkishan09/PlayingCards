import java.util.*;

public class Rummy {

    static int jokerValue;


    public static int checkSequence(Hand hand) {
        int numJokers = getNumJokers(hand.getCards());
        List<Card> cards = CardUtils.sortByFaceValues(removeJoker(hand.getCards()));
        int numberToChange = 0;
        for (int i = 0; i < cards.size() - 1; i++) {
            int diff = cards.get(i + 1).getFaceValue() - cards.get(i).getFaceValue();
            if (diff > 1)
                if (numJokers >= diff)
                    numJokers -= diff;
                else
                    numberToChange += (diff - numJokers);
        }
        return numberToChange;
    }

    public static int checkSet(Hand hand) {
        List<Card> cards = removeJoker(hand.getCards());
        int numOfDuplicates = numDuplicates(cards);
        List<Card> cardsWithNoDuplicates = removeDuplicateCards(cards);
        int[] suitArray = {0, 0, 0, 0};
        for (Card card : cardsWithNoDuplicates) {
            if (card.getSuit() == Card.Suit.CLUBS)
                suitArray[0]++;
            else if (card.getSuit() == Card.Suit.SPADES)
                suitArray[1]++;
            else if (card.getSuit() == Card.Suit.DIAMONDS)
                suitArray[2]++;
            else
                suitArray[3]++;
        }
        Arrays.sort(suitArray);
        return (suitArray[0] + suitArray[1] + suitArray[2] + numOfDuplicates);
    }

    public static List<Card> removeJoker(List<Card> cards) {
        List<Card> retVal = new ArrayList<Card>();
        for (Card card : cards) {
            if (!isJoker(card))
                retVal.add(card);
        }
        return retVal;
    }

    public static int getNumJokers(List<Card> cards) {
        int numJokers = 0;
        for (Card card : cards) {
            if (isJoker(card))
                numJokers++;
        }
        return numJokers;
    }


    public static boolean isJoker(Card card) {
        return ((card.getFaceValue() == -1) || (card.getFaceValue() == jokerValue));
    }

    public static boolean isDuplicate(Card card, List<Card> cards) {
        for (Card c : cards) {
            if (c.equals(card))
                return true;
        }
        return false;
    }

    public static Integer numDuplicates(List<Card> cards) {
        int numDuplicates = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (isDuplicate(cards.get(i), cards.subList(i + 1, cards.size() - 1))) {
                numDuplicates++;
            }
        }
        return numDuplicates;
    }

    public static List<Card> removeDuplicateCards(List<Card> cards) {
        List<Card> noDuplicates = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (!isDuplicate(cards.get(i), cards.subList(i + 1, cards.size() - 1))) {
                noDuplicates.add(cards.get(i));
            }
        }
        return noDuplicates;
    }

    public static void main(String[] args) {
        Hand hand = new Hand(4);
    }

}
