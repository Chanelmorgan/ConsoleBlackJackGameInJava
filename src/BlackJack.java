
public class BlackJack {

    public static void main(String[] args) {
        System.out.println("Welcome to BlackJack!");

        // Create our playing deck
        Deck playingDeck = new Deck();
        playingDeck.generateDeck();
        playingDeck.shuffle();
        System.out.println(playingDeck);
    }
}
