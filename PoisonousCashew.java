/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

/**
 *
 * @author katejia
 */
public class PoisonousCashew extends Nut {
    private static final int NUTRITION_POINTS = -15;

    public PoisonousCashew(int row, int column) {
        super('C', row, column, NUTRITION_POINTS, "Poisonous Cashew");
    }
}
