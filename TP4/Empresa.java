import java.io.*;
import java.util.*;
/**
 * Write a description of class Empresa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empresa
{
    public static void main (String [] args)
    {
        long cuil;
        String apellido,nombre,op;
        int diaIngreso,mesIngreso,añoIngreso,op2;
        double sueldoNeto,sueldoBasico;
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        String separador = System.getProperty("file.separator");
        String ruta = ("E:"+separador+"UNNE"+separador+"Programacion Orientada a Objetos 2017"+separador+"LABORATORIO"+separador+"TP4_SenaNicolasAriel"+separador+"Archivos"+separador+"Empleado.dat");
        System.out.println("-----Bienvenido-----");
        System.out.println("\n"+"Presione 1 para ingresar empleados");
        op2 = teclado.nextInt();
        while (op2 == 1){
        System.out.println("\n"+"Ingrese los siguientes datos");

        //crear fichero
        
        try{
            //crea objeto de tipo fichero
            FileOutputStream archiFOS = new FileOutputStream(ruta,true);
            //crea objeto de tipo archivo, se envia como parametro el "lugar fisico" o sea fichero donde se grabara.
            DataOutputStream archiDOS = new DataOutputStream(archiFOS);
            do{//grabar mientras el usuario siga ingresando datos
                System.out.print("\n"+"Ingrese CUIL: ");
                cuil = teclado.nextLong();
                System.out.print("Apellido: ");
                apellido = teclado.next();
                System.out.print("Nombre: ");
                nombre = teclado.next();
                System.out.print("Sueldo basico: ");
                sueldoBasico = teclado.nextDouble();
                System.out.print("Año ingreso: ");
                añoIngreso = teclado.nextInt();
                System.out.print("Mes ingreso: ");
                mesIngreso = teclado.nextInt();
                mesIngreso = mesIngreso - 1;
                System.out.print("Dia ingreso: "+"\n");
                diaIngreso = teclado.nextInt();
                Calendar fechaIngreso = new GregorianCalendar(añoIngreso,mesIngreso,diaIngreso);
                Empleado unEmpleado = new Empleado(cuil,apellido,nombre,sueldoBasico,fechaIngreso);
                //grabando
                archiDOS.writeLong(unEmpleado.getCuil());
                archiDOS.writeUTF(unEmpleado.getApellido());
                archiDOS.writeUTF(unEmpleado.getNombre());
                archiDOS.writeDouble(unEmpleado.getSueldoBasico());
                archiDOS.writeDouble(unEmpleado.sueldoNeto());
                archiDOS.writeInt(unEmpleado.getFechaIngreso().get(Calendar.DATE));
                archiDOS.writeInt(unEmpleado.getFechaIngreso().get(Calendar.MONTH));
                archiDOS.writeInt(unEmpleado.getFechaIngreso().get(Calendar.YEAR));
                System.out.println("\n"+"Desea ingresar los datos de otro empleados? (si)");
                op = teclado.next();
            }while(op.equals("si"));
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
        op2 = 0;
    }
        System.out.println("\n"+"Presione cualquier tecla para leer registros de empleados");
        teclado.next();
        //leer
        try{
            //Crear objeto fichero del cual leer
            FileInputStream archiFIS = new FileInputStream(ruta);
            //Crear objeto archivo para leer datos
            DataInputStream archiDIS = new DataInputStream(archiFIS);
            //leyendo
            while (archiDIS.available() > 0){
                cuil = archiDIS.readLong();
                apellido = archiDIS.readUTF();
                nombre = archiDIS.readUTF();
                sueldoBasico = archiDIS.readDouble();
                sueldoNeto = archiDIS.readDouble();
                diaIngreso = archiDIS.readInt();
                mesIngreso = archiDIS.readInt();
                añoIngreso = archiDIS.readInt();
                System.out.println("\n"+"CUIL: "+cuil);
                System.out.println("Apellido: "+apellido+" - Nombre: "+nombre);
                System.out.println("Sueldo Basico: "+sueldoBasico);
                System.out.println("Sueldo Neto: "+sueldoNeto);
                System.out.println("Fecha de ingreso: "+diaIngreso+"/"+mesIngreso+"/"+añoIngreso);
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
    }   
}     

