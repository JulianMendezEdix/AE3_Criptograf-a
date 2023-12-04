import java.util.Scanner;
import javax.crypto.SecretKey;

/**
 * Clase principal App que ejecuta la aplicación de autenticación y encriptación.
 */
public class App {
    
    private static Scanner leer = new Scanner(System.in);

    /**
     * Método principal que inicia la ejecución del programa.
     * 
     * Este método se encarga de autenticar al usuario y luego proporciona un menú
     * para encriptar y desencriptar frases utilizando AES.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        if (Autenticacion.UsuarioOk()) {
            byte[] fraseCifrada = null;
            SecretKey secretKey = null;
            int opcion = 0;

            while (opcion != 3) {
                opcion = menu();

                switch (opcion) {
                    case 1:
                        secretKey = Encriptacion.generarKey();
                        fraseCifrada = Encriptacion.cifrarFrase(secretKey);
                        break;
                    case 2:
                        Encriptacion.descifrarFrase(fraseCifrada, secretKey);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Introduzca opcion correcta");
                }
            }

            System.out.println("Programa Finalizado");
        }
    }

    /**
     * Muestra el menú de opciones al usuario y recoge su elección.
     * 
     * @return int La opción elegida por el usuario.
     */
    private static int menu() {
        System.out.println("");
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Encriptar frase");
        System.out.println("2. Desencriptar frase");
        System.out.println("3. Salir del programa");
        System.out.println("Introduzca su opción:");

        int opcion = leer.nextInt();
        leer.nextLine();

        return opcion;
    }
}
