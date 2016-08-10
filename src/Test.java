import java.util.*;

class Test {

    public static void main(String[] args) {
//        Deck d = new Deck(1, 0);
//        d.shuffle();
//        System.out.println(d.toString());
//        Card currentCard = d.draw();
//        Card[] hand = new Card[7];
//        for (int i = 0; i < 7; i++) {
//            hand[i] = d.draw();
//        }

        Poker pokerGame = new Poker(0);
        List<Card> bestFive = new ArrayList<>();
        bestFive.add(new Card("A", Card.Suit.SPADES));
        bestFive.add(new Card("A", Card.Suit.HEARTS));
        bestFive.add(new Card("A", Card.Suit.CLUBS));
        bestFive.add(new Card("A", Card.Suit.DIAMONDS));
        bestFive.add(new Card("10", Card.Suit.SPADES));
        System.out.println(pokerGame.evaluate(bestFive));

    }

}