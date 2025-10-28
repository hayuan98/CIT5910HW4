import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Integer> standardDeck;

    public Deck () {
        standardDeck = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            standardDeck.add(i + 1);
        }
        Collections.shuffle(standardDeck);

    }

    public int getIndexOfCard (int i) { // for any given index in Deck, find what's the integer
                                        // stored at that index. will use that integer to find the corresponding
                                        // card since each card is assigned an index number.
        return standardDeck.get(i);
    }

    public void dealACard () {
        standardDeck.remove(0);
    }

    public void printDeck () {
        System.out.println(standardDeck);
    }

}
