/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Metier;

import javax.swing.JButton;

/**
 *
 * @author emeka
 */
public class JBouton_better extends JButton {

//Attribut
    
private int coordonne_x ;
private int coordonne_y ;
private Cellule C_reference;

    public JBouton_better(int coordonne_x, int coordonne_y, Cellule C_reference ) {
        this.coordonne_x = coordonne_x;
        this.coordonne_y = coordonne_y;
        this.C_reference = C_reference;
    }

    

}
