import java.util.ArrayList;

public class Card {
    private String numOfCard; //indicate number shown on the card
    private String suitOfCard;// indicate suit shown on the card
    private int cardValueMax; // indicate maximum value of this card
    private int cardValueMin; // indicate minimum value of this card
    private int indexOfCard; // each card is represented by a number between 1-52;
    private int xOfCard; // the x coordinate of this card on the board
    private int yOfCard; // the y coordinate of this card on the board
    private String cardNumSuit;

    // constructor:
    public Card (int y) {
        int cardIndexA = 0;
        int cardIndexB = 0;
        if (y % 4 == 0) {
            suitOfCard = "S";
        } else if (y % 4 == 1) {
            suitOfCard = "H";
        } else if (y % 4 == 2) {
            suitOfCard = "C";
        } else {
            suitOfCard = "D";
        }
        cardIndexA = y / 13;
        int remainder = y % 13;
        cardIndexB = remainder;
        if (remainder == 0) {
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
            cardValueMax = 11;
            cardValueMin = 1;
        } else {
            numOfCard = String.valueOf(remainder);
            cardValueMax = remainder;
            cardValueMin = remainder;
        }
        cardNumSuit = " " + numOfCard + suitOfCard + " ";

        indexOfCard = cardIndexA * 13 + cardIndexB;
    }


    // getters:
    public String getCardNumSuit() {
        return cardNumSuit;
    }

    public String getNumOfCard () {
        return numOfCard;
    }

    public String getSuitOfCard () {
        return suitOfCard;
    }

    public int getCardValueMax () {
        return cardValueMax;
    }

    public int getCardValueMin () {
        return cardValueMin;
    }

    public int getIndexOfCard () {
        return indexOfCard;
    }

    public int getxOfCard () {
        return xOfCard;
    }

    public int getyOfCard () {
        return yOfCard;
    }





    // to determine card location on the board:
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
