package Examen1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JL
 */
public class Banco {

    Cuenta cuentas[];
    Banco bancos[];
    Cuenta saldoCuenta;

    int saldo;
    int limite;

    public Banco(Cuenta[] cuentas) {
        this.cuentas = cuentas;
        this.bancos = bancos;

    }

    public void TranserenciaLocal(Cuenta origen, int destino, int monto) {
        limite = cuentas[destino].getLimite();
        saldo = cuentas[destino].getSaldo();

        try {
            while (saldo + monto >= limite) {
                System.out.println("\nNo se puede transferir :" + monto);
            }
            wait(3000);

        } catch (InterruptedException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\n***OPERACIÖN: Transerencia local***");
        System.out.println(" *** De:" + origen.getNombre() + " *** ");
        System.out.println("a la cuenta: " + cuentas[destino].getNombre() + "que tendra un monto "
                + "de : " + monto);

        int cuenta = origen.getSaldo();
        int cuenta2 = cuentas[destino].getSaldo();
        System.out.println("\n\nSaldo actual: " + cuentas[destino].getSaldo());
        notify();
    }

    public void TransferenciaInterBancaria(Cuenta bancoOrigen, Cuenta bancoReceptor, int set1,
            int set2, int monto) {

        try {
            while (saldo + monto >= limite) {
                System.out.println("\nNo se puede transferir :" + monto);
            }
            wait(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\n***OPERACIÖN: Transerencia Inter Bancaria***\n");
        System.out.println("Solicitada por: " + bancoOrigen.getNombre() + ""
                + "con destino : " + bancoReceptor + "\n");
        System.out.println("La cuenta : " + cuentas[set1].getNombre() + ""
                + "transferirá: " + monto + "hacia la cuenta: " + cuentas[set2].getNombre() + "\n");

        int cuenta = bancoOrigen.getSaldo();
        int cuenta2 = bancoReceptor.getSaldo();
        System.out.println("\n\n Saldo de cuenta origen: " + cuenta);
        System.out.println("Saldo de cuenta receptora: " + cuenta2);

        bancoOrigen.setSaldo(cuenta2 += monto);

        System.out.println("\n\nSaldo despues de transferir *Cuenta Origen*"
                + ": " + cuentas[set1].getSaldo());
        System.out.println("Saldo despues de transferir *Cuenta Receptora*"
                + ": " + cuentas[set2].getSaldo());
        notify();
    }

    public synchronized Cuenta[] getCuentas() {
        return cuentas;
    }

    public synchronized void setCuentas(Cuenta[] cuentas, int monto) {

        this.cuentas = cuentas;
    }

    public synchronized Banco[] getBancos() {
        return bancos;
    }

    public synchronized void setBancos(Banco[] bancos) {
        this.bancos = bancos;
    }

}
