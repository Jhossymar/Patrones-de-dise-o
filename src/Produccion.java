public class Produccion {
    public Produccion() {
    }

    public static void main(String[] args) {
        ConfiguracionAuto sedanConfig = (new ConfiguracionAuto()).conMotor("Gasolina").conAudio("Estándar").conSensores(false);
        ConfiguracionAuto suvConfig = (new ConfiguracionAuto()).conMotor("Eléctrico").conAudio("Premium").conSensores(true);
        Carro sedan = sedanConfig.crear();
        Carro mocho = suvConfig.crear();
        System.out.println(" Autos listos:");
        System.out.println("Sedán: " + sedan.mostrarDetalles());
        System.out.println("SUV: " + mocho.mostrarDetalles());
    }
}
