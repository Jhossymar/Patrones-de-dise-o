package co.edu.ucc.Jhossymar_Garces.ejercicioadapterbridge;

// Interface común para dispositivos GPS (Adapter)
interface GpsDevice {
    String getLocation();
    String getStatus();
}

// Simulaciones de APIs de terceros
class GarminAPI {
    String fetchCoordinates() { return "Garmin: 4.7110,-74.0721"; }
    String fetchStatus() { return "Garmin: Activo"; }
}

class TomTomAPI {
    String getPos() { return "TomTom: 6.2442,-75.5812"; }
    String getState() { return "TomTom: Inactivo"; }
}

class HuaweiAPI {
    String location() { return "Huawei: 10.9878,-74.7889"; }
    String status() { return "Huawei: En movimiento"; }
}

// Adaptadores (Adapter Pattern)
class GarminAdapter implements GpsDevice {
    private GarminAPI garmin;
    public GarminAdapter(GarminAPI garmin) {
        this.garmin = garmin;
    }
    public String getLocation() {
        return garmin.fetchCoordinates();
    }
    public String getStatus() {
        return garmin.fetchStatus();
    }
}

class TomTomAdapter implements GpsDevice {
    private TomTomAPI tomtom;
    public TomTomAdapter(TomTomAPI tomtom) {
        this.tomtom = tomtom;
    }
    public String getLocation() {
        return tomtom.getPos();
    }
    public String getStatus() {
        return tomtom.getState();
    }
}

class HuaweiAdapter implements GpsDevice {
    private HuaweiAPI huawei;
    public HuaweiAdapter(HuaweiAPI huawei) {
        this.huawei = huawei;
    }
    public String getLocation() {
        return huawei.location();
    }
    public String getStatus() {
        return huawei.status();
    }
}

// Bridge Pattern - Abstracción y sus implementaciones
interface PanelRenderer {
    void render(String location, String status);
}

class MobilePanel implements PanelRenderer {
    public void render(String location, String status) {
        System.out.println("[MÓVIL] Ubicación: " + location + " | Estado: " + status);
    }
}

class DesktopPanel implements PanelRenderer {
    public void render(String location, String status) {
        System.out.println("[ESCRITORIO] Ubicación: " + location + " | Estado: " + status);
    }
}

abstract class TrackingPanel {
    protected PanelRenderer renderer;
    public TrackingPanel(PanelRenderer renderer) {
        this.renderer = renderer;
    }
    public abstract void display(String location, String status);
}

class ConcreteTrackingPanel extends TrackingPanel {
    public ConcreteTrackingPanel(PanelRenderer renderer) {
        super(renderer);
    }
    public void display(String location, String status) {
        renderer.render(location, status);
    }
}

// Utilidad para mostrar patrón
class UserInfo {
    public static String getPatron() {
        return "Adapter, Bridge";
    }
}

// Clase principal
public class Gps {
    public static void main(String[] args) {
        GpsDevice gps = new GarminAdapter(new GarminAPI()); // Se puede cambiar a TomTomAdapter o HuaweiAdapter

        PanelRenderer renderer = new MobilePanel(); // O new DesktopPanel()
        TrackingPanel panel = new ConcreteTrackingPanel(renderer);

        panel.display(gps.getLocation(), gps.getStatus());

        // Información adicional
        System.out.println("Patrón implementado: " + UserInfo.getPatron());
    }
}
