import java.util.*;

/**
 * Write a description of class Empresa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empresa
{
    public static void main (String [] args)
    {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        long cuil;
        double importe;
        String apellido,nombre,op;
        int dia,mes,anio;
        System.out.println("-----------Empresa----------");
        do
        {
            System.out.println("\n"+"Ingrese los siguientes datos");
            System.out.print("CUIL: ");
            cuil = teclado.nextLong();
            System.out.print("Nombre: ");
            nombre = teclado.next();
            System.out.print("Apellido: ");
            apellido = teclado.next();
            System.out.print("Importe: ");
            importe = teclado.nextDouble();
            System.out.print("Año de ingreso: ");            
            anio = teclado.nextInt();
            System.out.print("Mes(nº): ");
            mes = teclado.nextInt();
            mes = mes - 1;//0 enero - 11 diciembre
            System.out.print("Dia: ");
            dia = teclado.nextInt();
            Calendar unaFecha = new GregorianCalendar(anio,mes,dia);
            Empleado unEmpleado = new Empleado(cuil,apellido,nombre,importe,unaFecha);
            if (unEmpleado.esAniversario() == true)
            {      
                System.out.println("\n"+"Feliz año de ingreso "+unEmpleado.getNombre());
                System.out.println("Usted puede retirarse 1 hora antes con previo aviso");
            }

            System.out.println("Ingrese si para introducir nuevos datos");
            op = teclado.next();
        }while(op.equals("si"));
    }
}
