# Proyecto-Biblioteca-Neoris
- Proyecto de gestión de una bibliotecta desarrollado en Java y aplicando el paradigma de POO
### Desarrollo Java Neoris / Siglo 21 
### Cohorte 1

## Lógica del programa
El proyecto está dividio en 3 paquetes: biblioteca, claseabstracta y usuarioregistro.
- En el paquete claseabstracta hay una clase abstracta llamada Registro. Esta contiene dos atributos privados, usuario y contraseña, su constructor, un getter del usuario y los métodos equals() y hashcode(). 
- Luego en el paquete usuarioregistro, está la clase Usuario. Esta clase hereda de la clase Registro y cuenta con un atributo de tipo Libro, su constructores y cuenta con una función llamada registrarUsuario(), la cual cuenta con un Switch el cual controla el menú de inicio donde el usuario puede registrarse, iniciar sesión o salir del programa. Se usan los métodos equals() y hashcode() nombrados anteriormente para comparar los ArrayList y así verificar si el usuario esta registrado o no cuando inicia sesión.
- El paquete bibiloteca cuenta con la clase Main y la clase Libro. La clase Libro define los atributos titulo, autor y genero, un ArrayList donde se guardan los libros, su constructores, getters para los atributos, los metodos hashcode(), equals() y toString(), además de varias funciones.
  La funcion mostrarMenu() muestra un menú principal, utilizando un switch, con las opciones agregar libro, eliminar libro, ver libros y salir. Cada una de esta opcion llama a una función que maneja la lógica para realizar dicha operación. Dentro de la opción ver libros, se muestra otro menú utlizando un switch donde el usuario puede ver la lista completa de libros, buscar un libro por su titulo, genero o autor y también reservar el libro y devolverlo. Todo esto es manejado con las funciones filtrarBusqueda(), reservar() y devolver().
  Por último, la clase Main instancia un objeto de tipo Usuario y llama al método registrarUsuario() y desde acá se llaman a los demás métodos que van ejecutandose a lo largo del programa.
## Problema a la hora del desarrollo
