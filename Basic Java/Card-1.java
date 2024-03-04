
/**
 * A program for playing cards.
 *
 * @author Tristenne Cranford and Anny Cui
 * @version 2021.6.15
 */
public class Card implements Comparable <Card> {
    //make constants for card ranks and suits
    public static final int ACE = 1, JACK = 11, QUEEN = 12, KING = 13;
    public static final int CLUBS = 0, DIAMONDS = 1, SPADES = 2, HEARTS = 3;
    
    //fields
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
        StringBuilder description = new StringBuilder("[");
        if(rank==KING) description.append("King");
        else if(rank==QUEEN) description.append("Queen");
        else if(rank==JACK) description.append("Jack");
        else if(rank==ACE) description.append("Ace");
        else description.append(rank);
        
        //do suit
        if(suit==CLUBS) description.append(" of clubs]");
        else if(suit==DIAMONDS) description.append(" of diamonds]");
        else if(suit==SPADES) description.append(" of spades]");
        else description.append(" of hearts]");
        
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
     * Return <code>true</code> iff <code>this</code>
     * <code>Card</code> is equivalent to another one; otherwise false,
     * @param otherObject the other object (probably a <code>Card</code>) to compare with
     * @return the whether they are equivalent
     * @since 2021.6.15
     */
    @Override
    public boolean equals(Object otherObject) {
        if(!(otherObject instanceof Card)) return false;
        Card other = (Card)otherObject; 
        return ((this.rank==other.rank) && (this.suit==other.suit));
    }
    
    /**
     * Return <code>true</code> iff <code>this</code>
     * <code>Card</code> is equivalent to another rank; otherwise false.
     * @param other the other rank
     * @return the whether they are equivalent
     * @since 2021.6.15
     */
    public boolean hasSameRank(Card other) {
        return (this.rank==other.rank);
    }
    
    /**
     * Return <code>true</code> iff <code>this</code>
     * <code>Card</code> is equivalent to another suit; otherwise false.
     * @param other the other suit
     * @return the whether they are equivalent
     * @since 2021.6.15
     */
    public boolean hasSameSuit(Card other) {
        return (this.suit==other.suit);
    }
    
    /**
     * Return <code>true</code> iff <code>this</code>
     * <code>Card</code> is greater than another one; otherwise false.
     * @param other the other <code>Card</code>
     * @return the whether is greater
     * @since 2021.6.15
     */
    public boolean hasGreaterRank(Card other) {
        return (this.rank>other.rank);
    }
    
    /**
     * Return <code>true</code> iff <code>this</code>
     * <code>Card</code> is lesser than another one; otherwise false.
     * @param other the other <code>Card</code>
     * @return the whether is lesser
     * @since 2021.6.15
     */
    public boolean hasLesserRank(Card other) {
        return (this.rank<other.rank);
    }
    
    /**
     * Return <code>true</code> iff <code>this</code>
     * <code>Card</code> is face card (jack, queen, or king).
     * @return the whether is face card
     * @since 2021.6.15
     */
    public boolean isFaceCard() {
        return (rank==JACK || rank==QUEEN || rank==KING);
    }
    
    /**
     * Return <code>true</code> iff <code>this</code>
     * <code>Card</code> is red (hearts or diamonds).
     * @return the whether is red
     * @since 2021.6.15
     */
    public boolean isRed() {
        return (suit==HEARTS || suit==DIAMONDS);
    }
    
    /**
     * Return <code>true</code> iff <code>this</code>
     * <code>Card</code> is black (spades or clubs).
     * @return the whether is black
     * @since 2021.6.15
     */
    public boolean isBlack() {
        return (suit==SPADES || suit==CLUBS);
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
    
    ///////////////////////////////////////////////////////////////////
    //THE FOLLOWING CODE ARE FOR TEST 
    ///////////////////////////////////////////////////////////////////
    
    public static void main(String[] args) {
        Card myCard, randomCard;
        
        myCard = new Card();
        randomCard = new Card();
        
        System.out.println("My card is " +myCard+ "\t" + "Random card is " +randomCard);
        System.out.println();
        
        checkCard(myCard);
        checkCard(randomCard);
        System.out.println("Are those 2 cards equal? " +myCard.equals(randomCard));
        System.out.println("Are they has the same rank? " +myCard.hasSameRank(randomCard));
        System.out.println("My card has rank" +myCard.getRank()+ " and random card has rank" +randomCard.getRank()+".");
        System.out.println("Are they has the same suit? " +myCard.hasSameSuit(randomCard));
        System.out.println("My card is " + gainSuit(myCard) + " and random card is " + gainSuit(randomCard)+".");
        System.out.println("Is my card has a greater rank than the random one? " +myCard.hasGreaterRank(randomCard));
        System.out.println("Is my card lesser than the random one? " +myCard.hasLesserRank(randomCard));
    }
    
    private static void checkCard(Card card) {
        System.out.println("Is " +card+ " a face card? " +card.isFaceCard());
        System.out.println("Is " +card+ " a red card? " +card.isRed());
        System.out.println("Is " +card+ " a black card? " +card.isBlack());
    }
    
    private static String gainSuit(Card card) {
        if(card.getSuit()==CLUBS) return "club";
        else if(card.getSuit()==DIAMONDS) return "diamond";
        else if(card.getSuit()==SPADES) return "spade";
        else if(card.getSuit()==HEARTS) return "heart";
        else return null;
    }
}

