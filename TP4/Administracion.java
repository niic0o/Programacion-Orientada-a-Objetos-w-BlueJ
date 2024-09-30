import java.util.*;
import java.io.*;

//instancio unEvento y pido por teclado sus datos.
//instancio unaFundacion(nombre fund.)
//leo 1 registro invitado
//lo seteo en un objeto unaPersona
//le paso a unaFundacion (unEvento,unaPersona) para imprimir
//le paso a unaFundacion (unEvento, unaPersona, un Archivo) para grabar
/**
 * Write a description of class exeFundacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administracion
{
    public static void main (String [] args)
    {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        String separador = System.getProperty("file.separator");
        //String ruta1 = ("E:"+separador+"UNNE"+separador+"Programacion Orientada a Objetos 2017"+separador+"LABORATORIO"+separador+"TP4_SenaNicolasAriel"+separador+"Archivos"+separador+"Invitados.dat");
        //String ruta2 = ("E:"+separador+"UNNE"+separador+"Programacion Orientada a Objetos 2017"+separador+"LABORATORIO"+separador+"TP4_SenaNicolasAriel"+separador+"Archivos"+separador+"Eventos.dat");
        //E:\Drive\UNNE\Programacion Orientada a Objetos 2017\LABORATORIO\TP4_SenaNicolasAriel\Archivos
        //auxiliares
        String nombre,apellido,nombreE,nombreF,lugar;
        int dni,diasInscripcion,año,mes,dia,op;
        double costo;

        System.out.println("Ingrese los datos del evento");
        System.out.print("Nombre: ");
        nombreE = teclado.next();
        System.out.print("Lugar: ");
        lugar = teclado.next();
        System.out.print("Año: ");
        año = teclado.nextInt();
        System.out.print("Mes: ");
        mes = teclado.nextInt();
        mes = mes - 1;
        System.out.print("Dia: ");
        dia = teclado.nextInt();
        System.out.print("Dias anticipados para la inscripcion: ");
        diasInscripcion = teclado.nextInt();
        System.out.print("Costo: ");
        costo = teclado.nextDouble();
        Calendar fechaEvento = new GregorianCalendar(año,mes,dia);
        System.out.print("Nombre de la organizacion: ");
        nombreF = teclado.next();
        Evento unEvento = new Evento(nombreE,lugar,fechaEvento,diasInscripcion,costo);
        Fundacion unaFundacion = new Fundacion(nombreF);        
        try
        {
            //lectura
            FileInputStream archiFIS = new FileInputStream("invitados.dat");
            DataInputStream archiDIS = new DataInputStream(archiFIS);
            while (archiDIS.available() > 0){
                dni = archiDIS.readInt();
                apellido = archiDIS.readUTF();
                nombre = archiDIS.readUTF();
                dia = archiDIS.readInt();
                mes = archiDIS.readInt();
                año = archiDIS.readInt();
                Persona unaPersona = new Persona(dni,nombre,apellido,año);
                System.out.println("\n");
                unaFundacion.imprimirInvitacion(unEvento,unaPersona);
                try
                {
                    //escritura
                    FileOutputStream archiFOS = new FileOutputStream("Evento.dat",true);
                    DataOutputStream archiDOS = new DataOutputStream(archiFOS);
                    unaFundacion.grabarInvitacion(unEvento,unaPersona,archiDOS);
                    archiDOS.close();
                }
                catch(FileNotFoundException fnfe)
                {
                    System.out.println("Archivo no encontrado");
                }
                catch(IOException ioe)
                {
                    System.out.println("Error al grabar");
                }    

            }
            archiDIS.close();
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Archivo no encontrado");
        }
        catch(IOException ioe)
        {
            System.out.println("Error al grabar");
        }        
    }
}