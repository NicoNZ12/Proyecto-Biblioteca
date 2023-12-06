
package claseabstracta;

import java.util.Objects;

public abstract class Registro {
    //Atributos
    private String usuario;
    private String contraseña;
    
    //constructores

    public Registro() {
    }

    public Registro(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    
    //Getter

    public String getUsuario() {
        return usuario;
    }

    //Método equals y hashcode para comparar los objetos de tipo Usuario y ver si estan registrados o no a la hora de iniciar sesion
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.usuario);
        hash = 59 * hash + Objects.hashCode(this.contraseña);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Registro other = (Registro) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.contraseña, other.contraseña);
    }

   
}
