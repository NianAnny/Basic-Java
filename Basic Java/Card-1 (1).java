
/**
 * A program for playing cards.
 *
 * @author Tristenne Cranford and Anny Cui
 * @version 2021.6.15
 */
import java.awt.*;
import java.awt.image.BufferedImage;
public class Card implements Comparable <Card> {
    //make constants for card ranks and suits
    public static final int ACE = 1, JACK = 11, QUEEN = 12, KING = 13;
    public static final int CLUBS = 0, DIAMONDS = 1, SPADES = 2, HEARTS = 3;
    
    //fields
    private final int rank, suit;
    private BufferedImage image;
    
    //shared calss variables
    private static BufferedImage[][] defaultImages;
    
    /**
     * Create a new <code>Card</code>, from its rank, suit, image values.
     * @since 2021.6.15
     */
    public Card(int rank, int suit, BufferedImage image) {
        //checks values
        if(rank<ACE || rank>KING || suit<0 || suit>3) {
            throw new IllegalArgumentException("Can't make a card with rank" +rank+ " and suit" +suit+ "!");
        }
        this.rank = rank;
        this.suit = suit;
        
        //set up image(default on null)
        if(image==null) this.image = defaultImages[suit][rank-1];
        else this.image = image;
    }
    
    /**
     * Create <code>Card</code>, from rank and suit values.
     * @since 2021.6.15
     */
    public Card(int rank, int suit) {
        this(rank, suit, null);
    }
    
    /**
     * Make <code>setDefaultImages()</code> for the defaut image.
     * @param cardImage <code>BufferedImage[][]</code>
     * @since 2021.6.15
     */
    public static void setDefaultImages(BufferedImage[][] cardImages) {
        if(cardImages.length != 4 || cardImages[0].length != 13) {
            throw new IllegalArgumentException("Sorry, this passed 2D array is a wrong size!");
        }
        
        //set the class variable
        defaultImages = cardImages;
    }
    
    /**
     * Draw cards from the image.
     * @param pen the pen to draw
     * @param x the x coordinate of the card
     * @param y the y corrdinate of the card
     * @since 2021.6.15
     */
    public void draw(Graphics2D pen, int x, int y) {
        pen.drawImage(image, null, x, y);
    }
    
     /**
     * Compare a second <code>Card</code> with <code>this</code>.
     * @param other the other <code>Card</code> to compare
     * @return the integer <code>Card</code>
     * @since 2021.6.15
     */
    @Override
    public int compareTo(Card other) {
        if(this.rank==other.rank) return (this.suit-other.suit);
        else return (this.rank-other.rank);
    }
    
    /** 
     * Accessor for the rank.
     * @return the rank
     * @since 2021.6.15
     */
    public int getRank() {
        return this.rank;
    }

    /** 
     * Accessor for the suit.
     * @return the suit
     * @since 2021.6.15
     */
    public int getSuit() {
        return this.suit;
    }
}