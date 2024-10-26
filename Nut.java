/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

/**
 *
 * @author katejia
 */

public class Nut extends Entity {
    private static int totalNuts;
    private int nutritionPoints;
    private String name;

    public Nut(char nut, int row, int column, int nutritionPoints, String name) {
        super(nut, row, column);
        this.nutritionPoints = nutritionPoints;
        this.name = name;
        totalNuts++;
    }

    @Override
    public void create() {
        // No implementation needed for Nut
    }

    public int getNutritionPoints() {
        return nutritionPoints;
    }

    public String getName() {
        return name;
    }

    @Override
    public Entity put(int newRow, int newCol) {
        Entity[][] mazeArray = Maze.getMaze(); // Retrieve the maze array
        Entity replacedEntity = mazeArray[newRow][newCol];
        mazeArray[newRow][newCol] = this;
        setRow(newRow);
        setColumn(newCol);
        return replacedEntity;
    }

    public static int getTotalNuts() {
        return totalNuts;
    }
}
