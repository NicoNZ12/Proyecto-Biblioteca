package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //método Scanner 
        Scanner sc = new Scanner(System.in);

        //ArrayList donde guardaremos o eliminaremos los libros
        List<Libro> libros = new ArrayList<>();

        int opc = 0;
        do {
            try {
                System.out.println("--MENÚ--\n");
                System.out.println("1.Agregar libro \n2.Eliminar libro \n3.Lista de libros \n0.Salir");
                opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
                    case 1:
                        System.out.println("\nAGREGAR LIBRO\n");

                        System.out.println("Ingrese el nombre del libro: ");
                        String nombre = sc.nextLine();
                        while (nombre.equals("")) {
                            System.out.println("El nombre no puede estar en blanco");
                            nombre = sc.nextLine();
                        }

                        System.out.println("Ingrese el autor del libro: ");
                        String autor = sc.nextLine();
                        while (autor.equals("")) {
                            System.out.println("El autor no puede estar en blanco");
                            autor = sc.nextLine();
                        }

                        System.out.println("Ingrese el genero del libro: ");
                        String genero = sc.nextLine();
                        while (genero.equals("")) {
                            System.out.println("El genero no puede estar en blanco");
                            genero = sc.nextLine();
                        }

                        //Creamos un objeto de tipo Libro con los datos ingresados por el usuario
                        Libro libroNuevo = new Libro(nombre, autor, genero);
                        //Añadimos el libro al ArrayList
                        libros.add(libroNuevo);

                        System.out.println("\n*****Libro agregado correctamente*****\n");
                        break;

                    case 2:
                        System.out.println("\nELIMINAR LIBRO\n");
                        System.out.println("Ingrese el nombre del libro que desea eliminar: ");
                        nombre = sc.nextLine();

                        //Creamos un nuevo objeto y le pasamos el nombre del libro que deseamos borrar
                        Libro borrarLibro = new Libro(nombre, "", "");

                        if (libros.contains(borrarLibro)) {
                            libros.remove(borrarLibro);
                            System.out.println("\n*****Libro eliminado correctamente*****\n");
                        } else {
                            System.out.println("Ese libro no se encuentra en la lista\n");
                        }
                        break;

                    case 3:
                        System.out.println("\nLISTA DE LIBROS\n");
                        if (libros.isEmpty()) {
                            System.out.println("Aun no se han agregado libros\n");
                        } else {
                            for (Libro listaLibros : libros) {
                                System.out.println(listaLibros);
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Gracias por usar la biblioteca. \nDesarrollador: Nicolas Nunez");
                        break;

                    default:
                        System.out.println("Opcion incorrecta. Ingrese nuevamente\n");
                }
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero como opcion\n");
            }
        } while (opc != 0);
    }
}
