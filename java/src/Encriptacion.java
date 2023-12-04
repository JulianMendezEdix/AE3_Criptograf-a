import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Clase Encriptacion que proporciona funcionalidades para cifrar y descifrar frases utilizando AES.
 */
public class Encriptacion {
    
    private static Scanner leer = new Scanner(System.in);

    /**
     * Genera una clave secreta utilizando el algoritmo AES.
     * 
     * @return SecretKey La clave secreta generada, o null si ocurre un error.
     */
    public static SecretKey generarKey() {
        KeyGenerator generator;
        try {
            generator = KeyGenerator.getInstance("AES");
            return generator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Cifra una frase proporcionada por el usuario utilizando una clave secreta.
     * 
     * @param secretKey La clave secreta para el cifrado.
     * @return byte[] La frase cifrada, o null si ocurre un error.
     */
    public static byte[] cifrarFrase(SecretKey secretKey) {
        System.out.println("introduzca frase: ");
        String frase = leer.nextLine();

        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] bytesFrase = frase.getBytes();
            byte[] fraseCifrada = cipher.doFinal(bytesFrase);
            System.out.println("\nSu frase ha sido cifrada correctamente");
            return fraseCifrada;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Descifra una frase cifrada utilizando la clave secreta correspondiente.
     * 
     * @param fraseCifrada La frase cifrada a descifrar.
     * @param secretKey La clave secreta para el descifrado.
     */
    public static void descifrarFrase(byte[] fraseCifrada, SecretKey secretKey) {
        if (fraseCifrada != null && secretKey != null) {
            try {
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] fraseDescifrada = cipher.doFinal(fraseCifrada);
                System.out.println("\nFrase desencriptada correctamente:");
                System.out.println(new String(fraseDescifrada));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\nNo existe clave para descifrar");
        }
    }
}

