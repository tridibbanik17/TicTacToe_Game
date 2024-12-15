package three_by_three_board;

/**
 * Author: Tridib Banik, McMaster University, Software Engineering Second year.
 * This class represents the Tic-Tac-Toe game itself.
 * It manages the game flow, handles player turns, and determines the winner or a draw.
 */
public class Game {
    // The game board, which stores the current state of the game.
    private final ExtendedBoard board;


    // Player 1 of the game.
    private final Player player1;
    // Player 2 of the game.
    private final Player player2;

    // Constructor to initialize the game with the specified players and board.
    // player1 is the first player.
    // player2 is the second player.
    // board is the game board.
    public Game(Player player1, Player player2, ExtendedBoard board) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Main game loop that alternates between players, checks for wins, draws, and invalid moves.
     */
    public void play() {
        Player currentPlayer = player1; // Start with player 1

        while (true) {
            board.display(); // Display the current state of the board
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn.");

            // Get the current player's move
            int[] move = currentPlayer.getMove(board);

            // Place the player's marker on the board if the move is valid
            if (board.placeMarker(move[0], move[1], currentPlayer.getSymbol())) {
                // Check for a win
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    break;
                }

                // Check for a draw
                if (board.isFull()) {
                    board.display();
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch to the next player
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}