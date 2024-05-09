package main.java.back.models;

import java.util.ArrayList;
import java.util.List;

public class Graphe {
    public List<Noeud> noeuds = new ArrayList<>();;
    public List<Arrete> arretes = new ArrayList<>();
    // public boolean isOriented;
    public Graphe (){}

    // Faire un graphe a partir d'un fichier JSON
    //public 

    public void addNoeud (Noeud n){
        this.noeuds.add(n);       
    }

    public void addArrete (Arrete a){
        this.arretes.add(a);
    }
}
