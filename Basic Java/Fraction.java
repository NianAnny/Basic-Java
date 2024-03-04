
/**
 * A program for Fraction Operations.
 *
 * @author Anny Cui
 * @version 2021.06.12
 */
public class Fraction {
    private int num, den;

    /** 
     * Create a new <code>Fraction</code>, from its numerator and denominator.
     * @since 1.0
     */

    public Fraction(int numerator, int denominator) {
        this.num = numerator;
        this.den = denominator;
        reduce();
    }

    /** 
     * Add a second <code>Fraction</code> to <code>this</code>.
     * @param other the other <code>Fraction</code> to add
     * @return the resulting <code>Fraction</code>
     * @since 1.0
     */

    public Fraction add(Fraction other) {
        int addNum = (this.num*other.den) + (other.num*this.den);
        int addDen = this.den*other.den;
        return new Fraction(addNum, addDen);
    }

    /** 
     * Subtract a second <code>Fraction</code> from <code>this</code>.
     * @param other the other <code>Fraction</code> to subtract
     * @return the resulting <code>Fraction</code>
     * @since 1.0
     */

    public Fraction subtract(Fraction other) {
        int subtractNum = (this.num*other.den) - (other.num*this.den);
        int subtractDen = this.den*other.den;
        return new Fraction(subtractNum, subtractDen);
    }

    /** 
     * Multiply a second <code>Fraction</code> by <code>this</code>.
     * @param other the other <code>Fraction</code> to multiply
     * @return the resulting <code>Fraction</code>
     * @since 1.0
     */

    public Fraction multiply(Fraction other) {
        int multiplyNum = this.num*other.num;
        int multiplyDen = this.den*other.den;
        return new Fraction(multiplyNum, multiplyDen);
    }

    /** 
     * Divide <code>this</code> by a second <code>Fraction</code>.
     * @param other the other <code>Fraction</code> by which to divide
     * @return the resulting <code>Fraction</code>
     * @since 1.0
     */

    public Fraction divide(Fraction other) {
        int divideNum = this.num*other.den;
        int divideDen = this.den*other.num;
        return new Fraction(divideNum, divideDen);
    }

    /** 
     * Calculate the <code>double</code> whose value best approximates
     * <code>this</code>'s value.
     * @return the approximate value
     * @since 1.0
     */

    public double toDouble() {
        return ((double)(this.num)/(double)(this.den));
    }

    /** 
     * Build a <code>String</code> representing this <code>Fraction</code>, as
     * <code>(numerator/denominator)</code>.
     * @return the String <code>(numerator/denominator)</code>
     * @since 1.0
     */

    @Override
    public String toString() {
        return "(" +num+ "/" +den+ ")";
    }

    /** 
     * Return <code>true</code> if <code>this</code> <code>Fraction</code> is
     * equivalent to another one; otherwise false.
     * @param otherObject the other object (probably a <code>Fraction</code>) to
     * compare with
     * @return the whether they are equivalent
     * @since 1.0
     */

    @Override
    public boolean equals(Object otherObject) {
        if(!(otherObject instanceof Fraction)) return false;
        Fraction other = (Fraction)otherObject;
        return ((this.num == other.num) && (this.den == other.den));
    }

    /** 
     * Accessor for the numerator.
     * @return the numerator
     * @since 1.0
     */

    public int getNumerator() {
        return this.num;
    }

    /** 
     * Accessor for the denominator.
     * @return the denominator
     * @since 1.0
     */

    public int getDenominator() {
        return this.den;
    }

    /** 
     * Mutator for the numerator.
     * @param newNumerator the new numerator
     * @since 1.0
     */

    public void setNumerator(int newNumerator) {
        this.num = newNumerator;
        reduce();
    }

    /** 
     * Mutator for the denominator.
     * @param newDenominator the new denominator
     * @since 1.0
     */

    public void setDenominator(int newDenominator) {
        this.den = newDenominator;
        reduce();
    }

    // helper function to calculate the Greatest Common Divisor
    private static int calcGCD(int int1, int int2) {
        int1 = Math.abs(int1);
        int2 = Math.abs(int2);
        for(int i=0; i<2; i++) {
            int max = int1;
            if(int2>max) {
                max = int1;
                int1 = int2;
                int2 = max;
            }
        }
        
        if(int2 == 0) return int1;
        
        int gcd = 0;
        while(int2 != 0) {
            if(int1%int2 == 0) return int2;
            else {
                gcd = int2;
                int2 = int1%int2;
                int1 = gcd;
            }
        }
        return gcd;
    }

    // helper method to reduce this Fraction
    // call this in the constructor and the setters to reduce
    private void reduce() {
        // will call calcGCD() somewhere in here
        int gcd = calcGCD(num, den);
        if(gcd != 0) {
            num /= gcd;
            den /= gcd;
        }
        
        if(den<0) {
            num = -num;
            den = -den;
        }
    }
}
