package back.models;

public class MatriceAdjacence {
    public int[][] matrice; private boolean isOriented;

    public MatriceAdjacence(int taille, boolean isOriented) {
        this.matrice = new int[taille][taille];
        this.isOriented = isOriented;
        this.initialiserMatrice(0);
    }

    public void initialiserMatrice(int valeur) {
        for (int i = 0; i < this.matrice.length; i++) {
            for (int j = 0; j < this.matrice[i].length; j++) {
                this.matrice[i][j] = valeur;
            }
        }
    }    

    // Méthode pour ajouter une arête entre les nœuds u et v
    public void ajouterArete(int i, int j, int poids_ij, int poids_ji) {
        matrice[i][j] = poids_ij;
        if (this.isOriented){
            matrice[j][i] = poids_ji; 
        }else{
            matrice[j][i] = poids_ij;
        }
    }

    // Méthode pour supprimer une arête entre les nœuds u et v
    public void supprimerArete(int i, int j) {
        matrice[i][j] = 0;
        matrice[j][i] = 0; 
    }
    
    // Méthode pour vérifier si une arête existe entre les nœuds u et v
    public boolean areteExiste(int u, int v) {
        return matrice[u][v] > 1;
    }
}
