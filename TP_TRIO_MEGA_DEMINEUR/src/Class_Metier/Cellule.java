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
public class Cellule {
// Attribut principaux Class Cellule 
private boolean Presence_Bombe;
private int nbBombesAdjacentes ;

private boolean Presence_Kit_deminage;

private boolean Desamorcé;

private boolean devoilee ;



public boolean getPresenceBombe(){
    return Presence_Bombe;
}
public boolean getPresenceKitdeminage(){
    return Presence_Kit_deminage;
}
public boolean getdesamorce(){
    return Desamorcé;
}
public int getNbBombesAdjacentes(){
    return nbBombesAdjacentes;
}
public boolean getdevoilee(){
    return devoilee;
}
//Méthode
public void placerBombe(){
    Presence_Bombe=true;
}

//Info kit de deminage

public void placerkit(){
    Presence_Kit_deminage=true;
}
public boolean useKit(int nb_kit){
    if(nb_kit==1){
        Desamorcé=true;
        Presence_Bombe=false;
        return true;
    }
    return false ; 
}
public void revelerCellule(){
    devoilee=true;
}
public void setNbBombesAdjacentes(int nb_Bombe){
    nbBombesAdjacentes=nb_Bombe ;
}

    @Override
    public String toString() {
        if (devoilee==false){
            return "?";
        }
        if (Presence_Bombe==true && devoilee==true ){
            return "B";
        }
        if(Presence_Kit_deminage == true && devoilee == true) {
           return"K";
        }
        if( Desamorcé == true && devoilee == true) {
           return"D";
        }
        if (nbBombesAdjacentes>0 && devoilee==true && Presence_Bombe==false && Presence_Kit_deminage == false && Desamorcé == false ){
            return Integer.toString(nbBombesAdjacentes) ;
        }
        if(devoilee==true && Presence_Bombe==false && nbBombesAdjacentes==0 && Presence_Kit_deminage == false && Desamorcé == false ){
           return " "; 
        }
        return"probleme";
    }

}
