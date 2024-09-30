import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Ejecutable que permite gestionar el stock de una farmacia salvando los datos en un archivo.
 * @autor Sena, Nicolas Ariel
 * @version 1.3 - 10/2017
*/
public class ReposicionAutomatica8{
    public static void main (String[] args){
        Calendar fechaHoy = new GregorianCalendar();
        Laboratorio8 laboratorio8;
        Producto8 producto8;
        int cod, existMin, stock, codlab, prodReposicion = 0, fs = 0, pr = 0;//faltante de stock, punto de repo.
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
                laboratorio8 = new Laboratorio8(nombre,domicilio,telefono,compraMin,diaEnt);
                producto8 = new Producto8(cod,rubro,descripcion,costo,porceReposicion,existMin,laboratorio8);
                
                if (producto8.solicitar() != 'N'){
                    archiDOS.writeInt(producto8.getCodigo());
                    archiDOS.writeInt(codlab);
                    archiDOS.writeInt(laboratorio8.getCompraMinima());
                    archiDOS.writeDouble(laboratorio8.getCompraMinima()*producto8.getCosto());
                    archiDOS.writeChar(producto8.solicitar());
                    System.out.println("Producto: "+producto8.getDescripcion()+"\tLaboratorio: "+laboratorio8.getNombre()+
                                     "\nDomicilio: "+laboratorio8.getDomicilio()+" - Telefono: "+laboratorio8.getTelefono()+
                                     "\nCantidad a comprar: "+laboratorio8.getCompraMinima()+" paquetes\tDia de entrega: "+laboratorio8.getDiaEntrega()+" del mes"+
                                     "\n-------------------------------------------------------------------------------------------------");
                    
                    prodReposicion++;
                    importeReposicion += laboratorio8.getCompraMinima()*producto8.getCosto();
                    if (producto8.solicitar() == 'F'){
                        fs++;
                    }
                    if (producto8.solicitar() == 'F'){
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