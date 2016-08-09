class Rummy extends Game {

	
	public Rummy(int joker) {
		this.numberOfCards=13;
		deck = new Deck(0);
		hand = new Hand(deck,numberOfCards);
		this.numberOfCards = numberOfCards;
	}
	
	@Override
	void evaluate(Hand hand) {
		CardUtils.sortCardsOnSuite(hand);
		
		
	}
	
}