package practica1.Clases_Abstractas;
import practica1.Clases.Estudiante;
import practica1.Clases.Listas.ListaEstudiante;
import practica1.Interficies.AccesoElemento;
/**
 *
 * @author Nahuel
 */
public abstract class Asignatura implements AccesoElemento<Asignatura>{
    private String nombre;
    private int codigo;
    private Asignatura seg;
    private ListaEstudiante listaEstudiantes;
    
    
    public Asignatura(String nombre, int codigo){
        this.nombre = nombre;
        this.codigo = codigo;
        listaEstudiantes = new ListaEstudiante();
    }
    
    public String getNombre(){
        return nombre;
    }   
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setSeg(Asignatura t){
        seg = t;
    }
    
    public Asignatura getSeg(){
        return seg;
    }
    
    public static boolean isAlphabeticFirst(Asignatura asig1, Asignatura asig2){
        char tempLetra1;
        char tempLetra2;
        for(int i = 0; i<asig1.getNombre().length() && i<asig2.getNombre().length(); i++){
            if(asig1.getNombre().charAt(i) >96){
                tempLetra1 = (char)(asig1.getNombre().charAt(i)-32);
            }
            else{
                tempLetra1 = asig1.getNombre().charAt(i);
            }
            if(asig2.getNombre().charAt(i) >96){
                tempLetra2 = (char)(asig2.getNombre().charAt(i)-32);
            }
            else{
                tempLetra2 = asig2.getNombre().charAt(i);
            }
        
            if(tempLetra1<tempLetra2){
                return true;
            }
            else if(tempLetra1>tempLetra2){
                return false;
            }
        
        }
        return false;
    }
    
    public ListaEstudiante getEstudiantes(){
        return listaEstudiantes;
    }
    
    public void addEstudiante(Estudiante estudiante){
        listaEstudiantes.addElemento(estudiante);
    }
    
    public abstract String toString();
        
}
