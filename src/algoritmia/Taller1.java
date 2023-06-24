package algoritmia;

import java.util.Scanner;

public class Taller1 {

    public static void main(String[] args) {
        new Taller1().index();
    }
    public void index(){
        boolean acabat = false;
        while (!acabat){
            System.out.print("Selecciona exercici a corregir:\n"
                    + "1) Exercici 1\n"
                    + "2) Exercici 2\n"
                    + "3) Exercici 3\n"
                    + "4) Exercici 4\n"
                    + "5) Acabar execució del programa\n\n"
                    + "Selecció: ");
            int exercici = new Scanner(System.in).nextInt();
            switch (exercici){
                case 1:
                    System.out.println("\n\n\n");
                    exercici1();
                    System.out.println("\n\n\n");
                    break;
                case 2:
                    System.out.println("\n\n\n");
                    exercici2();
                    System.out.println("\n\n\n");
                    break;
                case 3:
                    System.out.println("\n\n\n");
                    exercici3();
                    System.out.println("\n\n\n");
                    break;
                case 4:
                    System.out.println("\n\n\n");
                    exercici4();
                    System.out.println("\n\n\n");
                    break;
                default:
                    acabat = true;
                    break;
            }
        }
    }
    
    //Programa per a l'exercici 1
    public Apuntador exercici1(){
        boolean acabat = false;
        //Cream l'apuntador principal anomenat capçalera que apuntarà a l'inici 
        //de la llista
        Apuntador capçalera = new Apuntador(new Node());
        //Cream un apuntador temporal que apunti al mateix node inicial que capçalera
        Apuntador temp = new Apuntador(capçalera.getSeg());
        while(!acabat){
            //Demanam l'enter del node següent
            System.out.print("Introdueix un nombre: ");
            int info = new Scanner(System.in).nextInt();
            temp.getSeg().setInfo(info);
            boolean accions = true;
            //Demanam a l'usuari si vol seguir afegint nombres, si vol acabar o
            //si ho vol imprimir (després d'imprimir-ho tornarà a fer la pregunta)
            while (accions){
                System.out.print("Vols afegir nombres, has acabat o ho vols "
                        + "imprimir?\n"
                        + "1) Afegir nombre\n"
                        + "2) Imprimir llista\n"
                        + "3) Acabar\n\n"
                        + "Selecció: ");
                int accio = new Scanner(System.in).nextInt();
                switch(accio){
                    case 1:
                        accions = false;
                        break;
                    case 2:
                        System.out.println("Llista actual: " + capçalera + "\nPitja "
                                + "ENTER per continuar...");
                        new Scanner(System.in).nextLine();
                        break;
                    default:
                        acabat = true;
                        accions = false;
                        break;
                }
            }
            //Si no hem acabat d'afegir nombres cream un node pel següent nombre
            //i hi apuntam l'apuntador temporal
            if (!acabat){
                temp.getSeg().setSeg(new Node());
                temp.setSeg(temp.getSeg().getSeg());
            }
        }
        //Retornam l'apuntador capçalera per si utilitzam aques exercici per a 
        //generar una llista als següents exercicis
        return capçalera;
    }
    
