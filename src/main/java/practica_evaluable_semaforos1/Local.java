package practica_evaluable_semaforos1;

public class Local {

    public static void main(String[] args) {

        Portero aforo = new Portero();
        Thread p1 = new Thread(new Persona(aforo, null));

        Thread c1 = new Thread(new Consumer(aforo, null));

        p1.start();

        c1.start();

    }

}
