package extendedboard_package;

import java.util.Arrays;

/**
 * Author: Tridib Banik, Student Number: 400514461, MacID: banikt
 * This class represents an extended Tic-Tac-Toe board that allows for customizable board size and win condition.
 * It inherits from the `Board` class and adds functionality to check for a win condition based on a specified number of markers in a row, column, or diagonal.
 */
public class ConfigurableBoard extends ExtendedBoard {
    private final int winCondition; // The number of markers required to win.

    
    // Constructor to initialize the board with the specified size and win condition.
    // Parameter size is the size of the board (number of rows and columns).
    // Parameter winCondition is the number of consecutive markers required to win.
    // It throws IllegalArgumentException if the win condition is larger than the board size.
    public ConfigurableBoard(int size, int winCondition) {
        super(size, winCondition);
        this.grid = new char[size][size];
        this.winCondition = winCondition;

        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }
    }

    /**
     * Displays the current state of the board to the console.
     */
    public void display() {
        int size = grid.length;
        System.out.println("\nHere is the " + size + "*" + size + " board:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j]);
                if (j < size - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("-".repeat(size * 4 - 1));
            }
        }
    }

    // Checks if the given symbol has won the game by forming a line of the specified length.
    // Parameter symbol is the symbol to check for a win.
    // It returns true if the symbol has won, false otherwise.
    public boolean checkWin(char symbol) {
        int size = grid.length;

        // Check rows and columns

        for (int i = 0; i < size; i++) {
            if (checkConsecutive(grid[i], symbol, winCondition)) return true; // Row
            if (checkConsecutive(getColumn(i), symbol, winCondition)) return true; // Column
        }

        // Check diagonals
        return checkDiagonals(symbol, winCondition);
    }

    // Gets a specific column from the board as an array.
    // Parameter colIndex is the index of the column to retrieve.
    // It returns an array representing the column.
    private char[] getColumn(int colIndex) {
        int size = grid.length;
        char[] column = new char[size];
        for (int i = 0; i < size; i++) {
            column[i] = grid[i][colIndex];
        }
        return column;
    }

    // Checks if there is a sequence of `m` consecutive occurrences of the specified symbol in the given line.
    // Parameter line is the line to check (row, column, or diagonal).
    // Parameter symbol is the symbol to check for.
    // Parameter winCondition The required number of consecutive symbols to win.
    // It returns true if there is a winning sequence, false otherwise.
    private boolean checkConsecutive(char[] line, char symbol, int winCondition) {
        int count = 0;
        for (char cell : line) {
            if (cell == symbol) {
                count++;
                if (count == winCondition) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    // Checks both primary and secondary diagonals for a winning sequence.
    // It returns true if a winning diagonal sequence is found, false otherwise.
    private boolean checkDiagonals(char symbol, int winCondition) {
        int size = grid.length;

        // Check both diagonals starting from each possible offset.
        for (int k = 0; k <= size - winCondition; k++) {
            if (checkConsecutive(getDiagonal(k, true), symbol, winCondition)) {
                return true; // Primary diagonal (top-left to bottom-right)
            }
            if (checkConsecutive(getDiagonal(k, false), symbol, winCondition)) {
                return true; // Secondary diagonal (top-right to bottom-left)
            }
        }

        return false;
    }

    // Retrieves a diagonal from the board, either the primary or secondary diagonal, starting from a given offset.
    // Parameter offset is the offset from the top-left corner.
    // Parameter primary indicates whether to get the primary or secondary diagonal.
    // It returns an array of characters representing the diagonal.
    private char[] getDiagonal(int offset, boolean primary) {
        int size = grid.length;
        char[] diagonal = new char[size - offset];
        for (int i = 0; i < size - offset; i++) {
            if (primary) {
                diagonal[i] = grid[i][i + offset]; // Primary diagonal (top-left to bottom-right)
            } else {
                diagonal[i] = grid[i][size - 1 - (i + offset)]; // Secondary diagonal (top-right to bottom-left)
            }
        }
        return diagonal;
    }
}