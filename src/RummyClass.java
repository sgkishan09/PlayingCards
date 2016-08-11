import java.util.ArrayList;
import java.util.Arrays;
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
        int intArray[] = new int[origList.size() - subtractList.size()];
        for (Integer i : subtractList) {
            int k = 0;
            for (Integer j : origList) {
                if (i.equals(j)) {
                    break;
                }
                k++;

            }
            origList.remove(k);
        }
        return listToArray(origList);
    }

    static List<List<List<Integer>>> generateSplits(int arr[], int j, int split[]) {
        List<List<List<Integer>>> listOfpossibleSplits = new ArrayList<>();
        for (List<Integer> list : generateCombinations(arr, arr.length, split[j])) {
            int[] remainingCards = removeArray(arr, listToArray(list));
            if (j < split.length - 1) {
                for (List<List<Integer>> splitsInAHand : generateSplits(remainingCards, j + 1, split)) {
                    List<List<Integer>> local = new ArrayList<>();
                    local.add(list);
                    for (List<Integer> individualSplit : splitsInAHand)
                        local.add(individualSplit);
                    listOfpossibleSplits.add(local);
                }
            }
            break;
        }
        return listOfpossibleSplits;
    }

    public static void main(String[] args) {
        List<ArrayList<Hand>> listofList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int r = 4;
        int n = arr.length;
        List<Integer> split = Arrays.asList(new Integer[]{5, 4, 4});
        int s2[] = {4, 3, 3};
        System.out.println(generateSplits(arr, 0, listToArray(split)));
        RummyClass rummy = new RummyClass();
        Deck deck = new Deck(2, 2);
        Hand hand = new Hand(13);
        hand.addCards(deck.pick(13));
//        System.out.println(hand);
    }
}