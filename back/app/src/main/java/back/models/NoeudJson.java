package back.models;

public class NoeudJson {
    public String id;
    public String label;

    public Noeud createNoeud (){
        Noeud n = new Noeud(label, id);
        return n;
    }
}
