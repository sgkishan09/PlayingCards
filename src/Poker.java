class Poker extends Game {

	public Poker(int noOfCards, int joker) {
		deck = new Deck(0);
		hand = new Hand(deck,noOfCards);
		this.numberOfCards = noOfCards;
	}
	
	@Override
	void evaluate(Hand hand) {
		
		
	}
	
}