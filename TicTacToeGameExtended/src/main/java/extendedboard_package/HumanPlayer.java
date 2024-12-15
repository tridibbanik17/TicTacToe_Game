package extendedboard_package;

import java.util.Scanner;

/**
 * Author: Tridib Banik, Student Number: 400514461, MacID: banikt
 * This class epresents a computer player.
 * It inherits from the Player class and provides a basic implementation for making random moves.
 */
public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in); // Scanner to get user input.

    // Constructor to initialize a human player with the specified symbol.
    public HumanPlayer(char symbol) {
        super(symbol); // Call the parent constructor to set the symbol.
    }

    // Gets the human player's move by prompting them to input row and column numbers.
    // Override
    public int[] getMove(Board board) {
        System.out.println("Player " + symbol + ", enter your move (row and column): ");
        System.out.println("Type an integer between 1 and " + board.getSize() + " as the row number and press enter.");
        int row = scanner.nextInt() - 1; // Get the row index (adjusted for 0-based index).
        System.out.println("Type an integer between 1 and " + board.getSize() + " as the column number and press enter.");
        int col = scanner.nextInt() - 1; // Get the column index (adjusted for 0-based index).
        return new int[]{row, col};
    }
}
