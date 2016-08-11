import java.util.*;

public class Rummy {

    static int jokerValue;

    public static int checkSequence(Hand hand) {
        int numJokers = getNumJokers(hand.getCards());
        List<Card> cards = CardUtils.sortByFaceValues(removeJoker(hand.getCards()));
        int numberToChange = 5;
        for (Card card : cards) {
            int currentDiff = generateSequencesWith(card, hand.getCards().size(), cards);
            if (numberToChange < currentDiff) {
                numberToChange = currentDiff;
            }
        }
        return numberToChange;
    }

    public static Integer generateSequencesWith(Card card, Integer sequenceSize, List<Card> handCards) {
        int ACE_VALUE = 14;
        int minChanges = 5;
        List<Card> returnLists = new ArrayList<Card>();
        if (!(ACE_VALUE - card.getFaceValue() < sequenceSize - 1) || card.getFaceValue() == ACE_VALUE) {
            for (int i = 0; i < sequenceSize; i++) {
                List<Card> currentSequence = getSequenceAtPosition(card, i, sequenceSize);
                int currentDiff = findDifference(handCards, currentSequence);
                if (currentDiff < minChanges) {
                    returnLists = currentSequence;
                    minChanges = currentDiff;
                }
            }
        } else {
            int minPosition = sequenceSize - (ACE_VALUE - card.getFaceValue());
            for (int i = sequenceSize - 1; i >= minPosition; i--) {
                List<Card> currentSequence = getSequenceAtPosition(card, i, sequenceSize);
                int currentDiff = findDifference(handCards, currentSequence);
                if (currentDiff < minChanges) {
                    returnLists = currentSequence;
                    minChanges = currentDiff;
                }
            }
        }
        return minChanges;
    }

    public static List<Card> getSequenceAtPosition(Card card, int i, int sequenceSize) {
        List<Card> currentSequence = new ArrayList<>(sequenceSize);
        int b = i - 1;
        int f = i + 1;
        currentSequence.set(i, card);
        while (b > 0) {
            currentSequence.set(b, new Card(card.hashCode() - (i - b)));
            b--;
        }
        while (f < sequenceSize) {
            currentSequence.set(f, new Card(card.hashCode() + (f - i)));
            f++;
        }
        return currentSequence;
    }

    public static Integer findDifference(List<Card> originalList, List<Card> generatedList) {
        int difference = 0;
        for (Card card : originalList) {
            if (!generatedList.contains(card)) {
                difference++;
            }
        }
        return difference;
    }


    public static Integer checkSet(Hand hand) {
        List<Card> cards = removeJoker(hand.getCards());
        int numOfDuplicates = numDuplicates(cards);
        List<Card> cardsWithNoDuplicates = removeDuplicateCards(cards);
        int[] faceValueArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (Card card : cardsWithNoDuplicates) {
            faceValueArray[card.getFaceValue() - 2]++;
        }
        Arrays.sort(faceValueArray);
        int toChange = numOfDuplicates;
        for (int value : faceValueArray) {
            toChange += value;
        }
        return (toChange - faceValueArray[12]);
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

    public static boolean isPresent(Card C, Card[] remove) {
        for (int i = 0; i < remove.length; i++) {
            if (C.equals(remove[i]))
                return true;
        }
        return false;
    }

    public static Card[] subtractArrays(Card[] original, Card[] remove) {
        Card[] small = new Card[original.length - remove.length];
        int i = 0;
        for (Card c : original) {
            if (!isPresent(c, remove)) {
                small[i] = c;
                ++i;
            }
        }
        return small;
    }

    public static void main(String[] args) {
        jokerValue = 4;
        Hand hand = new Hand(5);
        hand.addCard(new Card("2", Card.Suit.SPADES));
        hand.addCard(new Card("3", Card.Suit.SPADES));
        hand.addCard(new Card("7", Card.Suit.SPADES));
        hand.addCard(new Card("8", Card.Suit.SPADES));
        hand.addCard(new Card("JOKER", Card.Suit.JOKER));

        System.out.println(checkSequence(hand));


    }

}
