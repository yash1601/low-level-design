package models;
// ---------------------------
// Board
// ---------------------------
public class Board {
    private Cell[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                this.grid[i][j] = new Cell();
            }
        }
    }

    public void placeSymbol(int row, int col, Symbol symbol) {
        this.grid[row][col].setSymbol(symbol);
    }


    public boolean isValidMove(int row, int col) { return true; }

    public Cell[][] getGrid() { return this.grid; }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(grid[i][j].getSymbol() == null){
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Symbol symbol = grid[i][j].getSymbol();
                System.out.print(symbol != null ? symbol.getRepresentation() : ".");
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < size - 1) {
                for (int k = 0; k < size; k++) {
                    System.out.print("---");
                    if (k < size - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
    }
}
