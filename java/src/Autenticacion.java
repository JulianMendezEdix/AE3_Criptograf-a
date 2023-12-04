import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

/**
 * Clase Autenticacion encargada de gestionar la autenticación de usuarios.
 */
public class Autenticacion {
    
    private static Scanner leer = new Scanner(System.in);

    /**
     * Inicializa una lista de usuarios con credenciales predefinidas.
     * 
     * @return ArrayList<Usuario> lista de usuarios inicializados.
     */
    private static ArrayList<Usuario> initUsuarios() {
        Usuario u1 = new Usuario("root", "SBNJTRN+FjG7owHVrKtue7eqdM4RhdRWVl71HXN2d7I=");
        Usuario u2 = new Usuario("admin", "jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=");
        Usuario u3 = new Usuario("user", "BPiZbadjt6lpsQKO4wB1aerzpjVIbdqyEdUSyFud+Ps=");

        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);

        return usuarios;
    }

    /**
     * Verifica las credenciales del usuario.
     * 
     * Permite hasta tres intentos de inicio de sesión. Si las credenciales son
     * correctas, devuelve true, de lo contrario, false.
     * 
     * @return boolean Verdadero si las credenciales son correctas, falso si no.
     */
    public static boolean UsuarioOk() {
        ArrayList<Usuario> usuarios = initUsuarios();

        int count = 0;
        boolean result = false;

        while (count < 3) {
            System.out.println("Introduzca nombre");
            String nombre = leer.next();
            System.out.println("Introduzca contraseña");
            String password = leer.next();

            String passwordHash = hashearPassword(password);
            Usuario usuario = new Usuario(nombre, passwordHash);

            for (Usuario u : usuarios) {
                if (usuario.equals(u)) {
                    result = true;
                    break;
                } else {
                    result = false;
                }
            }
            if (result)
                break;
            else {
                System.out.println("contraseña y/o usuario erroneos");
                count++;
            }
        }

        if (!result) {
            System.out.println("Programa finalizado");
        }
        return result;
    }

    /**
     * Hashea la contraseña proporcionada utilizando SHA-256.
     * 
     * @param password La contraseña a hashear.
     * @return String El hash de la contraseña en Base64, o null si ocurre un error.
     */
    private static String hashearPassword(String password) {
        byte[] passwordHash = password.getBytes();
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(passwordHash);
            byte[] resumen = md.digest();
            String mensajeHashBase64 = Base64.getEncoder().encodeToString(resumen);
            return mensajeHashBase64;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}

