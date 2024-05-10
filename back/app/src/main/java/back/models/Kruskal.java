package back.models;

import java.util.Collections;
import java.util.LinkedList;

import back.models.UnionFind;
import back.models.Arret;

public class Kruskal {
    public static LinkedList<Arret> kruskalMST(LinkedList<Arret> arretes) {
        LinkedList<Arret> arbreCouvrantMinimal = new LinkedList<>();
        UnionFind unionFind = new UnionFind();

        // Trie les arêtes par poids croissant
        Collections.sort(arretes);

        for (Arret arrete : arretes) {
            Noeud rootDebut = unionFind.find(arrete.source);
            Noeud rootFin = unionFind.find(arrete.target);

            // Vérifie si l'ajout de cette arête crée un cycle
            if (rootDebut != rootFin) {
                arbreCouvrantMinimal.add(arrete);
                unionFind.union(rootDebut, rootFin);
            }
        }
        return arbreCouvrantMinimal;
    }
}
