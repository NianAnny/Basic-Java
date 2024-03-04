// Your job is to fill in all the missing function bodies. Be sure to add your
// name to this file, and rename it!

/**
 * Vector is an object representing a mathematical 3-dimensional
 * vector. Objects like this are useful when doing 3D graphics, or physics
 * calculations.
 *
 * @author      Adam Smith
 * @version     1.0
 */

public class Vector {
    private double x, y, z;

    /** 
     * Create a new <code>Vector</code>, from its x, y, and z values.
     * @since 1.0
     */

    public Vector(double x, double y, double z) {
        this.x = x ;
        this.y = y ;
        this.z = z ;
    }

    /** 
     * Add a second <code>Vector</code> to <code>this</code>.
     * @param other the other <code>Vector</code> to add
     * @return the resulting <code>Vector</code>
     * @since 1.0
     */

    public Vector add(Vector other) {
        double addX = this.x + other.x ;
        double addY = this.y + other.y ; 
        double addZ = this.z + other.z ; 
        return new Vector(addX, addY, addZ);
    }

    /** 
     * Subtract a second <code>Vector</code> from <code>this</code>.
     * @param other the other <code>Vector</code> to subtract
     * @return the resulting <code>Vector</code>
     * @since 1.0
     */

    public Vector subtract(Vector other) {
        double subtractX = this.x - other.x ;
        double subtractY = this.y - other.y ; 
        double subtractZ = this.z - other.z ; 
        return new Vector(subtractX, subtractY, subtractZ);
    }

    /** 
     * Multiply <code>this</code> by a scalar value.
     * @param scalar the value by which to multiply
     * @return the resulting <code>Vector</code>
     * @since 1.0
     */

    public Vector multiply(double scalar) {
        double multiplyX = this.x*scalar ;
        double multiplyY = this.y*scalar ; 
        double multiplyZ = this.z*scalar ; 
        return new Vector(multiplyX, multiplyY, multiplyZ);
    }

    /** 
     * Calculate the cross product of <code>this</code> with another
     * <code>Vector</code>.
     * @param other the other <code>Vector</code>
     * @return the resulting <code>Vector</code>
     * @since 1.0
     */

    public Vector calcCrossProduct(Vector other) {
        double crossX = (this.y * other.z) - (other.y * this.z);
        double crossY = -((this.x * other.z) - (other.x * this.z));
        double crossZ = (this.x * other.y) - (other.x * this.y);
        return new Vector(crossX, crossY, crossZ) ; 
    }

    /** 
     * Calculate the dot product of <code>this</code> with another
     * <code>Vector</code>.
     * @param other the other <code>Vector</code>
     * @return the resulting dot product
     * @since 1.0
     */

    public double calcDotProduct(Vector other) {
        double dotProduct = (this.x*other.x + this.y*other.y + this.z*other.z) ;
        return dotProduct;
    }

    /** 
     * Calculate the length of <code>this</code>.
     * @return the length
     * @since 1.0
     */

    public double calcLength() {
        double length = Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z) ;
        return length;
    }

    /** 
     * Create a new <code>Vector</code> with the same proportions as
     * <code>this</code>, but with a length of exactly <code>1.0</code>.
     * @return the new normalized <code>Vector</code>
     * @since 1.0
     */

    public Vector makeNormalizedVector() {
        double length = this.calcLength() ; 
        double normalX = this.x/length ;
        double normalY= this.y/length ;
        double normalZ = this.z/length ;
        return new Vector( normalX, normalY, normalZ ) ;
    }

    /** 
     * Calculate the angle between <code>this</code> and a second
     * <code>Vector</code>.
     * @param other the other <code>Vector</code>
     * @return the angle (in radians)
     * @since 1.0
     */

    public double calcAngle(Vector other) {
        double thisLength = this.calcLength() ;
        double otherLength = other.calcLength() ; 
        double angle = Math.acos((this.x * other.x + this.y * other.y + this.z * other.z) / (thisLength * otherLength)) ;
        return angle;
    }

    /** 
     * Build a <code>String</code> representing this <code>Vector</code>, as
     * <code>[x,&nbsp;y,&nbsp;z]</code>.
     * @return the String <code>[x,&nbsp;y,&nbsp;z]</code>
     * @since 1.0
     */

    @Override
    public String toString() {
        return  ("(" + x + "," + y + "," + z + ")") ;
    }

    /** 
     * Return <code>true</code> if <code>this</code>
     * <code>Vector</code> is equivalent to another one; otherwise
     * false.
     * @param otherObject the other object (probably a <code>Vector</code>) to
     * compare with
     * @return the whether they are equivalent
     * @since 1.0
     */

    @Override
    public boolean equals(Object otherObject) {
        if(!(otherObject instanceof Vector)) return false ; 
        Vector other = (Vector)otherObject ; 
        return ((this.x == other.x) && (this.y == other.y) && (this.z == other.z)) ;
    }

    /** 
     * Accessor for the x coordinate.
     * @return the x coordinate
     * @since 1.0
     */

    public double getX() {
        return this.x;
    }

    /** 
     * Accessor for the y coordinate.
     * @return the y coordinate
     * @since 1.0
     */

    public double getY() {
        return this.y;
    }

    /** 
     * Accessor for the z coordinate.
     * @return the z coordinate
     * @since 1.0
     */

    public double getZ() {
        return this.z;
    }

    /** 
     * Mutator for the x coordinate.
     * @param newX the new x coordinate
     * @since 1.0
     */

    public void setX(double newX) {
        this.x = newX; 
    }

    /** 
     * Mutator for the y coordinate.
     * @param newY the new y coordinate
     * @since 1.0
     */

    public void setY(double newY) {
        this.y = newY ;
    }

    /** 
     * Mutator for the z coordinate.
     * @param newZ the new z coordinate
     * @since 1.0
     */

    public void setZ(double newZ) {
        this.z = newZ ;
    }
}