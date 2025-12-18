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
        GrilleDeJeu game = new GrilleDeJeu(20,20,50);
        game.placerBombesAleatoirement();
        game.calculerBombesAdjacentes();
        game.revelerCellule(15, 5);
        System.out.println(game);
        
    }
   
}
