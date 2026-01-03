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
    private Cellule[][] grille;
    private int nbBombes;
    private int nbvie;

    public GrilleDeJeu(int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.nbvie = 3;
        this.grille = new Cellule[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                grille[i][j] = new Cellule();
            }
        }
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

    public Cellule[][] getgrille() {
        return grille;
    }
    
    public String getValueCellule(int x , int y ){
        
        return grille[x][y] +"";
        
    }

    public void placerBombesAleatoirement() {
        int compteur = 0;
        while (compteur != nbBombes) {
            int j = (int) (Math.random() * nbColonnes);
            int i = (int) (Math.random() * nbLignes);
            while (grille[i][j].getPresenceBombe() == true) {
                i = (int) (Math.random() * nbColonnes);
                j = (int) (Math.random() * nbLignes);
            }
            grille[i][j].placerBombe();
            compteur++;
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
        int nb_bombe_devoile=0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (grille[i][j].getdevoilee() == true & getPresenceBombe(i, j) == true ) {
                    nb_bombe_devoile+=1;
                    
                }
                if (grille[i][j].getdevoilee() == true & getPresenceBombe(i, j) == false) {
                    nb += 1;
                }

            }
        }
        if (nb == val) {
            return "gagné";
        }
        if(nb_bombe_devoile==nbvie){
           return "perdu";
        }
        int resu=nbvie-nb_bombe_devoile;
        return resu+"" ;
        
        
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
        StringBuilder chaine = new StringBuilder();
        for (int i = 0; i < nbLignes; i++) {
            chaine.append("|");
            for (int j = 0; j < nbColonnes; j++) {
                 chaine.append(grille[i][j].toString()).append("|");
            }
            chaine.append("\n");
        }
        return chaine.toString();
    }

}
