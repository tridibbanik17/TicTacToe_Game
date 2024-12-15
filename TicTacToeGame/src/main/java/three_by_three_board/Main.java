package three_by_three_board;

import java.util.Scanner;

/**
 * Author: Tridib Banik, McMaster University, Second year Software Engineering.
 * This class represents the main game loop, handling user input, player creation, game setup, and game execution.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            // Display welcome message and game mode options
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("Select Game Mode:");
            System.out.println("1. Human vs Human");
            System.out.println("2. Human vs Computer");
            System.out.println("3. Computer vs Computer");
            System.out.println("Type either 1, 2, or 3 corresponding to the game mode and press enter.");

            // Read user input for game mode selection
            int selection = scanner.nextInt();

            // Validate user input for game mode (1-3)
            while (selection < 1 || selection > 3) {
                System.out.println("Invalid selection.");
                System.out.println("Please enter 1 for Human vs Human, 2 for Human vs Computer and 3 for Computer vs Computer.");
                selection = scanner.nextInt();
            }

            // Consume the remaining newline character after reading the integer
            scanner.nextLine();

            // Create Player objects based on the selected game mode
            Player player1, player2;

            if (selection == 1) {
                // Human vs Human mode
                player1 = new HumanPlayer('X');
                player2 = new HumanPlayer('O');
            } else if (selection == 2) {
                // Human vs Computer mode
                player1 = new HumanPlayer('X');
                System.out.println("Choose Computer Type (1: Smart, 2: Regular):");
                int computerType = scanner.nextInt();

                // Validate computer type input
                while (computerType < 1 || computerType > 2) {
                    System.out.println("Invalid selection. Please enter 1 for smart computer or 2 for regular computer.");
                    computerType = scanner.nextInt();
                }

                scanner.nextLine(); // Consume remaining newline character
                player2 = (computerType == 1) ? new SmartComputerPlayer('O') : new ComputerPlayer('O');
            } else {
                // Computer vs Computer mode
                System.out.println("Choose Computer 1 Type (1: Smart, 2: Regular):");
                int computer1Type = scanner.nextInt();

                while (computer1Type < 1 || computer1Type > 2) {
                    System.out.println("Invalid selection. Please enter 1 for smart computer or 2 for regular computer.");
                    computer1Type = scanner.nextInt();
                }

                scanner.nextLine(); // Consume remaining newline character

                System.out.println("Choose Computer 2 Type (1: Smart, 2: Regular):");
                int computer2Type = scanner.nextInt();

                while (computer2Type < 1 || computer2Type > 2) {
                    System.out.println("Invalid selection. Please enter 1 for smart computer or 2 for regular computer.");
                    computer2Type = scanner.nextInt();
                }

                scanner.nextLine(); // Consume remaining newline character

                player1 = (computer1Type == 1) ? new SmartComputerPlayer('X') : new ComputerPlayer('X');
                player2 = (computer2Type == 1) ? new SmartComputerPlayer('O') : new ComputerPlayer('O');
            }

            // Create the game board and start the game
            int size = ExtendedBoard.getSize();
            int winCondition = ExtendedBoard.getWinCondition();
            ExtendedBoard board = new ExtendedBoard(size, winCondition);
            Game game = new Game(player1, player2, board);
            game.play();

            // Ask the user if they want to play again
            boolean validResponse = false;
            while (!validResponse) {
                System.out.println("Would you like to play again? (yes/no)");
                String response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("yes")) {
                    validResponse = true;
                    continuePlaying = true;
                } else if (response.equals("no")) {
                    validResponse = true;
                    System.out.println("Exiting the game...");
                    System.out.println("Thanks for playing Tic-Tac-Toe!");
                    continuePlaying = false;
                } else {
                    System.out.println("Invalid input! Please type 'yes' to continue playing or 'no' to exit.");
                    validResponse = false;
                }
            }
        }

        // Close the scanner to release resources
        scanner.close();
    }
}