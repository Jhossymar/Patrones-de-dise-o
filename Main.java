import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

interface LocalizadorWeb {
    void mostrarUbicacion();
}

class GPSCamion {
    public String obtenerUbicacion() {
        return "Lat: 4.60971, Lon: -74.08175";
    }
}

class AdaptadorGPS implements LocalizadorWeb {
    private GPSCamion gps;

    public AdaptadorGPS(GPSCamion gps) {
        this.gps = gps;
    }

    @Override
    public void mostrarUbicacion() {
        String ubicacion = gps.obtenerUbicacion();
        System.out.println("Ubicación del camión: " + ubicacion);
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

public class Main {
    public static void main(String[] args) {
        // Mostrar encabezado
        Encabezado.mostrar();

        // Crear y usar el adaptador GPS
        LocalizadorWeb localizador = new AdaptadorGPS(new GPSCamion());
        localizador.mostrarUbicacion();
    }
}
