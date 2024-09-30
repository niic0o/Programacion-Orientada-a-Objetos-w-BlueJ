    //instanciar unProducto(sus parametros, unLaboratorio)
    //tomar la fecha de hoy, fragmentarla en año mes dia
    //crear un archivo (comprar_ + año + mes + dia + ".txt"}
    //grabar los campos indicados en la guia
    //el campo razon de compra es F o P. F faltante de stock, si el stock del producto es igual o menor al minimo de compra requerido por el laboratorio del producto
    //P si el stock del producto es menor o igual al punto de reposicion del producto, y si faltan mas de 5 dias corridos para el dia de entrega pautado por el laboratorio del producto
    //El metodo que realiza lo dicho anteriormente se encuentra dentro de la clase Producto.
    //tener en cuenta que al final de la ejecucion se desea saber cuanto productos hay que reponer el monto total de la compra planificada y cuantas compras por faltante de stock y pto de repo se realizo. 

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Ejecutable que permite gestionar el stock de una farmacia salvando los datos en un archivo.
 * @autor Sena, Nicolas Ariel
 * @version 1.1 - 10/2017
*/
public class ReposicionAutomatica{
    public static void main (String[] args){
        Calendar fechaHoy = new GregorianCalendar();
        Laboratorio laboratorio;
        Producto producto;
        int cod, existMin, stock, codlab, prodReposicion = 0, fs = 0, pr = 0;
        String rubro, descripcion;
        double costo, porceReposicion, importeReposicion = 0;
        String nombre;
        String domicilio;
        String telefono;
        int compraMin, diaEnt, tamreg = 192;
        
        try{
            FileOutputStream archiFOS = new FileOutputStream("comprar_"+fechaHoy.get(Calendar.YEAR)+fechaHoy.get(Calendar.MONTH)+fechaHoy.get(Calendar.DATE)+".txt");
            DataOutputStream archiDOS = new DataOutputStream(archiFOS);
            FileInputStream archiFIS = new FileInputStream("productos.dat");
            DataInputStream archiDIS = new DataInputStream(archiFIS);
            RandomAccessFile archivo = new RandomAccessFile("Laboratorios.dat","r");
            DateFormat formato1 = DateFormat.getDateInstance(DateFormat.FULL);
            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Listado de productos a comprar al "+formato1.format(fechaHoy.getTime())+"\n");
            while (archiDIS.available() != 0){
                nombre = "";
                domicilio = "";
                telefono = "";
                cod = archiDIS.readInt();
                rubro = archiDIS.readUTF();
                descripcion = archiDIS.readUTF();
                existMin = archiDIS.readInt();
                porceReposicion = archiDIS.readDouble();
                stock = archiDIS.readInt();
                costo = archiDIS.readDouble();
                codlab = archiDIS.readInt();
                
                archivo.seek(tamreg * codlab);
                archivo.readInt();
                for (int i = 0 ; i < 30 ; i++){
                    nombre = nombre + archivo.readChar();
                }
                for (int i = 0 ; i < 30 ; i++){
                    domicilio = domicilio + archivo.readChar();
                }
                for (int i = 0 ; i < 30 ; i++){
                    telefono = telefono + archivo.readChar();
                }
                compraMin = archivo.readInt();
                diaEnt = archivo.readInt();
                laboratorio = new Laboratorio(nombre,domicilio,telefono,compraMin,diaEnt);
                producto = new Producto(cod,rubro,descripcion,costo,porceReposicion,existMin,laboratorio);
                
                if (producto.solicitar() != 'N'){
                    archiDOS.writeInt(producto.getCodigo());
                    archiDOS.writeInt(codlab);
                    archiDOS.writeInt(laboratorio.getCompraMinima());
                    archiDOS.writeDouble(laboratorio.getCompraMinima()*producto.getCosto());
                    archiDOS.writeChar(producto.solicitar());
                    System.out.println("Producto: "+producto.getDescripcion()+"\tLaboratorio: "+laboratorio.getNombre()+
                                     "\nDomicilio: "+laboratorio.getDomicilio()+" - Telefono: "+laboratorio.getTelefono()+
                                     "\nCantidad a comprar: "+laboratorio.getCompraMinima()+" paquetes\tDia de entrega: "+laboratorio.getDiaEntrega()+" del mes"+
                                     "\n-------------------------------------------------------------------------------------------------");
                    
                    prodReposicion++;
                    importeReposicion += laboratorio.getCompraMinima()*producto.getCosto();
                    if (producto.solicitar() == 'F'){
                        fs++;
                    }
                    if (producto.solicitar() == 'F'){
                        pr++;
                    }
                }
            }
            System.out.println("Número de productos a reponer: "+prodReposicion+
                             "\nImporte total de la compra planificada: $ "+importeReposicion+
                             "\nNumero de compras por faltante de stock: "+fs+
                             "\nNumero de compras por punto de reposición: "+pr+
                             "\n-------------------------------------------------------------------------------------------------"+
                             "\nArchivo creado: "+"comprar_"+fechaHoy.get(Calendar.YEAR)+fechaHoy.get(Calendar.MONTH)+fechaHoy.get(Calendar.DATE)+".txt"+
                             "\n-------------------------------------------------------------------------------------------------");

            archiDIS.close();
            archiFIS.close();
        } catch(FileNotFoundException fnfe){
            System.out.println("Archivo no encontrado");
        } catch(IOException ioe){
            System.out.println("Error de lectura/escritura");
        }
    }
}