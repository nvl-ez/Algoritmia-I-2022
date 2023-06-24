package algoritmia;

public class Node {
    private int info;
    private Node seg = null;
    
    //Contructors
    public Node(int info, Node seg){
        this.info = info;
        this.seg = seg;
    }
    
    public Node(){
        
    }
    
    //Canviar les dades del node
    public void setSeg(Node seg){
        this.seg = seg;
    }
    
    public void setInfo(int info){
        this.info = info;
    }
    
    //Obtenir les dades del node
    public Node getSeg(){
        return seg;
    }
    
    public int getInfo(){
        return info;
    }
    
    //Imprimir
    @Override
    public String toString(){
        if (seg != null){
        return info + ", ";
        }
        return  info + "";
    }
}
