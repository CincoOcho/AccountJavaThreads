package Examen1;

import SyncPagoPendiente.*;

/**
 *
 * @author JL<///7>
 */
public class TestUsuarioCuenta {

    public static void main(String[] args) {

        Cuenta c = new Cuenta(200, 100, "CuentaPrimaria");
        Usuario u = new Usuario("cliente-1", c);
        Usuario u2 = new Usuario("cliente-2", c);
        u.start();
        u2.start();

    }

}
