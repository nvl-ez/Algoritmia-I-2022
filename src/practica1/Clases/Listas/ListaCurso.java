package practica1.Clases.Listas;

import practica1.Clases_Abstractas.Curso;
import practica1.Interficies.AccesoListas;

/**
 *
 * @author Nahuel
 */
public class ListaCurso implements AccesoListas<Curso>{

    Curso top;
    private int length;
    
    public ListaCurso(){
        top = null;
        length = 0;
    }
    
    @Override
    public void addElemento(Curso nuevoCurso) {
        length++;
        if(top != null){
            Curso temp1 = top;
            Curso temp2 = top;
            
            if(!Curso.isAlphabeticFirst(nuevoCurso, temp1)){
                while(temp1 != null && !Curso.isAlphabeticFirst(nuevoCurso, temp1)){
                    temp2=temp1;
                    temp1= temp1.getSeg();
                }
                nuevoCurso.setSeg(temp1);
                temp2.setSeg(nuevoCurso);
            }
            else{
                nuevoCurso.setSeg(top);
                top = nuevoCurso;
            }
            
        }
        else{
            top = nuevoCurso;
        }
    }

    @Override
    public void removeElemento(int i) {
        length--;
        Curso temp = top;
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
    public int getIndice(Curso t) {
        Curso temp = top;
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
    public Curso getElemento(int i) {
        Curso temp = top;
        for(int j = 0; j<i; j++){
            temp = temp.getSeg();
        }
        return temp;
    }
    
    @Override
    public String toString(){
        Curso temp = top;
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
