package registro;

import biblioteca.Libro;
import clasesabstractas.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        mostrarMenu();
    }
    
    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do {
            try {
                System.out.println("--MENU--");
                System.out.println("1.Cliente\n2.Bibliotecario\n0.Salir");
                opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
                    case 1:
                        System.out.println("\nCliente: ");
                        registrarCliente();

                        break;
                    case 2:
                        System.out.println("\nBibliotecario: ");
                        registrarBibliotecario();
                        break;
                    case 0:
                        System.out.println("\nGracias por usar la aplicacion\nDesarrollador: Nicolas Nunez");
                        break;
                    default:
                        System.out.println("Opcion invalida. Ingrese nuevamente.\n");
                }
            } catch (Exception e) {
                System.out.println("Debe ingresar un numero como opcion\n");
            }
        } while (opc != 0);
    }

    public static void registrarCliente() {
        List<Cliente> clientes = new ArrayList<>();
        int opc;
        do {
            System.out.println("1.Registrarse\n2.Iniciar Sesion\n0.Salir");
            Scanner sc = new Scanner(System.in);
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("Ingrese su usuario: ");
                    String usuario = sc.nextLine();
                    while (usuario.equals("")) {
                        System.out.println("El usuario no puede estar en blanco");
                        usuario = sc.nextLine();
                    }

                    System.out.println("Ingrese una contrasenia(8 caracteres): ");
                    String contrasenia = sc.nextLine();
                    while (contrasenia.length() != 8) {
                        System.out.println("Ingrese una contraseña de 8 caracteres");
                        contrasenia = sc.nextLine();
                    }
                    Cliente nuevoCliente = new Cliente(usuario, contrasenia);
                    clientes.add(nuevoCliente);
                    System.out.println(nuevoCliente.getUsuario() + " registrado correctamente.\n");
                    break;

                case 2:
                    System.out.println("Usuario: ");
                    usuario = sc.nextLine();
                    System.out.println("Contrasenia: ");
                    contrasenia = sc.nextLine();
                    Cliente inicioSesionCliente = new Cliente(usuario, contrasenia);
                    if (clientes.contains(inicioSesionCliente)) {
                        System.out.println("BIENVENIDO!\n");
                    } else {
                        System.out.println("Cliente no registrado\n");
                    }
                    break;
                case 0:
                    System.out.println("\n");
                    break;
            }
        } while (opc != 0);
    }

    public static void registrarBibliotecario() {
        List<Bibliotecario> bibliotecarios = new ArrayList<>();
        int opc;
        do {
            System.out.println("1.Registrarse\n2.Iniciar Sesion\n0.Salir");
            Scanner sc = new Scanner(System.in);
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("Ingrese su usuario: ");
                    String usuario = sc.nextLine();
                    while (usuario.equals("")) {
                        System.out.println("El usuario no puede estar en blanco");
                        usuario = sc.nextLine();
                    }

                    System.out.println("Ingrese una contrasenia(8 caracteres): ");
                    String contrasenia = sc.nextLine();
                    while (contrasenia.length() != 8) {
                        System.out.println("Ingrese una contraseña de 8 caracteres");
                        contrasenia = sc.nextLine();
                    }
                    Bibliotecario nuevoBibliotecario = new Bibliotecario(usuario, contrasenia);
                    bibliotecarios.add(nuevoBibliotecario);
                    System.out.println(nuevoBibliotecario.getUsuario() + " registrado correctamente.\n");
                    break;

                case 2:
                    System.out.println("Usuario: ");
                    usuario = sc.nextLine();
                    System.out.println("Contrasenia: ");
                    contrasenia = sc.nextLine();
                    Bibliotecario inicioSesionBibliotecario = new Bibliotecario(usuario, contrasenia);
                    if (bibliotecarios.contains(inicioSesionBibliotecario)) {
                        System.out.println("BIENVENIDO!\n");
                        new Libro().mostrarMenu();
                    } else {
                        System.out.println("Bibliotecario no registrado\n");
                    }
                    break;
                case 0:
                    System.out.println("\n");
                    break;
            }
        } while (opc != 0);
    }
}
