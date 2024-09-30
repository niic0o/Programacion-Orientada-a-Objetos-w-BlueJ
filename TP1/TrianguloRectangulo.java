import java.lang.StrictMath;

public class TrianguloRectangulo
{
  public static void main(String[]args)
    {
        double h = Double.parseDouble(args[0]);
        double c1 = Double.valueOf(args[1]);
        double c2 = Double.parseDouble(args[2]);
        if ((Math.pow(h,2)) == (Math.pow(c1,2) + Math.pow(c2,2)))
            {
                System.out.println("El triangulo es rectangulo");
            }
        else 
        System.out.println("El triangulo no es rectangulo");

    }
}
