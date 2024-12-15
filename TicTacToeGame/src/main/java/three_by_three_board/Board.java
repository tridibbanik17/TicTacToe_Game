package three_by_three_board;

import java.util.Arrays;

/**
 * Author: Tridib Banik, McMaster University, Second year Software Engineering.
 * The Board class represents the game board in Tic-Tac-Toe.
 * It handles the grid initialization, display, and placement of markers.
 */
public class Board {
    protected char[][] grid; // The 2D grid representing the board's cells.
    protected static final int SIZE = 3;
    
    // Constructor initializes the board with the specified size and fills it with empty spaces.
    public Board(int SIZE) {
        this.grid = new char[SIZE][SIZE];
        for (char[] row : grid) {
            Arrays.fill(row, ' '); // Fill each cell with an empty space.
        }
    }

    // Displays the current state of the board to the console.
    public void display() {
        System.out.println("\nHere is the 3*3 Tic-Tac-Toe Board:");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
                if (j < grid[i].length - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < grid.length - 1) {
                System.out.println("-".repeat(grid.length * 4 - 1));
            }
        }
    }

    // Places a marker on the board at the specified row and column.
    // Return true if the move is successful, false otherwise.
    public boolean placeMarker(int row, int col, char symbol) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid.length && grid[row][col] == ' ') {
            grid[row][col] = symbol; // Place the symbol in the specified position.
            return true;
        }
        return false; 
    }

   
    // Checks if the board is full (no empty spaces).
    // Return true if the board is full, false otherwise.
    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == ' ') return false; // An empty space found.
            }
        }
        return true; // No empty spaces means the board is full.
    }

    // Getter method to return the current grid of the board.
    public char[][] getGrid() {
        return grid;
    }

    // Getter method to return the size of the board (number of rows/columns).
    public static int getSize() {
        return SIZE;
    }
}





















/*
import java.util.Arrays;

// Board class stores the board state as a 2D character array and provides methods to interact with the board.
public class Board {
    private char[][] grid;
    private static final int SIZE = 3;

    // constructor method
    public Board() {
        // Initializing a 2D grid that accepts char type
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // Assigning '-' to each element of the 2D grid representing empty cells.
                grid[i][j] = '-';
            }
        }
    }

    // Print the board to the console
    public void displayBoard() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // This method ensures that a marker can only be placed on an empty cell
    public boolean placeMarker(int row, int col, char marker) {
        if (grid[row][col] == '-') {
            grid[row][col] = marker;
            return true;
        }
        return false;
    }

    // This method efficiently checks for a full board by iterating over each cell
    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == '-') return false;
            }
        }
        return true;
    }

    // Getter method to return grid 
    public char[][] getGrid() {
        return grid;
    }
}

*/








/*
import java.util.Arrays;

public class Board {
    protected final char[][] grid;
    protected static final int SIZE = 3;
    public Board() {
        this.grid = new char[SIZE][SIZE];
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }
    }

    public void display() {
        System.out.println("\nBoard:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }

    public boolean placeMarker(int row, int col, char symbol) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && grid[row][col] == ' ') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    public char[][] getGrid() {
        return grid; // Returns the current grid state
    }

    public int getSize() {
        return SIZE; // Returns the number of rows of the grid.
    }
}

*/