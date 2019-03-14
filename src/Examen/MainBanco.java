package Examen;

/**
 *
 * @author JL<///7>
 */
public class MainBanco {

    public static void main(String[] args) {
        Cuenta[] cuentas = new Cuenta[5];
        Cuenta[] cuentas2 = new Cuenta[5];
        Banco[] bancos = new Banco[2];
        Banco bancoPrimario;

        Usuario[] usuarios = new Usuario[10];

        for (int i = 0; i < 5; i++) {
            cuentas[i] = new Cuenta(10, 20, " U-1 " + i + " Banco-1 " + i);
            cuentas2[i] = new Cuenta(10, 20, " U-2 " + i + " Banco-2" + i);

        }
        bancos[0] = new Banco(cuentas);
        bancos[1] = new Banco(cuentas2);

        usuarios[0] = new Usuario(cuentas[0], bancos[0], "User-1");
        usuarios[1] = new Usuario(cuentas[1], bancos[0], "User-2");
        usuarios[2] = new Usuario(cuentas[2], bancos[0], "User-3");
        usuarios[3] = new Usuario(cuentas[3], bancos[0], "User-4");
        usuarios[4] = new Usuario(cuentas[4], bancos[0], "User-5");

        usuarios[5] = new Usuario(cuentas2[0], bancos[1], "User-6");
        usuarios[6] = new Usuario(cuentas2[1], bancos[1], "User-7");
        usuarios[7] = new Usuario(cuentas2[2], bancos[1], "User-8");
        usuarios[8] = new Usuario(cuentas2[3], bancos[1], "User-9");
        usuarios[9] = new Usuario(cuentas2[4], bancos[1], "User-10");

        for (int i = 0; i < 5; i++) {
            usuarios[i].start();
        }
    }

}
