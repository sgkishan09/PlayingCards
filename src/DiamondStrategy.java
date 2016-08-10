import java.util.*;

public abstract class DiamondStrategy {
    List<Card> diamondsPlayed = null;
    List<Card> opponentsPlayed = null;
    public abstract Card getNextMove(Card currentOpenCard, List<Card> hand);
}
