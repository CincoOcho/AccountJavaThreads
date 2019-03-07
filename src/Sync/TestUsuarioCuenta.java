package Sync;

/**
 *
 * @author JL<///7>
 */
public class TestUsuarioCuenta {

    public static void main(String[] args) {

        Cuenta c = new Cuenta(200, 100, "CuentaPrimaria");
        Usuario u = new Usuario("user-1", c);
        Usuario u2 = new Usuario("user-2", c);
        u.start();
        u2.start();

    }

}
