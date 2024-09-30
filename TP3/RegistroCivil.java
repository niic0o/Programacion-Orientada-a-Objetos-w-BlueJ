import java.util.Scanner;
import java.lang.Object;
/**
 * Gestiona el casamiento de una pareja
 * 
 * @author Nicolas Ariel Sena
 * @version 14/09/2017
 */
public class RegistroCivil
{
    public static void main (String [] args)
    {

        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        int op,op2, edad;
        String op3,nombre, apellido;
        System.out.println("--------- Registro Civil ----------"); 
        do
        {
            System.out.print("\n"+"Nombre (mujer): ");
            nombre = teclado.next();
            System.out.print("Apellido: ");
            apellido = teclado.next();
            System.out.print("Edad: ");
            edad = teclado.nextInt();
            Mujer unaMujer = new Mujer(nombre,apellido,edad);
            System.out.print("\n"+"Nombre (hombre): ");
            nombre = teclado.next();
            System.out.print("Apellido: ");
            apellido = teclado.next();
            System.out.print("Edad: ");
            edad = teclado.nextInt();
            Hombre unHombre = new Hombre(nombre,apellido,edad);
            do
            {
                System.out.println("\n"+"Ingrese 0 para casar a la mujer");
                System.out.println("Ingrese 1 para casar al hombre");
                System.out.println("Ingrese 2 para divorciar a la mujer");
                System.out.println("Ingrese 3 para divorciar al hombre");
                System.out.println("Ingrese 4 para ver estado civil (mujer)");
                System.out.println("Ingrese 5 para ver estado civil (hombre)");
                System.out.println("Ingrese 6 para emitir certificado de matrimonio (M)");
                System.out.println("Ingrese 7 para emitir certificado de matrimonio (H)"+"\n"); 
                op = teclado.nextInt();
                switch(op) {
                    case 0: unaMujer.casarseCon(unHombre); break;    
                    case 1: unHombre.casarseCon(unaMujer); break;
                    case 2: unaMujer.divorcio(); break;
                    case 3: unHombre.divorcio(); break;
                    case 4: unaMujer.mostrarEstadoCivil(); break;
                    case 5: unHombre.mostrarEstadoCivil(); break;
                    case 6: unaMujer.casadaCon(); break;
                    case 7: unHombre.casadoCon(); break;
                    default: System.out.print("valor incorrecto!"); break;
                }
                System.out.println("'1' para continuar operando");
                op2 = teclado.nextInt();
            }while(op2 == 1);
            System.out.println("'0' para ingresar otra pareja");
            op3 = teclado.next();
        }while(op3.equals("0"));
    }
}
