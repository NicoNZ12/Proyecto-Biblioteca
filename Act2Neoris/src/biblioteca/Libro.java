
package biblioteca;

import java.util.Objects;

public class Libro {
    //Atributos
    private String nombre;
    private String autor;
    private String genero;

    //Constructores
    public Libro() { //constructor vacío
    }

    public Libro(String nombre, String autor, String genero) { //constructor con párametros
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
    }

    //Métodos hashcode y equals para poder comparar los objetos a la hora de eliminarlos del ArrayList
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Libro libro = (Libro) obj;
        return Objects.equals(nombre, libro.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    
    //Método toString para mostrar el objeto
    @Override
    public String toString() {
        return "Libro: \nNombre: " + nombre + " / Autor: " + autor + " / Genero: " + genero + "\n";
    }
}
