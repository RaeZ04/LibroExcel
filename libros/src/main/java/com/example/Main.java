package com.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File excel = new File("libros.xlsx");

        libreria libreria = new libreria();

        libreria.cargarDesdeExcel(excel);

        int eleccion;
        boolean dentro = true;

        admin admin = new admin("admin", "admin");
        usuario usuarioEstandar = new usuario("user", "user");

        do {
            System.out.println("");
            System.out.println("------------------");
            System.out.println(" Inicio De Sesión");
            System.out.println("------------------");
            System.out.println("");

            System.out.print("Introduce tu nombre de usuario: ");
            String usuario = InputOutput.leerString();

            System.out.print("Introduce la contraseña: ");
            String pass = InputOutput.leerString();
            System.out.println("");

            if (usuario.equals(admin.getNombreUsuario()) && pass.equals(admin.getContraseña())) {

                boolean dentrosesion = true;

                System.out.println("----------------------------------------------------------");
                System.out.println(" Has iniciado sesión como Administrador, que deseas hacer:");
                System.out.println("----------------------------------------------------------");

                do {

                    System.out.println("");
                    System.out.println("Biblioteca");
                    System.out.println(" ");
                    System.out.println("1. Agregar Libro");
                    System.out.println("2. Buscar un libro");
                    System.out.println("3. Lista de libros");
                    System.out.println("4. Añadir Unidades");
                    System.out.println("5. Borrar Libros");
                    System.out.println("6. Cerrar Sesión");
                    System.out.println("7. Salir del programa");
                    System.out.println("");
                    System.out.print("Elige una opcion: ");

                    eleccion = InputOutput.leerInt();

                    System.out.println("");

                    if (eleccion == 1) {

                        System.out.print("Introduzca el ID: ");
                        int id = InputOutput.leerInt();

                        System.out.print("Introduzca el titulo del libro: ");
                        String nombre = InputOutput.leerString();

                        System.out.print("Introduzca el autor del libro: ");
                        String autor = InputOutput.leerString();

                        System.out.print("Introduzca cantidad de libros: ");
                        int cantidad = InputOutput.leerInt();

                        libreria.agregarlibro(id, nombre, autor, cantidad);

                    } else if (eleccion == 2) {

                        int eleccion2;

                        do {
                            System.out.println("");
                            System.out.println("1. Buscar por título ");
                            System.out.println("2. Buscar por autor ");
                            System.out.println("3. Volver atrás");

                            System.out.print("Elige una opcion: ");
                            eleccion2 = InputOutput.leerInt();

                            if (eleccion2 == 1) {

                                System.out.print("Introduce el título: ");
                                String titulo = InputOutput.leerString();
                                libreria.buscartitulo(titulo);

                            } else if (eleccion2 == 2) {

                                System.out.print("Introduce el autor: ");
                                String autor = InputOutput.leerString();
                                libreria.buscarautor(autor);

                            } else if (eleccion2 == 3) {

                            } else {

                                System.out.println("");
                                System.out.println("Has elegido una opción incorrecta, elige del 1-3.");
                                System.out.println("");
                                
                            }

                        } while (eleccion2 != 3);

                    } else if (eleccion == 3) {

                        libreria.mostrarlibros();

                    } else if (eleccion == 4) {

                        System.out.print("Indica el ID del libro al que quieres añadir unidades: ");
                        int idbuscar = InputOutput.leerInt();
                        System.out.print("Indica cuantas unidades quieres añadir: ");
                        int unidadesañadidas = InputOutput.leerInt();
                        libreria.sumarlibros(idbuscar, unidadesañadidas);

                    } else if (eleccion == 5) {

                        libreria.vaciarLibros(excel);
                        System.out.println("Has borrado todos los libros.");

                    } else if (eleccion == 6) {

                        System.out.println("Has cerrado sesión.");
                        dentrosesion = false;

                    } else if (eleccion == 7) {

                        System.out.println("Has salido del programa.");
                        dentro = false;

                    } else {

                        System.out.println("Opción no valida, elija del 1-6, o 7 para salir.");

                    }
                } while (eleccion != 7 && dentrosesion == true);

            } else if (usuario.equals(usuarioEstandar.getNombreUsuario()) && pass.equals(usuarioEstandar.getContraseña())) {

                boolean dentrosesion = true;

                System.out.println("----------------------------------------------------------");
                System.out.println(" Has iniciado sesión como Usuario, que deseas hacer:");
                System.out.println("----------------------------------------------------------");

                do {

                    System.out.println("");
                    System.out.println("Biblioteca");
                    System.out.println("");
                    System.out.println("1. Buscar un libro");
                    System.out.println("2. Lista de libros");
                    System.out.println("3. Cerrar Sesión");
                    System.out.println("4. Salir del programa");
                    System.out.println("");
                    System.out.print("Elige una opcion: ");

                    eleccion = InputOutput.leerInt();

                    System.out.println("");

                    if (eleccion == 1) {

                        int eleccion2;

                        do {

                            System.out.println("");
                            System.out.println("1. Buscar por título ");
                            System.out.println("2. Buscar por autor ");
                            System.out.println("3. Volver atrás");

                            System.out.print("Elige una opcion: ");
                            eleccion2 = InputOutput.leerInt();

                            if (eleccion2 == 1) {

                                System.out.print("Introduce el título: ");
                                String titulo = InputOutput.leerString();
                                libreria.buscartitulo(titulo);

                            } else if (eleccion2 == 2) {

                                System.out.print("Introduce el autor: ");
                                String autor = InputOutput.leerString();
                                libreria.buscarautor(autor);

                            } else if (eleccion2 == 3) {

                            } else {

                                System.out.println("");
                                System.out.println("Has elegido una opción incorrecta, elige del 1-3.");
                                System.out.println("");

                            }

                        } while (eleccion2 != 3);

                    } else if (eleccion == 2) {

                        libreria.mostrarlibros();

                    } else if (eleccion == 3) {

                        System.out.println("Has cerrado sesión.");
                        dentrosesion = false;

                    } else if (eleccion == 4) {

                        System.out.println("Has salido del programa.");
                        dentro = false;
                        
                    } else {

                        System.out.println("Opción no valida, elija del 1-3, o 4 para salir.");

                    }

                } while (eleccion != 4 && dentrosesion == true);

            } else {

                System.out.println("Nombre de usuario o contraseña incorrectos");

            }

        } while (dentro);

        libreria.guardarEnExcel(excel);
        
    }
}
