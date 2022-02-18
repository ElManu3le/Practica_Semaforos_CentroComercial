package practica_evaluable_semaforos1;

public class Local {

    public static void main(String[] args) throws InterruptedException {

        //Cola de Array
        Portero aforo = new Portero();        
        //Se comparte la cola con los hilos Persona y Consumer
        Thread p1 = new Thread(new Persona(aforo));
        Thread c1 = new Thread(new Consumer(aforo));

        //Lanzamos una Persona y un Consumer
        p1.start();
        c1.start();

    }

}
