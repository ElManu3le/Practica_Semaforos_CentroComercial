package practica_evaluable_semaforos1;

import java.util.*;

//Basicamente se encarga de ser un semaforo, controla el tamanyo y el aforo del local
public class Portero {

    // capacidad del local
    private final int MAX_SIZE = 31;

    //variable contador para contar la cantidad de personas que entran total a la cola
    private int contador = 0;

    private LinkedList<Object> aforoPersonas = new LinkedList<>();


    /**Metodo utilizado para meter elementos a nuestra cola, en caso de estar llena esperara a que haya hueco para usar */
    public void entrar() {
        synchronized (aforoPersonas) {
            //While usado para ir comprobando constantemente el estado del tamaño de la cola
            while (aforoPersonas.size() + 1 > MAX_SIZE) {

                System.out.println("El local esta lleno, espera hasta que haya hueco");
                try {
                    aforoPersonas.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //En caso de disponer de un hueco en la cola, se añade y cuenta el elemento nuevo
            aforoPersonas.add(new Object());
            contador++;
            System.out.println("Ha entrado una nueva persona, hay: " + aforoPersonas.size() + " en el local ");
            System.out.println("Han entrado al local: " + contador + " personas \n");
            aforoPersonas.notify();
        }
    }


    /**Metodo utilizado para acabar con los hilos Persona lanzados */
    public void consume() {
        synchronized (aforoPersonas) {
            //El metodo while es utilizado para evitar que el programa consuma elementos una vez no haya en la cola
            while (aforoPersonas.size() == 0) {

                System.out.println("El local esta vacio!!!");
                try {
                    //Esperara a que haya elementos en la cola para consumir
                    aforoPersonas.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            aforoPersonas.remove();

            System.out.println("Se ha ido una persona, ahora quedan en el local: " + aforoPersonas.size() + "\n");
            aforoPersonas.notifyAll();
        }
    }

}
