# PS #4 : CARD MEMORY GAME

*written by Hayley Irvine, Jae Jang*

assisted by: *Dr. Pauca, CLASS Tutor*

#### This code is a card memory game, it consists of a separate card class, utilized through our MemoryGame class. 


(Descriptions of Code)
## : Card Class 

This Java class defines a "Card" object for a game, likely a memory or matching card game. 

The class includes attributes to handle the card's graphical representation, size, grid position (row and column), and whether it is flipped. 

It has methods to load and display the card's image from a specified filename URL, flip the card's state, compare two cards for equality based on their filenames, and override the "toString" method for descriptive output. 

Additional functionality allows the card to hide itself by overlaying a default image: ("blue sky") 

The class also handles errors in loading or displaying images by catching invalid input and printing error messages.



## : MemoryGame Class 


: The game handles mouse clicks on the drawing panel to determine which card was selected. The logic involves determining the row and column of the clicked card based on the mouse coordinates.

When a card is clicked, it is shown. If it is the second card clicked, the game checks if it matches the previously clicked card (stored in firstCard). If they match, both cards are marked as flipped and remain visible. If they don't match, a timer is started to flip them back after a short delay, effectively hiding them again.
Points are incremented for each successful match. The game ends when all matches are found (when points reach a certain number, e.g., 10 for a 4x5 grid assuming each image appears twice).
When all pairs are matched, a message is displayed, and the application exits.

###### Graphics & Animation
The game uses basic Swing functions to create dialogs and handle image changes

A timer is used to manage the delay in hiding unmatched cards, providing a brief moment for players to view the second card before it is turned face down again.
Cards have methods to "show" and "hide" themselves, during the duration of the game. 

Once card is matched, it won't flip back. 

## Contributions: 

Hayley: originally came up with the Project Idea, Worked heavily with Dr. Pauca to initiate the start of our project setting up the exoskeleton of our project, 
worked extremely hard to insert and integrate the urls to add the active images. Built and formulated plan for the Card.Java with Dr. Pauca which was base needed to utilize the MemoryGame Class. 
Also chose the images used for the 5x5 grid, and utilized arrays masterfully to build the right size boxes to fit within the drawing panel. 
built try & catch functions for default sky image along with scaling the image perfectly for the right fit for the 5 x 5 grid used. Completed the most important part of our memory game, which was to figure out how to code the clicking and flipping the images around if not the correct one, and also figured out how to make it a point system so that when user got everything correct the game is considered done!


Jae: fixed image errors for initial images in .png files, Built and worked with Computer science tutor to build on code and get the ball rolling for MemoryGame.java class. added popup features for starting game and ending game, and worked on trying to make cards reset if wrong along with boolean function in Card.java. Wrote initial code for putting images and unflipped images into the grids by scaling for an original grid of 3x3 not 5x5, code was modified by hayley into larger grids for better gaming experience. 

