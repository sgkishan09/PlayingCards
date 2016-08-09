import java.util.Collections;
import java.util.*;


public class CardUtils {

    public static boolean areSameColor(List<Card> cards) {
        Card.Colors firstCardColor = cards.get(0).getColor();
        for (Card card : cards) {
            if (!(card.getColor() == firstCardColor)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areSameSuite(List<Card> cards) {
        Card.Suites firstCardSuite = cards.get(0).getSuite();
        for (Card card : cards) {
            if (!(card.getSuite() == firstCardSuite)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areSequential(List<Card> cards) {
        List<Integer> values = getFaceValues(cards);
        Collections.sort(values);
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i + 1) - values.get(i) != 1)
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
