package practica_evaluable_semaforos1;

public class Consumer  implements Runnable{
    private Portero portero;

    public Consumer(){}

    public Consumer(Portero portero , String name){
        this.portero = portero;
    }

    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
                portero.consume();
                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }
}



