
/**
 * Write a description of class Ejercicio_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejercicio_2
{
    public static void main (String [] args)
        {
            int a;
            int b;
            for(a=42;a<=150;a++)
                {
                    b = a%4;
                    if(b == 0)
                        {
                            System.out.println("El numero: "+a+" es multiplo de 4");
                        }
                 }
        }
}