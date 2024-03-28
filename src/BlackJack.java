import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack!");

        // Create playing deck
        Deck playingDeck = new Deck();
        playingDeck.generateDeck();
        playingDeck.shuffle();

        // Create a deck for the player -> the cards the player has in hand
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        double playerMoney = 100.00;

        Scanner userInput = new Scanner(System.in);

    }
}
