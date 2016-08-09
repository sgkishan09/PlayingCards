
abstract class Game {
	protected Hand hand;
	protected Deck deck;
	
	/**
     * Returns the List of cards in hand
     *
     * @return List<Card>
     */
	abstract void evaluate(Hand hand);
}