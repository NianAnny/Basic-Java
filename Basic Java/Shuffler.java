
/**
 * Shuffling the card deck for fine!
 *
 * @author Anny Cui
 * @version 2021.06.24
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
public class Shuffler {
    //set constants
    private static final String TITLE = "Shuffled Cards";
    private static final int IMAGE_WIDTH = 1560;
    private static final int IMAGE_HEIGHT = 672;
    private static final int CARD_COLUMN = 13;
    private static final int CARD_ROW = 4;
    private static final int CARD_WIDTH = IMAGE_WIDTH/CARD_COLUMN;
    private static final int CARD_HEIGHT = IMAGE_HEIGHT/CARD_ROW;
    private static final int WINDOW_WIDTH = CARD_WIDTH*9;
    private static final int WINDOW_HEIGHT = CARD_HEIGHT+(CARD_HEIGHT/2);
    private static final Color BOARD = new Color(0, 117, 37);
    private static final String IMAGE_FILE_NAME = "cards.png";
    
    public static void main(String[] args) {
        GraphicsWindow window = new GraphicsWindow(TITLE, WINDOW_WIDTH, WINDOW_HEIGHT, 0, 0);
        window.paintBackground(BOARD);
        Graphics2D pen = window.getPen();
        
        //draw cards
        Card.setDefaultImages(GraphicsWindow.loadImageAsTiles(IMAGE_FILE_NAME, CARD_WIDTH, CARD_HEIGHT));
        CardSet deckOfCard = CardSet.makeStandardDeck();
        deckOfCard.shuffle();
        deckOfCard.draw(pen, CARD_WIDTH/7, (WINDOW_HEIGHT-CARD_HEIGHT)/2);
        
        //finish up
        window.finalize();
    }
}
