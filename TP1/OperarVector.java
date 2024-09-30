import java.util.Scanner;
public class OperarVector
{
    public static void main(String[]args)
        {
            Scanner teclado = new Scanner(System.in);
            teclado.useDelimiter("\n");
            int [] notas_array = new int[5];
            System.out.println("Ingrese las notas (5)");
            int i;
            for (i=0;i < 5; i++)
                {
                    notas_array[i] = teclado.nextInt();
                    System.out.println("Nota "+ (i+1) +" ingresada satisfactoriamente");
                }
            System.out.println("-fin de ingreso-");
            float promedio;
            int mayor = 0, suma = 0, div = 0;
            for (i = 0;i < 5; i++)
                {
                    suma = suma + notas_array[i];
                    System.out.print(" "+notas_array[i]+"\t");
                    div++;
                    if (mayor < notas_array[i])
                        {
                            mayor = notas_array[i];
                        }
                 }
            promedio = suma / div;
            System.out.println("\n"+"La mayor nota es: "+mayor+"\n"+"El promedio es: "+promedio);
        }             
}
