import java.lang.StrictMath;
import java.util.Scanner;
public class Circunferencia
{
    public static void main(String[]args)
        {
            Scanner teclado = new Scanner(System.in);
            teclado.useDelimiter("\n");
            double perimetro, radio;
            String op;
            do {
            System.out.println("ingrese el radio");
            radio = teclado.nextDouble();
            perimetro = 2 * Math.PI * radio;
            System.out.println("El perimetro es: "+ perimetro);
            System.out.println("'si' para ingresar otro numero, cualquier tecla para finalizar");
            op = teclado.next();
               }while(op.equals("si"));
        }
}
