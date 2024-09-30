import java.util.Scanner;
public class OrdenVector
{
    public static void main(String[]args)
        {
            Scanner teclado = new Scanner(System.in);
            teclado.useDelimiter("\n");
            double [] elem_array = new double[4];
            System.out.println("Ingrese los elementos (4 numeros reales unicamente)");
            int i;
            for (i=0;i < 4; i++)
                {
                    elem_array[i] = teclado.nextDouble();
                    System.out.println("Elemento "+ (i+1) +" ingresado satisfactoriamente");
                }
            System.out.println("-fin de ingreso-");
            double menor = elem_array[0];
            System.out.println("Elementos desordenados");
            for (i = 0;i < 4; i++)
               {
                
                System.out.print(" "+elem_array[i]+"\t");
                if (menor > elem_array[i])
                    {
                       menor = elem_array[i];
                   }
                 } 
            double temp = 0;
            int tam = 4,j;
            for (j=1; j<tam; j++)
                {
                    for (i=0 ; i<tam - 1; i++)
                    {
                        if (elem_array[i] > elem_array[i+1])
                            {
                                temp = elem_array[i];
                                elem_array[i] = elem_array[i+1];
                                elem_array[i+1] = temp;
                            }
                    }
                }
            System.out.println("\n" + "Elementos ordenados");    
            for (i = 0;i < 4; i++)
                {
            
                    System.out.print(" "+elem_array[i]+"\t");
                }
            System.out.println("\n"+"El menor elemento es: "+menor);
                      
        }
}