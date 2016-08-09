
abstract class Game {
	protected Hand hand;
	protected Deck deck;
	protected int numberOfCards;
	/**
     * Returns the List of cards in hand
     *
     * @return List<Card>
     */
	abstract void evaluate(Hand hand);
}