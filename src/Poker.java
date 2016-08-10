import java.util.*;

class Poker extends DiamondGame {


    public Poker(int jokersPerPack) {

        Deck deck = new Deck(1, jokersPerPack);
        deck.shuffle();
        Hand hand = new Hand(5);
    }

    public static enum WinCategory {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH,
        ROYAL_FLUSH;
    }

    int ACE_VALUE = 14;

    //@Override
    WinCategory evaluate(List<Card> bestFive) {
        List<Integer> faceValues = CardUtils.getFaceValues(bestFive);
        List<Card.Suit> suits2 = CardUtils.getSuitValues(bestFive);
        final WinCategory category;

        int distinctCount = CardUtils.distinctFaces(bestFive);
        if (distinctCount == 5) {

            boolean flush = CardUtils.areSameSuite(bestFive);

            TreeSet<Integer> sortedSet = new TreeSet<Integer>(faceValues);
            ArrayList<Integer> arry = new ArrayList<Integer>();
            arry.addAll(sortedSet);

            if (CardUtils.areSequential(bestFive)) {
                if (CardUtils.containsFace(bestFive, ACE_VALUE))
                    category = flush ? WinCategory.ROYAL_FLUSH : WinCategory.STRAIGHT;

                else category = flush ? WinCategory.STRAIGHT_FLUSH : WinCategory.STRAIGHT;

            }
            else {
                if (isTwoToFive(arry) && CardUtils.containsFace(bestFive, ACE_VALUE)) {
                    category = flush ? WinCategory.STRAIGHT_FLUSH : WinCategory.STRAIGHT;
                } else {
                    category = flush ? WinCategory.FLUSH : WinCategory.HIGH_CARD;
                }
            }
        } else if (distinctCount == 4) {
            category = WinCategory.ONE_PAIR;
        } else if (distinctCount == 3) {
            category = maxCommonElementSize(faceValues) == 2 ? WinCategory.TWO_PAIR : WinCategory.THREE_OF_A_KIND;
        } else category = maxCommonElementSize(faceValues) == 3 ? WinCategory.FULL_HOUSE : WinCategory.FOUR_OF_A_KIND;

        return category;

    }

    public int maxCommonElementSize(List<Integer> value) {
        int max = 0;
        int[] occurences = new int[15];
        for (int i = 0; i < value.size(); i++) {
            occurences[value.get(i)]++;
            if (occurences[value.get(i)] > max)
                max = occurences[value.get(i)];
        }
        return max;
    }


    public boolean isTwoToFive(ArrayList<Integer> sortedFaceValues) {
        return sortedFaceValues.get(0) == 2 && Math.abs(sortedFaceValues.get(0) - sortedFaceValues.get(sortedFaceValues.size() - 2)) == 3;
    }


}