import java.text.SimpleDateFormat;
import java.util.Date;

public class Main{
public static void main(String[] args){
    mostrarEncabezado.Encabezado();
    Vehiculo v1 = VehiculoFactory.crearVehiculo("electrico");
    Vehiculo v2 = VehiculoFactory.crearVehiculo("gasolina");
    v1.mostrarTipo();
    v2.mostrarTipo();

    String nombreCodificado = nombreCod.getIdentidad();

    System.out.println("Identidad Codificada: " + nombreCodificado);
   }
   
    
}
