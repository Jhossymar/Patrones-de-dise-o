public class Carro {
    private String tipoMotor;
    private String sistemaDeAudio;
    private boolean sensoresReversa;

    public Carro(String tipoMotor, String sistemaDeAudio, boolean sensoresReversa) {
        this.tipoMotor = tipoMotor;
        this.sistemaDeAudio = sistemaDeAudio;
        this.sensoresReversa = sensoresReversa;
    }

    public String mostrarDetalles() {
        String sensores = this.sensoresReversa ? "con sensores de reversa" : "sin sensores de reversa";
        return "Motor: " + this.tipoMotor + ", Audio: " + this.sistemaDeAudio + ", " + sensores;
    }

    public static void main(String[] args) {
        Carro miCarro = new Carro("Gasolina", "Pioneer", false);
        System.out.println("Mi carro: " + miCarro.mostrarDetalles());
        Carro carroDeJhossymar = new Carro("Eléctrico", "Bose", true);
        System.out.println("El carro de Jhossymar: " + carroDeJhossymar.mostrarDetalles());
    }
}
