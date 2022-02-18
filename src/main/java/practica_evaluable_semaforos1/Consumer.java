package practica_evaluable_semaforos1;

public class Consumer implements Runnable {
    private Portero portero;

    public Consumer() {
    }

    //Constructor de la clase Consumer
    public Consumer(Portero portero) {
        this.portero = portero;
    }

    @Override
    public void run() {

        //Lanzara 100 hilos consume donde esperara 1seg antes de consumir los hilos lanzados al principio
        for (int i = 0; i < 100; i++) {
            
            try {
                Thread.sleep(1000);
                portero.consume();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
