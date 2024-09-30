import java.util.*;
public class creaEmpleado
{
    public static void main (String [] args)
        {
            Scanner teclado = new Scanner(System.in);
            teclado.useDelimiter("\n");
            long cuil;
            String apellido, nombre, op;
            double sueldoBasico;
            int anioIngreso;
            System.out.println("-------- Liquidacion de sueldo -------"+"\n"+"\n"+"Ingrese los siguientes datos:"+"\n");
            do{
                System.out.print("CUIL: ");
                cuil = teclado.nextLong();
                System.out.print("Nombre: ");
                nombre = teclado.next();
                System.out.print("Apellido: ");
                apellido = teclado.next();
                System.out.print("Sueldo Basico(usar coma): ");
                sueldoBasico = teclado.nextDouble();
                System.out.print("Anio Ingreso: ");
                anioIngreso = teclado.nextInt();
                Empleado unEmpleado = new Empleado(cuil,nombre,apellido,sueldoBasico,anioIngreso);
                System.out.println("\n");
                unEmpleado.mostrar();
                System.out.println(" "+unEmpleado.mostrarLinea());
                System.out.println("\n"+"Ingrese 'si' para ingresar nuevos datos, cualquier letra para salir"+"\n");
                op = teclado.next();
                System.out.println("\n"+"--------------------"+"\n");
            }while(op.equals("si"));
        }                   
}
