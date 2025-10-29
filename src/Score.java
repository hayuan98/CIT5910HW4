import java.util.ArrayList;

public class Score {
    private int Score;

    public Score (TheBoard userBoard) {
        int[][] cardTracker = userBoard.getCardTracker();

        int currentCardIndex = 0;
        Score = 0;
        for (int i = 0; i < cardTracker.length; i++){
            ArrayList<Integer> handIndex = new ArrayList<Integer>();
            for (int j = 0; j < cardTracker[0].length; j++) {

                currentCardIndex = cardTracker[i][j];
                if (currentCardIndex != 0) {
                    handIndex.add(currentCardIndex);
                }

            }
            int handScore = getPoint(handIndex);
            Score = Score + handScore;
        }

        for (int j = 0; j < cardTracker[0].length; j++){
            ArrayList<Integer> handIndex = new ArrayList<Integer>();
            for (int i = 0; i < cardTracker.length; i++){

                currentCardIndex = cardTracker[i][j];
                if (currentCardIndex != 0) {
                    handIndex.add(currentCardIndex);
                }

            }
            int handScore = getPoint(handIndex);
            Score = Score + handScore;
        }


    }

    public int getScore() {
        return Score;
    }

    public int getPoint (ArrayList<Integer> handIndex) {
        int valueMax = 0;
        int valueMin = 0;
        int valueToUse = 0;
        int pointCounter = 0;
        int digitCount = 0;
        while(digitCount != handIndex.size()){
            for (int i = 0; i < handIndex.size(); i++){
                Card cardHolder = new Card(handIndex.get(i));
                valueMax = valueMax + cardHolder.getCardValueMax();
                valueMin = valueMin + cardHolder.getCardValueMin();
                digitCount++;
            }
            if (valueMax!= valueMin) {
                int difference = valueMax - valueMin; // if diff exists, it's caused by Ace card(s)
                int aceCount = difference / 10;  // to check how many Ace(s) are there in this hand
                for (int i = 0; i < aceCount; i++) { // count Ace as 1 instead of 11 to reduce valueMax
                    if (valueMax > 21) {
                        valueMax = valueMax - 10;
                        valueToUse = valueMax;
                    } else {
                        valueToUse = valueMax;
                    }
                }
            } else {
                valueToUse = valueMax;
            }
        }

        if (valueToUse > 21) {
            pointCounter = 0;
        } else if (valueToUse == 21) {
            if (handIndex.size() == 2){
                pointCounter = 10;
            } else {
                pointCounter = 7;
            }
        } else if (valueToUse == 20) {
            pointCounter = 5;
        } else if (valueToUse == 19) {
            pointCounter = 4;
        } else if (valueToUse == 18) {
            pointCounter = 3;
        } else if (valueToUse == 17) {
            pointCounter = 2;
        } else {
            pointCounter = 1;
        }
        return pointCounter;
    }
}
