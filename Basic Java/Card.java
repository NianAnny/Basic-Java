
/**
 * A Card program.
 *
 * @author Anny Cui
 * @version 2021.6.15
 */
public class Card implements Comparable<Card> {
    /**
     * Create constants of ranks(Ace, Jack, Queen, King)
     * for <code>Card</code>.
     * @since 2021.6.15
     */
    public static final int ACE = 1, JACK = 11, QUEEN = 12, KING = 13;
    
    /**
     * Create constants of suits
     * for <code>Card</code>
     * @since 2021.6.15
     */
    public static final int CLUBS = 0, DIAMONDS = 1, SPADES = 2, HEARTS = 3;
    
    /**
     * Create fields for <code>Card</code>.
     * @since 2021.6.15
     */
    private final int rank, suit;
    
     /**
     * Create a new <code>Card</code>, from its rank, and suit values.
     * @since 2021.6.15
     */
    public Card(int rank, int suit) {
        //checks values
        if(rank<ACE || rank>KING || suit<0 || suit>3) {
            throw new IllegalArgumentException("Can't make a card with rank" +rank+ " and suit" +suit+ "!");
        }
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * Get random cards of <code>this</code>
     * <code>Card</code>.
     * @return the random cards
     * @since 2021.6.15
     */
    public Card() {
        rank = (int)(Math.random() * 13) + 1;
        suit = (int)(Math.random() * 4);
    }
    
     /**
     * Build a <code>String</code> representing this <code>Card</code>, as
     * <code>[rank; suit]</code>.
     * @return the String <code>[rank; suit]</code>
     * @since 2021.6.15
     */
    @Override
    public String toString() {
        //build up String from its components, using mutable StringBuilder for efficiency
        //do rank
        StringBuilder description = new StringBuilder("");
        if(rank==KING) description.append("King");
        else if(rank==QUEEN) description.append("Queen");
        else if(rank==JACK) description.append("Jack");
        else if(rank==ACE) description.append("Ace");
        else description.append(rank);
        
        //do suit
        if(suit==CLUBS) description.append(" of Clubs");
        else if(suit==DIAMONDS) description.append(" of Diamonds");
        else if(suit==SPADES) description.append(" of Spades");
        else description.append(" of Hearts");
        
        //convert and return String
        return description.toString();
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
