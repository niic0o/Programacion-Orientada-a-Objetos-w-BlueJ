import java.util.*;
/**
 * Gestiona la inscripcion de alumnos a un curso
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class Carrera
{
    public static void main (String [] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        //Curso
        String nombre;
        //Alumno
        int lu,opcion;
        String apellido;// y nombre
        double nota1,nota2;
        System.out.println("********** BIENVENIDO **********");
        System.out.print("Ingrese el nombre del curso: ");
        nombre = teclado.next();
        Curso unCurso = new Curso(nombre);
        do{
            System.out.println("\n"+"1 - Inscribir alumno"+
                "\n"+"2 - Añadir notas de parciales"+
                "\n"+"3 - Ver lista de inscriptos"+
                "\n"+"4 - Eliminar alumno"+
                "\n"+"5 - Buscar alumno"+
                "\n"+"6 - Ver promedio de alumno"+
                "\n"+"7 - Salir"+"\n");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                System.out.println("Ingrese los datos del alumno");
                System.out.print("LU :");
                lu = teclado.nextInt();
                System.out.print("Nombre: ");
                nombre = teclado.next();
                System.out.print("Apellido: ");
                apellido = teclado.next();
                Alumno unAlumno = new Alumno(lu,nombre,apellido);
                unCurso.inscribirAlumno(unAlumno);
                break;

                case 2:
                System.out.print("LU del alumno: ");
                lu = teclado.nextInt();
                System.out.print("Nota 1: ");
                nota1 = teclado.nextDouble();
                System.out.print("Nota 2: ");
                nota2 = teclado.nextDouble();
                unCurso.agragarNotas(lu,nota1,nota2);
                break;

                case 3:
                unCurso.mostrarInscriptos();
                break;

                case 4:
                System.out.print("LU del alumno a eliminar: ");
                lu = teclado.nextInt();
                if(unCurso.estaInscripto(lu) == false){
                        System.out.println("Ese alumno no esta inscripto!");
                }else{                
                Alumno chauAlumno = unCurso.quitarAlumno(lu);
                System.out.println("Se da de baja a "+chauAlumno.getNombre()+
                    " porque abandona el curso --****");
                System.out.println("Esta "+chauAlumno.getNombre()+" inscripto??"+
                    "--> "+unCurso.estaInscripto(chauAlumno));  
                }
                break;

                case 5:
                System.out.print("Ingrese LU: ");
                lu = teclado.nextInt();
                unCurso.muestraAlumno(lu);
                break;

                case 6:
                System.out.print("Ingrese LU: ");
                lu = teclado.nextInt();
                unCurso.imprimirPromedioDelAlumno(lu);
                break;

                case 7:
                System.out.println("");

                default: System.out.println("chau pe!");
            }   
        }while(opcion != 7);
    }
}
