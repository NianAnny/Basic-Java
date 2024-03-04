
/**
 * A card set program.
 *
 * @author Anny Cui
 * @version 2021.6.15
 */
import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class CardSet {
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
     * Make <code>draw()</code> to draw cards.
     * @param pen the pen to draw
     * @param x the x coordinate of the card
     * @param y the y corrdinate of the card
     * @since 2021.6.15
     */
    public void draw(Graphics2D pen, int x, int y) {
        for(int i=0; i<4; i++) {
            for(int j=Card.ACE; j<=Card.KING; j++) {
                Card card = new Card(j, i);
                card.draw(pen, x+x*13*i+x*j, y);
            }
        }
    }
    
    /**
     * Add cards to <code>CardSet</code>
     * @param card the other <code>Card</code> to add into.
     * @since 2021.6.15
     */
    public void add(Card card) {
        cardDeck.add(card);
    }
    
    /** 
     * Accessor for the cardSet.
     * @return the size
     * @since 2021.6.15
     */
    public int getSize() {
        return cardDeck.size();
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
    
    /**
     * Shuffle the cards
     * for <code>CardSet</code>.
     * @since 2021.6.15
     */
    public void shuffle() {
        Random number = new Random(51);
        int chosenCard = number.nextInt(51);
        for(int i=1; i<52; i++) {
            int cardNumber = i;
            i = chosenCard;
            chosenCard = cardNumber;
        }
    }
}