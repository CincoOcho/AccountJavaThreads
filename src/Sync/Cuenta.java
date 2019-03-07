package Sync;

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
    //toString
    @Override
    public synchronized String toString() {
      
        return "Cuenta{" + "limite=" + limite + ", saldo=" + saldo + ", nombre=" + nombre + '}';
    }
    //saldo ......................................................
    public synchronized void Retirar(int monto)  {
       while(monto>saldo){
           System.out.println("No se puede retirar "+monto);
           try {
               wait();
               System.out.println("Despues de esperar...");
           } catch (InterruptedException ex) {
               Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        System.out.println("**********************"+nombre+"*************************");
       System.out.println("Saldo actual: "+saldo+" Monto a retirar: "+monto);
       saldo-=monto; 
       System.out.println("Saldo Final: "+saldo);
       notify();
       
    }
    public synchronized void Depositar(int monto) {
        while(saldo+monto>=limite){
            System.out.println("No se puede depositar " +monto);
            try {
                wait();
                System.out.println("Despues de esperar...");
            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("**********************"+nombre+"*************************");
        System.out.println("Saldo actual: "+saldo+" Monto a depositar:"+monto);
        saldo+=monto;
        System.out.println("Saldo Final: "+saldo);
        notify();
    }
    public synchronized void Consultar(){
        System.out.println("**********************"+nombre+"*************************");
        System.out.println("Consulta de saldo: ");
        System.out.println(""+toString());
    }
    //Otra persona **************************************************************
    public synchronized void Retirar(int monto, String nombre) {
         while(monto>saldo){
           System.out.println("No se puede retirar "+monto);
             try {
                 wait();
                 System.out.println("Despues de esperar...");
             } catch (InterruptedException ex) {
                 Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
             }
       }
       System.out.println("**********************"+nombre+"*************************");
       System.out.println("Saldo actual: "+saldo+" Monto a retirar: "+monto);
       saldo-=monto; 
       System.out.println("Saldo Final: "+saldo);
       notify();
    }
    public synchronized void Depositar(int monto, String nombre) {
        while(saldo+monto>=limite){
            System.out.println("No se puede depositar " +monto);
            try {
                wait();
                System.out.println("Despues de esperar...");
            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("**********************"+nombre+"*************************");
        System.out.println("Saldo actual: "+saldo+" Monto a depositar:"+monto);
        saldo+=monto;
        System.out.println("Saldo Final: "+saldo);
        notify();
    }
    
    //consultar
    public synchronized void Consultar(String nombre){
        System.out.println("**********************"+nombre+"*************************");
        System.out.println("Consulta de saldo: ");
        System.out.println(""+toString());
    }
    
    
    
    
}
