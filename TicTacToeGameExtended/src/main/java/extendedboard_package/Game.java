package extendedboard_package;

/**
 * Author: Tridib Banik, Student Number: 400514461, MacID: banikt
 * This class represents the Tic-Tac-Toe game itself.
 * It manages the game flow, handles player turns, and determines the winner or a draw.
 */
public class Game {
    private final ConfigurableBoard board; // The game board.
    private final Player player1; // Player 1 of the game.
    private final Player player2; // Player 2 of the game.

    // Constructor to initialize the game with two players and a configurable board.
    public Game(Player player1, Player player2, ConfigurableBoard board) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    // Main game loop where players take turns, the board is displayed, and the game continues until there is a winner or draw.
    public void play() {
        Player currentPlayer = player1; // Player 1 starts the game.
        while (true) {
            board.display(); // Display the current state of the board.
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn.");
            int[] move = currentPlayer.getMove(board); // Get the current player's move.

            // Place the player's marker on the board if the move is valid.
            if (board.placeMarker(move[0], move[1], currentPlayer.getSymbol())) {
                // Check if the current player has won.
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.display();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    break; // Exit the loop when a player wins.
                }
                // Check if the board is full and it's a draw.
                if (board.isFull()) {
                    board.display();
                    System.out.println("It's a draw!");
                    break; // Exit the loop if the game is a draw.
                }
                // Switch to the other player for the next turn.
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Invalid move. Try again."); // Inform the player if the move was invalid.
            }
        }
    }
}
