package practica_evaluable_semaforos1;

public class Persona implements Runnable {

    private Portero portero;

    public Persona() {
    }

    //Constructor de la clase Persona
    public Persona(Portero portero) {
        this.portero = portero;
    }

    
    @Override
    public void run() {

        /** Se lanzan 100 hilos con el proceso entrar en la cola*/
        for (int i = 0; i < 100; i++) {
            portero.entrar();
        }
    }

}
