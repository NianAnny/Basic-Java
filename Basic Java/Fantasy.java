
/**
 * Fantasy Game Program for the map.
 *
 * @author Anny Cui
 * @version 2021.06.17
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
public class Fantasy {
    
    private static final String IMAGE_FILE_NAME = "wizard.png";
    private static final String FILE_NAME = "terrain.png";

    public static void main(String[] argw) {
        String title = "Fantasy Game!";
        final int TILE_SIZE = 64;
        final int MAP_SIZE = 11;
        final int WIDTH = MAP_SIZE*TILE_SIZE;
        final int HEIGHT = MAP_SIZE*TILE_SIZE;
        int x = 50;
        int y = 50;
        GraphicsWindow window = new GraphicsWindow(title, WIDTH, HEIGHT, x, y);
        
        //set up the pen
        Graphics2D pen = window.getPen();
        
        //print terrain
        BufferedImage[] terrains = GraphicsWindow.loadImageAsTiles(FILE_NAME, TILE_SIZE);
        
        int pieces = (MAP_SIZE*MAP_SIZE)/terrains.length;
        int locationX = 0;
        int locationY = 0;
        
        for(int i=0; i<MAP_SIZE*MAP_SIZE; i++) {
            for(int j=0; j<terrains.length; j++) {
                for(int k=0; k<pieces; k++) {
                    locationX = (int)(Math.random()*MAP_SIZE)*TILE_SIZE;
                    locationY = (int)(Math.random()*MAP_SIZE)*TILE_SIZE; 
                    pen.drawImage(terrains[j], null, locationX, locationY);
                }
            }
        }
        
        //print the character wizard in the center
        BufferedImage wizard = GraphicsWindow.loadImage(IMAGE_FILE_NAME);
        pen.drawImage(wizard, null, TILE_SIZE*(MAP_SIZE/2), TILE_SIZE*(MAP_SIZE/2));
        
        //finish up
        window.finalize();
    }
}
