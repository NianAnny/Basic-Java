
/**
 * A card set program.
 *
 * @author Anny Cui
 * @version 2021.6.15
 */
import java.util.*;
public class CardSet {
    /**
     * Create a field for <code>CardSet</code>
     * @since 2021.6.15
     */
    private ArrayList<Card> cardDeck;
    
    /**
     * Create a new <code>CardSet</code>, from its ArrayList<Card> and size values.
     * @since 2021.6.15
     */
    public CardSet() {
        this.cardDeck = new ArrayList<Card>();
    }
    
     /**
     * Build a <code>String</code> representing this <code>CardSet</code>, as
     * <code>(rank of suit)</code>.
     * @return the String <code>(rank of suit)</code>
     * @since 2021.6.15
     */
    @Override
    public String toString() {
        return cardDeck.toString();
    }
    
    /**
     * Add cards to <code>CardSet</code>
     * @param card the other <code>Card</code> to add into.
     * @return the resultiong <code>CardSet</code>
     * @since 2021.6.15
     */
    public void add(Card card) {
        this.cardDeck.add(card);
    }
    
    /**
     * Remove cards from <code>CardSet</code>
     * @param wichCard the other <code>Card</code> to discard.
     * @return the resulting <code>CardSet</code>
     * @since 2021.6.15
     */
    public Card discard(int whichCard) {
        return this.cardDeck.remove(whichCard);
    }
    
    /** 
     * Accessor for the cardSet.
     * @return the size
     * @since 2021.6.15
     */
    public int getSize() {
        return this.cardDeck.size();
    }
    
    /**
     * Shuffle the cards
     * for <code>CardSet</code>.
     * @return the resulting <code>CardSet</code>
     * @since 2021.6.15
     */
    public void shuffle() {
        Collections.shuffle(this.cardDeck);
    }
    
    /**
     * Make a <code>CardSet</code> for a standard deck
     * @return <code>CardSet</code>
     * @since 2021.6.15
     */
    public static CardSet makeStandardDeck() {
        CardSet standardDeck = new CardSet();
        for(int j=Card.CLUBS; j<=Card.HEARTS; j++) {
            for(int i=Card.ACE; i<=Card.KING; i++) {
                standardDeck.add(new Card(i, j));
            }
        }
        return standardDeck;
    }
    
    ///////////////////////////////////////////////////
    //CODE FOR TEST
    ///////////////////////////////////////////////////
    
    public static void main(String[] args) {
        // make a new set of cards
        CardSet hand = new CardSet();
        System.out.println("Empty hand is: " +hand);

        // add 2 random Cards, and 3 specified ones
        hand.add(new Card());
        hand.add(new Card());
        hand.add(new Card(10, Card.SPADES));
        hand.add(new Card(Card.QUEEN, Card.DIAMONDS));
        hand.add(new Card(2, Card.CLUBS));

        System.out.println("Hand of size " +hand.getSize()+ ": " +hand);

        // remove the first and last ones
        Card discard1 = hand.discard(0);
        Card discard2 = hand.discard(3);
        System.out.println("Discarded the " +discard1+ " and the " +discard2+ ".");

        System.out.println("Hand of size " +hand.getSize()+ ": " +hand);

        // test shuffling
        hand.shuffle();
        System.out.println("Same hand, shuffled: " +hand);

        // make a standard deck
        CardSet deck = CardSet.makeStandardDeck();
        System.out.println("\nHere's a full deck:");
        System.out.println(deck);
    }
}