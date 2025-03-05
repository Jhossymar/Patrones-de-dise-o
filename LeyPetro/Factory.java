package LeyPetro;
abstract class Liquidacion{
    public abstract double calcularPension(double salario);

}
class Ley78 extends Liquidacion{
    @Override
    public double calcularPension(double salario){
        return salario * 15;
    }
}
class Ley86 extends Liquidacion {
    @Override
    public double calcularPension(double salario){
        return salario * 5;
    }
}
class Ley98 extends Liquidacion{
    @Override
    public double calcularPension(double salario){
        return salario * 2.5;

    }
 
}
class Ley100 extends Liquidacion{
    @Override
    public double calcularPension(double salario){
        return salario;
    }

}
class LeyPetro extends Liquidacion{
    @Override
    public double calcularPension(double salario){
        return Math.min(salario * 3.5, salario * 0.7);
    }
}
class LiquidacionFactory {
    public static Liquidacion obtenerLiquidacion(String tipo){
        switch (tipo){
            case "Ley78": return new Ley78();
            case "Ley86": return new Ley86();
            case "Ley98": return new Ley98();
            case "Ley100": return new Ley100();
            case "LeyPetro": return new LeyPetro();
            default: throw new IllegalArgumentException ("Ley no reconocida");

        }
    }
}
public class Factory {
    public static void Main(String [] args){
        double salarioBase = 1500000;
        String[] leyes ={"Ley78", "Ley86", "Ley98", "Ley100", "LeyPetro"};
        

        for (String ley : leyes) {
            Liquidacion liquidacion = LiquidacionFactory.obtenerLiquidacion(ley);
            System.out.println(ley + ": $" + liquidacion.calcularPension(salarioBase));
        }
    }
}