import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Card {
    private String filename;
    private boolean isFlipped;
    private Graphics g;

    public Card(String x, Graphics g){ //String only exists in this method
        filename = x;
        isFlipped = false;
        this.g = g; //copy graphics
    }

    //displays card clicked on at a specific position on the board
    public void show (int row, int col){
        int x = row * 100; //where image is displayed
        int y = col * 100;
        File img = new File(filename);
        BufferedImage image = null; //if image is successfully read, it puts image on screen
        try {
             BufferedImage in = ImageIO.read(img);
             image = new BufferedImage(
                    100, 100, BufferedImage.TYPE_INT_ARGB);
        }
        catch (Exception e) {

        }
        g.drawImage(image, x, y, null);
    }

    public void hide (int row, int col){
        int x;
    }


    @Override
    public String toString() {
        return "Card{" +
                "filename='" + filename + '\'' +
                ", isFlipped=" + isFlipped +
                ", g=" + g +
                '}';
    }
}
