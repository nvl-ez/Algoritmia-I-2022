package practica1.Clases_Abstractas;
import practica1.Clases.Listas.ListaAsignatura;
import practica1.Interficies.AccesoElemento;
/**
 *
 * @author Nahuel
 */
public abstract class Curso implements AccesoElemento<Curso>{
    //private lista asignaturas;
    private String nombre;
    private int codigo;
    private Curso seg;
    private ListaAsignatura listaAsignaturas;
    
    public Curso(String nombre, int codigo /*lista asignaturas*/){
        this.nombre = nombre;
        this.codigo = codigo;
        listaAsignaturas = new ListaAsignatura();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setSeg(Curso t){
        seg = t;
    }
    
    public Curso getSeg(){
        return seg;
    }
    
    public static boolean isAlphabeticFirst(Curso curso1, Curso curso2){
        char tempLetra1;
        char tempLetra2;
        for(int i = 0; i<curso1.getNombre().length() && i<curso2.getNombre().length(); i++){
            if(curso1.getNombre().charAt(i) >96){
                tempLetra1 = (char)(curso1.getNombre().charAt(i)-32);
            }
            else{
                tempLetra1 = curso1.getNombre().charAt(i);
            }
            if(curso2.getNombre().charAt(i) >96){
                tempLetra2 = (char)(curso2.getNombre().charAt(i)-32);
            }
            else{
                tempLetra2 = curso2.getNombre().charAt(i);
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
    
    public ListaAsignatura getAsignaturas(){
        return listaAsignaturas;
    }
    
    public void addAsignatura(Asignatura asignatura){
        listaAsignaturas.addElemento(asignatura);
    }
    
    public abstract String toString();
}
