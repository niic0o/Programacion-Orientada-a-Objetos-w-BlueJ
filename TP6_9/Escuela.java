import java.util.Scanner;
/**
 * Write a description of class Escuela here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escuela{
    public static void main (String [] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        String nombre, apellido; 
        int dni,lu,año,opcion;
        double nota1, nota2;
        Persona persona = null;
        Alumno alumno = null;        
        System.out.println("********Bienvenido********");
        do{
            System.out.println("\n"+"1 - Gestion persona"+
                "\n"+"2 - Gestion alumno"+
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
                año = teclado.nextInt();
                persona = new Persona(dni,nombre,apellido,año);
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
                año = teclado.nextInt();
                System.out.print("Lu: ");
                lu = teclado.nextInt();
                System.out.print("Nota 1: ");
                nota1 = teclado.nextDouble();
                System.out.print("Nota 2: ");
                nota2 = teclado.nextDouble();
                alumno = new Alumno(dni,nombre,apellido,año,lu);
                alumno.setNota1(nota1);
                alumno.setNota2(nota2);
                alumno.mostrar();
                break;
                default: System.out.println("chau pe!");
            }
    }while(opcion != 3);
}
}

