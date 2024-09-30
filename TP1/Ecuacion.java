import java.lang.StrictMath;
public class Ecuacion
{
    public static void main (String[]args)
    {
        double a = Double.parseDouble(args[0]);
        double b = Double.valueOf(args[1]);
        double c = Double.parseDouble(args[2]);
        double discr = Math.pow(b,2) - (4 * a * c);
        double x1, x2;
        if (discr > 0)
            {
                x1 = (-b + discr) / (2 * a);
                x2 = (-b - discr) / (2 * a);
                System.out.println("El valor de x1 es: "+ x1 + "\n" + "El valor de x2 es: "+ x2);
            }
        if (discr == 0)
            {
                x1 = (-b) / (2 * a);
                System.out.println("El valor de x1 y x2 es: "+ x1);
            } 
        if (discr < 0)
            {
                System.out.println("Error! no es posible resolver en el conjunto de los numeros reales");
            }
    }
}
