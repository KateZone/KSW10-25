/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

/**
 *
 * @author katejia
 */
public class EmptySpace extends Entity {
    public EmptySpace(int row, int column) {
        super(' ', row, column);
    }

    @Override
    public void create() {
        // No implementation needed for EmptySpace
    }

    @Override
    public Entity put(int newRow, int newCol) {
        Entity[][] maze = Maze.getMaze(); // Get the maze array using the getter method
        Entity replacedEntity = maze[newRow][newCol];
        maze[newRow][newCol] = this;
        setRow(newRow);
        setColumn(newCol);
        return replacedEntity;
    }
}

