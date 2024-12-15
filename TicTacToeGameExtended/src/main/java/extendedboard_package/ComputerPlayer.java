package extendedboard_package;

import java.util.Random;

/**
 * Author: Tridib Banik, McMaster University, Software Engineering Second year.
 * This class epresents a computer player.
 * It inherits from the Player class and provides a basic implementation for making random moves.
 */

public class ComputerPlayer extends Player {
    private final Random random = new Random(); // Random object to generate random moves.


    // Constructor to initialize a computer player with the specified symbol.
    public ComputerPlayer(char symbol) {
        super(symbol); // Call the parent constructor to set the symbol.
    }

    // This method extracts the computer player's move by randomly selecting an empty cell on the board.
    // This method generates a random move on the board.
    // parameter board represents the current state of the game board.
    // It returns an integer array containing the row and column indices of the move.
    // Override
    public int[] getMove(Board board) {
        int row, col;
        do {
            row = random.nextInt(board.getSize()); 
            col = random.nextInt(board.getSize()); 
        } while (!board.placeMarker(row, col, ' ')); // Ensure the selected cell is empty.
        return new int[]{row, col};
    }
}
