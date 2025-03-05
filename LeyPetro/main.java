package LeyPetro;
public class main{
    public static void main(String[] args){
        double salarioBase = 1500000;
        Liquidacion ley78 = new Ley78();
        Liquidacion ley86 = new Ley86();
        mostrarEncabezado.Encabezado();
        

      System.out.println("Ley 78: " + ley78.calcularPension(salarioBase));
      System.out.println("Ley 86: " + ley86.calcularPension(salarioBase));
      String nombreCodificado = nombreCod.getIdentidad();

      System.out.println("Identidad Codificada: " + nombreCodificado);

    }
}
abstract class Liquidacion{
    public abstract double calcularPension(double salario);

}
class Ley78 extends Liquidacion{
    @Override 
    public double calcularPension(double salario){
        return salario * 15;
    }
}
class Ley86 extends Liquidacion{
    @Override
    public double calcularPension(double salario){
        return salario * 5;
    }
}