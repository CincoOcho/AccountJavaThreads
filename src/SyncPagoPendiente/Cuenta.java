package SyncPagoPendiente;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JL<///7>
 */
public class Cuenta {

    private int limite, saldo, iteracion = 0;
    private String nombre;

    public synchronized String getNombre() {
        return nombre;
    }

    public synchronized void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public synchronized int getLimite() {
        return limite;
    }

    public synchronized void setLimite(int limite) {
        this.limite = limite;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Cuenta(int limite, int saldo, String nombre) {
        this.limite = limite;
        this.saldo = saldo;
        this.nombre = nombre;
    }

    @Override
    public synchronized String toString() {

        return "Cuenta{" + "limite=" + limite + ", saldo=" + saldo + ", nombre=" + nombre + '}';
    }

    public synchronized void Retirar(int monto) {
        while (monto > saldo && (iteracion < 5)) {
            try {
                System.out.println("\n////INTENTO DE RETIRO, Usuario: " + nombre);
                System.out.println("\nNo puede retirar la cantidad de: " + monto + " !!!");
                System.out.println("Saldo: " + saldo + "\nEl retiro exede el saldo : " + monto + "\nUsuario: " + nombre);
                int deuda = saldo;
                saldo -= deuda;
                monto -= deuda;
                System.out.println("Retiro: " + deuda + "  Adeudo: " + monto);

                wait(3000);
                System.out.println("++++++++WAIT+++++++++");
                iteracion++;
                if (iteracion == 5) {
                    System.out.println("\nNo se puede seguir corriendo este proceso!");
                    System.exit(0);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        iteracion++;
        System.out.println("\nOperacion: RETIRO, Usuario: " + nombre);
        System.out.println("Saldo actual: " + saldo + " Monto a retirar: " + monto);
        saldo -= monto;
        System.out.println("Saldo Final: " + saldo);
        notify();
        if (iteracion == 5) {
            System.out.println("\nNo puede seguir corriendo este proceso!");
            System.exit(0);
        }
    }
    

    public synchronized void Depositar(int monto) {
        while ((saldo + monto) > limite && (iteracion < 5)) {
            try {
                System.out.println("\n////INTENTO DE DEPOSITO, Usuario: " + nombre);
                System.out.println("Saldo total: " + saldo + "\nNo se puede depositar " + monto + "\nLimite de cuenta:" + limite);
                int debe = saldo + monto - limite;
                int abono = monto - debe;
                saldo += abono;
                monto = debe;
                System.out.println("Deposito: " + abono + " Pendiente: " + monto);

                wait(3000);
                System.out.println("++++++++WAIT+++++++++");
                iteracion++;
                if (iteracion == 5) {
                    System.out.println("\nNo puede seguir corriendo este proceso!");
                    System.exit(0);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("\nOperacion: DEPOSITO, Usuario: " + nombre);
        System.out.println("Saldo actual: " + saldo + " Monto a depositar:" + monto);
        saldo += monto;
        System.out.println("Saldo Final: " + saldo);
        notify();
        if (iteracion == 5) {
            System.out.println("\nNo puede seguir corriendo este proceso!");
            System.exit(0);
        }
    }

    public synchronized void Consultar() {
        System.out.println("\nOperacion: CONSULTA, Usuario: " + nombre);
        System.out.println("Consulta de saldo: ");
        System.out.println("" + toString());
    }

    
    public synchronized void Retirar(int monto, String nombre) {
        while (monto > saldo && (iteracion < 5)) {
            try {
                System.out.println("\n////INTENTO DE RETIRO, Usuario: " + nombre);
                System.out.println("\nNo puede retirar la cantidad de: " + monto + " !!!");
                System.out.println("Saldo: " + saldo + "\nEl retiro exede el saldo : " + monto + "\nUsuario: " + nombre);
                int deuda = saldo;
                saldo -= deuda;
                monto -= deuda;
                System.out.println("Retiro: " + deuda + "  Adeudo: " + monto);
                wait(3000);
                System.out.println("++++++++LINE WAIT+++++++++");
                iteracion++;
                if (iteracion == 5) {
                    System.out.println("\nNo puede seguir corriendo este proceso!");
                    System.exit(0);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("\nOperacion: RETIRO, Usuario: " + nombre);
        System.out.println("Saldo actual: " + saldo + " Monto a retirar: " + monto);
        saldo -= monto;
        System.out.println("Saldo Final: " + saldo);
        notify();
        if (iteracion == 5) {
            System.out.println("\nNo puede seguir corriendo este proceso!");
            System.exit(0);
        }
    }

    public synchronized void Depositar(int monto, String nombre) {
        while (saldo + monto >= limite) {
            try {
                System.out.println("\n////INTENTO DE DEPOSITO, Usuario: " + nombre);
                System.out.println("Saldo total: " + saldo + "\nNo se puede depositar " + monto + "\nLimite de cuenta:" + limite);
                int debe = saldo + monto - limite;
                int abono = monto - debe;
                saldo += abono;
                monto = debe;
                System.out.println("Deposito: " + abono + " Pendiente: " + monto);
                
                wait(3000);
                System.out.println("++++++++LINE WAIT+++++++++");
                if (iteracion == 5) {
                    System.out.println("\nNo puede seguir corriendo este proceso!");
                    System.exit(0);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("\nOperacion: DEPOSITO, Usuario: " + nombre);
        System.out.println("Saldo actual: " + saldo + " Monto a depositar:" + monto);
        saldo += monto;
        System.out.println("Saldo Final: " + saldo);
        notify();
        if (iteracion == 5) {
            System.out.println("\nNo puede seguir corriendo este proceso!");
            System.exit(0);
        }
    }

    
    public synchronized void Consultar(String nombre) {
        System.out.println("\nOperacion: CONSULTA, Usuario: " + nombre);
        System.out.println("Consulta de saldo: ");
        System.out.println("" + toString());
    }

}
