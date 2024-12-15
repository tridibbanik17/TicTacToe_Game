package extendedboard_package;

/**
 * Author: Tridib Banik, Student Number: 400514461, MacID: banikt
 * The ExtendedBoard class extends the Board class and adds functionality to check for a win condition.
 * It checks if a player has won based on a specified number of markers needed in a row, column, or diagonal.
 */
public class ExtendedBoard extends Board {
    private final int winCondition; // The number of markers required to win.

    // Constructor initializes the board with the specified size and win condition.
    public ExtendedBoard(int size, int winCondition) {
        super(size);
        this.winCondition = winCondition;
    }

    public int getWinCondition() {
        return winCondition;
    }

    // Checks if the given symbol (player's marker) has met the win condition.
    // Returns true if a winning combination is found, otherwise false.
    public boolean checkWin(char symbol) {
        int size = grid.length;

        // Check rows
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                boolean rowWin = true;
                for (int k = 0; k < winCondition; k++) {
                    if (grid[i][j + k] != symbol) {
                        rowWin = false;
                        break;
                    }
                }
                if (rowWin) return true; // Found a winning row.
            }
        }

        // Check columns
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                boolean colWin = true;
                for (int k = 0; k < winCondition; k++) {
                    if (grid[j + k][i] != symbol) {
                        colWin = false;
                        break;
                    }
                }
                if (colWin) return true; // Found a winning column.
            }
        }

        // Check diagonals
        for (int i = 0; i <= size - winCondition; i++) {
            for (int j = 0; j <= size - winCondition; j++) {
                // Primary diagonal
                boolean primaryDiagonalWin = true;
                for (int k = 0; k < winCondition; k++) {
                    if (grid[i + k][j + k] != symbol) {
                        primaryDiagonalWin = false;
                        break;
                    }
                }
                if (primaryDiagonalWin) return true;

                // Secondary diagonal
                boolean secondaryDiagonalWin = true;
                for (int k = 0; k < winCondition; k++) {
                    if (grid[i + k][j + winCondition - k - 1] != symbol) {
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
