
import java.util.*;
import java.io.*;

/** Clase ejecutable GestionBiblioteca,
 *  para instanciar diferentes objetos.
 * @version 
 */
public class GestionBiblioteca{

    /** 
     *  para cargar los datos
     *  e interaccionar con el usuario.
     *  @param No recibe parametros.
     *  @return No retorna ningun valor.
     *  @exception No hay excepciones.
     */
    public static void main(){
        Biblioteca biblioteca = new Biblioteca("BIBLIOTECA 9 DE JULIO");

        //Cargamos varios libros como constantes.
        biblioteca.nuevoLibro("POO con C++", 1, "Ra-Ma", 1997);
        biblioteca.nuevoLibro("UNIX. Interconexion de redes", 1, "Ra-Ma", 1997);
        biblioteca.nuevoLibro("BASES DE DATOS", 2, "Ra-Ma", 2001);
        biblioteca.nuevoLibro("Desarrollo Web con PHP", 1, "Anaya Multimedia", 2007);
        biblioteca.nuevoLibro("Programacion avanzada con VISUAL BASIC", 2, "Mc Graw Hill", 2001);

        //Cargamos varios socios del tipo Estudiante como constantes
        biblioteca.nuevoSocioEstudiante(34255122, "DOMINGO PACHECO","Lic. en Sistemas de Informacion");
        biblioteca.nuevoSocioEstudiante(29388521, "Diego G. Trangoni","Lic. en Sistemas de Informacion");
        biblioteca.nuevoSocioEstudiante(37698014, "Ojeda Eric","Lic. en Sistemas de Informacion");
        biblioteca.nuevoSocioEstudiante(29388521, "Sena, Nicolas","Lic. en Sistemas de Informacion");
        biblioteca.nuevoSocioEstudiante(29388521, "Souto Flores ","Lic. en Sistemas de Informacion");
        biblioteca.nuevoSocioEstudiante(29388521, "Villareal Matias","Lic. en Sistemas de Informacion");

        //Cargamos varios socios del tipo Docente como constantes
        biblioteca.nuevoSocioDocente(18634778, "Mettini Aldo", "Informatica");
        biblioteca.nuevoSocioDocente(14663770, "Alicia Lopez", "Informatica");
        biblioteca.nuevoSocioDocente(19882654, "Yanina", "Informatica");
        biblioteca.nuevoSocioDocente(28675123, "Burghardt", "Informatica");
        biblioteca.nuevoSocioDocente(18453776, "Monica", "Informatica");

        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        String menu;
        int option = 0;
        // Ingreso de libros
        String titulo, editorial;
        int  edicion, anio;
        // Ingreso de socio
        String nombre,  carrera, area;
        int nroDni, nroPrestado;

        do{
            try{
                System.out.print("\nºººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººº" +
                    "\nº               Biblioteca: " + biblioteca.getNombre() + "                        º" + 
                    "\nºººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººº" +
                    "\nº 1 - Agregar un libro                                                   º" + 
                    "\nº 2 - Agregar un socio                                                   º" + 
                    "\nº 3 - Prestar libro                                                      º" + 
                    "\nº 4 - Buscar quien tiene el libro x                                      º" +
                    "\nº 5 - Devolver Libro                                                     º" +
                    "\nº 6 - Lista de docentes responsables                                     º" + 
                    "\nº 7 - Cantidad de socios                                                 º" + 
                    "\nº 8 - Lista de libros                                                    º" +
                    "\nº 9 - Lista de socios                                                    º" +
                    "\nº 10 - Buscar socio                                                      º" +
                    "\nº 11 - Eliminar libro                                                    º" +
                    "\nº 12 - Eliminar socio                                                    º" +                    
                    "\nº 13 - Salir                                                             º" +
                    "\nºººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººººº" +
                    "\nElija una opcion: "); option = teclado.nextInt();

                switch(option)
                {
                    case 1: 
                    System.out.println("cls");
                    System.out.println("\f");
                    System.out.print("\nIngrese el titulo del libro: "); titulo = teclado.next();
                    System.out.print("Edicion: "); edicion = teclado.nextInt();
                    System.out.print("Editorial: "); editorial = teclado.next();
                    System.out.print("Año: "); anio = teclado.nextInt();

                    biblioteca.nuevoLibro(titulo, edicion, editorial, anio);

                    System.out.println("\f");

                    System.out.println("\n> > > > > > > > > > Libro agregado con exito < < < < < < < < < <");
                    break;//Fin case 1

                    case 2: 
                    System.out.println("\f");
                    System.out.print("\nººººººººººººººººººººººººººººººººººººººº" + 
                        "\nº 1 - Estudiante                      º" +
                        "\nº 2 - Docente                         º" +
                        "\nººººººººººººººººººººººººººººººººººººººº" +
                        "\nTipo de socio: "); int tipo = teclado.nextInt();
                    if(tipo == 1)
                    {
                        System.out.print("\nIngrese nombre y apellido del socio: "); 
                        nombre = teclado.next();
                        System.out.print("Nro. de DNI: "); 
                        nroDni = teclado.nextInt();
                        System.out.print("Carrera: "); 
                        carrera = teclado.next();

                        biblioteca.nuevoSocioEstudiante(nroDni, nombre, carrera);

                        System.out.println("\f");

                        System.out.println("\n> > > > > > > > > > Socio agregado con exito < < < < < < < < < <");
                    }
                    else if(tipo == 2)
                    { 
                        System.out.print("\nIngrese nombre y apellido del socio: "); 
                        nombre = teclado.next();
                        System.out.print("Nro. de DNI: "); 
                        nroDni = teclado.nextInt();
                        System.out.print("Area: "); 
                        area = teclado.next();

                        biblioteca.nuevoSocioDocente(nroDni, nombre, area);

                        System.out.println("\f");

                        System.out.println("\n> > > > > > > > > > Socio agregado con exito < < < < < < < < < <");
                    }
                    else
                    {
                        System.out.println("\f");
                        System.out.println("\nEl numero ingresado es Incorrecto");
                    }
                    break;//Fin case 2

                    case 3:
                    System.out.println("\f");
                    System.out.print(biblioteca.listaDeLibros() + "\nSeleccione un libro: ");
                    int nroLibro = teclado.nextInt();
                    System.out.println("\f");
                    Libro libro = biblioteca.getLibros().get(nroLibro - 1);//empieza de cero
                    if(libro.prestado() == true){
                        System.out.println("\f");
                        System.out.println("\n> > > > > > > > > > Imposible realizar el préstamo. El libro ya se encuentra prestado < < < < < < < < < <");
                    }else{
                        System.out.print(biblioteca.listaDeSocios() + "\nSeleccione un socio: "); 
                        int nroSocio = teclado.nextInt();
                        Socio socio = biblioteca.getSocios().get(nroSocio - 1);
                        if(socio.puedePedir()){
                            biblioteca.prestarLibro(Calendar.getInstance(), socio, libro);
                            System.out.println("\f");
                            System.out.println("\n> > > > > > > > > > Libro prestado con éxito < < < < < < < < < <");
                        }else{
                            System.out.println("\f");
                            System.out.print("\n> > > > > > > > > > El socio no esta habilitado para un nuevo prestamo < < < < < < < < < <");
                        }
                    }
                    break;//Fin case 3

                    case 4: 
                    System.out.println("\f");
                    System.out.print(biblioteca.listaDeLibros() + "\nIngrese numero del libro: "); 
                    int libBuscado = teclado.nextInt();
                    Libro p_libro2 = biblioteca.getLibros().get(libBuscado - 1);
                    if(p_libro2.prestado())
                    {
                        System.out.println("\f");
                        System.out.print("\nEl que tiene el libro es: ");
                    }
                    System.out.print(biblioteca.quienTieneElLibro(p_libro2) + "\n");
                    break;//Fin case 4

                    case 5: 
                    System.out.println("\f");
                    System.out.print(biblioteca.listaDeLibros() + "\n Seleccione un libro: ");
                    int nroLibroADevolver = teclado.nextInt();
                    Libro p_libro3 = biblioteca.getLibros().get(nroLibroADevolver - 1);
                    biblioteca.devolverLibro(p_libro3);
                    System.out.println("\f");
                    System.out.println("\n> > > > > > > > > > Libro devuelto con exito < < < < < < < < < <");
                    break;//Fin case 5

                    case 6: 
                    System.out.println("\f");
                    System.out.println("\n==========================================================================" + 
                        "\n=                Lista de profesores responsables                        =" +
                        "\n==========================================================================" + 
                        "\n" + biblioteca.listaDeDocentesResponsables());
                    break;//Fin case 6

                    case 7: 
                    System.out.println("\f");
                    System.out.println(biblioteca.listaDeSocios());
                    break;//Fin case 7

                    case 8: 
                    System.out.println("\f");
                    System.out.println(biblioteca.listaDeLibros());
                    break;//Fin case 8

                    case 9: 
                    System.out.println("\f");
                    System.out.println(biblioteca.listaDeSocios());
                    break;//Fin case 9

                    case 10: 
                    System.out.println("\f");
                    System.out.print("\nIngrese DNI del Socio a buscar: "); 
                    int aux1 = teclado.nextInt();
                    if(biblioteca.buscarSocio(aux1) == null)
                    {
                        System.out.println("No se encuentra en la lista de Socios \n");
                    }
                    else
                    {
                        System.out.println(biblioteca.buscarSocio(aux1).toString());
                    }
                    break;//Fin case 10
                    case 11:
                    System.out.println("\f");
                    System.out.print(biblioteca.listaDeLibros() + "\nSeleccione un libro: ");
                    nroLibro = teclado.nextInt();
                    System.out.println("\f");
                    Libro eliminarLibro = biblioteca.getLibros().get(nroLibro - 1);//empieza de cero
                    biblioteca.removeLibro(eliminarLibro);
                    System.out.println("Libro eliminado!");
                    break;
                    
                    case 12:
                    System.out.println("\f");
                    System.out.print("\nIngrese Nro de DNI del Socio: "); 
                    aux1 = teclado.nextInt();
                    Socio eliminarSocio = biblioteca.buscarSocio(aux1);
                    if(biblioteca.buscarSocio(aux1) == null)
                    {
                        System.out.println("No se encuentra en la lista de Socios \n");
                    }
                    else
                    {
                        biblioteca.removeSocio(eliminarSocio);
                        System.out.println("Socio eliminado!");
                    }
                    break;
                    
                    case 13: 
                    System.out.println("\f");
                    System.out.print("\n > > > > > > > > > > Fin Gestion < < < < < < < < < < ");
                    break;//Fin case 11

                    default: System.out.println("ERROR: Opcion incorrecta");
                    break;
                }//Fin switch
            }
            catch(Exception e){
                System.out.print("Reanudando... Lo sentimos repita la ultima operacion porque sea producido un error!");
                teclado = new Scanner(System.in);
            }
        }while(option != 13);
    }//Fin main
}//Fin class