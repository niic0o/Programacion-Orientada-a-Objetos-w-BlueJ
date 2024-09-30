import java.util.*;
import java.io.*;
/**
 * Write a description of class DatosVIP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DatosVIP
{
    public static void main (String [] args)
    {
        long cuil;
        String apellido,nombre,op;
        int diaIngreso,mesIngreso,añoIngreso;
        double sueldoNeto,sueldoBasico;
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        String separador = System.getProperty("file.separator");
        String ruta1 = ("E:"+separador+"UNNE"+separador+"Programacion Orientada a Objetos 2017"+separador+"LABORATORIO"+separador+"TP4_SenaNicolasAriel"+separador+"Archivos"+separador+"Empleado.dat");
        String ruta2 = ("E:"+separador+"UNNE"+separador+"Programacion Orientada a Objetos 2017"+separador+"LABORATORIO"+separador+"TP4_SenaNicolasAriel"+separador+"Archivos"+separador+"EmpleadoVIP.dat");

        System.out.println("-----Bienvenido-----");

        //leer empleados.dat
        try{
            //elimina empleadosVIP.dat para luego actualizar con empleado.dat
            BufferedWriter bw = new BufferedWriter(new FileWriter(ruta2));
            bw.write("");
            bw.close();
            //Crear objeto fichero del cual leer
            FileInputStream archiFIS = new FileInputStream(ruta1);
            //Crear objeto archivo para leer datos
            DataInputStream archiDIS = new DataInputStream(archiFIS);
            //leyendo
            while (archiDIS.available() > 0){
                //almacenar en variables
                cuil = archiDIS.readLong();
                apellido = archiDIS.readUTF();
                nombre = archiDIS.readUTF();
                sueldoBasico = archiDIS.readDouble();
                sueldoNeto = archiDIS.readDouble();
                diaIngreso = archiDIS.readInt();
                mesIngreso = archiDIS.readInt();
                añoIngreso = archiDIS.readInt();
                //grabar 10 años de antiguedad en empleadoVip.dat
                Calendar fechaIngreso = new GregorianCalendar(añoIngreso,mesIngreso,diaIngreso);
                Empleado unEmpleado = new Empleado(cuil,apellido,nombre,sueldoBasico,fechaIngreso);
                //10 años de antiguedad o mas seran grabados
                if (unEmpleado.antiguedad2() > 9)
                {
                    try{
                        //crea objeto de tipo fichero
                        FileOutputStream archiFOS = new FileOutputStream(ruta2,true);
                        //crea objeto de tipo archivo, se envia como parametro el "lugar fisico" o sea fichero donde se grabara.
                        DataOutputStream archiDOS = new DataOutputStream(archiFOS);
                        //grabando
                        archiDOS.writeLong(unEmpleado.getCuil());
                        archiDOS.writeUTF(unEmpleado.getApellido());
                        archiDOS.writeUTF(unEmpleado.getNombre());
                        archiDOS.writeDouble(unEmpleado.getSueldoBasico());
                        archiDOS.writeDouble(unEmpleado.sueldoNeto());
                        archiDOS.writeInt(unEmpleado.getFechaIngreso().get(Calendar.DATE));
                        archiDOS.writeInt(unEmpleado.getFechaIngreso().get(Calendar.MONTH));
                        archiDOS.writeInt(unEmpleado.getFechaIngreso().get(Calendar.YEAR));
                        //cerrar archivo
                        archiDOS.close();
                    }
                    //manejar excepciones
                    catch (FileNotFoundException fnfe)
                    {
                        System.out.println("\n"+"Archivo no encontrado");
                    }
                    catch (IOException ioe)
                    {
                        System.out.println("\n"+"Error al grabar");
                    }
                }
            }
            archiDIS.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("\n"+"Archivo no encontrado");
        }
        catch (IOException ioe)
        {
            System.out.println("\n"+"Error al leer");
        }
        System.out.println("\n"+"-------------REGISTRO de EmpleadosVIP----------------");
        try{
            //Crear objeto fichero del cual leer
            FileInputStream archivoFIS = new FileInputStream(ruta2);
            //Crear objeto archivo para leer datos
            DataInputStream archivoDIS = new DataInputStream(archivoFIS);
            //leyendo
            while (archivoDIS.available() > 0){
                cuil = archivoDIS.readLong();
                apellido = archivoDIS.readUTF();
                nombre = archivoDIS.readUTF();
                sueldoBasico = archivoDIS.readDouble();
                sueldoNeto = archivoDIS.readDouble();
                diaIngreso = archivoDIS.readInt();
                mesIngreso = archivoDIS.readInt();
                añoIngreso = archivoDIS.readInt();
                System.out.println("\n"+"CUIL: "+cuil);
                System.out.println("Apellido: "+apellido+" - Nombre: "+nombre);
                System.out.println("Sueldo Basico: "+sueldoBasico);
                System.out.println("Sueldo Neto: "+sueldoNeto);
                System.out.println("Fecha de ingreso: "+diaIngreso+"/"+mesIngreso+"/"+añoIngreso);
            }
            archivoDIS.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("\n"+"Archivo no encontrado");
        }
        catch (IOException ioe)
        {
            System.out.println("\n"+"Error al leer");
        }        
    }
}
