
package extendedboard_package;
import java.util.Random;

/**
 * Author: Tridib Banik, McMaster University, Software Engineering Second year.
 * This class epresents a smart computer player.
 * Inherits from the ComputerPlayer class and implements a more advanced strategy.
 */
public class SmartComputerPlayer extends ComputerPlayer {
    private final Random random = new Random();

    // Constructor to initialize a smart computer player with the specified symbol.
    // Parameter symbol is the symbol representing the player's marker (e.g., 'X' or 'O').
    public SmartComputerPlayer(char symbol) {
        super(symbol);
    }

    // Generates a move using a more advanced strategy, prioritizing winning and blocking opponent's wins.
    // Parameter board is the current state of the game board.
    // It returns an integer array containing the row and column indices of the move.
    // Override
    public int[] getMove(Board board) {
        ExtendedBoard extendedBoard = (ExtendedBoard) board; // Cast to ExtendedBoard to use its methods

        // 1. Prioritize Winning
        int[] winningMove = findWinningMove(extendedBoard, this.symbol);
        if (winningMove != null) {
            return winningMove;
        }

        // 2. Block Opponent
        char opponentSymbol = (symbol == 'X') ? 'O' : 'X';
        winningMove = findWinningMove(extendedBoard, opponentSymbol);
        if (winningMove != null) {
            return winningMove;
        }

        // 3. Play Center
        int center = board.getSize() / 2;
        if (board.getGrid()[center][center] == ' ') {
            return new int[]{center, center};
        }

        // 4. Take Corners
        int[][] corners = {{0, 0}, {0, board.getSize() - 1}, {board.getSize() - 1, 0}, {board.getSize() - 1, board.getSize() - 1}};
        for (int[] corner : corners) {
            if (board.getGrid()[corner[0]][corner[1]] == ' ') {
                return corner;
            }
        }

        // 5. Random Move
        int row, col;
        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.placeMarker(row, col, ' '));
        return new int[]{row, col};
    }

    // Checks if a specific symbol can win in the next move.
    // Parameter symbol is the symbol to check for a winning move.
    // It returns an integer array containing the winning move, or null if no winning move is found.
    private int[] findWinningMove(ExtendedBoard board, char symbol) {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getGrid()[i][j] == ' ') {
                    board.getGrid()[i][j] = symbol;
                    if (board.checkWin(symbol)) {
                        board.getGrid()[i][j] = ' ';
                        return new int[]{i, j};
                    }
                    board.getGrid()[i][j] = ' ';
                }
            }
        }
        return null;
    }
}

