    package com.example;

    import org.apache.poi.ss.usermodel.*;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.util.ArrayList;

    public class libreria {

        ArrayList<libro> libros = new ArrayList<>();

        public void agregarlibro(int id, String nombre, String autor, int unidades) {

            for (libro existente : libros) {

                if (existente.getId() == id) {

                    System.out.println("");
                    System.out.println("Ya existe un libro con este ID. No se puede agregar.");
                    return;

                }
            }

            libro nuevoLibro = new libro(id, nombre, autor, unidades);
            libros.add(nuevoLibro);
            System.out.println("");
            System.out.println("Libro agregado con ID: " + nuevoLibro.getId() + ", Título: " + nuevoLibro.getNombre()
                    + ", Autor: " + nuevoLibro.getAutor() + ", Cantidad: " + nuevoLibro.getUnidades() + ".");

        }

        public void buscartitulo(String titulo) {

            System.out.println("");
            System.out.println("Resultados de la busqueda: ");
            System.out.println("");
            int contador1 = 0;

            for (libro libro : libros) {

                String tituloMinusculaas = libro.getNombre().toLowerCase();
                String busquedaTitulo = titulo.toLowerCase();

                if (tituloMinusculaas.contains(busquedaTitulo)) {

                    libro.mostrarInformacion();
                    contador1++;

                }

            }

            if (contador1 == 0) {

                System.out.println("No se ha encontrado ningún resultado.");
                System.out.println("");

            }

        }

        public void buscarautor(String autor) {

            System.out.println("");
            System.out.println("Resultados de la busqueda: ");
            System.out.println("");
            int contador2 = 0;

            for (libro libro : libros) {

                String AutorMinusculaas = libro.getAutor().toLowerCase();
                String busquedaAutor = autor.toLowerCase();

                if (AutorMinusculaas.contains(busquedaAutor)) {

                    libro.mostrarInformacion();
                    contador2++;

                }

            }

            if (contador2 == 0) {

                System.out.println("No se ha encontrado ningún resultado.");
                System.out.println("");

            }

        }

        public void mostrarlibros() {

            int contadormostrar = 0;

            for (libro libro : libros) {

                libro.mostrarInformacion();
                contadormostrar++;

            }

            if (contadormostrar == 0) {

                System.out.println("No hay ningun libro.");

            }

        }

        public void sumarlibros(int idbuscar, int unidadedsañadidas) {

            int contador3 = 0;

            for (libro libro : libros) {

                if (libro.getId() == idbuscar) {

                    contador3++;

                    int unidadesnuevas = libro.getUnidades() + unidadedsañadidas;
                    libro.setUnidades(unidadesnuevas);

                    System.out.println("");
                    System.out.println("Has añadido " + unidadedsañadidas + " Unidades de " + libro.getNombre()
                            + ", ahora hay " + unidadesnuevas + " Unidades.");

                }

            }

            if (contador3 == 0) {

                System.out.println("");
                System.out.println("No se ha encontrado ningun libro con ese ID.");

            }

        }

        public void cargarDesdeExcel(File excel) {

            try (FileInputStream fis = new FileInputStream(excel);
                    Workbook workbook = new XSSFWorkbook(fis)) {
        
                Sheet sheet = workbook.getSheet("Libros");
        
                if (sheet != null && sheet.getLastRowNum() > 0) {

                    int rowCount = sheet.getLastRowNum();

                    for (int i = 1; i <= rowCount; i++) { 

                        Row row = sheet.getRow(i);

                        if (row != null) {
                            
                            int id = (int) row.getCell(0).getNumericCellValue();
                            String titulo = row.getCell(1).getStringCellValue();
                            String autor = row.getCell(2).getStringCellValue();
                            int unidades = (int) row.getCell(3).getNumericCellValue();
        
                            libro nuevoLibro = new libro(id, titulo, autor, unidades);
                            libros.add(nuevoLibro);

                        }
                    }
                }
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        

        public void guardarEnExcel(File excel) {

            try (FileInputStream fis = new FileInputStream(excel);
                    Workbook workbook = new XSSFWorkbook(fis);
                    FileOutputStream fos = new FileOutputStream(excel)) {
        
                Sheet sheet = workbook.getSheet("Libros");
        
                // Limpiar la hoja antes de agregar los nuevos datos

                int rowCount = sheet.getLastRowNum();
                for (int i = rowCount; i >= 1; i--) {

                    sheet.removeRow(sheet.getRow(i));

                }
        
                // Agregar los nuevos datos

                for (int i = 0; i < libros.size(); i++) {

                    Row row = sheet.createRow(i + 1); 
                    row.createCell(0).setCellValue(libros.get(i).getId());
                    row.createCell(1).setCellValue(libros.get(i).getNombre());
                    row.createCell(2).setCellValue(libros.get(i).getAutor());
                    row.createCell(3).setCellValue(libros.get(i).getUnidades());

                }
        
                // Guardar el libro en el archivo

                workbook.write(fos);
        
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
        
        public void vaciarLibros(File excel) {

            libros.clear();
            
            try (FileInputStream fis = new FileInputStream(excel);
                    Workbook workbook = new XSSFWorkbook(fis);
                    FileOutputStream fos = new FileOutputStream(excel)) {
        
                Sheet sheet = workbook.getSheet("Libros");
        
                // Limpiar

                int rowCount = sheet.getLastRowNum();
                for (int i = rowCount; i >= 1; i--) {

                    sheet.removeRow(sheet.getRow(i));

                }
        
                // Guardar los cambios en el archivo Excel

                workbook.write(fos);
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
