/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

/**
 *
 * @author katejia
 */
public abstract class Entity {
    protected char symbol;
    protected int row;
    protected int column;

    public Entity(char symbol, int row, int column) {
        this.symbol = symbol;
        this.row = row;
        this.column = column;
    }

    public abstract void create();

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public abstract Entity put(int newRow, int newCol);
}
