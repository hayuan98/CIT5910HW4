public class ScoresObsolete {
    private int Score;
    int[] hand1Index = new int[5];
    int[] hand2Index = new int[5];
    int[] hand3Index = new int[3];
    int[] hand4Index = new int[3];
    int[] hand5Index = new int[2];
    int[] hand6Index = new int[4];
    int[] hand7Index = new int[4];
    int[] hand8Index = new int[4];
    int[] hand9Index = new int[2];

    public ScoresObsolete(TheBoard userBoard) {
        int[][] cardTracker = userBoard.getCardTracker();

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 5; j++) {
                hand1Index[j] = cardTracker[i][j];
            }
        }
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                hand2Index[j] = cardTracker[i][j];
            }
        }

        for (int i = 2; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                hand3Index[j-1] = cardTracker[i][j];
            }
        }

        for (int i = 3; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                hand4Index[j-1] = cardTracker[i][j];
            }
        }

        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < 2; i++) {
                hand5Index[i] = cardTracker[i][j];
            }
        }

        for (int j = 1; j < 2; j++) {
            for (int i = 0; i < 4; i++) {
                hand6Index[i] = cardTracker[i][j];
            }
        }

        for (int j = 2; j < 3; j++) {
            for (int i = 0; i < 4; i++) {
                hand7Index[i] = cardTracker[i][j];
            }
        }

        for (int j = 3; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                hand8Index[i] = cardTracker[i][j];
            }
        }

        for (int j = 4; j < 5; j++) {
            for (int i = 0; i < 2; i++) {
                hand9Index[i] = cardTracker[i][j];
            }
        }

        Score = getPoint(hand1Index) + getPoint(hand2Index) + getPoint(hand3Index)
                + getPoint(hand4Index) + getPoint(hand5Index) + getPoint(hand6Index)
                + getPoint(hand7Index) + getPoint(hand8Index) + getPoint(hand9Index);
    }

    public int getScore() {
        return Score;
    }

    public int[] getHand1Index() {
        return hand1Index;
    }

    public int[] getHand2Index() {
        return hand1Index;
    }
    public int[] getHand3Index() {
        return hand1Index;
    }
    public int[] getHand4Index() {
        return hand1Index;
    }
    public int[] getHand5Index() {
        return hand1Index;
    }
    public int[] getHand6Index() {
        return hand1Index;
    }
    public int[] getHand7Index() {
        return hand1Index;
    }
    public int[] getHand8Index() {
        return hand1Index;
    }
    public int[] getHand9Index() {
        return hand1Index;
    }


    public int getPoint (int[] handIndex) {
        int valueMax = 0;
        int valueMin = 0;
        int valueToUse = 0;
        int pointCounter = 0;
        int digitCount = 0;
        while(digitCount != handIndex.length){
            for (int i = 0; i < handIndex.length; i++){
                Card cardHolder = new Card(handIndex[i]);
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
            if (handIndex.length == 2){
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
