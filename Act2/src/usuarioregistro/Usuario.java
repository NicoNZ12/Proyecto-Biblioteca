
package usuarioregistro;

import biblioteca.Libro;
import claseabstracta.Registro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario extends Registro {
    private Libro libros;
    
    
    public Usuario() {
    }

    public Usuario(String usuario, String contraseña) {
        super(usuario, contraseña);
    }
    
    public void registrarUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        int opc = 0;
        do {
            System.out.println("--MENU PRINCIPAL--");
            System.out.println("1.Registrarse\n2.Iniciar Sesion\n0.Salir");
            Scanner sc = new Scanner(System.in);
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("\nIngrese su usuario: ");
                    String usuario = sc.nextLine();
                    while (usuario.equals("")) {
                        System.out.println("El usuario no puede estar en blanco");
                        usuario = sc.nextLine();
                    }

                    System.out.println("Ingrese una contrasenia(8 caracteres): ");
                    String contrasenia = sc.nextLine();
                    while (contrasenia.length() != 8) {
                        System.out.println("Ingrese una contrasenia de 8 caracteres");
                        contrasenia = sc.nextLine();
                    }
                    Usuario nuevoUsuario = new Usuario(usuario, contrasenia);
                    usuarios.add(nuevoUsuario);
                    System.out.println("\n*****Usuario: " + "\"" + nuevoUsuario.getUsuario() + "\" registrado correctamente*****\n");
                    break;

                case 2:
                    System.out.println("\nUsuario: ");
                    usuario = sc.nextLine();
                    System.out.println("Contrasenia: ");
                    contrasenia = sc.nextLine();
                    Usuario inicioSesion = new Usuario(usuario, contrasenia);
                    if (usuarios.contains(inicioSesion)) {
                        System.out.println("\nBIENVENIDO "+ inicioSesion.getUsuario() + "!\n");
                        new Libro().mostrarMenu();
                    } else {
                        System.out.println("\n*****Usuario NO registrado*****\n");
                    }
                    break;
                case 0:
                    System.out.println("\nGracias por usar la aplicacion.\nDesarrollador: Nicolas Nunez.");
                    break;
                default:
                    System.out.println("Opcion invalida. Ingrese nuevamente\n");
            }
        } while (opc != 0);
    }
}
