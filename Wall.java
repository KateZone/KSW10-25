/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

/**
 *
 * @author katejia
 */
public class Wall extends Entity {
    public Wall(int row, int column) {
        super('*', row, column);
    }

    @Override
    public void create() {
        // No implementation needed for Wall
    }

    @Override
    public Entity put(int newRow, int newCol) {
        // Walls cannot be moved, so return the same wall entity
        return this;
    }
}
