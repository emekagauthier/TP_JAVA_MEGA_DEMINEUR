/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_duo_mega_demineur;

/**
 *
 * @author emeka
 */
public class Cellule {
// Attribut principaux Class Cellule 
private boolean Presence_Bombe;
private boolean devoilee ;
private int nbBombesAdjacentes ;

public boolean getPresenceBombe(){
    return Presence_Bombe;
}

public int getNbBombesAdjacentes(){
    return nbBombesAdjacentes;
}

//Méthode
public void placerBombe(){
    Presence_Bombe=true;
}
public void revelerCellule(){
    devoilee=true;
}

    @Override
    public String toString() {
        if (devoilee==false){
            return "?";
        }
        if (Presence_Bombe==true && devoilee==true ){
            return "B";
        }
        return "";
    }

}
