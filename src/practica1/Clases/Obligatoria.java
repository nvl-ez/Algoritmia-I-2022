package practica1.Clases;

import practica1.Clases_Abstractas.Asignatura;

/**
 *
 * @author Nahuel
 */
public class Obligatoria extends Asignatura {
    private int creditos;
    
    public Obligatoria (String nombre, int codigo, int creditos){
        super(nombre, codigo);
        this.creditos = creditos;
    }
    
    public int getCreditos(){
        return creditos;
    }
    
    public String toString(){
        return ("Nombre: "+getNombre() + "   Codigo: "+ getCodigo()+"   Creditos: "+creditos+"\n");
    }
}
