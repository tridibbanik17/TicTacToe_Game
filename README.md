<div align="center">

<h3 align="center">Tic-Tac-Toe Game</h3>

  <p align="center">
    A Tic-Tac-Toe game with customizable board sizes and different game modes.
    <br />
     <a href="https://github.com/tridibbanik17/tictactoe_game">github.com/tridibbanik17/tictactoe_game</a>
  </p>
</div>

## Table of Contents

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#key-features">Key Features</a></li>
      </ul>
    </li>
    <li><a href="#architecture">Architecture</a></li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

## About The Project

This repository contains two versions of the classic Tic-Tac-Toe game implemented in Java: `TicTacToeGame` and `TicTacToeGameExtended`.

`TicTacToeGame` provides a standard 3x3 Tic-Tac-Toe board with three game modes: Human vs Human, Human vs Computer, and Computer vs Computer. The computer player has two difficulty levels: regular (random moves) and smart (strategic moves).

`TicTacToeGameExtended` allows for a customizable board size (from 3x3 to 20x20) and win condition (number of consecutive markers required to win). It also includes the same game modes and computer player types as the standard version.

### Key Features

- **Multiple Game Modes:** Human vs Human, Human vs Computer (with regular and smart AI), and Computer vs Computer (with configurable AI types).
- **Configurable Board Size (Extended Version):** Choose a board size between 3x3 and 20x20.
- **Configurable Win Condition (Extended Version):** Set the number of consecutive markers needed to win.
- **Smart Computer Player:** Uses a strategic AI to block the opponent and win the game.
- **Clear and Concise Code:** Well-documented and easy-to-understand Java code.

## Architecture

The project is structured into two main modules:

- **TicTacToeGame:** Contains the core game logic for the standard 3x3 board.
    - Key classes: `Board`, `ComputerPlayer`, `ExtendedBoard`, `Game`, `HumanPlayer`, `Main`, `Player`, `SmartComputerPlayer`.
- **TicTacToeGameExtended:** Contains the extended game logic with customizable board size and win condition.
    - Key classes: `Board`, `ComputerPlayer`, `ConfigurableBoard`, `ExtendedBoard`, `Game`, `HumanPlayer`, `Main`, `Player`, `SmartComputerPlayer`.

Both modules share a similar architecture, with the following key components:

- **Board:** Represents the game board and handles marker placement and display.
- **Player:** An abstract class representing a player (Human or Computer).
- **HumanPlayer:** Implements a human player that takes input from the console.
- **ComputerPlayer:** Implements a computer player that makes random moves.
- **SmartComputerPlayer:** Implements a computer player that uses a strategic AI.
- **Game:** Manages the game flow, handles player turns, and determines the winner or a draw.
- **Main:** Contains the main game loop, handles user input, and sets up the game.

The `TicTacToeGameExtended` module also includes the `ConfigurableBoard` class, which extends the `ExtendedBoard` class and allows for customizable board size and win condition.

The project uses Maven for dependency management and building. The `pom.xml` file in each module defines the project dependencies and build configuration.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
  ```sh
  sudo apt install openjdk-17-jdk # Example for Debian/Ubuntu
  ```
- Maven
  ```sh
  sudo apt install maven # Example for Debian/Ubuntu
  ```

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/tridibbanik17/tictactoe_game.git
   ```
2. Navigate to the desired module directory (TicTacToeGame or TicTacToeGameExtended):
   ```sh
   cd tictactoe_game/TicTacToeGame
   ```
   or
   ```sh
   cd tictactoe_game/TicTacToeGameExtended
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```
4. Run the game:
   ```sh
   java -cp target/TicTacToeGame-1.0-SNAPSHOT.jar three_by_three_board.Main
   ```
   or
   ```sh
   java -cp target/TicTacToeGameExtended-1.0-SNAPSHOT.jar extendedboard_package.Main
   ```

## Acknowledgments

- This project was inspired by the classic Tic-Tac-Toe game.
