package Examen1;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JL<///7>
 */
public class Cuenta {

    private int limite, saldo;
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

    public synchronized void Retirar(int monto, String nombre) {
        while (monto > saldo) {
            System.out.println("\nNo puede retirar la cantidad de:" + monto + " !!!");
            try {
                wait();
                System.out.println("++++++++LINE WAIT+++++++++");
            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("\nOperacion: RETIRO, Usuario: " + nombre);
        System.out.println("Saldo actual: " + saldo + " Monto a retirar: " + monto);
        saldo -= monto;
        System.out.println("Saldo Final: " + saldo);
        notify();

    }//////////////////////////////////RETIRAR!

    
    
    public synchronized void Depositar(int monto, String nombre) {
        while (saldo + monto >= limite) {
            System.out.println("\nNo se puede depositar :" + monto);
            try {
                wait();
                System.out.println("++++++++LINE WAIT+++++++++");
            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("\nOperacion: DEPOSITO, Usuario: " + nombre);
        System.out.println("Saldo actual: " + saldo + " Monto a depositar:" + monto);
        saldo += monto;
        System.out.println("Saldo Final: " + saldo);
        notify();
    }////////////////////////////////DEPOSITAR
    

    
    
    public synchronized void Consultar(String nombre) {
        System.out.println("\nOperacion: CONSULTA, Usuario: " + nombre);
        System.out.println("Consulta de saldo: ");
        System.out.println("" + toString());
    }
 

}
