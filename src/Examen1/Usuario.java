package Examen1;

import java.util.Random;

/**
 *
 * @author JL<///7>
 */
public class Usuario extends Thread {

    private String nombreUsuario;
    private Cuenta cuenta;
    private Banco banco;

    public Usuario(Cuenta cuenta, Banco banco, String nombreUsuario) {
        super();
        this.cuenta = cuenta;
        this.banco = banco;
        this.nombreUsuario = nombreUsuario;

    }

    public String getnombreUsuario() {

        return nombreUsuario;
    }

    @Override
    public void run() {
        System.out.println("Iniciando :" + nombreUsuario);
        //int operacion = new Random().nextInt(3);  
        int monto, cuentaDestino = 0, banco1 = 0, banco2 = 0;
        for (int i = 0; i < 5; i++) {
            int operacion = (int) (Math.random() * 4);
            int random1 = (int) (Math.random() * 50);
            int random2 = (int) (Math.random() * 50);
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
                case 3:
                    cuentaDestino = operacion;
                    monto = random1;
                    this.banco.TranserenciaLocal(cuenta, monto, monto);
                    break;

                case 4:
                    cuentaDestino=operacion;
                    monto=random1;
                    banco1=random2;
                    this.banco.TransferenciaInterBancaria(cuenta, cuenta, i, i, monto);
                    
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
