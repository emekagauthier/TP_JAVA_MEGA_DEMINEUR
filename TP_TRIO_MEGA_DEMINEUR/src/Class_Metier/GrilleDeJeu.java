/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Metier;

import Class_Metier.Cellule;

/**
 *
 * @author emeka
 */
public class GrilleDeJeu {

    private int nbLignes;
    private int nbColonnes;
    Cellule[][] grille = new Cellule[nbLignes][nbColonnes];
    private int nbBombes;

    public GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.grille = new Cellule[nbLignes][nbColonnes];
    }

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
            while (grille[i][j].getPresenceBombe() == true) {
                i = (int) (Math.random() * nbColonnes);
                j = (int) (Math.random() * nbLignes);
            }
            grille[i][j].placerBombe();
        }
    }

    public void calculerBombesAdjacentes() {
        for (int x = 0; x < nbLignes; x++) {
            for (int y = 0; y < nbColonnes; y++) {

                if (grille[x][y].getPresenceBombe()) {

                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {

                            // ignorer la case de la bombe elle-même
                            if (dx == 0 && dy == 0) {
                                continue;
                            }

                            int nx = x + dx;
                            int ny = y + dy;

                            // vérifier les limites
                            if (nx >= 0 && nx < nbLignes
                                    && ny >= 0 && ny < nbColonnes
                                    && !grille[nx][ny].getPresenceBombe()) {

                                grille[nx][ny].setNbBombesAdjacentes(grille[nx][ny].getNbBombesAdjacentes() + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean getPresenceBombe(int i, int j) {
        return grille[i][j].getPresenceBombe();
    }

    public String toutesCellulesRevelees() {
        int val = (nbLignes * nbColonnes) - nbBombes;
        int nb = 0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (grille[i][j].getdevoilee() == true & getPresenceBombe(i, j) == true) {
                    return "perdu";
                }
                if (grille[i][j].getdevoilee() == true & getPresenceBombe(i, j) == false) {
                    nb += 1;
                }

            }
        }
        if (nb == val) {
            return "gagné";
        }
        return "pas fini";
    }

    //Methode Reveler Cellule
    public void revelerCellule(int ligne, int colonne) {
        if (grille[ligne][colonne].getdevoilee() == true) {
            //case deja devoilé
        } else {
            grille[ligne][colonne].revelerCellule();
            if (getPresenceBombe(ligne, colonne) == true) {
                //j'ai perdu mais quoi envoyer comme signal 

            }
            if (getPresenceBombe(ligne, colonne) == false && grille[ligne][colonne].getNbBombesAdjacentes() == 0) {

                //Case a Gauche
                if ((colonne - 1) >= 0) {
                    revelerCellule(ligne, colonne - 1);
                }
                // Case a Droite
                if ((colonne + 1) < nbColonnes) {
                    revelerCellule(ligne, colonne + 1);
                }
                //En haut 
                if ((ligne - 1) >= 0) {
                    revelerCellule(ligne - 1, colonne);
                }
                //En bas
                if ((ligne + 1) < nbLignes) {
                    revelerCellule(ligne + 1, colonne);
                }
                //En haut a gauche
                if ((ligne - 1) >= 0 && (colonne - 1) >= 0) {
                    revelerCellule(ligne - 1, colonne - 1);
                }
                //En bas a droite
                if ((ligne + 1) < nbLignes && (colonne + 1) < nbColonnes) {
                    revelerCellule(ligne + 1, colonne + 1);
                }
                //En haut a Droite
                if ((ligne - 1) >= 0 && (colonne + 1) < nbColonnes) {
                    revelerCellule(ligne - 1, colonne + 1);
                }
                //En bas à Gauche
                if ((ligne + 1) < nbLignes && (colonne - 1) >= 0) {
                    revelerCellule(ligne + 1, colonne - 1);
                }

            }

        }
    }

    @Override
    public String toString() {
        String r = super.toString();
        String chaine = "|";
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (j != nbColonnes) {
                    chaine += r;
                } else {
                    chaine += "|\n";
                }
            }
        }
        return chaine;
    }

}
