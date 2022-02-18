package practica_evaluable_semaforos1;

public class Persona implements Runnable {

    private Portero portero;

    public Persona(){}

    public Persona(Portero portero , String name){
        this.portero = portero;
    }

    @Override
    public void run(){
        while(true){
           
            portero.entrar();
        }
    }

}
