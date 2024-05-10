package back.models;

public class Noeud implements Comparable <Noeud>{
    public String label; // exemple de label : "faire le devoir de RO"
    public String ID; // exemple de ID : A, B, C ....

    public Noeud (String label, String ID){
        this.label = label;
        this.ID = ID;
    }

    @Override
    public int compareTo(Noeud other) {
        return this.label.compareTo(other.label) + this.ID.compareTo(other.ID) ;
    }
}
