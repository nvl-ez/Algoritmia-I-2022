package practica1.Clases.Listas;

import practica1.Clases_Abstractas.Asignatura;
import practica1.Interficies.AccesoListas;

/**
 *
 * @author Nahuel
 */
public class ListaAsignatura implements AccesoListas<Asignatura>{

    private Asignatura top;
    private int length;
    
    public ListaAsignatura(){
        top = null;
        length = 0;
    }
    
    @Override
    public void addElemento(Asignatura nuevaAsignatura) {
        length++;
        if(top != null){
            Asignatura temp1 = top;
            Asignatura temp2 = top;
            
            if(!Asignatura.isAlphabeticFirst(nuevaAsignatura, temp1)){
                while(temp1 != null && !Asignatura.isAlphabeticFirst(nuevaAsignatura, temp1)){
                    temp2=temp1;
                    temp1= temp1.getSeg();
                }
                nuevaAsignatura.setSeg(temp1);
                temp2.setSeg(nuevaAsignatura);
            }
            else{
                nuevaAsignatura.setSeg(top);
                top = nuevaAsignatura;
            }
            
        }
        else{
            top = nuevaAsignatura;
        }
    }

    @Override
    public void removeElemento(int i) {
        length--;
        Asignatura temp = top;
        if(i==0){
            top=temp.getSeg();
        }
        else{
            for(int j = 0; j<i-1; j++){
                temp = temp.getSeg();
            }
            temp.setSeg(temp.getSeg().getSeg());
        }
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getIndice(Asignatura t) {
            Asignatura temp = top;
            int i =0;
            while(!temp.getNombre().equals(t.getNombre())){
                i++;
                temp = temp.getSeg();
                if(temp==null){
                    return -1;
                }
            }
            return i;
    }

    @Override
    public Asignatura getElemento(int i) {
        Asignatura temp = top;
        for(int j = 0; j<i; j++){
            temp = temp.getSeg();
        }
        return temp;
    }
    
    @Override
    public String toString(){
        Asignatura temp = top;
        String value ="";
        while(temp!=null){
            value = value + temp.toString()+"\n";
            temp = temp.getSeg();
        }
        return value;
    }
    
    @Override
    public void removeAll(){
        top = null;
    }
}
