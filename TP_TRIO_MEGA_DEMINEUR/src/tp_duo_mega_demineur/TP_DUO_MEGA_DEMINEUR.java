/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp_duo_mega_demineur;

import Class_Metier.Cellule;
import Class_Metier.GrilleDeJeu;

/**
 *
 * @author emeka
 */
public class TP_DUO_MEGA_DEMINEUR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GrilleDeJeu game = new GrilleDeJeu(10,10,10);
        game.placerBombesAleatoirement();
        game.calculerBombesAdjacentes();
        game.revelerCellule(0, 0);
        System.out.println(game);
        
    }
   
}
