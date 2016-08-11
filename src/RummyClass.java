import java.util.ArrayList;
import java.util.List;

/**
 * Created by gkishan on 8/10/2016.
 */
public class RummyClass {
    Card OpenJoker;
    Hand hand;

    public RummyClass() {
        OpenJoker = new Card("A", Card.Suit.SPADES);
    }

    static List<String> combinationUtil(int arr[], int data[], int start,
                                        int end, int index, int r) {
        List<String> out = new ArrayList<String>();
        if (index == r) {
            String temp = "";
            for (int j = 0; j < r; j++) {
                temp = temp + " " + data[j];
            }
            out.add(temp);
            return out;
        }
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            out.addAll(combinationUtil(arr, data, i + 1, end, index + 1, r));
        }
        return out;
    }

    static List<String> generateCombinations(int arr[], int n, int r) {
        int data[] = new int[r];
        return combinationUtil(arr, data, 0, n - 1, 0, r);
    }
    static List<List<String>> generateSplits(int arr[],int split[])
    {
        for(int i=0;i<split.length;i++) {
            System.out.println(generateCombinations(arr, arr.length, split[i]));
        }
        return null;
    }
    public static void main(String[] args) {
        List<ArrayList<Hand>> listofList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        int arr[] = {1, 2, 3, 4, 5, 6};
        int r = 4;
        int n = arr.length;
        RummyClass rummy = new RummyClass();
        Deck deck = new Deck(2, 2);
        Hand hand = new Hand(13);
        hand.addCards(deck.pick(13));
        System.out.println(hand);
    }
}
