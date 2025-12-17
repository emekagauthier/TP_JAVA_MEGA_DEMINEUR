/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_duo_mega_demineur;

/**
 *
 * @author emeka
 */
public class GrilleDeJeu {

    private Cellule[][] grille = new Cellule[10][10];
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;

    public int getNbLignes() {
        return nbLignes;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbBombes() {
        return nbBombes;
    }

    public void placerBombesAleatoirement() {
        int compteur = 1;
        while (compteur != nbBombes) {
            int i = (int) (Math.random() * nbColonnes);
            int j = (int) (Math.random() * nbLignes);
            while (grille[i][j].getPresenceBombe()==true) {
                i = (int)(Math.random() * nbColonnes);
                j = (int) (Math.random() * nbLignes);
            }
            grille[i][j].placerBombe();
        }

    }
}
