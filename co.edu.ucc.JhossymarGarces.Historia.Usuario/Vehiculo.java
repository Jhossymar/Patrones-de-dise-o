import java.text.SimpleDateFormat;
import java.util.Date;

public interface Vehiculo {
void mostrarTipo();
    
}
 class CarroElectrico implements Vehiculo{
    @Override
    public void mostrarTipo(){
        System.out.println("Soy un carro electrico");
    }
}
 class CarroGasolina implements Vehiculo{
    @Override
    public void mostrarTipo(){
        System.out.println("Soy un carro de gasolina");
    }
}
 class VehiculoFactory{
    public static Vehiculo crearVehiculo(String tipo){
        if (tipo.equalsIgnoreCase("electrico")){
            return new CarroElectrico();
        }else if (tipo.equalsIgnoreCase("gasolina")){
            return new CarroGasolina();
        } throw new IllegalArgumentException("Tipo de Vehiculo no valido");
    }

     
}

