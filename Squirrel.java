/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.util.Scanner;

/**
 *
 * @author katejia
 */
public class Squirrel {
    private int row;
    private int column;
    private int pointsCollected;
    private int totalNutsEaten;

    public Squirrel(int row, int column) {
        this.row = row;
        this.column = column;
        this.pointsCollected = 0;
        this.totalNutsEaten = 0;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPointsCollected() {
        return pointsCollected;
    }

    public int getTotalNutsEaten() {
        return totalNutsEaten;
    }

    public void move(char direction) {
        int newRow = row;
        int newColumn = column;

        switch (direction) {
            case 'u':
                newRow--;
                break;
            case 'd':
                newRow++;
                break;
            case 'l':
                newColumn--;
                break;
            case 'r':
                newColumn++;
                break;
            default:
                System.out.println("Invalid direction!");
                return;
        }

        if (Maze.isValidPosition(newRow, newColumn)) {
            Entity destinationEntity = Maze.getMaze()[newRow][newColumn];
            if (destinationEntity instanceof Nut) {
                Nut nut = (Nut) destinationEntity;
                pointsCollected += nut.getNutritionPoints();
                totalNutsEaten++;
                Maze.setElement(newRow, newColumn, ' '); // Remove the eaten nut from the maze
            } else if (destinationEntity instanceof EmptySpace) {
                Maze.setElement(row, column, ' '); // Clear the current position
                Maze.setElement(newRow, newColumn, '@'); // Update the new position with the squirrel
            } else {
                System.out.println("Cannot move into a wall!");
                return;
            }

            // Update the squirrel's position
            row = newRow;
            column = newColumn;
        } else {
            System.out.println("Invalid move! Out of bounds.");
        }
    }
}
