import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

// Interfaz del nuevo sistema de reportes
interface ReporteNuevo {
    void generar(String datos);
}

// Sistema contable antiguo
class SistemaContableAntiguo {
    public void exportar(String contenido) {
        System.out.println("Exportando a sistema contable antiguo: " + contenido);
    }
}

// Adaptador para conectar el nuevo sistema con el antiguo
class AdaptadorReporte implements ReporteNuevo {
    private SistemaContableAntiguo sistemaAntiguo;

    public AdaptadorReporte(SistemaContableAntiguo sistemaAntiguo) {
        this.sistemaAntiguo = sistemaAntiguo;
    }

    @Override
    public void generar(String datos) {
        // Convertimos los datos del nuevo sistema al formato esperado por el sistema antiguo
        sistemaAntiguo.exportar(datos);
    }
}

// Clase para codificar nombres en Base64
class NombreCodificador {
    public static String codificarNombre(String nombreCompleto) {
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
}

// Clase para mostrar el encabezado del programa
class Encabezado {
    public static void mostrar() {
        String nombre = "Jhossymar Garces";  // Se usa el nombre del estudiante
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

// Cliente que usa el nuevo sistema de reportes
public class Main {
    public static void main(String[] args) {
        // Mostrar el encabezado
        Encabezado.mostrar();

        // Crear instancia del sistema contable antiguo
        SistemaContableAntiguo sistemaAntiguo = new SistemaContableAntiguo();

        // Adaptar el nuevo sistema de reportes al sistema contable antiguo
        ReporteNuevo reporte = new AdaptadorReporte(sistemaAntiguo);

        // Generar un reporte con el nuevo sistema
        reporte.generar("Reporte financiero de marzo 2025");
    }
}
