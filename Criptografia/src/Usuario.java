import java.util.Objects;

/**
 * Clase Usuario que representa un usuario con nombre y contraseña.
 */
public class Usuario {
    
    private String nombre;
    private String password;

    /**
     * Constructor para crear un nuevo usuario.
     * 
     * @param nombre El nombre del usuario.
     * @param password La contraseña del usuario.
     */
    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return String El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece o actualiza el nombre del usuario.
     * 
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return String La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece o actualiza la contraseña del usuario.
     * 
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Genera un código hash para el usuario basado en el nombre y la contraseña.
     * 
     * @return int El código hash generado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, password);
    }

    /**
     * Compara este usuario con otro objeto para determinar la igualdad.
     * 
     * @param obj El objeto con el que se compara.
     * @return boolean Verdadero si los objetos son iguales, falso si no.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password);
    }   
}

