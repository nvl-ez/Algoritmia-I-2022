package practica1.Clases;

import practica1.Clases_Abstractas.Curso;
import practica1.Enums.Any;

/**
 *
 * @author Nahuel
 */
public class Batxiller extends Curso {
    Any any;
    public Batxiller(String nombre, int codigo, Any any){
        super(nombre, codigo);
        this.any=any;
    }
    
    public Any getAny(){
        return any;
    }
    
    @Override
    public String toString(){
        String nombreAny = "";
        switch(any){
            case primero:
                nombreAny = "Primero";
                break;
            case segundo:
                nombreAny = "Segundo";
                break;
        }
        
        return("Tipo: Batxiller   Nombre del Curso: "+getNombre() + "   Codigo: "+ getCodigo()+"   Año: "+nombreAny+"\n");
    }
}