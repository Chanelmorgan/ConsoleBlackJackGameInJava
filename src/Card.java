public class Card {

    // Variables
    private Suit suit;
    private Value value;

    // Constructor
    public Card(Suit suit, Value value){
        this.value = value;
        this.suit = suit;
    }


    public String toString(){
        return this.suit.toString() + "-" + this.value.toString();
    }

    public Value getValue(){
        return this.value;
    }
}
