package Examen1;

import SyncPagoPendiente.*;
import java.util.Random;

/**
 *
 * @author JL<///7>
 */
public class Usuario extends Thread {

    private String nombreUsuario;
    private Cuenta cuenta;

    public Usuario(String nombreUsuario, Cuenta cuenta) {
        this.nombreUsuario = nombreUsuario;
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        System.out.println("Iniciando :" + nombreUsuario);
        //int operacion = new Random().nextInt(3);  

        for (int i = 0; i < 5; i++) {
            int operacion = (int) (Math.random() * 3);
            int random1 = (int) (Math.random()*50);
            int random2 = (int) (Math.random()*50);
            /*Random r=new Random(50);
        Random r2=new Random(50);*/

            switch (operacion) {

                case 0:
                    cuenta.Depositar(random1, nombreUsuario);
                    break;

                case 1:
                    cuenta.Retirar(random2, nombreUsuario);
                    break;

                case 2:
                    cuenta.Consultar(nombreUsuario);
                    break;

                default:
                    System.out.println("ERROR!!");
                    break;

            }

        }
        System.out.println("\n\n......................");
        System.out.println("Terminado :" + nombreUsuario);
        System.out.println("......................\n");
    }

}
