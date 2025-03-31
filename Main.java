import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

// Interfaz común
interface Notificacion {
    void enviar(String mensaje);
}

// Implementación base
class NotificacionBase implements Notificacion {
    public void enviar(String mensaje) {
        System.out.println("Notificación enviada: " + mensaje);
    }
}

// Decorador base
abstract class NotificacionDecorator implements Notificacion {
    protected Notificacion notificacion;

    public NotificacionDecorator(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public void enviar(String mensaje) {
        notificacion.enviar(mensaje);
    }
}

// Decorador para SMS
class NotificacionSMS extends NotificacionDecorator {
    public NotificacionSMS(Notificacion notificacion) {
        super(notificacion);
    }

    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("También se envió por SMS: " + mensaje);
    }
}

// Decorador para WhatsApp
class NotificacionWhatsApp extends NotificacionDecorator {
    public NotificacionWhatsApp(Notificacion notificacion) {
        super(notificacion);
    }

    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("También se envió por WhatsApp: " + mensaje);
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
        String nombre = "nombre Codificado";
        String nombreCodificado = NombreCodificador.codificarNombre(nombre);
        String universidad = "Universidad Cooperativa de Colombia";
        String estudiante = "Jhossymar Garces";
        String profesor = "Harold Bolaños";
        String asignatura = "Patrones de Diseño";
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        System.out.println("========================================");
        System.out.println("               ENCABEZADO               ");
        System.out.println("========================================");
        System.out.println("Fecha       : " + fecha);
        System.out.println("Nombre      : " + nombre);
        System.out.println("Codificado  : " + nombreCodificado);
        System.out.println("Universidad : " + universidad);
        System.out.println("Estuadiante    : " + estudiante);
        System.out.println("Profesor    : " + profesor);
        System.out.println("Asignatura  : " + asignatura);
        System.out.println("========================================");
    }
}

// Cliente
public class Main {
    public static void main(String[] args) {
        // Mostrar el encabezado
        Encabezado.mostrar();

        // Notificación simple
        Notificacion noti = new NotificacionBase();

        // Decorar con SMS
        Notificacion notiSMS = new NotificacionSMS(noti);

        // Decorar con WhatsApp y SMS
        Notificacion notiCompleta = new NotificacionWhatsApp(notiSMS);

        // Enviar notificación con todas las funcionalidades
        notiCompleta.enviar("Tu pedido ha sido enviado.");
    }
}
