import java.util.ArrayList;

public class TheBoard {
    private String[] [] TheBoard;

    public TheBoard () {
        TheBoard = new String[4][5];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                TheBoard[i][j] = " " + Integer.toString(i * 5 + j + 1) + " ";
            }
        }
        for (int i = 2; i < 3; i++) {
            for (int j = 1; j <4; j++) {
                TheBoard[i][j] = " " + Integer.toString(i * 5 + j) + " ";
            }
        }
        for (int i = 3; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                TheBoard[i][j] = " " + Integer.toString(i * 5 + j - 2) + " ";
            }
        }
    }

    public String getValue (int i, int j) {
        return TheBoard [i][j];
    }

    public void placeCard (int location, Card currentCard) {
        int i;
        int j;
        if (location <= 10) {
           i = location / 5;
           j = location % 5 - 1;
        } else if (location <= 13){
            i = location / 10 + 1;
            j = location % 10;
        } else {
            i = location / 10 + 2;
            j = location % 10 - 3;
        }
        String cardNumSuit = " " + currentCard.getNumOfCard() + currentCard.getSuitOfCard() + " ";
        String originalValue = " " + Integer.toString(location) + " ";
        String currentValue = TheBoard [i][j];
        if (currentValue.equals(originalValue)) {
            TheBoard[i][j] = cardNumSuit;
        } else {
            System.out.println("Unable to place two cards in the same spot. Please choose another spot.");
        }

    }
}
