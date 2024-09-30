import java.util.Scanner;
/**
 * Write a description of class Escuela here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empresa{
    public static void main (String [] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        String nombre, apellido; 
        int dni,añoNac,añoIngreso,opcion;
        double importe;
        long cuil;
        Persona persona = null;
        Empleado empleado = null;        
        System.out.println("********Bienvenido********");
        do{
            System.out.println("\n"+"1 - Gestion persona"+
                "\n"+"2 - Gestion empleado"+
                "\n"+"3 - Salir"+"\n");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                System.out.print("Dni: ");
                dni = teclado.nextInt();
                System.out.print("Nombre: ");
                nombre = teclado.next();
                System.out.print("Apellido: ");
                apellido = teclado.next();
                System.out.print("Año nacimiento: ");
                añoNac = teclado.nextInt();
                persona = new Persona(dni,nombre,apellido,añoNac);
                persona.mostrar();
                break;
                
                case 2:
                System.out.print("Dni: ");
                dni = teclado.nextInt();
                System.out.print("Nombre: ");
                nombre = teclado.next();
                System.out.print("Apellido: ");
                apellido = teclado.next();
                System.out.print("Año nacimiento: ");
                añoNac = teclado.nextInt();
                System.out.print("Cuil: ");
                cuil = teclado.nextLong();
                System.out.print("Sueldo Basico: ");
                importe = teclado.nextDouble();
                System.out.print("Año ingreso: ");
                añoIngreso = teclado.nextInt();
                empleado = new Empleado(dni,nombre,apellido,añoNac,cuil,importe,añoIngreso);
                empleado.mostrar();
                break;
                default: System.out.println("chau pe!");
            }
    }while(opcion != 3);
}
}
