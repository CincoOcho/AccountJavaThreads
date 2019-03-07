package Sync;

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
        System.out.println("Iniciando,  :" + nombreUsuario);
        //int operacion = new Random().nextInt(3);  

        for (int i = 0; i < 5; i++) {
                    int operacion = (int) (Math.random() * 3);
        Random r=new Random(200);
        Random r2=new Random(300);
            switch (operacion) {

                case 0:
                    cuenta.Depositar(r.nextInt(100), nombreUsuario);
                    break;
                case 1:
                    cuenta.Retirar(r2.nextInt(100), nombreUsuario);

                    break;

                case 2:
                    cuenta.Consultar(nombreUsuario);

                    break;
                    
                

                default:
                    System.out.println("ERROR!!");
                    break;

            }
            
        }
        System.out.println("Terminado....................\n"+nombreUsuario);
    }

}
