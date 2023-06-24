package practica1.Clases;

import practica1.Clases_Abstractas.Curso;
import practica1.Enums.Especialidad;

/**
 *
 * @author Nahuel
 */
public class Fp extends Curso {
    Especialidad especialidad;
    public Fp(String nombre, int codigo, Especialidad especialidad){
        super(nombre, codigo);
        this.especialidad = especialidad;
    }
    
    public Especialidad getEspecialidad(){
        return especialidad;
    }
    
    @Override
    public String toString(){
        String nombreEspecialidad = "";
        switch(especialidad){
            case mecanica:
                nombreEspecialidad = "Mecanica";
                break;
            case electronica:
                nombreEspecialidad = "Electronica";
                break;
            case informatica:
                nombreEspecialidad = "Informatica";
                break;
        }
        
        return("Tipo: FP   Nombre del Curso: "+getNombre() + "   Codigo:"+ getCodigo()+"   Especialidad:"+nombreEspecialidad+"\n");
    }
}