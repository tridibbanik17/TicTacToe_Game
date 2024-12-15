package three_by_three_board;

/**
 * Author: Tridib Banik, McMaster University, Second year Software Engineering.
 * The ExtendedBoard class extends the Board class and adds functionality to check for a win condition.
 * It checks if a player has won based on a specified number of markers needed in a row, column, or diagonal.
 */
public class ExtendedBoard extends Board {
    private static final int WINCONDITION = 3; // The number of consecutive markers required to win, which is 3 for 3*3 grid.

    // Constructor initializes the board with the specified size and win condition.
    public ExtendedBoard(int size, int winCondition) {
        super(SIZE);
    }

    public static int getWinCondition() {
        return WINCONDITION;
    }

    public static int getSize() {
        return SIZE;
    }

    // Checks if the given symbol (player's marker) has met the win condition.
    // Returns true if a winning combination is found, otherwise false.

    public boolean checkWin(char symbol) {
        int size = grid.length;

        // Check rows
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - WINCONDITION; j++) {
                boolean rowWin = true;
                for (int k = 0; k < WINCONDITION; k++) {
                    if (grid[i][j + k] != symbol) {
                        rowWin = false;
                        break;
                    }
                }
                if (rowWin) return true; // Found a winning row.
            }
        }

        // Check columns
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - WINCONDITION; j++) {
                boolean colWin = true;
                for (int k = 0; k < WINCONDITION; k++) {
                    if (grid[j + k][i] != symbol) {
                        colWin = false;
                        break;
                    }
                }
                if (colWin) return true; // Found a winning column.
            }
        }

        // Check diagonals
        for (int i = 0; i <= SIZE - WINCONDITION; i++) {
            for (int j = 0; j <= SIZE - WINCONDITION; j++) {
                // Primary diagonal
                boolean primaryDiagonalWin = true;
                for (int k = 0; k < WINCONDITION; k++) {
                    if (grid[i + k][j + k] != symbol) {
                        primaryDiagonalWin = false;
                        break;
                    }
                }
                if (primaryDiagonalWin) return true;

                // Secondary diagonal
                boolean secondaryDiagonalWin = true;
                for (int k = 0; k < WINCONDITION; k++) {
                    if (grid[i + k][j + WINCONDITION - k - 1] != symbol) {
                        secondaryDiagonalWin = false;
                        break;
                    }
                }
                if (secondaryDiagonalWin) return true;
            }
        }

        return false; // No winning condition found.
    }
}
