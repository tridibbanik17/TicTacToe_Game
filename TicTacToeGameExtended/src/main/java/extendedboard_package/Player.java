
package extendedboard_package;

/**
 * Author: Tridib Banik, McMaster University, Software Engineering Second year.
 * This abstract class defines the Player for a Tic-Tac-Toe game.
 * It provides a base structure for different types of players (Human or Computer).
 */

public abstract class Player {
    protected final char symbol; // Player's marker X or O

    // Constructor to initialize a player with a given symbol.
    public Player(char symbol) {
        this.symbol = symbol;
    }

    // Gets the symbol of the player.
    public char getSymbol() {
        return symbol;
    }

    // Abstract method for getting the player's move. 
    // Implemented by specific player types (e.g., Human or Computer).
    // It returns an array of integers representing the row and column of the move.
    public abstract int[] getMove(Board board);
}

