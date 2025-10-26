public class Card {
    private String numOfCard; //indicate number shown on the card
    private String suitOfCard;// indicate suit shown on the card
    private int cardValueMax; // indicate maximum value of this card
    private int cardValueMin; // indicate minimum value of this card
    private int indexOfCard; // each card is represented by a number between 1-52;
    private int xOfCard; // the x coordinate of this card on the board
    private int yOfCard; // the y coordinate of this card on the board

    public Card () {
        for (int i =1; i <= 52; i++){
            indexOfCard = i;

            if (i % 4 == 0){
                suitOfCard = "S";
            } else if (i % 4 == 1) {
                suitOfCard = "H";
            } else if (i % 4 == 2) {
                suitOfCard = "C";
            } else {
                suitOfCard = "D";
            }

            int remainder = i % 13;
            if (remainder == 0){
                numOfCard = "K";
                cardValueMax = 10;
                cardValueMin = 10;
            } else if (remainder == 11) {
                numOfCard = "J";
                cardValueMax = 10;
                cardValueMin = 10;
            } else if (remainder == 12) {
                numOfCard = "Q";
                cardValueMax = 10;
                cardValueMin = 10;
            } else if (remainder == 1) {
                numOfCard = "A";
                cardValueMax = 10;
                cardValueMin = 1;
            } else {
                numOfCard = String.valueOf(i);
                cardValueMax = i;
                cardValueMin = i;
            }
        }
    }

    public void cardLocation (int spotNum){
        int remainder = spotNum % 5;
        yOfCard = spotNum / 5;
        if (spotNum < 17) {
            if (spotNum <= 10){
                if (remainder != 0){
                    xOfCard = remainder - 1;
                } else {
                    xOfCard = yOfCard * 5 - 1;
                }
            } else {
                int newRemainder = spotNum - 10;
                if (newRemainder % 3 != 0){
                    xOfCard = newRemainder;
                } else {
                    xOfCard = 3;
                }
            }
            System.out.println("The card is placed on" + spotNum + "at (" + xOfCard +", " + yOfCard + ").");
        }
        // if spotNum is >= 17, the card will be placed in discard pile and won't be assigned a location on the board.
    }
}
