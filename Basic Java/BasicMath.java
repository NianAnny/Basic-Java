
/**
 * A basic math program.
 *
 * @author Anny Cui
 * @version 2021.05.18
 */
public class BasicMath  {
    public static void main(String[] args) {
        
        // Values of a photograph (a rectangle)
        int photoBase = 10;
        int photoHeight = 5;
        System.out.println("Sides' values of a photograph are of length " + photoBase + " cm and "+ photoHeight + " cm.");
        
        //The difference between a longer side and a short one of the photograph
        int sideDifference = photoBase - photoHeight;
        System.out.println("The base side of this photograph is " + sideDifference + " longer than the height side.");
        
        // Total perimeter of the photograph
        int photoPerimeter = photoBase * 2 + photoHeight * 2;
        System.out.println("The perimeter of this photograph is " + photoPerimeter + " cm.");
        
        // Area of the rectangle (base*height)
        int photoArea = photoBase * photoHeight;
        System.out.println("The area of the photograph is " + photoArea + " square cm.");
        
        // The ratio of the base and the height of this photography
        int ratio = photoBase / photoHeight;
        System.out.println("The ratio of the base to the height of this photograph is " + ratio + ".");
        
        // Values of a pizza (a circle)
        double pizzaDiameter = 8.2;
        double pizzaRadius = pizzaDiameter / 2; // Radius is half of the diameter
        System.out.println("The diameter of a pizza is " + pizzaDiameter + " inches and the radius of it is " + pizzaRadius + " inches.");
        
        // Perimeter of the pizza (pi*diameter)
        double pizzaPerimeter = Math.PI * pizzaDiameter;
        System.out.println("The perimeter of this pizza is " + pizzaPerimeter + " inches.");
        
        // Area of the pizza (pi*r^2)
        double pizzaArea = Math.PI * pizzaRadius * pizzaRadius;
        System.out.println("The area of the pizza is " + pizzaArea + " square inches.");
        
        // Perimeter of a quarter pizza
        double pizzaQuarter = pizzaDiameter + pizzaPerimeter / 4; // perimeter of a quarter circle (2 radius or diameter and 1/4 perimeter of the whole circle)
        System.out.println("The perimeter of a slice is " + pizzaQuarter + " inches when the pizza is divided into quarters.");
        
        // The difference between perimeter of a circle and that of a quarter
        double perimeterDifference = pizzaPerimeter - pizzaQuarter;
        System.out.println("The perimeter of the whole pizza is " + perimeterDifference + " longer than that of a quarter pizza after cuutting.");
        
        // Party activities
        boolean takePhotograph = true; // People will take the photograph in the party
        boolean takePizza = false; // People won't eat a pizza in the party
        boolean takeCake = ! takePizza; // People will eat a cake in the party
        boolean isParty = (takePhotograph || takeCake) && ! takePizza; // People will take the photograph or eat a cake, but won't eat pizza in the party
        System.out.println("People will eat a cake in the party is " + takeCake + ".");
        System.out.println("People will take the photograph or eat a cake but won't eat a pizza in the party is " + isParty + ".");
    }
}
