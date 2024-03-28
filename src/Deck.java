import java.util.ArrayList;
import java.util.Random;

public class Deck {

    // Instance vars
    private ArrayList<Card> cards;

    // Constructor
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void generateDeck() {
        //Generate Cards
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                // Add a new card to the deck
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public void shuffle(){
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        // Use Random -> to generate random numners
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();

        for(int i =0; i < originalSize; i++) {
            // Generate random index
            randomCardIndex =  random.nextInt((this.cards.size() - 1)+1);
            tempDeck.add(this.cards.get(randomCardIndex));
            // Remove from original deck
            this.cards.remove(randomCardIndex);
        }

        this.cards = tempDeck;
    }

    public String toString() {
        String cardListOutput = "";
        for (Card card : this.cards) {
            cardListOutput += "\n" + card.toString();
        }
        return cardListOutput;
    }

    public void removeCard(int i){
        this.cards.remove(i);
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    // Draws from the deck
    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }





}
