import java.util.ArrayList;
import java.util.Arrays;

public class TheBoard {
    private String[][] TheBoard;
    private int [][]  cardTracker;
    private int errorTracker;
    private int cardCount;

    public TheBoard () {
        TheBoard = new String[5][5];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                TheBoard[i][j] = " 0" + Integer.toString(i * 5 + j + 1) + " ";
                TheBoard [1][4] = " 10 ";
            }
        }
        for (int i = 2; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                TheBoard[i][j] = " " + Integer.toString(i * 5 + j) + " ";
            }
        }
        for (int i = 3; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                TheBoard[i][j] = " " + Integer.toString(i * 5 + j - 2) + " ";
            }
        }
        for (int i =4; i < 5; i++) {
            TheBoard[i][0] = "Discarded:";
            for (int j = 1; j < 5; j++){
                TheBoard[i][j] = " " + Integer.toString(i * 4 + j)+ " ";
            }
        }

        TheBoard[2][0] = "    ";
        TheBoard[3][0] = "    ";
        TheBoard[2][4] = "    ";
        TheBoard[3][4] = "    ";

        cardTracker = new int[4][5];
    }

    public void placeCard ( int currentLoc, Card currentCard){
        int i = 0;
        int j = 0;
        errorTracker = 0;
        String originalValue;
        if (currentLoc<10) {
            originalValue = " 0" + Integer.toString(currentLoc) + " ";
        } else {
            originalValue = " " + Integer.toString(currentLoc) + " ";
        }
        if (currentLoc <= 0 || currentLoc > 20) {
            System.out.println("Invalid spot. If you would like to discard the card, please enter a number " +
                    "between 17-20; otherwise please enter a number between 1-16.");
            errorTracker++;
        } else if (currentLoc <= 16) {
            if (currentLoc == 5 || currentLoc == 10){
                i = currentLoc / 5 - 1;
                j = 4;
            } else if (currentLoc < 10){
                i = currentLoc / 5;
                j = currentLoc % 5 - 1;
            } else if (currentLoc >=11 && currentLoc <=13) {
                i = 2;
                j = currentLoc - 10;
            } else if (currentLoc >= 14 && currentLoc <= 16) {
                i = 3;
                j = currentLoc - 13;
            }
            String currentValue = TheBoard[i][j];
            if (currentValue.equals(originalValue)) {
                TheBoard[i][j] = currentCard.getCardNumSuit();
                cardTracker[i][j] = currentCard.getIndexOfCard();
                cardCount++;
            } else {
                System.out.println("Unable to place two cards in the same spot. Please choose another spot.");
                errorTracker++;
            }
        } else {
            if (currentLoc == 17){
                i = 4;
                j = 1;
            } else if (currentLoc == 18) {
                i = 4;
                j = 2;
            } else if (currentLoc == 19) {
                i = 4;
                j = 3;
            } else {
                i = 4;
                j = 4;
            }
            String currentValue = TheBoard[i][j];
            if (currentValue.equals(originalValue)) {
                TheBoard[i][j] = currentCard.getCardNumSuit();
                int discardCount = 0;
                for (int x = 1; x < 5; x++){
                    String currentValuecheck = TheBoard[4][x];
                    String originalValuecheck = " " + Integer.toString(4 * 4 + x) + " ";
                    if (!currentValuecheck.equals(originalValuecheck)){
                        discardCount++;
                    }
                }
                int discardsRemaining = 4 - discardCount;
                System.out.println("Discards remaining: " + Integer.toString(discardsRemaining) +".");
            } else {
                System.out.println("Unable to place two cards in the same spot. Please choose another spot.");
                errorTracker++;
            }
        }

    }

    public void printTheBoard () {
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(TheBoard[i][j]);
            }
            System.out.println(TheBoard[i][4]);
        }
    }

    public void printTheTracker() {
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(cardTracker[i][j]+ " ");
            }
            System.out.println(cardTracker[i][4]);
        }
    }

    public int[][] getCardTracker () {
        return cardTracker;
    }

    public int getErrorTracker() {
        return errorTracker;
    }

    public int getCardCount() {
        return cardCount;
    }
}
