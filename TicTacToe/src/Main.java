import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create symbols for players
        Symbol symbolX = new Symbol('X');
        Symbol symbolO = new Symbol('O');

        // Create players
        Player player1 = new Player("Player 1", symbolX);
        Player player2 = new Player("Player 2", symbolO);

        // Define board size (3x3)
        int boardSize = 3;
        Board board = new Board(boardSize);

        // Create game instance
        TicTacToeGame game = new TicTacToeGame(player1, player2, board);

        // Print initial status
        System.out.println("Game initialized. Status: " + game.getStatus());

        Scanner scanner = new Scanner(System.in);

        while(true){
            if(game.getStatus() == GameStatus.IN_PROGRESS){
                System.out.println(game.getCurrent().getName()+"'s turn");
                System.out.print("Enter row: ");
                int row = scanner.nextInt();

                System.out.print("Enter column: ");
                int col = scanner.nextInt();

                game.makeMove(row, col);
            }
            else if(game.getStatus() == GameStatus.WIN){
                System.out.println("Game Over! Status: " + " " + game.getCurrent().getName()+ " " + game.getStatus());
                break;
            }
            else {
                System.out.println("Game is a Draw!");
                break;
            }
        }

    }
}
