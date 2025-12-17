/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class_Metier;

/**
 *
 * @author emeka
 */
public class Partie {
//Attributs
GrilleDeJeu partie ;

public void initialiserPartie(){
    partie.placerBombesAleatoirement();
    partie.calculerBombesAdjacentes();
}
public void tourDeJeu(int ligne, int colonne){
    partie.revelerCellule(ligne, colonne);
    
    
    
}
public String verifierVictoire(){
    return "";    
}

public void StartPartie(){
    initialiserPartie();
    
    
    
}


}
