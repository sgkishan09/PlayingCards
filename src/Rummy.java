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

//	public static void main(String[] args) {
//		Card[] small = new Card[4];
//		small[0] = new Card("A", Card.Suit.SPADES);
//		small[1] = new Card("2", Card.Suit.CLUBS);
//		small[2] = new Card("3", Card.Suit.CLUBS);
//		small[3] = new Card("4", Card.Suit.CLUBS);
//		Card[] o = new Card[5];
//		o[0] = new Card("A", Card.Suit.SPADES);
//		o[1] = new Card("2", Card.Suit.CLUBS);
//		o[2] = new Card("3", Card.Suit.CLUBS);
//		o[3] = new Card("4", Card.Suit.CLUBS);
//		o[4] = new Card("5", Card.Suit.DIAMONDS);
//
//		System.out.println(subtractArrays(o,small)[0]);
//
//
//	}

}
