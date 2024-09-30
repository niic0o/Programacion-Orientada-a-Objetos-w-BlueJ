import java.lang.StrictMath;
public class Ejercicio_4
{
    public static void main(String[]args)
        {
            double a = Double.parseDouble(args[0]);
            double b = Double.valueOf(args[1]);
            double c = Double.parseDouble(args[2]);
            double semip = (a + b + c) / 2;
            double area = (Math.sqrt(semip * ((semip - a) * (semip - b) * (semip - c))));
            System.out.println("El semiperimetro es: "+ semip + "\n" + "El area es: "+ area);
        }   
}
