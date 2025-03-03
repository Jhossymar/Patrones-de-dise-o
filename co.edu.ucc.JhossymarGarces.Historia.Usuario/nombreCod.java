import java.util.Base64;

public class nombreCod {
    public static String getIdentidad(){

        String nombreCompleto = "Jhossymar Garces";
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
     }
}