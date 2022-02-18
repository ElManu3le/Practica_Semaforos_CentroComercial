package practica_evaluable_semaforos1;

public class Consumer  implements Runnable{
    private Portero portero;

    public Consumer(){}

    public Consumer(Portero portero){
        this.portero = portero;
    }

    @Override
    public void run(){

        for (int i = 0; i < 100; i++) {
            try{
                Thread.sleep(1000);
                portero.consume();
                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}



