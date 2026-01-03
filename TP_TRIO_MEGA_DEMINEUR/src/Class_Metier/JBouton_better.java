/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Metier;

import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author emeka
 */
public class JBouton_better extends JButton {

//Attribut
    private int coordonne_x;
    private int coordonne_y;
    private Cellule C_reference;

    public JBouton_better(int coordonne_x, int coordonne_y, Cellule C_reference) {
        this.coordonne_x = coordonne_x;
        this.coordonne_y = coordonne_y;
        this.C_reference = C_reference;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (C_reference.getdevoilee() == false) {
            setText("?");
        }
        if (C_reference.getPresenceBombe() == true && C_reference.getdevoilee() == true) {
            setText("B");
        }
        if(C_reference.getPresenceKitdeminage() == true && C_reference.getdevoilee() == true) {
            setText("K");
        }
        if(C_reference.getdesamorce() == true && C_reference.getdevoilee() == true) {
            setText("D");
        }
        if (C_reference.getNbBombesAdjacentes() > 0 && C_reference.getdevoilee() == true && C_reference.getPresenceBombe() == false && C_reference.getPresenceKitdeminage() == false && C_reference.getdesamorce() == false ) {
            setText(Integer.toString(C_reference.getNbBombesAdjacentes()));
        }
        if (C_reference.getdevoilee() == true && C_reference.getPresenceBombe() == false && C_reference.getNbBombesAdjacentes() == 0 && C_reference.getPresenceKitdeminage() == false && C_reference.getdesamorce() == false) {
            setText("");
        }

    }

}
