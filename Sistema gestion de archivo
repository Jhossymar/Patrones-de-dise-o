package co.edu.ucc.Jhossymar_Garces.Sistema_gestion_archivo.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Base64;
import java.text.SimpleDateFormat;
import java.util.Date;

// ========== INTERFAZ COMÚN ==========
interface ElementoMenu {
    void mostrar();
}

class Opcion implements ElementoMenu {
    private String nombre;

    public Opcion(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.println("Opción: " + nombre);
    }
}

// ========== CLASE COMPUESTA (Menú) ==========
class Menu implements ElementoMenu {
    private String nombre;
    private List<ElementoMenu> elementos = new ArrayList<>();

    public Menu(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ElementoMenu elemento) {
        elementos.add(elemento);
    }

    public void mostrar() {
        System.out.println("Menú: " + nombre);
        for (ElementoMenu e : elementos) {
            e.mostrar();
        }
    }
}

// ========== CODIFICADOR DE NOMBRE ==========
class NombreCodificador {
    public static String codificarNombre(String nombreCompleto) {
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
}

// ========== ENCABEZADO PERSONALIZADO ==========
class Encabezado {
    public static void mostrar() {
        String nombre = "co.edu.ucc.Jhossymar_Garces.Sistema_gestion_archivo.Garces.Jhossymar Garces";
        String nombreCodificado = NombreCodificador.codificarNombre(nombre);
        String universidad = "Universidad Cooperativa de Colombia";
        String profesor = "Harold Bolaños";
        String asignatura = "Patrones de Diseño";
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        System.out.println("========================================");
        System.out.println("               ENCABEZADO               ");
        System.out.println("========================================");
        System.out.println("Fecha       : " + fecha);
        System.out.println("Estudiante  : " + nombre);
        System.out.println("Codificado  : " + nombreCodificado);
        System.out.println("Universidad : " + universidad);
        System.out.println("Profesor    : " + profesor);
        System.out.println("Asignatura  : " + asignatura);
        System.out.println("========================================");
    }
}

// ========== MAIN ==========
public class Menuaplicacion {
    public static void main(String[] args) {
        Encabezado.mostrar();

        // Crear opciones
        Opcion opcion1 = new Opcion("Abrir archivo");
        Opcion opcion2 = new Opcion("Guardar archivo");
        Opcion opcion3 = new Opcion("Imprimir");
        Opcion opcion4 = new Opcion("Salir");

        // Submenú Archivo
        Menu menuArchivo = new Menu("Archivo");
        menuArchivo.agregar(opcion1);
        menuArchivo.agregar(opcion2);
        menuArchivo.agregar(opcion3);

        // Submenú Ayuda
        Menu menuAyuda = new Menu("Ayuda");
        menuAyuda.agregar(new Opcion("Acerca de"));
        menuAyuda.agregar(new Opcion("Soporte"));

        // Menú principal
        Menu menuPrincipal = new Menu("Menú Principal");
        menuPrincipal.agregar(menuArchivo);
        menuPrincipal.agregar(menuAyuda);
        menuPrincipal.agregar(opcion4);

        // Mostrar menú completo
        menuPrincipal.mostrar();
    }
}
