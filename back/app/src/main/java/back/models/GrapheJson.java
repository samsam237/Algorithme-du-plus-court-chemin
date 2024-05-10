package back.models;

import java.util.*;

import back.models.Arret;

public class GrapheJson {
    public boolean isOriented;
    public List<NoeudJson> nodes;
    public List<ArretJson> arrets;

    public Graphe createGraphe(){
        Graphe g = new Graphe();
        Noeud n_source, n_target;

        g.isOriented = this.isOriented;
        for (NoeudJson nj : nodes){
            g.addNoeud(nj.createNoeud());
        }
        
        for (ArretJson aj : arrets){
            n_source = g.getNoeudFromID(aj.source); n_target = g.getNoeudFromID(aj.target);
            if (n_source != null && n_target != null){
                g.addArrete(new Arret(n_source, n_target, aj.poids));
            } 
        }

        return g;
    }
}
