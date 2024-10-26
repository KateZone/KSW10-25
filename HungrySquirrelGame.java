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
public class HungrySquirrelGame {

    private static Squirrel squirrel;
    private static Nut[] nuts;
    private static boolean gameOver;

    public static void main(String[] args) {
        initializeGame();
        playGame();
    }

    private static void initializeGame() {
        Maze.create("/Users/katejia/Desktop/Java/Maze.txt");

        Scanner scanner = new Scanner(System.in);
        int squirrelRow, squirrelColumn;

        do {
            System.out.print("Enter the Squirrel position (row, column): ");

            String input = scanner.nextLine();
            String[] positions = input.split(",");

            if (positions.length == 2) {
                try {
                    squirrelRow = Integer.parseInt(positions[0].trim());
                    squirrelColumn = Integer.parseInt(positions[1].trim());

                    if (Maze.available(squirrelRow, squirrelColumn)) {
                        System.out.println("User input accepted.");
                        break;
                    } else {
                        System.out.println("Position not available. Try again!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input format. Try again!");
                }
            } else {
                System.out.println("Invalid input format. Try again!");
            }
        } while (true);

        squirrel = new Squirrel(squirrelRow, squirrelColumn);
        nuts = new Nut[5]; // Fixed size of 5 for the nuts array

        // Randomly generate almonds
        int almondCount = 0;
        while (almondCount < 2) {
            int row = (int) (Math.random() * Maze.getRowCount());
            int col = (int) (Math.random() * Maze.getColumnCount());
            if (Maze.available(row, col)) {
                Nut almond = new Nut('A', row, col, 5, "Almond");
                Maze.getMaze()[row][col] = almond;
                nuts[almondCount] = almond;
                almondCount++;
            }
        }

        // Randomly generate peanuts
        int peanutCount = 0;
        while (peanutCount < 3) {
            int row = (int) (Math.random() * Maze.getRowCount());
            int col = (int) (Math.random() * Maze.getColumnCount());
            if (Maze.available(row, col)) {
                Nut peanut = new Nut('P', row, col, 10, "Peanut");
                Maze.getMaze()[row][col] = peanut;
                nuts[almondCount + peanutCount] = peanut;
                peanutCount++;
            }
        }

        gameOver = false;
    }

    private static void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            Maze.display();
            System.out.print("Enter command (u/d/l/r) to move Up, Down, Left, or Right: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.matches("[udlr]")) {
                char direction = input.charAt(0);
                squirrel.move(direction);
                checkGameOver();
            } else {
                System.out.println("Invalid command! Please try again.");
            }
        }
        scanner.close();
        System.out.printf("Squirrel successfully collected all the nuts. Total points: %d\n", squirrel.getPointsCollected());
        System.out.println("Thank you for playing this game!");
    }

    private static void checkGameOver() {
    if (squirrel.getTotalNutsEaten() == nuts.length) {
        gameOver = true;
        System.out.printf("Squirrel successfully collected all the nuts. Total points: %d\n",
                squirrel.getPointsCollected());
    } else if (squirrel.getPointsCollected() < 0) {
        gameOver = true;
        System.out.println("The squirrel ate a poisonous cashew and died! Game over.");
    }
}


}
