import java.util.Scanner;
/**
 * Gestiona la emision del recibo de sueldo de docentes.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class Secretaria
{
    public static void main (String [] args)
    {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        String maestro, grado, colegio, domicilio, director, op;
        double sueldoBasico, asignacionFamiliar;
        System.out.println("-------------- BIENVENIDO ---------------");
        do
        {
            System.out.println("\n"+"Ingrese los datos del docente");
            System.out.print("Docente: ");
            maestro = teclado.next();
            System.out.print("Grado: ");
            grado = teclado.next();
            System.out.print("Sueldo Basico: ");
            sueldoBasico = teclado.nextDouble();
            System.out.print("Asignacion Familiar: ");
            asignacionFamiliar = teclado.nextDouble();
            Docente unDocente = new Docente(maestro,grado,sueldoBasico,asignacionFamiliar);
            System.out.println("\n"+"Ingrese los datos del establecimiento");
            System.out.print("Escuela: ");
            colegio = teclado.next();
            System.out.print("Domicilio: ");
            domicilio = teclado.next();
            System.out.print("Director: ");
            director = teclado.next();
            Escuela unaEscuela = new Escuela(colegio,domicilio,director);
            unaEscuela.imprimirRecibo(unDocente);
            System.out.print("\n"+"Desea emitir otro recibo? ('si')");
            op = teclado.next();
    }while(op.equals("si"));
}
}
