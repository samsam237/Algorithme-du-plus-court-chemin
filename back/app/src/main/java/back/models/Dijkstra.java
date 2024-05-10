package back.models;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Dijkstra {
    public static Map<String, Integer> dijkstra(Graphe G, Noeud s) {
        // Initialisation des distances et des prédécesseurs
        Map<Noeud, Integer> distances = new HashMap<>();
        Map<Noeud, Noeud> predecesseurs = new HashMap<>();
        for (Noeud n : G.noeuds) {
            distances.put(n, Integer.MAX_VALUE);
            predecesseurs.put(n, null);
        }
        distances.put(s, 0);

        // File de priorité pour sélectionner le prochain nœud à explorer
        PriorityQueue<Noeud> filePriorite = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        filePriorite.offer(s);

        while (!filePriorite.isEmpty()) {
            Noeud u = filePriorite.poll();
            for (Arret a : G.arretes) {
                if (a.source.equals(u)) {
                    Noeud v = a.target;
                    int poids = a.poids;
                    if (distances.get(v) > distances.get(u) + poids) {
                        distances.put(v, distances.get(u) + poids);
                        predecesseurs.put(v, u);
                        filePriorite.offer(v);
                    }
                }
            }
        }

        // Création et retour de la liste chaînée contenant les distances
        Map<String, Integer> distancesCourtes = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (Noeud n : G.noeuds) {
            try {
                distancesCourtes.put(objectMapper.writeValueAsString(n), distances.get(n));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return distancesCourtes;
    }
}
