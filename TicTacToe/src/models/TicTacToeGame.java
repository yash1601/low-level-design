package models;
// ---------------------------
// TicTacToeGame
// ---------------------------
public class TicTacToeGame {
    private Board board;
    private Player player1;
    private Player player2;
    private Player current;
    private GameStatus status;

    public TicTacToeGame(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.status = GameStatus.IN_PROGRESS;
        this.current = this.player1;
    }

    public void makeMove(int row, int col) {
        if (board.isValidMove(row, col) && status == GameStatus.IN_PROGRESS) {
            board.placeSymbol(row, col, current.getSymbol());
            // Check for win or draw conditions here and update status accordingly
            if (checkWinner(row, col)) {
                status = GameStatus.WIN;
            } else if (board.isFull()) {
                status = GameStatus.DRAW;

            }
            // Switch current player
            current = (current == player1) ? player2 : player1;
        }
        this.board.printBoard();
    }
    private boolean checkWinner(int row, int col) {
        // Implement win checking logic here
            char s = current.getSymbol().getRepresentation();
            int n = board.getSize();
            Cell[][] g = board.getGrid();

            // check row
            boolean win = true;
            for (int c = 0; c < n; c++) {
                if (g[row][c].getSymbol() == null || g[row][c].getSymbol().getRepresentation() != s) { win = false; break; }
            }
            if (win) return true;

            // check col
            win = true;
            for (int r = 0; r < n; r++) {
                if (g[r][col].getSymbol() == null || g[r][col].getSymbol().getRepresentation() != s) { win = false; break; }
            }
            if (win) return true;

            // check diagonal
            if (row == col) {
                win = true;
                for (int i = 0; i < n; i++) {
                    if (g[i][i].getSymbol() == null || g[i][i].getSymbol().getRepresentation() != s) { win = false; break; }
                }
                if (win) return true;
            }

            // check anti-diagonal
            if (row + col == n - 1) {
                win = true;
                for (int i = 0; i < n; i++) {
                    if (g[i][n - 1 - i].getSymbol() == null || g[i][n - 1 - i].getSymbol().getRepresentation() != s) { win = false; break; }
                }
                if (win) return true;
            }
        return false;
    }


    public GameStatus getStatus() { return this.status; }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player getCurrent() {
        return current;
    }

}


