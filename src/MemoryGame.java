import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
/**********************************************************************
 * @file MemoryGame.java
 * @brief Had some trouble with making both cards display and then disappear if they weren't the same picture
 * @author Hayley Irvine
 * @date: 4/30
 * @acknowledgement:  Cecilia Liu (CLASS Tutor) , Professor Pauca
 ***********************************************************************/

public class MemoryGame { //Memory Game java class

    static int clicks = 0; //clicks start at 0
    static Card firstCard = null; //null means that the firstCard isn't referencing any object
    static int points = 0; //points start at 0 and only increase when the player gets a pair correctly
    static DrawingPanel panel; //static variable panel
    public static void main(String[] args) { //Main method

        panel = new DrawingPanel(750, 600); //size of drawing board
        Graphics g = panel.getGraphics(); //get graphics

        int size = 150;//size of each square for the pictures

        Card[][] table = createCardArray(g, size); //2D array of card objects

        panel.onMouseClick( //a mouse click listener for the drawing panel
                (x, y) -> {
                    onClick(x, y, size, table); //call onClick method with parameters
                }
        );

        //displays all 20 cards with a sky background in front of all the pictures (call hide method from Card class)

        table[3][0].hide();
        table[3][1].hide();
        table[3][2].hide();
        table[1][0].hide();
        table[1][1].hide();
        table[1][2].hide();
        table[1][3].hide();
        table[1][4].hide();
        table[3][3].hide();
        table[3][4].hide();
        table[2][0].hide();
        table[2][1].hide();
        table[2][2].hide();
        table[2][3].hide();
        table[2][4].hide();
        table[0][0].hide();
        table[0][1].hide();
        table[0][2].hide();
        table[0][3].hide();
        table[0][4].hide();

        SwingUtilities.invokeLater(() -> {
            // Display a pop-up message asking "Play Game" with an "OK" button
            JOptionPane.showMessageDialog(null, "Welcome to the Memory Game!", "Play Game", JOptionPane.INFORMATION_MESSAGE);
        }
        );
    }

    /**
     * Creates 2D array and sets a URL link for each card to display an image within scale
     *   Otherwise it returns false.
     * @param g : Graphics to display images
     * @param size : int, size is set to 150
     * @return :  Card[][] table of a size of 4 by 5
     */

    public static Card[][] createCardArray(Graphics g, int size) { //2D card array
        Card[][] table = new Card[4][5]; //create array of cards

        //sets a URL link for each location (row, col)
        table[1][0] = new Card("https://static.vecteezy.com/system/resources/previews/006/867/628/non_2x/red-bullfinch-cartoon-bird-isolated-bright-winter-bullfinches-winter-bird-character-cartoon-illustration-vector.jpg", g, size, 1, 0);
        table[2][4] = new Card("https://static.vecteezy.com/system/resources/previews/009/902/801/non_2x/a-small-cartoon-boat-with-a-red-flag-cartoon-design-of-water-transport-flat-illustration-isolated-on-a-white-background-vector.jpg", g, size, 2, 4);
        table[1][2] = new Card("https://static.vecteezy.com/system/resources/previews/009/902/801/non_2x/a-small-cartoon-boat-with-a-red-flag-cartoon-design-of-water-transport-flat-illustration-isolated-on-a-white-background-vector.jpg", g, size, 1, 2);
        table[3][3] = new Card("https://img.freepik.com/premium-vector/cute-dino-smiling-flat-cartoon-style_138676-2628.jpg", g, size, 3, 3);
        table[1][4] = new Card("https://img.freepik.com/premium-vector/cute-dino-smiling-flat-cartoon-style_138676-2628.jpg", g, size, 1, 4);

        table[2][0] = new Card("https://static.vecteezy.com/system/resources/previews/032/403/874/original/cute-whale-cartoon-illustration-cute-sea-animal-cartoon-vector.jpg", g, size, 2, 0);
        table[3][4] = new Card("https://static.vecteezy.com/system/resources/previews/032/403/874/original/cute-whale-cartoon-illustration-cute-sea-animal-cartoon-vector.jpg", g, size, 3, 4);
        table[3][0] = new Card("https://static.vecteezy.com/system/resources/previews/020/377/724/original/slice-of-watermelon-cartoon-food-fruit-isolated-on-white-background-vector.jpg", g, size, 3, 0);
        table[2][3] = new Card("https://static.vecteezy.com/system/resources/previews/020/377/724/original/slice-of-watermelon-cartoon-food-fruit-isolated-on-white-background-vector.jpg", g, size, 2, 3);
        table[1][3] = new Card("https://static.vecteezy.com/system/resources/previews/010/983/021/non_2x/tulip-flower-clip-art-outline-with-yellow-cute-color-animated-illustration-design-vector.jpg", g, size, 1, 3);

        table[0][2] = new Card("https://static.vecteezy.com/system/resources/previews/025/162/179/original/sticker-style-fruit-bowl-mascot-on-yellow-background-vector.jpg", g, size, 0, 2);
        table[3][1] = new Card("https://static.vecteezy.com/system/resources/previews/025/162/179/original/sticker-style-fruit-bowl-mascot-on-yellow-background-vector.jpg", g, size, 3, 1);
        table[2][2] = new Card("https://static.vecteezy.com/system/resources/previews/006/867/628/non_2x/red-bullfinch-cartoon-bird-isolated-bright-winter-bullfinches-winter-bird-character-cartoon-illustration-vector.jpg", g, size, 2, 2);
        table[2][1] = new Card("https://img.freepik.com/premium-vector/drink-cup-cute-icon-design_720392-15.jpg", g, size, 2, 1);
        table[0][3] = new Card("https://img.freepik.com/premium-vector/drink-cup-cute-icon-design_720392-15.jpg", g, size, 0, 3);

        table[0][0] = new Card("https://static.vecteezy.com/system/resources/previews/010/983/021/non_2x/tulip-flower-clip-art-outline-with-yellow-cute-color-animated-illustration-design-vector.jpg", g, size, 0, 0);
        table[0][1] = new Card("https://img.freepik.com/premium-vector/cartoon-cat-with-pink-tail-sits-blue-background_828550-16.jpg", g, size, 0, 1);
        table[3][2] = new Card("https://img.freepik.com/premium-vector/cartoon-cat-with-pink-tail-sits-blue-background_828550-16.jpg", g, size, 3, 2);
        table[1][1] = new Card("https://i.pinimg.com/736x/63/6c/68/636c68f22725528fcf0b2e22299c2992.jpg", g, size, 1, 1);
        table[0][4] = new Card("https://i.pinimg.com/736x/63/6c/68/636c68f22725528fcf0b2e22299c2992.jpg", g, size, 0, 4);

        return table; //returns the 2D array table of type Card[][]
    }

