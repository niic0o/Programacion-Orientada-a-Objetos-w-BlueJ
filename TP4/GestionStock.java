import java.util.*;
import java.io.*;
/**
 * Ejecuta la gestion del stock de una drogueria.
 *
 * @author Nicolas Ariel Sena
 * @version 2.0 - 14/09/2017
 */
public class GestionStock
{
    public static void main (String [] args)
    {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        String separador = System.getProperty("file.separator");
        int codProducto,codLaboratorio,cantidadCompra,existenciaMinima,stock,compraMinima,diaDeEntrega;
        double montoCompra,ptoDeReposicion,precio;
        char razonDeCompra,op;
        String rubro,descripcion,nombre,domicilio,telefono;
        System.out.println("-------  Bienvenido a Gestion Stock 2.0 -------");
        try{
            FileInputStream archiFIS = new FileInputStream("Laboratorio.dat");
            DataInputStream archiDIS = new DataInputStream(archiFIS);
            while (archiDIS.available() > 0){
                codLaboratorio = archiDIS.readInt();
                nombre = archiDIS.readUTF();
                domicilio = archiDIS.readUTF();
                telefono = archiDIS.readUTF();
                compraMinima = archiDIS.readInt();
                diaDeEntrega = archiDIS.readInt();
                //instanciar unLaboratorio con esos datos
                Laboratorio unLaboratorio = new Laboratorio (codLaboratorio,nombre,domicilio,telefono,compraMinima,diaDeEntrega);
                //grabar un registro de acceso secuencial producto.dat
                try{

                    RandomAccessFile archi = new RandomAccessFile("Productos.dat","rw");
                    codProducto = 0; stock = 0; existenciaMinima = 0;
                    nombre = ""; domicilio = ""; telefono = ""; rubro = ""; descripcion = ""; 
                    precio = 0.0; ptoDeReposicion = 0.0;
                    System.out.println("\n"+"Ingrese los datos solicitados"+"\n");
                    System.out.print("Codigo del producto: ");
                    codProducto = teclado.nextInt();
                    System.out.print("Rubro: ");
                    rubro = teclado.next();
                    if (rubro.length() < 30){
                        for(int i=rubro.length(); i <30; i++)
                            rubro = rubro+" ";
                    }else{
                        rubro = rubro.substring(0,30);
                    }
                    System.out.print("Descripcion: ");
                    descripcion = teclado.next();
                    if (descripcion.length() < 30){
                        for(int i=descripcion.length(); i <30; i++)
                            descripcion = descripcion+" ";
                    }else{
                        descripcion = descripcion.substring(0,30);
                    }                        
                    System.out.print("Existencia Minima: ");
                    existenciaMinima = teclado.nextInt();
                    System.out.print("% Punto de reposicion: ");
                    ptoDeReposicion = teclado.nextDouble();
                    System.out.print("Ingrese el stock del producto: ");
                    stock = teclado.nextInt();
                    System.out.print("Precio: ");
                    precio = teclado.nextDouble();
                    Producto unProducto = new Producto(codProducto,rubro,descripcion,existenciaMinima,ptoDeReposicion,stock,precio,unLaboratorio);
                    //grabar
                    if (archi.length()!= 0){
                        // se posiciona al final del último registro
                        archi.seek( archi.length() );
                    }
                    archi.writeInt(unProducto.getCodigo());
                    archi.writeChars(unProducto.getRubro());
                    archi.writeChars(unProducto.getDescripcion());
                    archi.writeInt(unProducto.getExistMinima());
                    archi.writeDouble(unProducto.getPorcPtoRepo());
                    archi.writeInt(unProducto.getStock());
                    archi.writeDouble(unProducto.getCosto());
                    archi.writeInt(unProducto.getLab().getCodLab());
                    archi.close();
                }
                catch (FileNotFoundException fnfe)
                {
                    System.out.println("Archivo no encontrado");
                }
                catch (IOException ioe)
                {
                    System.out.println("Error de lectura");
                }                    
            }
            archiDIS.close();

        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("Archivo no encontrado");
        }
            catch (IOException ioe)
            {
            System.out.println("Error de lectura");
        }

    }
}
