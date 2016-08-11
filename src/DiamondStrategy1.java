import java.util.List;
import java.util.Random;

/**
 * Created by musinha on 8/10/2016.
 */
public class DiamondStrategy1 extends DiamondStrategy {

    Random rand = new Random();

    @Override
    public Card getNextMove(Card currentOpenCard, List<Card> hand) {
        hand = CardUtils.sortByFaceValues(hand);
        int indexOfOver7 = indexOfOver7(hand);
        if (currentOpenCard.getFaceValue() > 8)
            return hand.get(rand.nextInt(hand.size() - indexOfOver7) + indexOfOver7);
        else
            return hand.get(rand.nextInt(indexOfOver7));
    }

    Integer indexOfOver7(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getFaceValue() > 7)
                return i;
        }
        return cards.size();
    }
}
