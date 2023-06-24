package practica1.Clases.Listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import practica1.Clases.Estudiante;
import practica1.Interficies.AccesoListas;

/**
 *
 * @author Nahuel
 */
public class ListaEstudiante implements AccesoListas<Estudiante>{

    private ArrayList<Estudiante> list;
    
    public ListaEstudiante(){
        list = new ArrayList<Estudiante>();
        Collections.sort(list, Comparator.comparing(Estudiante::getNombre));
    }

    @Override
    public void addElemento(Estudiante t) {
        list.add(t);
    }

    @Override
    public void removeElemento(int i) {
        list.remove(i);
    }

    @Override
    public int getLength() {
        return list.size();
    }

    @Override
    public int getIndice(Estudiante t) {
        return list.indexOf(t);
    }

    @Override
    public Estudiante getElemento(int i) {
        return list.get(i);
    }
    
    @Override
    public String toString(){
        String valor = "";
        for(int i = 0; i<list.size(); i++){
            valor = valor + list.get(i).toString();
        }
        return valor;
    }
    
    @Override
    public void removeAll(){
        list.removeAll(list);
    }

}
