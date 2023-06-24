package algoritmia;

public class Apuntador {
    private Node apuntat;
    
    //Metode constructor
    public Apuntador(Node node){
        apuntat = node;
    }
    
    public Apuntador(){
        apuntat = null;
    }
    
    //Obtenir a quin node apunta l'apuntador
    public Node getSeg(){
        return apuntat;
    }
    
    //Canviar el node al qual apunta l'apuntador
    public void setSeg(Node node){
        apuntat = node;
    }
    
    //Imprimir
    @Override
    public String toString(){
        Apuntador aux = new Apuntador(getSeg());
        String s = "[";
        while (aux.getSeg() != null){
            s += aux.getSeg().toString();
            aux.setSeg(aux.getSeg().getSeg());
        }
        return s + "]";
    }
}
