class Test {

    public static void main(String[] args) {
        Deck d = new Deck(1);
        d.shuffle();
        System.out.println(d.toString());
        Card currentCard = d.draw();
        Card[] hand = new Card[7];
        for (int i = 0; i < 7; i++) {
            hand[i] = d.draw();
        }

    }

}