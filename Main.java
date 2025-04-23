// Interfaz que define el método clone
interface Prototype {
    Prototype clone();
}

// Clase HistorialMedico que implementa la interfaz Prototype
class HistorialMedico implements Prototype {
    private String nombrePaciente;
    private String historial;

    // Constructor de la clase
    public HistorialMedico(String nombrePaciente, String historial) {
        this.nombrePaciente = nombrePaciente;
        this.historial = historial;
    }

    // Implementación del método clone para clonar el objeto
    @Override
    public Prototype clone() {
        // Retornamos una copia del historial médico
        return new HistorialMedico(this.nombrePaciente, this.historial);
    }

    // Método para agregar una nueva nota médica
    public void agregarNota(String nota) {
        this.historial += "\n" + nota;
    }

    // Método para mostrar el historial médico
    public void mostrarHistorial() {
        System.out.println("Historial Médico de: " + nombrePaciente);
        System.out.println(historial);
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear un historial médico original
        HistorialMedico historialOriginal = new HistorialMedico("Carlos Paredes", "Diagnóstico inicial: Gripe.");

        // Clonar el historial médico
        HistorialMedico historialClonado = (HistorialMedico) historialOriginal.clone();

        // Agregar una nueva nota al historial clonado
        historialClonado.agregarNota("Nota adicional: Se recomienda control periódico de la presión arterial.");

        // Mostrar ambos historiales para comprobar que el original no ha sido alterado
        System.out.println("Historial Original:");
        historialOriginal.mostrarHistorial();

        System.out.println("\nHistorial Clonado:");
        historialClonado.mostrarHistorial();
    }
}


