
package usuarioregistro;

import biblioteca.Libro;
import claseabstracta.Registro;

public class Usuario extends Registro {
    private Libro libros;
    
    
    public Usuario() {
    }

    public Usuario(String usuario, String contraseña) {
        super(usuario, contraseña);
    }
    
}
