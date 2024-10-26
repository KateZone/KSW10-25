/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author katejia
 */
public class Maze {
    public static final int MAX_MAZE_ROW = 20;
    public static final int MAX_MAZE_COLUMN = 50;

    private static Entity[][] maze = new Entity[MAX_MAZE_ROW][MAX_MAZE_COLUMN];

    public static void create(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            int rowCount = 0;
            int columnCount = 0;

            while (scanner.hasNextLine() && rowCount < MAX_MAZE_ROW) {
                String line = scanner.nextLine();
                columnCount = Math.max(columnCount, line.length());
                rowCount++;
            }

            scanner.close();
            scanner = new Scanner(file);

            int row = 0;
            while (scanner.hasNextLine() && row < rowCount) {
                String line = scanner.nextLine();
                for (int col = 0; col < line.length() && col < columnCount; col++) {
                    char symbol = line.charAt(col);
                    if (symbol == '*') {
                        maze[row][col] = new Wall(row, col);
                    } else {
                        maze[row][col] = new EmptySpace(row, col);
                    }
                }
                row++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Maze file not found.");
        }
    }

    public static void display() {
        for (int row = 0; row < MAX_MAZE_ROW; row++) {
            for (int col = 0; col < MAX_MAZE_COLUMN; col++) {
                System.out.print(maze[row][col].getSymbol());
            }
            System.out.println();
        }
    }

    public static void setElement(int row, int col, char symbol) {
        if (isValidPosition(row, col)) {
            if (symbol == '*') {
                maze[row][col] = new Wall(row, col);
            } else {
                maze[row][col] = new EmptySpace(row, col);
            }
        }
    }

    public static boolean available(int row, int col) {
        // Check if the location at the given row and column is a blank space (empty)
        if (row >= 0 && row < MAX_MAZE_ROW && col >= 0 && col < MAX_MAZE_COLUMN) {
            return maze[row][col].getSymbol() == ' ';
        }
        return false;
    }

    public static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < MAX_MAZE_ROW && col >= 0 && col < MAX_MAZE_COLUMN;
    }

    public boolean isEmptySpace(int row, int col) {
        return isValidPosition(row, col) && maze[row][col] instanceof EmptySpace;
    }

    public static Entity[][] getMaze() {
        return maze;
    }

    public static int getRowCount() {
        return MAX_MAZE_ROW;
    }

    public static int getColumnCount() {
        return MAX_MAZE_COLUMN;
    }
}
