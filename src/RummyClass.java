import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    static List<List<Integer>> combinationUtil(int arr[], int data[], int start,
                                               int end, int index, int r) {
        List<List<Integer>> out = new ArrayList<>();
        if (index == r) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < r; j++) {
                temp.add(data[j]);
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

    static List<List<Integer>> generateCombinations(int arr[], int n, int r) {
        int data[] = new int[r];
        return combinationUtil(arr, data, 0, n - 1, 0, r);
    }

    public static List<Integer> arrayToList(int intArray[]) {
        List<Integer> intList;
        intList = new ArrayList<Integer>();
        for (int intValue : intArray) {
            intList.add(intValue);
        }
        return intList;
    }

    public static int[] listToArray(List<Integer> list) {
        int intArray[] = new int[list.size()];
        for (int j = 0; j < list.size(); j++)
            intArray[j] = list.get(j);
        return intArray;
    }

    public static int[] removeArray(int original[], int subtract[]) {
        List<Integer> origList = arrayToList(original);
        List<Integer> subtractList = arrayToList(subtract);
        origList.removeAll(subtractList);
        return listToArray(origList);
    }

    static List<List<List<Integer>>> generateSplits(int arr[], int j, int split[]) {
        List<List<List<Integer>>> listOfpossibleSplits = new ArrayList<>();
        List<List<Integer>> combinations = generateCombinations(arr, arr.length, split[j]);
        for (List<Integer> split2 : combinations) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            temp.add(split2);
            if (j == split.length - 1)
                listOfpossibleSplits.add(temp);
            int[] remainingCards = removeArray(arr, listToArray(split2));
            if (j < split.length - 1) {
                for (List<List<Integer>> splitsInAHand : generateSplits(remainingCards, j + 1, split)) {
                    List<List<Integer>> listofSplits = new ArrayList<>();
                    listofSplits.add(split2);
                    for (List<Integer> individualSplit : splitsInAHand)
                        listofSplits.add(individualSplit);
                    listOfpossibleSplits.add(listofSplits);
                }
            }
        }
        return listOfpossibleSplits;
    }

    public static List<List<List<Integer>>> generateSplits(int arr[], int split[]) {
        return generateSplits(arr, 0, split);
    }

    public static Hand convertInttoHand(List<Integer> integerList) {
        Hand hand = new Hand(integerList.size());
        for (int cardHash : integerList)
            hand.addCard(new Card(cardHash));
        return hand;
    }

    public static List<Integer> convertHandtoInt(Hand hand) {
        List<Integer> integerList = new ArrayList<>();
        for (Card card : hand.getCards())
            integerList.add(card.hashCode());
        return integerList;
    }

    public static List<Hand> convertIntToHand(List<List<Integer>> listOfSplits) {
        List<Hand> handList = new ArrayList<>();
        for (List<Integer> integerList : listOfSplits)
            handList.add(convertInttoHand(integerList));
        return handList;
    }

    public static void main(String[] args) {
        RummyClass rummy = new RummyClass();
        Deck deck = new Deck(2, 2);
        Hand hand = new Hand(7);
        hand.addCards(deck.pick(7));
        System.out.println(hand);
        List<Integer> split = Arrays.asList(new Integer[]{4, 3});
        List<List<List<Integer>>> answer = generateSplits(listToArray(convertHandtoInt(hand)), listToArray(split));
        for (int i = 0; i < answer.size(); i++) {
            List<Hand> hands = convertIntToHand(answer.get(i));
            System.out.println(hands);
        }
    }
}
