package co.edu.ucc.Jhossymar_Garces.app.pedidos;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

interface Cafe {
    String descripcion();
    double costo();
}

// ========== IMPLEMENTACIÓN BASE ==========
class CafeBasico implements Cafe {
    public String descripcion() { return "Café básico"; }
    public double costo() { return 5.0; }
}

// ========== DECORADOR ABSTRACTO ==========
abstract class CafeDecorator implements Cafe {
    protected Cafe cafe;

    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    public String descripcion() {
        return cafe.descripcion();
    }

    public double costo() {
        return cafe.costo();
    }
}

class ConLeche extends CafeDecorator {
    public ConLeche(Cafe cafe) {
        super(cafe);
    }

    public String descripcion() {
        return super.descripcion() + " + Leche";
    }

    public double costo() {
        return super.costo() + 1.5;
    }
}

class ConAzucar extends CafeDecorator {
    public ConAzucar(Cafe cafe) {
        super(cafe);
    }

    public String descripcion() {
        return super.descripcion() + " + Azúcar";
    }

    public double costo() {
        return super.costo() + 0.5;
    }
}

class NombreCodificador {
    public static String codificarNombre(String nombreCompleto) {
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
}

class Encabezado {
    public static void mostrar() {
        String nombre = "Jhossymar Garces";
        String codificado = NombreCodificador.codificarNombre(nombre);
        String universidad = "Universidad Cooperativa de Colombia";
        String profesor = "Harold Bolaños";
        String asignatura = "Patrones de Diseño";
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        System.out.println("========================================");
        System.out.println("               ENCABEZADO               ");
        System.out.println("========================================");
        System.out.println("Fecha       : " + fecha);
        System.out.println("Estudiante  : " + nombre);
        System.out.println("Codificado  : " + codificado);
        System.out.println("Universidad : " + universidad);
        System.out.println("Profesor    : " + profesor);
        System.out.println("Asignatura  : " + asignatura);
        System.out.println("========================================\n");
    }
}

// ========== CLASE PRINCIPAL ==========
public class PedidoCafe {
    public static void main(String[] args) {
        // Mostrar encabezado
        Encabezado.mostrar();

        Cafe cafe = new CafeBasico();
        cafe = new ConLeche(cafe);
        cafe = new ConAzucar(cafe);

        System.out.println("Descripción del pedido: " + cafe.descripcion());
        System.out.println("Costo total: $" + cafe.costo());

        // Métodos solicitados
        System.out.println("\ngetIdentidad(): " + getIdentidad());
        System.out.println("getPatron(): " + getPatron());
    }

    public static String getIdentidad() {
        return NombreCodificador.codificarNombre("Jhossymar Garces");
    }

    public static String getPatron() {
        return "Patrón implementado: Decorator";
    }
}
