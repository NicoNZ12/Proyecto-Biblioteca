package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Libro {

    //Atributos
    private String titulo;
    private String autor;
    private String genero;

    //método Scanner 
    Scanner sc = new Scanner(System.in);

    //ArrayList donde guardaremos o eliminaremos los libros
    List<Libro> libros = new ArrayList<>();

    //ArrayList que se usa para reservar y devolver libros
    List<Libro> librosReservados = new ArrayList<>();

    //Constructores
    public Libro() { //constructor vacío
    }

    public Libro(String titulo, String autor, String genero) { //constructor con párametros
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    //Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    //Método que muestra el menu
    public void mostrarMenu() {
        int opc = 0;

        //Menu bibliotecario
        do {
            System.out.println("--MENU--");
            System.out.println("1.Agregar libro \n2.Eliminar libro \n3.Ver libros \n0.Salir");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("\nAGREGAR LIBRO\n");

                    System.out.println("Ingrese el titulo del libro: ");
                    String titulo = sc.nextLine();
                    while (titulo.equals("")) {
                        System.out.println("El titulo no puede estar en blanco");
                        titulo = sc.nextLine();
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
                    Libro libroNuevo = new Libro(titulo, autor, genero);
                    //Añadimos el libro al ArrayList
                    libros.add(libroNuevo);

                    System.out.println("\n*****Libro agregado correctamente*****\n");
                    break;

                case 2:
                    System.out.println("\nELIMINAR LIBRO\n");
                    System.out.println("Ingrese el nombre del libro que desea eliminar: ");
                    titulo = sc.nextLine();

                    //Creamos un nuevo objeto y le pasamos el nombre del libro que deseamos borrar
                    Libro borrarLibro = new Libro(titulo, "", "");

                    if (libros.contains(borrarLibro)) {
                        libros.remove(borrarLibro);
                        System.out.println("\n*****Libro eliminado correctamente*****\n");
                    } else {
                        System.out.println("Ese libro no se encuentra en la lista\n");
                    }
                    break;

                case 3:
                    System.out.println("\nVER LIBROS\n");
                    verLibros();
                    break;

                case 0:
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Opcion incorrecta. Ingrese nuevamente\n");
            }
        } while (opc != 0);
    }

    public void verLibros() {
        int opc;
        do {
            System.out.println("1. Lista de libros\n2. Reservar libro\n3. Devolver libro\n0. Salir");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    int opcion;
                    do {
                        System.out.println("\n1. Lista completa\n2. Buscar por titulo, autor o genero\n0. Salir");
                        opcion = Integer.parseInt(sc.nextLine());

                        switch (opcion) {
                            case 1:
                                if (libros.isEmpty()) {
                                    System.out.println("\nAun no se han agregado libros\n");
                                } else {
                                    System.out.println("\nLISTA DE LIBROS");
                                    for (Libro libro : libros) {
                                        System.out.println(libro);
                                    }
                                }
                                break;
                            case 2:
                                filtrarBusqueda();
                                break;
                            case 0:
                                System.out.println("\n");
                                break;
                            default:
                                System.out.println("Opcion incorrecta. Ingrese nuevamente\n");
                        }
                    } while (opcion != 0);
                    break;
                case 2:
                    System.out.println("RESERVAR LIBRO");
                    reservar();
                    break;
                case 3:
                    System.out.println("DEVOLVER LIBRO");
                    devolver();
                    break;
                case 0:
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Opcion invalida. Ingrese nuevamente.\n");
            }
        } while (opc != 0);
    }

    public void filtrarBusqueda() {
        System.out.println("\nIngrese el titulo, genero o autor del libro que desea buscar: ");
        String busqueda = sc.nextLine().toLowerCase();

        //ArrayList que guarda los resultados de la busqueda del libro
        List<Libro> resultadosBusqueda = new ArrayList<>();

        //si el titulo, autor o genero coincide con algun libro ingresado, se guarda en el nuevo ArrayList
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(busqueda) || libro.getAutor().toLowerCase().contains(busqueda) || libro.getGenero().toLowerCase().contains(busqueda)) {
                resultadosBusqueda.add(libro);
            }
        }

        try {
            if (!resultadosBusqueda.isEmpty()) {
                System.out.println("\nResultados de la busqueda:");
                for (Libro libro : resultadosBusqueda) {
                    System.out.println(libro);
                }
            } else {
                System.out.println("\nNo hay libros ingresados que coincidan con la busqueda: " + busqueda);
            }
        } catch (Exception e) {
            System.out.println("\nHubo un error a la hora de mostrar los resultados.");
        }
    }

    public void reservar() {
        System.out.println("\nEscriba el titulo del libro que desea reservar: ");
        String titulo = sc.nextLine();

        boolean libroEncontrado = false;
        try {
            for (Libro libroReservado : libros) {
                if (libroReservado.getTitulo().toLowerCase().contains(titulo)) {
                    librosReservados.add(libroReservado); //Se añade el libro al ArrayList 
                    libroEncontrado = true;
                    libros.remove(libroReservado);//Se remueva de la lista original
                    break;
                }
            }

            if (libroEncontrado) {
                System.out.println("\n*****Libro reservado con exito*****\n");
            } else {
                System.out.println("\nEste libro no esta registrado o se encuentra reservado.\n");
            }
        } catch (Exception e) {
            System.out.println("Error al reservar el libro.");
        }
    }

    public void devolver() {
        System.out.println("\nEscriba el titulo del libro que desea devolver: ");
        String titulo = sc.nextLine();

        boolean libroDevolver = false;

        try {
            for (Libro libroDevueltos : librosReservados) {
                if (libroDevueltos.getTitulo().toLowerCase().contains(titulo)) {
                    librosReservados.remove(libroDevueltos); //Removemos el libro del ArrayList librosReservados
                    libroDevolver = true;
                    libros.add(libroDevueltos); //Agregamos el libro a la lista original
                    break;
                }
            }

            if (libroDevolver) {
                System.out.println("\n*****Libro devuelto con exito*****\n");
            } else {
                System.out.println("\nEste libro no se encuentra reservado.\n");
            }
        } catch (Exception e) {
            System.out.println("Error al devolver el libro.");
        }
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
        return Objects.equals(titulo, libro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

    //Método toString para mostrar el objeto
    @Override
    public String toString() {
        return "Libro: \nTitulo: " + titulo + " / Autor: " + autor + " / Genero: " + genero + "\n";
    }
}
