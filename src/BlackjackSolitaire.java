import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackjackSolitaire {
    private TheBoard userGameBoard;
    private Deck userGameDeck;
    private Scores userScore;

    public BlackjackSolitaire () {
        userGameDeck = new Deck();
        userGameBoard = new TheBoard();
        userScore= new Scores(userGameBoard);
    }

    public void play (){
        System.out.println("Welcome to the BlackJack Solitaire Game!");
        System.out.println("Getting the game ready...");
        while (userGameBoard.getCardCount()< 16) {
            Card currentCard = new Card(userGameDeck.getIndexOfCard(0));
            System.out.println("The current card is: " + currentCard.getCardNumSuit());
            System.out.println("Please enter a number between 1-16 to place the card. If you would like to " +
                                "discard the card, please enter a number between 17-20.");
            Scanner inputReader = new Scanner(System.in);
            if (inputReader.hasNextInt()) {
                int userLocation = inputReader.nextInt();
                userGameBoard.placeCard(userLocation, currentCard);
                System.out.println("The board is updated as following: ");
                userGameBoard.printTheBoard();
                if (userGameBoard.getErrorTracker() == 0) {
                    userGameDeck.dealACard();
                }
            } else {
                System.out.println("Invalid spot. If you would like to discard the card, please enter a number" +
                                    "between 17-20; otherwise please enter a number between 1-16.");
            }

        }

        System.out.print("You have finished the game! Your score is: ");
        userScore = new Scores(userGameBoard);
        System.out.print(". Congratulations!");
        System.out.println();
        userGameBoard.printTheTracker();
    }
}
