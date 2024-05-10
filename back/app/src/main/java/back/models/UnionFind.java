package back.models;

import java.util.*;

class UnionFind {
    Map<Noeud, Noeud> parent;

    public UnionFind() {
        parent = new HashMap<>();
    }

    public Noeud find(Noeud x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x); // Initialisation : chaque noeud est initialement son propre représentant
            return x;
        }

        Noeud root = x;
        while (root != parent.get(root)) {
            root = parent.get(root);
        }

        // Compression de chemin : mise à jour des parents de tous les nœuds visités
        while (x != root) {
            Noeud next = parent.get(x);
            parent.put(x, root);
            x = next;
        }

        return root;
    }

    public void union(Noeud x, Noeud y) {
        Noeud rootX = find(x);
        Noeud rootY = find(y);
        if (rootX != rootY) {
            parent.put(rootX, rootY); // Attache rootX à rootY
        }
    }
}

