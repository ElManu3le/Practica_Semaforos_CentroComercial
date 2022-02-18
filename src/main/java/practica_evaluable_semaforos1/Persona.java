package practica_evaluable_semaforos1;

public class Persona implements Runnable {

    private Portero portero;

    public Persona() {
    }

    public Persona(Portero portero) {
        this.portero = portero;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            portero.entrar();
        }
    }

}
