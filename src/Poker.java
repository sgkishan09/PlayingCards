class Poker extends Game {

	
	public Poker(int joker) {
		this.numberOfCards=5;
		deck = new Deck(1, false);
		deck.shuffle();
		hand = new Hand(deck,numberOfCards);
		this.numberOfCards = numberOfCards;
	}
	
	@Override
	void evaluate(Hand hand) {
		
		
	}
	
}