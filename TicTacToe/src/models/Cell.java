package models;

// ---------------------------
// Cell
// ---------------------------
public class Cell {
    private int row;
    private int column;
    private Symbol symbol;


    public Cell() { }

    public int getRow() { return 0; }

    public int getColumn() { return 0; }

    public Symbol getSymbol() { return this.symbol; }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}

