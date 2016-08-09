import java.util.Collections;
import java.util.*;


public class CardUtils {

    public static List<Card> removeJoker(List<Card> cards) {
        List<Card> retVal = new ArrayList<Card>();
        for (Card card : cards) {
            if (card.getSuite() != Card.Suites.JOKER)
                retVal.add(card);
        }
        return retVal;
    }

    public static boolean areSameColor(List<Card> cards) {
        cards = removeJoker(cards);
        Card.Colors firstCardColor = cards.get(0).getColor();
        for (Card card : cards) {
            if (!(card.getColor() == firstCardColor)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areSameSuite(List<Card> cards) {
        cards = removeJoker(cards);
        Card.Suites firstCardSuite = cards.get(0).getSuite();
        for (Card card : cards) {
            if (!(card.getSuite() == firstCardSuite)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areSequential(List<Card> cards) {
        int numOfJokers = 0;
        List<Integer> values = getFaceValues(cards);
        Collections.sort(values);
        if (values.get(0) == -1)
            numOfJokers++;
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i + 1) == -1)
                numOfJokers++;
            if (values.get(i + 1) - values.get(i) != 1)
                if(numOfJokers > 0)
                    numOfJokers--;
                else
                    return false;
        }
        return true;
    }

    public static List<Integer> getFaceValues(List<Card> cards) {
        List<Integer> values = new ArrayList<Integer>();
        for (Card card : cards) {
            values.add(card.getFaceValue());
        }
        return values;
    }
}
