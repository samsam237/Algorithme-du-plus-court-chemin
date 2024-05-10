package back.models;

public class Arret implements Comparable <Arret> {
    public Noeud source, target;
    public int poids;

    public Arret (Noeud source, Noeud target, int poids){
        this.source = source; this.target = target; this.poids = poids;
    }    

    @Override
    public int compareTo(Arret other) {
        return Integer.compare(this.poids, other.poids) ;
    }
}
