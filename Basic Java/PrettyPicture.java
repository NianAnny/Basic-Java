/**
 * Write a description of class PrettyPicture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.image.BufferedImage;
public class PrettyPicture {

    private static final String IMAGE_FILE_NAME = "meme.png";

    public static void main(String[] args) {
        String title = "Pretty Picture";
        int width = 1000;
        int height = 500;
        int x = 0;
        int y = 0;
        GraphicsWindow window = new GraphicsWindow(title, width, height, x, y);
        window.paintBackground(Color.WHITE);

        //SET UP PEN
        Graphics2D pen = window.getPen();

        //DRAW A BLUE RECTANGLE
        pen.setColor(Color.BLUE);
        pen.fillRect(width/2, height/4, width/8, height/4);
        
        //DRAW A DIAMOND
        //x point array
        int[] diamondX = new int[4];
        diamondX[0] = 0;
        diamondX[1] = 100;
        diamondX[2] = 200;
        diamondX[3] = 100;
        
        //y point array
        int[] diamondY = new int[4];
        diamondY[0] = 400;
        diamondY[1] = 300;
        diamondY[2] = 400;
        diamondY[3] = 500;
        
        //make custom color and draw
        Color myBlue = new Color(0, 252, 244);
        pen.setColor(myBlue);
        pen.fillPolygon(diamondX, diamondY, 4);
        
        //DRAW A TRIANGLE
        //x point array
        int[] triangleX = new int[3];
        triangleX[0] = 700;
        triangleX[1] = 800;
        triangleX[2] = 900;
        
        //y point array
        int[] triangleY = new int[3];
        triangleY[0] = 400;
        triangleY[1] = 300;
        triangleY[2] = 500;
        
        //set color and draw
        pen.setColor(Color.GREEN);
        pen.fillPolygon(triangleX, triangleY, 3);

        //DRAW A RED CIRCLE
        pen.setColor(Color.RED);
        pen.fillOval(0, 0, width/8, height/4);
        
        //DRAW A STRAIGHT LINE
        Color myPink = new Color(252, 0, 244);
        pen.setColor(myPink);
        pen.drawLine(300, 400, 600, 400);

        //PRINT A MESSAGE
        pen.setColor(Color.BLACK);
        pen.drawString("Drawing is fun!", width/2, height/4);

        //PRINT A PICTURE
        BufferedImage meme = GraphicsWindow.loadImage(IMAGE_FILE_NAME);
        pen.drawImage(meme, null, width/4, height/4);
        
        //finish up
        window.finalize();
    }
}
