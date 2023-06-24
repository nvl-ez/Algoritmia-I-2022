package practica1.Clases;

import practica1.Clases_Abstractas.Asignatura;
import practica1.Enums.Tipo;


/**
 *
 * @author Nahuel
 */
public class Optativa extends Asignatura {
    private Tipo perfil;
    
    public Optativa(String nombre, int codigo, Tipo perfil){
        super(nombre, codigo);
        this.perfil = perfil;
    }
    
    public Tipo getTipo(){
        return perfil;
    }
    
    public String toString(){
        String nombrePerfil = "";
        switch(perfil){
            case practico:
                nombrePerfil = "practico";
                break;
            case teorico:
                nombrePerfil = "teorico";
                break;
        }
        
        return("Nombre: "+getNombre() + "   Codigo: "+ getCodigo()+"   Perfil: "+nombrePerfil+"\n");
    }
}
