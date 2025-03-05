package LeyPetro;
import java.util.Base64;
import java.util.Date;
import java.text.SimpleDateFormat;

public class mostrarEncabezado {
    
    public static void Encabezado(){
        
        String nombre = "Jhossymar Garces";
        String universidad = "Universidad Cooperativa De Colombia";
        String profe = "Harold Bolaños";
        String asignatura = "Patrones de Diseño";
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        System.out.println("Fecha: " + fecha);
        System.out.println("Nombre: "+nombre);
        System.out.println("Universidad: " + universidad);
        System.out.println("Profe: " + profe);
        System.out.println("Asignatura: " + asignatura);

        
     }

     
}
