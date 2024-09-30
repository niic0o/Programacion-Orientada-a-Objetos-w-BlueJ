import java.util.*;

/**
 * Write a description of class Empresa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IberaServicios
{
    public static void main (String [] args)
    {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        long cuil;
        double importe;
        String apellido,nombre,op, op2;
        int dia,mes,anio;
        System.out.println("-----------Ibera Servicios----------");
        do
        {
            System.out.println("\n"+"Gerente General, ingrese sus datos");
            System.out.print("CUIL: ");
            cuil = teclado.nextLong();
            System.out.print("Nombre: ");
            nombre = teclado.next();
            System.out.print("Apellido: ");
            apellido = teclado.next();
            System.out.print("Importe: ");
            importe = teclado.nextDouble();
            System.out.print("Año de ingreso: "+"\n");
            anio = teclado.nextInt();
            EmpleadoConJefe unGerente = new EmpleadoConJefe(cuil,apellido,nombre,importe,anio);
            unGerente.mostrar();
            System.out.println("\n"+"Ingrese los siguientes datos del empleado");
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
            EmpleadoConJefe unEmpleado = new EmpleadoConJefe(cuil,apellido,nombre,importe,unaFecha,unGerente);
            if (unEmpleado.esAniversario() == true)
            {      
                System.out.println("\n"+"Feliz año de ingreso "+unEmpleado.getNombre());
                System.out.println(unEmpleado.getApellido()+". Tiene habilitado el retiro anticipado de 1 hora reloj firmado por: "+unEmpleado.getJefe().apeYNom());
            }
            unEmpleado.mostrar();
            System.out.println("Ingrese si para introducir nuevos datos");
            op = teclado.next();
        }while(op.equals("si"));
    }
}