    //Programa per a l'exercici 2
    public void exercici2(){
        boolean acabat = false;
        Apuntador capçalera = new Apuntador();
        Apuntador brossa = new Apuntador(new Node());
        Apuntador temp2 = null;
        int c = 0;
        while (!acabat){
            System.out.print("Que vols fer?\n"
                    + "1) Nova llista\n"
                    + "2) Eliminar dada\n"
                    + "3) Imprimir llista\n"
                    + "4) Llista de fems\n"
                    + "5) Acabar l'execució de l'exercici 2\n\n"
                    + "Selecció: ");
            int seleccio = new Scanner(System.in).nextInt();
            switch(seleccio){
                case 1:
                    System.out.print("\n");
                    capçalera = exercici1();
                    temp2 = new Apuntador(brossa.getSeg());
                    c = 0;
                    break;
                case 2:
                    Apuntador temp = new Apuntador(capçalera.getSeg());
                    if (capçalera.getSeg() == null){
                        System.out.println("No hi ha cap llista introduida!");
                    } else {
                        System.out.print("Dada a eliminar: ");
                        int n = new Scanner(System.in).nextInt();
                        boolean trobat = false;
                        //Comprova que el 1r element no sigui la dada cercada
                        if (temp.getSeg().getInfo() == n){
                            //Si ho és, l'eliminarà i la mourà a la llista de brossa
                            temp2.getSeg().setSeg(temp.getSeg());
                            capçalera.setSeg(temp.getSeg().getSeg());
                            temp.setSeg(temp.getSeg().getSeg());
                            temp2.getSeg().getSeg().setSeg(null);
                            temp2.setSeg(temp2.getSeg().getSeg());
                            trobat = true;
                            c++;
                        }
                        //Comprova que la resta d'elements no siguin la dada cercada
                        if (!trobat && temp.getSeg() != null){
                            while(temp.getSeg().getSeg() != null){
                                //Comprova node a node que la dada no coïncidesqui
                                if (temp.getSeg().getSeg().getInfo() == n){
                                    //Si coïncideix, l'eliminarà i la mourà a la llista 
                                    //de brossa
                                    trobat = true;
                                    temp2.getSeg().setSeg(temp.getSeg().getSeg());
                                    if (temp.getSeg().getSeg().getSeg() != null){
                                        temp.getSeg().setSeg(temp.getSeg().getSeg().getSeg());
                                    } else {
                                        //En cas de que sigui la darrera de la llista
                                        temp.getSeg().setSeg(null);
                                    }
                                    temp2.getSeg().getSeg().setSeg(null);
                                    temp.setSeg(temp.getSeg().getSeg());
                                    temp2.setSeg(temp2.getSeg().getSeg());
                                    c++;
                                } else {
                                    //En cas de que no la trobi
                                    temp.setSeg(temp.getSeg().getSeg());
                                }
                                //Si la dada eliminada es la darrera finalitzarà
                                if (temp.getSeg() == null) break;
                            }
                        }
                        if (!trobat){
                            System.out.println("La dada no s'ha trobat!");
                        } else{
                            if (c == 1) brossa.setSeg(brossa.getSeg().getSeg());
                            System.out.println("La dada s'ha elminat!");
                        }
                    }
                    break;
                case 3:
                    if (capçalera.getSeg() != null){
                        System.out.println("Llista actual: " + capçalera + "\nPitja"
                                + " ENTER per continuar...");
                    } else {
                        System.out.println("La llista és buida!");
                    }
                    new Scanner(System.in).nextLine();
                    break;
                case 4:
                    if (brossa.getSeg() != null){
                        System.out.println("Llista actual: " + brossa + "\nPitja"
                                + " ENTER per continuar...");
                    } else {
                        System.out.println("La llista és buida!");
                    }
                    new Scanner(System.in).nextLine();
                    break;
                default:
                    acabat = true;
                    break;
            }
            System.out.print("\n\n");
        }
    }
    