    /**
     * Creates 2D array and sets a URL link for each card to display an image within scale
     *   Otherwise it returns false.
     * @param x : x and y are used to declare row and column size for each space
     * @param y :
     * @param table : 2D array used to check the Cards that are clicked on
     * @param size : int, size is set to 150
     */
    public static void onClick(int x, int y, int size, Card[][]table) { //perform certain things depending on where the user clicks and the amount of clicks

        System.out.println("clicks = " + clicks); //print amount of clicks to the screen

        int row = y / size; //declare row and col
        int col = x / size;

        System.out.println("row, col = " + row + ", " + col); //print the row and column to the console that the user clicked on

        if (table[row][col].isFlipped()) { //if the user clicks on a card that has already been flipped
            System.out.println("Clicked on a card that is flipped: Try again!"); //print statement to console
            return; //exit
        }
        if (clicks % 2 == 0) { //when clicks is an even number
            table[row][col].show(); //show the first card
            clicks++; //increase clicks
            firstCard = table[row][col]; //set firstCard equal to that row and col that was clicked
            return; //exit

        }


        table[row][col].show(); //when click = 1, flip the second card


        if (table[row][col].equals(firstCard)) { //if the cards equal each other/have the same picture
            points++; //increase points
            System.out.println("Points: " + points); //display points in console

            table[row][col].setFlip(); //set second card to true. User can't click on card again
            firstCard.setFlip(); //set first card to true

        }
        if (points ==10){ //exit game if points = 10 and all pairs are found
            System.out.println("Game Over!"); //print game over to the console
            SwingUtilities.invokeLater(() -> {
                        // Display a pop-up message asking "Play Game" with an "OK" button
                        JOptionPane.showMessageDialog(null, "Game Over!", "Memory Game", JOptionPane.INFORMATION_MESSAGE); //print message to screen and have user click OK
                        System.exit(0); //exit the game after the user clicks okay
                    }
            );

        }


        if (!table[row][col].equals(firstCard)) { //if the first card doesn't equal the second card
            table[row][col].show(); // Show the second card

            Timer timer = new Timer(); //create a timer object
            timer.schedule(new TimerTask() {
                @Override
                public void run() { //create a method within the if statement

                    // After 2 seconds, flip both cards back
                    firstCard.hide(); //hide the first card
                    table[row][col].hide();//hide the second card
                    firstCard.resetFlip(); //reset the first card to false
                    table[row][col].resetFlip();//reset the second card to false
                    timer.cancel(); // Cancel the timer
                }
            }, 2000);//delay of 2 seconds
        }

        clicks++; //increase clicks
    }

}