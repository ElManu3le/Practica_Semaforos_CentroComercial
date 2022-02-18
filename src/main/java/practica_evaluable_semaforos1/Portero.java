package practica_evaluable_semaforos1;

import java.util.*;

//Basicamente se encarga de ser un semaforo, controla el tamanyo y el aforo del local
public class Portero {
    // capacidad del local
    private final int MAX_SIZE = 31;

    private LinkedList<Object> aforoPersonas = new LinkedList<>();


    /**Tecnicamente es un producir, pero me ceñire a lo que me pide el PDF */
    public void entrar() {
        synchronized (aforoPersonas) {
            while (aforoPersonas.size() + 1 > MAX_SIZE) {
                // System.out.println("[Productor" + Thread.currentThread().getName() + "] El almacén está lleno");
                System.out.println("El local esta lleno, espera hasta que haya hueco");
                try {
                    aforoPersonas.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            aforoPersonas.add(new Object());
            //System.out.println("[Productor" + Thread.currentThread().getName() + "] Producción de un producto, ahora en stock" + aforoPersonas.size());

            aforoPersonas.notifyAll();
        }
    }

    public void consume() {
        synchronized (aforoPersonas) {
            while (aforoPersonas.size() == 0) {
                //System.out.println("[Consumidor" + Thread.currentThread().getName() + "] El almacén está vacío");
                System.out.println("El local esta vacio!!!");
                try {
                    aforoPersonas.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            aforoPersonas.remove();
            //System.out.println("[Consumidor" + Thread.currentThread().getName() + "] Consumir un producto, ahora en stock" + aforoPersonas.size());
            
            aforoPersonas.notifyAll();
        }
    }

}
