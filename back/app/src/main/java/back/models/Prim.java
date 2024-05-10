package back.models;

import java.util.*;

public class Prim {
    public static LinkedList<Arret> primMST(Graphe graphe) {
        LinkedList<Arret> arbreCouvrantMinimal = new LinkedList<>();
        Set<Noeud> visite = new HashSet<>();
        PriorityQueue<Arret> fileDePriorite = new PriorityQueue<>();

        // On choisit arbitrairement le premier noeud comme point de départ
        Noeud premierNoeud = graphe.noeuds.get(0);
        visite.add(premierNoeud);

        // Ajoute toutes les arêtes incidentes du premier noeud à la file de priorité
        for (Arret arrete : graphe.arretes) {
            if (arrete.source == premierNoeud || arrete.target == premierNoeud) {
                fileDePriorite.offer(arrete);
            }
        }

        while (!fileDePriorite.isEmpty()) {
            Arret arreteMin = fileDePriorite.poll();
            Noeud u = arreteMin.source == premierNoeud ? arreteMin.target : arreteMin.source;

            if (!visite.contains(u)) {
                visite.add(u);
                arbreCouvrantMinimal.add(arreteMin);

                // Ajoute toutes les arêtes incidentes du noeud nouvellement visité
                for (Arret arrete : graphe.arretes) {
                    if (arrete.source == u || arrete.target == u) {
                        Noeud v = arrete.source == u ? arrete.target : arrete.source;
                        if (!visite.contains(v)) {
                            fileDePriorite.offer(arrete);
                        }
                    }
                }
            }
        }
        return arbreCouvrantMinimal;
    }
}
