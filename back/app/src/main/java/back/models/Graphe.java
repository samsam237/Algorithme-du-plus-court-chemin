package back.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graphe {
    public LinkedList<Noeud> noeuds = new LinkedList<>();;
    public LinkedList<Arret> arretes = new LinkedList<>();
    public boolean isOriented = false;

    public Noeud getNoeudFromID(String noeudID) {
        for (Noeud n : this.noeuds) {
            if (n.ID.equals(noeudID)) {
                return n;
            }
        }
        return null;
    }
    
    public Graphe (){}


    // Faire un graphe a partir d'un fichier JSON
    //public 

    public void addNoeud (Noeud n){
        this.noeuds.add(n);       
    }

    public void addArrete (Arret a){
        this.arretes.add(a);
    }
}
