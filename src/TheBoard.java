import java.util.ArrayList;

public class TheBoard {
    private String[] [] TheBoard;

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
    }

    public String getValue (int location) {
        int a;
        int b;
        if (location < 0 || location > 20) {
            String invalidInputMessage= "Invalid spot. If you would like to discard the card, please enter a number between 17-20; otherwise please enter a number between 1-16.";
            return invalidInputMessage;
        } else if (location <= 16) {
            if (location <= 10) {
                a = location / 6;
                b = location % 6 - 1;
            } else if (location <= 13) {
                a = location / 10 + 1;
                b = location % 10;
            } else {
                a = location / 10 + 2;
                b = location % 10 - 3;
            }
            return TheBoard[a][b];
        } else {
            int discardCount = 0;
            for (int i = 1; i < 5; i++){
                String currentValue = TheBoard[4][i];
                String originalValue = " " + Integer.toString(4 * 4 + i) + " ";
                if (!currentValue.equals(originalValue)){
                    discardCount++;
                }
            }
            int discardsRemaining = 4 - discardCount;
            return "Discards remaining: " + Integer.toString(discardsRemaining) +".";
        }
    }

    public void placeCard ( int currentLoc, Card currentCard){
        int i = 0;
        int j = 0;
        String cardNumSuit = " " + currentCard.getNumOfCard() + currentCard.getSuitOfCard() + " ";
        String originalValue;
        if (currentLoc<10) {
            originalValue = " 0" + Integer.toString(currentLoc) + " ";
        } else {
            originalValue = " " + Integer.toString(currentLoc) + " ";
        }
        if (currentLoc < 0 || currentLoc > 20) {
            System.out.println("Invalid spot. If you would like to discard the card, please enter a number between 17-20; otherwise please enter a number between 1-16.");
        } else if (currentLoc <= 16) {
            if (currentLoc <= 10) {
                i = currentLoc / 6;
                j = currentLoc % 6 - 1;
            } else if (currentLoc <= 13) {
                i = currentLoc / 10 + 1;
                j = currentLoc % 10;
            } else {
                i = currentLoc / 10 + 2;
                j = currentLoc % 10 - 3;
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
        }
        String currentValue = TheBoard[i][j];
        if (currentValue.equals(originalValue)) {
            TheBoard[i][j] = cardNumSuit;
        } else {
            System.out.println("Unable to place two cards in the same spot. Please choose another spot.");
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
}
