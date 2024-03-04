
/**
 * Display an overhead map for a role-playing video game, showing a wizard in a fantasy world.
 *
 * @author Tristenne Cranford
 * @version 2021.06.22
 */
import java.awt.*;
import java.awt.image.BufferedImage;
public class Checkers
{
    //tile size, window size, and window title
    private static final int NUM_TILES_IN_ROW_AND_COLUMN = 8;
    private static final int WINDOW_SIZE = 640;
    private static final int TILE_SIZE = WINDOW_SIZE  /NUM_TILES_IN_ROW_AND_COLUMN;
    private static final String WINDOW_TITLE = "Checkers";
    /**
     * Draw a checkerboard onto the window.
     * @param pen the pen to draw the tiles
     * @param lastTileInRow the coordinates of the last tile in the row.
     * @since 2021.06.22
     */
    private static void drawBoard(Graphics pen, int lastTileInRow) {
        //make tile colors
        Color myGray = new Color(100, 100, 100);
        Color myRed = new Color(130, 20, 24);
        
        //print rows that begin with red tiles
        for (int y = 0; y <= lastTileInRow; y += TILE_SIZE * 2) {
            //red tiles (1,3,5,7)
            for (int x = 0; x <= lastTileInRow; x += TILE_SIZE * 2) {
                pen.setColor(myRed);
                pen.fillRect(x, y, TILE_SIZE, TILE_SIZE);
            }
            //gray tiles (2,4,6,8)
            for (int x = TILE_SIZE; x <= lastTileInRow; x += TILE_SIZE * 2) {
                pen.setColor(myGray);
                pen.fillRect(x, y, TILE_SIZE, TILE_SIZE);
            }
        }
        
        //print rows that begin with gray tiles
        for (int y = TILE_SIZE; y <= lastTileInRow; y += TILE_SIZE * 2) {
            //gray tiles
            for (int x = 0; x <= lastTileInRow; x += TILE_SIZE * 2) {
                pen.setColor(myGray);
                pen.fillRect(x, y, TILE_SIZE, TILE_SIZE);
            }
            //red tiles
            for (int x = TILE_SIZE; x <= lastTileInRow; x += TILE_SIZE * 2) {
                pen.setColor(myRed);
                pen.fillRect(x, y, TILE_SIZE, TILE_SIZE);
            }
        }
    }
    /**
     * Draw a checker piece onto the window.
     * @param pen the pen to draw the tiles
     * @param x the x coordinate where the piece would be drawn on a tile
     * @param y the y coordinate where the piece would be drawn on a tile
     * @param color the color of the piece
     * @param xTileSizes the tile number on the x axis that the piece will be drawn on
     * @param yTileSizes the tile number on the y axis that the piece will be drawn on
     * @since 2021.06.22
     */
    private static void drawChecker(Graphics pen, int x, int y, Color color, int xTileSizes, int yTileSizes) {
        //create solid part of piece
        pen.setColor(color);
        pen.fillOval((TILE_SIZE * xTileSizes) + x, (TILE_SIZE * yTileSizes) + y, (TILE_SIZE/4) * 3, (TILE_SIZE/4) * 3);
        
        //create outline and inner circle of pieces
        pen.setColor(Color.BLACK);
        pen.drawOval((TILE_SIZE * xTileSizes) + x, (TILE_SIZE * yTileSizes) + y, (TILE_SIZE/4) * 3, (TILE_SIZE/4) * 3);
        pen.drawOval((TILE_SIZE * xTileSizes) + (x*2), (TILE_SIZE * yTileSizes) + (y*2), TILE_SIZE/2, TILE_SIZE/2);
    }
    
    //main function
    public static void main(String[] args) {
        //create window
        GraphicsWindow window = new GraphicsWindow(WINDOW_TITLE, WINDOW_SIZE, WINDOW_SIZE, 0, 0);
        
        //set up pen
        Graphics2D pen = window.getPen();
        
        //calculate what the coordinates of the last tile in the row would be and make colors.
        int lastTileInRow = WINDOW_SIZE - TILE_SIZE;
        Color myBlack = new Color(50, 50, 50);
        
        //draw the board
        drawBoard(pen, lastTileInRow);
        
        //print black pieces on 1st and 3rd rows
        for (int yTileSizes = 0; yTileSizes <= 2; yTileSizes += 2) {
            for (int xTileSizes = 1; xTileSizes <= lastTileInRow; xTileSizes += 2) {
                drawChecker(pen, TILE_SIZE/8, TILE_SIZE/8, myBlack, xTileSizes, yTileSizes);
            }
        }
        
        //print black pieces on row 2
        for (int xTileSizes = 0; xTileSizes <= lastTileInRow; xTileSizes += 2) {
            int yTileSizes = 1;
            drawChecker(pen, TILE_SIZE/8, TILE_SIZE/8, myBlack, xTileSizes, yTileSizes);
        }
        
        //print red pieces on 6th and 8th rows
        for (int yTileSizes = 5; yTileSizes <= 7; yTileSizes += 2) {
            for (int xTileSizes = 0; xTileSizes <= lastTileInRow; xTileSizes += 2) {
                drawChecker(pen, TILE_SIZE/8, TILE_SIZE/8, Color.RED, xTileSizes, yTileSizes);
            }
        }
        
        //print red pieces on row 7
        for (int xTileSizes = 1; xTileSizes <= lastTileInRow; xTileSizes += 2) {
            int yTileSizes = 6;
            drawChecker(pen, TILE_SIZE/8, TILE_SIZE/8, Color.RED, xTileSizes, yTileSizes);
        }
        
        //finalize window
        window.finalize();
    }
}
