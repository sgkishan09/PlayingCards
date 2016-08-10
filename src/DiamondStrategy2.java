import java.util.List;

/**
 * Created by sagar on 8/10/2016.
 */
public class DiamondStrategy2 extends DiamondStrategy {

    @Override
    public Card getNextMove(Card currentOpenCard, List<Card> hand) {
    	int returnIndex = 0;
    	for(int i = 0; i < hand.size(); i++)
    		if (currentOpenCard.getFaceValue() == hand.get(i).getFaceValue())
    			returnIndex = i;
    	return hand.get(returnIndex);
    }
}
   
