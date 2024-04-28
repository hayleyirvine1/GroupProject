import java.awt.*;

public class MemoryGame {
    public static void main(String[] args) {

        DrawingPanel panel = new DrawingPanel(200, 300);
        Graphics g = panel.getGraphics();

        panel.onMouseClick( //where the user can click
               (x, y) -> {
                    onClick(g, x, y);
                }
        );

        Card[][] table = createCardArray(g);

        System.out.println(table[0][0]); //calling  toString method
        System.out.println(table[0][1]);
        System.out.println(table[0][2]);

        table[0][0].show(0, 0);
        table[0][1].show(0, 1);


    }

    public static Card[][] createCardArray(Graphics g) {
        Card[][] table = new Card[2][3]; //create array of cards

        table[0][0] = new Card("Diamond.png", g);
        table[0][1] = new Card("Diamond.png", g);
        table[0][2] = new Card("Grin.png", g);
        table[1][0] = new Card("Grin.png", g);
        table[1][1] = new Card("SmileyFace.png", g);
        table[1][2] = new Card("SmileyFace.png", g);

        return table;
    }

    public static void onClick(Graphics g, int y, int x, table[][], int row, int col) { //where user can click
        if (y >= 40 || y <= 80) { //size of each square
            return;
            row, col = map(x, y);
            if (table[row][col].isFlipped()) {
                return;
            }
            if (clicks % 2 == 0) {
                table[row][col].show();
                clicks++;
                firstCard = table[row][col];
                return;
            } else (table[row][col].show()) {
                if (table[row][col].equals(firstCard)) {
                }

            }
        }


    }
}



//draw pictures on each card?
//a class for each picture?
//how to use client

//chapter 3. supplement



//clicks
//turn = 1;
//p1 score = 0
//p2 = 0
//another String array that has jpg (array filenames)
//int array table pf size 4 x 4. have it shuffle
//diamond shape = 0
//square = 1
//store numbers in table array


//click on cards. is card already clicked
//clicks = 0
//card x, card y = map (x,y)// map method should return 1, 1,
// row, col = map(x,y )
//return -1,-1 if not clicking a card

//if (card at row column, is open?) ignore it. return
//know if it the first click or second click
//if (clicks is even) then its the first card. then show card at row, col). then return, clicks++
//states at (row, col) and turn it to true. return. prev_row = row. prev.col=col


//else (show card at row, col) method
//states[row][col] = true;
//turn 2;

//another method(compare if cards are the same)
//method called match(row, col)(prevrow and prevcol)
//if (table[row][col] ==table[prow][rcol]
//if(turn ==1)
//p1++
//else(p2++1). hide method(row, col, prow, pcol). states == false

//method called hide row and column

//if all cards flipped game over. method

//define a class
//hide and show are methods within card class
//card object.





//Card.java: file name: String. isFlipped variable = false.
// MemoryGame.java main() --> create table = Card array()
//







//show (row, col)--> table [row] [col]. show number 0, display diamond

//show(row,col)
//ind = table[row][col]
//draw(row, col, filenames[ind])



//array called states with table size
//default value if its false--> its not flipped
//if states at row col == true. return
//

//
//
//
//
//
//
//        //smiley face output
//        Image smileyFace = panel.loadImage("smiley.png");
//        Graphics g = panel.getGraphics();
//        for(int i = 0; i < 4; i++){ //four in a row
//            g.drawImage(smileyFace, i * 110 + 10, 10, panel);
//        }
//
//
//
//
//        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
//        Graphics g = panel.getGraphics();
//
//        drawBoard(g); //draw the board
//
//        panel.onMouseClick( //where the user can click
//                (x, y) -> {
//                    handelClick(g, x, y);
//                }
//        );
//
//        public static void handleClick(Graphics g, int y) { //where user can click
//            //they can't click once a card is flipped
//            if (y >= 40 || y <= 80) { //size of each square
//                return;
//            }
//        }
//
//        public static void drawBaord(Graphics g, String [] board) { //draw board
//            g.setColor(Color.BLACK);
//
//            //filled cards is boolean array (keeps track of cards that are flipped over)
//            //filled cards are false
//




//draw cards

//a method that shuffles the cards

//method that finds pairs and increases points for both players

//ask users if they want to customize their names (Scanner)


