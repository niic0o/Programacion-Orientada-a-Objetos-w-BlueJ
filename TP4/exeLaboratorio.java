import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class exeLaboratorio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class exeLaboratorio
{
    public static void main (String [] args)
    {
        int i,op;
        int cod = 0;
        String nombre = " ";
        String domicilio = " ";
        String telefono = " ";
        int compraMinima = 0;
        int diaDeEntrega = 0;
        long tamRegistro = 192; 
        int canRegistro = 0;
        
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
//        String separador = System.getProperty("file.separator");
//        String ruta = ("G:"+"Drive"+separador+"UNNE"+separador+"Programacion Orientada a Objetos 2017"+separador+"LABORATORIO"+separador+"TP4_SenaNicolasAriel"+separador+"Archivos"+separador+"Laboratorio.dat");
        System.out.println("----------------Bienvenido-------------");
        System.out.println("Presione 1 para comenzar a grabar registros, 0 para salir");
        op = teclado.nextInt();
        while (op == 1)
        {
            try{
                //crear archivo de acceso directo
                RandomAccessFile archivo = new RandomAccessFile("Laboratorio.dat","rw");
                do{
                    System.out.println("\n");
                    System.out.print("Nombre: ");
                    nombre = teclado.next();
                    if (nombre.length() < 30)
                    {
                        for(i=nombre.length();i<30;i++);
                        {
                            nombre = nombre + " ";
                        }
                    }
                        else
                        {   //substring recibe (donde comienza el string, donde termina el string)
                            nombre = nombre.substring(0,30);
                        }
                    System.out.print("Domicilio: ");
                    domicilio = teclado.next();
                                        if (domicilio.length() < 30)
                    {
                        for(i=domicilio.length();i<30;i++);
                        {
                            domicilio = domicilio + " ";
                        }
                    }
                        else
                        {   //substring recibe (donde comienza el string, donde termina el string)
                            domicilio = domicilio.substring(0,30);
                        }
                    System.out.print("Telefono: ");
                    telefono = teclado.next();
                                        if (telefono.length() < 30)
                    {
                        for(i=telefono.length();i<30;i++);
                        {
                            telefono = telefono + " ";
                        }
                    }
                        else
                        {   //substring recibe (donde comienza el string, donde termina el string)
                            telefono = telefono.substring(0,30);
                        }
                    System.out.print("Compra Minima: ");
                    compraMinima = teclado.nextInt();
                    System.out.print("Dia de entrega: ");
                    diaDeEntrega = teclado.nextInt();
                    //grabando
                    if (archivo.length() != 0)
                    {
                        archivo.seek(archivo.length());
                    }
                    
                    if (archivo.length() != 0)
                    {

                        archivo.writeInt(cod = cod + 1);

                    }
                    else
                    {
                        archivo.writeInt(0);
                    }
                    archivo.writeChars(domicilio);
                    archivo.writeChars(telefono);
                    archivo.writeInt(compraMinima);
                    archivo.writeInt(diaDeEntrega);
                    System.out.println("\n"+"Desea ingresar otro registro, presione 1");
                    op = teclado.nextInt();
                    }while(op == 1);
                    archivo.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Archivo no encontrado");
        }
        catch (IOException ioe)
        {
            System.out.println("Error al grabar");
        }
        
        op = 0;    
    }
}
}
