
/**
 * Set up a chess board and show all chess pieces.
 *
 * @author Anny Cui
 * @version 2021.06.23
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
public class Chess {
    //constants for window title, tile number, tile size, window size, piece size, piece image file name
    private static final String TITLE = "Chess";
    private static final int BOARD_TILE_NUMBER = 8;
    private static final int SQUARE_SIZE = 80;
    private static final int PIECE_TILE_SIZE = 68;
    private static final int WINDOW_SIZE = BOARD_TILE_NUMBER*SQUARE_SIZE;
    private static final String IMAGE_FILE_NAME = "chess-pieces.png";
    private static final int X_ON_SQUARE_TILE = (SQUARE_SIZE-PIECE_TILE_SIZE)/2;
    private static final int Y_ON_SQUARE_TILE = (SQUARE_SIZE-PIECE_TILE_SIZE)/2;
    private static final String WHITE_PAWN="WP", WHITE_KNIGHT="WN", WHITE_BISHOP="WB", WHITE_ROOK="WR", WHITE_QUEEN="WQ", WHITE_KING="WK";
    private static final String BLACK_PAWN="BP", BLACK_KNIGHT="BN", BLACK_BISHOP="BB", BLACK_ROOK="BR", BLACK_QUEEN="BQ", BLACK_KING="BK";
    
    //main function
    public static void main(String[] args) {
        //make a window
        GraphicsWindow window = new GraphicsWindow(TITLE, WINDOW_SIZE, WINDOW_SIZE, 0, 0);
        //set up the pen
        Graphics2D pen = window.getPen();
        
        //draw the chess board
        int squareNumber = BOARD_TILE_NUMBER;
        drawBoard(pen, squareNumber);
        
        //read the image of chess pieces as tiles
        BufferedImage[][] chessPieces = GraphicsWindow.loadImageAsTiles(IMAGE_FILE_NAME, PIECE_TILE_SIZE, PIECE_TILE_SIZE);
        
        //ask for which .cp file is used for chess piece location
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.println("Which chess problem file you want to use for setting up the chess board?");
        String userInput = keyboardScanner.nextLine();
        String fileName = userInput;
        String[] fileLines = readFile(fileName);
        if(fileLines==null) {
            System.out.println("Sorry, the file cannot be found!");
            System.exit(0);
        }
        
        for(int i=0; i<fileLines.length; i++){
            String pieceDescriptor = fileLines[i];
            drawPiece(pen, pieceDescriptor, chessPieces);
        }
        
        //finish up
        window.finalize();
    }
    
    /**
     * Read a file from disk into String[].
     * @param fileName the fileName to read
     * @return String[]
     * @since 2021.06.23
     */
    private static String[] readFile(String fileName) {
        Scanner fileScanner = null;
        //set up scanner
        try {
            File chessFile = new File(fileName);
            fileScanner = new Scanner(chessFile);
        }
        catch(FileNotFoundException ex) {
            return null;
        }
        
        //put constants of file into the ArrayList
        ArrayList<String> lineList = new ArrayList<>();
        while(fileScanner.hasNextLine()) {
            lineList.add(fileScanner.nextLine());
        }
        
        //shut down and convert to return
        fileScanner.close();
        String[] fileLines = (String[])lineList.toArray(new String[lineList.size()]);
        return fileLines;
    }
    
    /**
     * Parse the String
     * @param pieceDescriptor the contents in the file
     * @return ints 0 to 7 representing the pieces' file
     * @since 2021.06.23
     */
    private static int getFile(String pieceDescriptor) {
        char letter = pieceDescriptor.charAt(3);
        return letter-'a';
    }
    
    /**
     * Draw chess pieces
     * @param pen the pen to draw
     * 
     * @param pieceName which the tile will be drawn
     * @since 2021.06.23
     */
    private static void drawPiece(Graphics2D pen, String pieceDescriptor, BufferedImage[][] chessPieces) {
        int row = pieceDescriptor.charAt(4)-'0';
        int column = getFile(pieceDescriptor);
        int x = column*SQUARE_SIZE+X_ON_SQUARE_TILE;
        int y = WINDOW_SIZE-(SQUARE_SIZE*row)+Y_ON_SQUARE_TILE;
        if(pieceDescriptor.contains(WHITE_PAWN)) pen.drawImage(chessPieces[0][0], null, x, y);
        else if(pieceDescriptor.contains(WHITE_KNIGHT)) pen.drawImage(chessPieces[0][1], null, x, y);
        else if(pieceDescriptor.contains(WHITE_BISHOP)) pen.drawImage(chessPieces[0][2], null, x, y);
            else if(pieceDescriptor.contains(WHITE_ROOK)) pen.drawImage(chessPieces[0][3], null, x, y);
            else if(pieceDescriptor.contains(WHITE_QUEEN)) pen.drawImage(chessPieces[0][4], null, x, y);
            else if(pieceDescriptor.contains(WHITE_KING)) pen.drawImage(chessPieces[0][5], null, x, y);
        
            else if(pieceDescriptor.contains(BLACK_PAWN)) pen.drawImage(chessPieces[1][0], null, x, y);
            else if(pieceDescriptor.contains(BLACK_KNIGHT)) pen.drawImage(chessPieces[1][1], null, x, y);
            else if(pieceDescriptor.contains(BLACK_BISHOP)) pen.drawImage(chessPieces[1][2], null, x, y);
            else if(pieceDescriptor.contains(BLACK_ROOK)) pen.drawImage(chessPieces[1][3], null, x, y);
            else if(pieceDescriptor.contains(BLACK_QUEEN)) pen.drawImage(chessPieces[1][4], null, x, y);
            else if(pieceDescriptor.contains(BLACK_KING)) pen.drawImage(chessPieces[1][5], null, x, y);
    }
    
    /**
     * Create a chessboard on the window
     * @param pen the pen to draw tiles
     * @param squareNumber the coordinates(without SQUARE_SIZE) of each squares
     * @since 2021.06.23
     */
    private static void drawBoard(Graphics2D pen, int squareNumber) {
        //set up colors
        Color lightSquare = new Color(255,226,163);
        Color darkSquare = new Color(201,119,10);
        
        for(int i=0; i<squareNumber; i++) {
            //print light squares in each row
            for(int j=i%2; j<squareNumber; j+=2) {
                pen.setColor(lightSquare);
                pen.fillRect(j*SQUARE_SIZE, i*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
            
            //print dark squares in each row
            for(int j=-i%2+1; j<squareNumber; j+=2) {
                pen.setColor(darkSquare);
                pen.fillRect(j*SQUARE_SIZE, i*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }
}
