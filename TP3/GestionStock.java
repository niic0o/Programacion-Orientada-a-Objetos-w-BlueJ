import java.util.*;
/**
 * Ejecuta la gestion del stock de una drogueria.
 *
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class GestionStock
{
    public static void main (String [] args)
    {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        //Stock solo se inicializa por constructor, es modificable por el metodo "ajuste()" durante el bucle do while!
        Producto stockCero = new Producto();
        int codigo, stock;
        String nom, dom, tel, rubro, descripcion, op;
        double costo;
        System.out.println("-------  Bienvenido a Gestion Stock -------");
        do
        {
            System.out.println("\n"+"Ingrese los datos solicitados"+"\n");
            System.out.print("Nombre del laboratorio: ");
            nom = teclado.next();
            System.out.print("Domicilio: ");
            dom = teclado.next();
            System.out.print("Telefono: ");
            tel = teclado.next();
            System.out.print("Codigo del producto: ");
            codigo = teclado.nextInt();
            System.out.print("Rubro: ");
            rubro = teclado.next();
            System.out.print("Descripcion: ");
            descripcion = teclado.next();
            System.out.print("Costo: ");
            costo = teclado.nextDouble();
            Laboratorio unLaboratorio = new Laboratorio(nom,dom,tel);
            Producto unProducto = new Producto(codigo,rubro,descripcion,costo,unLaboratorio);
            System.out.println("\n"+"---- Datos ingresados satisfactoriamente -----"+"\n");
            System.out.print("Ingrese el stock del producto: ");
            stock = teclado.nextInt();
            unProducto.ajuste(stock);
            System.out.println("\n"+"---- Datos ingresados satisfactoriamente -----"+"\n");           
            unProducto.mostrar();
            System.out.println(unProducto.mostrarLinea());
            System.out.println("Desea eliminar stock del producto? presione 'si'");
            op = teclado.next();
            if (op.equals("si"))
            {
                System.out.println("Atencion! si no introduce lo solicitado los datos se dañaran!!!, pulse 0 para salir");
                System.out.print("Ingrese un numero negativo para eliminar tal cantidad del stock total: ");
                stock = teclado.nextInt();
                unProducto.ajuste(stock);
                unProducto.mostrar();          
            }
            System.out.println("Desea consultar precio de lista/precio al contado? ('si')");
            op = teclado.next();
            if (op.equals("si"))
            {
                System.out.println("\n");
                System.out.println(unProducto.mostrarLinea());
            }
            System.out.println("\n"+"------------------"+"\n");
            System.out.println("Desea realizar una nueva gestion ('si') ('no')");
            op = teclado.next();
        }while(op.equals("si"));
    }
}
