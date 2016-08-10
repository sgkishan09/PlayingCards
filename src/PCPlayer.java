import java.util.*;

/**
 * Created by musinha on 8/10/2016.
 */
public class PCPlayer {

    DiamondStrategy playingStrategy;
    List<Card> hand;

    PCPlayer(DiamondStrategy currentStrategy, List<Card> playerCards){
        playingStrategy = currentStrategy;
        hand = playerCards;
    }    
    public Card getNextMove(Card currentOpenCard){
    	return playingStrategy.getNextMove(currentOpenCard, this.hand);
    }
    
}