    //Programa per a l'exercici 3
    public void exercici3(){
        boolean acabat = false;
        Apuntador capçalera = new Apuntador();
        Apuntador temp = null;
        Apuntador aux = new Apuntador();
        while (!acabat){
            //Menu de selecció d'acció
            System.out.print("Que vols fer?\n"
                    + "1) Nova llista\n"
                    + "2) Afegir nombre\n"
                    + "3) Imprimir llista\n"
                    + "4) Acabar l'execució de l'exercici 3\n\n"
                    + "Selecció: ");
            int seleccio = new Scanner(System.in).nextInt();
            //Opció seleccionada
            switch(seleccio){
                //Crear una nova llista
                case 1:
                    System.out.print("\n");
                    capçalera = exercici1();
                    break;
                // Introduir un nombre a una llista creada
                case 2:
                    boolean afegit = false;
                    if (capçalera.getSeg() != null){
                        temp = new Apuntador(capçalera.getSeg());
                        System.out.print("Nombre a introduir: ");
                        //Llegeix el nombre itroduït
                        int n = new Scanner(System.in).nextInt();
                        //Cas 1r nombre
                        if(capçalera.getSeg().getInfo() < n){
                            capçalera.setSeg(new Node(n, temp.getSeg()));
                            afegit = true;
                        }
                        //Cas altre nombre
                        while(temp.getSeg() != null && !afegit){
                            if (temp.getSeg().getInfo() < n){
                                aux.getSeg().setSeg(new Node(n, temp.getSeg()));
                                afegit = true;
                            }
                            aux = new Apuntador(temp.getSeg());
                            temp.setSeg(temp.getSeg().getSeg());
                        }
                        //Cas darrer nombre
                        if(!afegit){
                            aux.getSeg().setSeg(new Node(n, null));
                        }
                        //Missatge de que l'exercici s'ha completat
                        if (afegit){
                            System.out.println("Nombre " + n + " introduit");
                        }
                    } else {
                        System.out.println("La llista no existeix.");
                    }
                    break;
                //Mostra la llista per consola
                case 3:
                    if (capçalera.getSeg() != null){
                        System.out.println("Llista actual: " + capçalera + "\nPitja"
                                + " ENTER per continuar...");
                    } else {
                        System.out.println("La llista és buida!");
                    }
                    new Scanner(System.in).nextLine();
                    break;
                //Per defecte finalitzarà el bucle
                default:
                    acabat = true;
                    break;
            }
            System.out.println("\n\n");
        }
    }
    
    //Programa per a l'exercici 4
    public void exercici4(){
        boolean acabat = false;
        Apuntador capçalera = new Apuntador();
        Apuntador temp = null;
        Apuntador aux = new Apuntador();
        while (!acabat){
            //Menu de selecció d'acció
            System.out.print("Que vols fer?\n"
                    + "1) Nova llista\n"
                    + "2) Eliminar una posició\n"
                    + "3) Imprimir llista\n"
                    + "4) Acabar l'execució de l'exercici 4\n\n"
                    + "Selecció: ");
            int seleccio = new Scanner(System.in).nextInt();
            switch (seleccio){
                //Crea una nova llista
                case 1:
                    capçalera = exercici1();
                    System.out.print("\n");
                    break;
                //Elimina la posició introduida per paràmetre
                case 2:
                    if (capçalera.getSeg() != null){
                        temp = new Apuntador(capçalera.getSeg());
                        System.out.print("Posició a eliminar: ");
                        int k = new Scanner(System.in).nextInt();
                        int contador = 1;
                        boolean eliminat = false;
                        //Cas del 1r nombre
                        if (k == 1){
                            capçalera.setSeg(capçalera.getSeg().getSeg());
                            eliminat = true;
                        }
                        while (temp.getSeg() != null && contador <= k && !eliminat){
                            if (contador == k){
                                aux.getSeg().setSeg(temp.getSeg().getSeg());
                                eliminat = true;
                            }
                            contador += 1;
                            if (!eliminat){
                                aux = new Apuntador(temp.getSeg());
                                temp.setSeg(temp.getSeg().getSeg());
                            }
                        }
                        if (!eliminat && contador + 1 == k){
                            aux.getSeg().setSeg(null);
                        }
                        if (eliminat){
                            System.out.println("Posició " + k + " eliminada.");
                        } else {
                            System.out.println("La llista només te " + (contador + 1) +
                                    "elements!\n" + k + " és massa gran.");
                        }
                    } else {
                        System.out.println("La llista es buida.");
                    }
                    break;
                //Mostra la llista actual per consola
                case 3:
                    if (capçalera.getSeg() != null){
                        System.out.println("Llista actual: " + capçalera + "\nPitja"
                                + " ENTER per continuar...");
                    } else {
                        System.out.println("La llista és buida!");
                    }
                    new Scanner(System.in).nextLine();
                    break;
                //Per defecte el programa finalitzarà
                default:
                    acabat = true;
                    break;
            }
        }
    }
}
