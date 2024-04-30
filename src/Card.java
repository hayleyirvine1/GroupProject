import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Card{ //Card Class

    //Private variables
    private String filename; //stores the filenames
    private boolean isFlipped; //indicate whether the card is flipped or not
    private Graphics g;
    private int size; //size of card

    //row and column position of the card
    private int row;
    private int col;

    private Image scaledImage; //scaled image

    /**
     * A constructor for the Card class with parameters
     * @param g : Graphics to display images
     * @param size : int, size is set to 150
     * @param row : set row position
     * @param col : set column position on the board
     * @param x : String x = filename
     */

    public Card(String x, Graphics g, int size, int row, int col){ //String only exists here
        filename = x; //set the filename for the image
        isFlipped = false; //set the initial flipped state of the card to false
        this.g = g; //copy graphics. assign the graphics objec to 'g'
        this.size = size; //set the size of the card
        this.row = row; //set the row position of the card on the board
        this.col = col; //set column position

        //Attempt to read the image from the provided URL
        try {
            Image image = ImageIO.read(new URL(filename));
            //Scale the image to fit the specified size using smooth scaling algorithm
            scaledImage = image.getScaledInstance(this.size, this.size, Image.SCALE_SMOOTH);
        }
        catch (Exception e) {
            //Print an error message if loading the image fails
            System.out.println("Failed to get the image");
        }

    }

    public boolean isFlipped() {
        return isFlipped; //return the current state for the isFlipped boolean variable
    }

    public void setFlip() {
        isFlipped = true; //set isFlipped to true
    }
    public void resetFlip() {
        isFlipped = false; //set isFlipped to true
    }


    /**
     * Displays card clicked on at a specific position on the board
     */

    public void show (){
        int x = col * this.size; //where image is displayed
        int y = row * this.size;


        try {
            //Attempt to show scaled image under the sky image
            g.drawImage(scaledImage, x, y, null);

        }
        catch (Exception e) {
            //Print an error message if image fails to display
            System.out.println("File not properly read");
        }
    }


    /**
     * Hides a card with a blue sky image
     */
    public void hide (){
        int x = col * this.size; //where image is displayed
        int y = row * this.size; //same as show card

        BufferedImage image = null; //if image is successfully read, it puts image on screen

        try {
            //display sky image
            image = ImageIO.read(new URL("https://images.theconversation.com/files/393210/original/file-20210401-13-z6rl6z.jpg?ixlib=rb-4.1.0&rect=9%2C0%2C2994%2C1999&q=20&auto=format&w=320&fit=clip&dpr=2&usm=12&cs=strip"));
            Image scaledImage = image.getScaledInstance(this.size, this.size, Image.SCALE_SMOOTH);

            // Create a BufferedImage to hold the scaled image
            image = new BufferedImage(this.size, this.size, BufferedImage.TYPE_INT_ARGB);
            g.drawImage(scaledImage, x, y, null);

        }
        catch (Exception e) {
            //Writes an error message if the image fails to display
            System.out.println("File not properly read");
        }
    }

    /**
     * Define a method named equals that takes a card object as a parameter
     * @param card : used to check if filenames equal each other
     * @return card
     */
    //define a method named equals that takes a card object as a parameter
    public boolean equals(Card card){ //if the cards equal each other
        if (this.filename.equals(card.filename)) { //check if the filenames of the two cards are equal
            return true; //return true indicating that the cards are equal
        }
        return false; //cards aren't equal
    }


    @Override //override to the toString() method
    public String toString() {
        //return a string representation of the Card object
        return "Card{" +
                "filename='" + filename + '\'' +
                ", isFlipped=" + isFlipped +
                ", g=" + g +
                '}';
    }
}