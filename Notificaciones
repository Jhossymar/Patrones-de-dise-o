import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

// Interfaz para el canal de notificación
interface CanalNotificacion {
    void enviar(String mensaje);
}

// Implementación del canal de notificación: Email
class Email implements CanalNotificacion {
    public void enviar(String mensaje) {
        System.out.println("Email enviado: " + mensaje);
    }
}

// Implementación del canal de notificación: SMS
class SMS implements CanalNotificacion {
    public void enviar(String mensaje) {
        System.out.println("SMS enviado: " + mensaje);
    }
}

// Abstracción: Notificador
abstract class Notificador {
    protected CanalNotificacion canal;

    public Notificador(CanalNotificacion canal) {
        this.canal = canal;
    }

    public abstract void notificar(String mensaje);
}

// Implementación de Notificador para órdenes
class NotificadorOrden extends Notificador {
    public NotificadorOrden(CanalNotificacion canal) {
        super(canal);
    }

    public void notificar(String mensaje) {
        canal.enviar("Orden: " + mensaje);
    }
}

// Implementación de Notificador para facturas
class NotificadorFactura extends Notificador {
    public NotificadorFactura(CanalNotificacion canal) {
        super(canal);
    }

    public void notificar(String mensaje) {
        canal.enviar("Factura: " + mensaje);
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
        String nombre = "Nombre Modificado";
        String nombreCodificado = NombreCodificador.codificarNombre(nombre);
        String universidad = "Universidad Cooperativa de Colombia";
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
        System.out.println("Profesor    : " + profesor);
        System.out.println("Asignatura  : " + asignatura);
        System.out.println("========================================");
    }
}

// Clase principal (Main)
public class Main {
    public static void main(String[] args) {
        // Mostrar el encabezado
        Encabezado.mostrar();

        // Crear notificaciones
        Notificador noti1 = new NotificadorOrden(new Email());
        Notificador noti2 = new NotificadorFactura(new SMS());

        // Enviar notificaciones
        noti1.notificar("Tu pedido ha sido enviado.");
        noti2.notificar("Tu factura está lista.");
    }
}
