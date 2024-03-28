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
            if (playerBet > playerMoney) {
                System.out.println("You cannot bet more than you have. Please leave.");
                break;
            }

            boolean endRound = false;

            // Start dealing
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            // Dealer gets two cards
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            while (true) {
                System.out.println("Your hand: ");
                System.out.println(playerDeck.toString());
                System.out.println("Your deck is valued at: " + playerDeck.cardsValue());

                // Display dealer hand
                System.out.println("Dealer Hnad: " + dealerDeck.getCard(0).toString() + " and [Hidden]");

                // Hit or Stand
                System.out.println("Would you like to (1) Hit or \n (2) Stand?");
                int response = userInput.nextInt();

                if (response == 1) {
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a : " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                    // Bust if > 21
                    if(playerDeck.cardsValue() > 21 ) {
                        System.out.println("BUST!. Currently valued at: " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                if(response == 2) {
                    break;
                }
            }

            // Reveal dealers cards
            System.out.println("Dealers Cards: " + dealerDeck.toString());
            if(dealerDeck.cardsValue() > playerDeck.cardsValue() && !endRound) {
                System.out.println("Dealer beats you!");
                playerMoney -= playerBet;
                endRound = true;
            }

            // Dealer draws at 16, stand at 17
            while(dealerDeck.cardsValue() < 17 && !endRound) {
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());

            }

            // Display total value for dealer
            System.out.println("Dealer's hand is valued at: " + dealerDeck.cardsValue());

            if(dealerDeck.cardsValue() > 21 && !endRound){
                System.out.println("Dealer busts! You win.");
                playerMoney += playerBet;
                endRound = true;
            }

            if(playerDeck.cardsValue() == dealerDeck.cardsValue() && !endRound){
                System.out.println("Push ( tie )");
                endRound = true;
            }

            if(playerDeck.cardsValue() > dealerDeck.cardsValue() && !endRound){
                System.out.println("You win the hand!");
                playerMoney += playerBet;
                endRound = true;
            }


        }
        System.out.println("GAME OVER! You are out of money. :(");


    }
}
