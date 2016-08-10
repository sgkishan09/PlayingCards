import java.util.*;

public abstract class DiamondStrategy {
    List<Card> diamondsPlayed = null;
    List<Card> opponentsPlayed = null;

    public abstract Card getNextMove(Card currentOpenCard, List<Card> hand);

    public boolean addToDiamondsPlayed(Card currentCard) {
        return diamondsPlayed.add(currentCard);
    }

    public boolean addToOpponentsPlayed(Card currentCard) {
        return opponentsPlayed.add(currentCard);
    }


}
