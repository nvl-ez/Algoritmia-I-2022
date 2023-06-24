package practica1.Clases;

import java.util.ArrayList;
import practica1.Interficies.AccesoElemento;

/**
 *
 * @author Nahuel
 */
public class Estudiante implements AccesoElemento<Estudiante>{
    private String nombre;
    private String DNI;
    private Estudiante seg;
    
    public Estudiante(String nombre, String DNI){
        this.nombre = nombre;
        this.DNI = DNI;
    }


    public String getNombre() {
        return nombre;
    }


    public String getDNI() {
        return DNI;
    }


    public void setSeg(Estudiante t) {
        seg = t;
    }
        


    public Estudiante getSeg() {
        return seg;
    }
    
    public String toString(){
        return("Nombre: "+getNombre() + "   DNI: "+ getDNI()+"\n");
    }
}
