import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;

public class test {

    public static void main (String[] args) {

        Deck testDeck = new Deck();
        testDeck.printDeck();
        TheBoard testBoard = new TheBoard();


        Card testCard1 = new Card(1); // intentionally putting multiple Aces in one hand
        System.out.println(testCard1.getCardNumSuit());

        testBoard.placeCard(1,testCard1);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard2 = new Card(14);
        System.out.println(testCard2.getCardNumSuit()); // intentionally putting multiple Aces in one hand

        testBoard.placeCard(2,testCard2);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard3 = new Card(27); // intentionally putting multiple Aces in one hand
        System.out.println(testCard3.getCardNumSuit());

        testBoard.placeCard(3,testCard3);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard4 = new Card(40); //
        System.out.println(testCard4.getCardNumSuit());

        testBoard.placeCard(4,testCard4);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard5 = new Card(33); // intentionally setting number as 7 so that can test scoring mechanism of multiple Aces
        System.out.println(testCard5.getCardNumSuit());

        testBoard.placeCard(5,testCard5);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard6 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard6.getCardNumSuit());

        testBoard.placeCard(6,testCard6);
        testBoard.printTheBoard();
        testDeck.dealACard();


        Card testCard7 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard7.getCardNumSuit());

        testBoard.placeCard(7,testCard7);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard8 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard8.getCardNumSuit());

        testBoard.placeCard(8,testCard8);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard9 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard9.getCardNumSuit());

        testBoard.placeCard(9,testCard9);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard10 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard10.getCardNumSuit());

        testBoard.placeCard(10,testCard10);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard11 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard11.getCardNumSuit());

        testBoard.placeCard(11,testCard11);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard12 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard12.getCardNumSuit());

        testBoard.placeCard(12,testCard12);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard13 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard13.getCardNumSuit());

        testBoard.placeCard(13,testCard13);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard14 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard14.getCardNumSuit());

        testBoard.placeCard(14,testCard14);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard15 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard15.getCardNumSuit());

        testBoard.placeCard(15,testCard15);
        testBoard.printTheBoard();
        testDeck.dealACard();

        Card testCard16 = new Card(testDeck.getIndexOfCard(0));
        System.out.println(testCard16.getCardNumSuit());
        testDeck.dealACard();

        testBoard.placeCard(16,testCard16);
        testBoard.printTheBoard();
        System.out.println("card count is " + testBoard.getCardCount());
        System.out.print("the score is: ");
        Scores finalScore = new Scores(testBoard);
        System.out.println();

        testBoard.printTheTracker();
        System.out.println();
        //test score mechanism:
        int testHand1Point = finalScore.getPoint(finalScore.hand1Index);
        System.out.println(testHand1Point);
        int testHand2Point = finalScore.getPoint(finalScore.hand2Index);
        System.out.println(testHand2Point);
        int testHand3Point = finalScore.getPoint(finalScore.hand3Index);
        System.out.println(testHand3Point);
        int testHand4Point = finalScore.getPoint(finalScore.hand4Index);
        System.out.println(testHand4Point);
        int testHand5Point = finalScore.getPoint(finalScore.hand5Index);
        System.out.println(testHand5Point);
        int testHand6Point = finalScore.getPoint(finalScore.hand6Index);
        System.out.println(testHand6Point);
        int testHand7Point = finalScore.getPoint(finalScore.hand7Index);
        System.out.println(testHand7Point);
        int testHand8Point = finalScore.getPoint(finalScore.hand8Index);
        System.out.println(testHand8Point);
        int testHand9Point = finalScore.getPoint(finalScore.hand9Index);
        System.out.println(testHand9Point);



    }
}
