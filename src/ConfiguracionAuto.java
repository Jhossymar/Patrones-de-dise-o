public class ConfiguracionAuto {
    private String motor;
    private String audio;
    private boolean sensores;

    public ConfiguracionAuto() {
    }

    public ConfiguracionAuto conMotor(String motor) {
        this.motor = motor;
        return this;
    }

    public ConfiguracionAuto conAudio(String audio) {
        this.audio = audio;
        return this;
    }

    public ConfiguracionAuto conSensores(boolean sensores) {
        this.sensores = sensores;
        return this;
    }

    public Carro crear() {
        return new Carro(this.motor, this.audio, this.sensores);
    }
}

