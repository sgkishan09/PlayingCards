
public class game {

	private static int MIN_LIMIT = 1;
	private static int MAX_LIMIT = 13;
	private static int NO_OF_PLAYERS = 2;
	
	public ArrayList<Cards> removeDiamonds(ArrayList<Cards> c)
	{
		
	}
	
	public static void main(String[] args) {
		int noOfCards = MAX_LIMIT - MIN_LIMIT + 1;
		ArrayList<Hand> hands = new ArrayList<>();
	for(int player=1; player<=NO_OF_PLAYERS; player++) {
		Hand hand = new Hand(noOfCards);
 		for(int value=MIN_LIMIT; value<MAX_LIMIT; value++) {
			for(Suit suit : Suit.values()) {
				Card card = new Card(value, suit);
				hand.addCard(card);
			}
		}
 		hands.add(hand);
	}
	
	
	getDeck(ArrayList<Cards>)
	
}
