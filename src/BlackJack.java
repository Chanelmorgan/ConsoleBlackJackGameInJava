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


        // Game loop
        while(playerMoney > 0) {
            System.out.println("You have £" + playerMoney + ", how much would you like to bet?");
            double playerBet = userInput.nextDouble();
            if(playerBet > playerMoney) {
                System.out.println("You cannot bet more than you have. Please leave.");
                break;
            }

            // Start dealing
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            // Dealer gets two cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while(true) {
                System.out.println("Your hand: ");
                System.out.println(playerDeck.toString());
            }


        }
        System.out.println("GAME OVER! You are out of money. :(");

    }
}
