package practica_evaluable_semaforos1;

import java.util.*;

//Basicamente se encarga de ser un semaforo, controla el tamanyo y el aforo del local
public class Portero {
    // capacidad del local
    private final int MAX_SIZE = 31;
    private int contador = 0;

    private LinkedList<Object> aforoPersonas = new LinkedList<>();


    /**Tecnicamente es un producir, pero me ceñire a lo que me pide el PDF */
    public void entrar() {
        synchronized (aforoPersonas) {
            while (aforoPersonas.size() + 1 > MAX_SIZE) {

                System.out.println("El local esta lleno, espera hasta que haya hueco");
                try {
                    aforoPersonas.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            aforoPersonas.add(new Object());
            contador ++;
            System.out.println("Ha entrado una nueva persona, hay: " + aforoPersonas.size() + " en el local ");
            System.out.println("Han entrado al local: " + contador + " personas \n");
            aforoPersonas.notify();
        }
    }

    public void consume() {
        synchronized (aforoPersonas) {
            while (aforoPersonas.size() == 0) {
                
                System.out.println("El local esta vacio!!!");
                try {
                    aforoPersonas.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            aforoPersonas.remove();
            
            System.out.println("Se ha ido una persona, ahora quedan en el local: " + aforoPersonas.size() + "\n" );
            aforoPersonas.notifyAll();
        }
    }

}
