import java.util.*;

/**
 * Gestiona el pedido de productos de un laboratorio
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class TomaPedido
{
    public static void main (String [] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        //Laboratorio
        String nombre,domicilio,telefono;
        int compraMinima,diaEntrega;
        //Producto
        int codigo,stock,existenciaMinima;
        double costo,porcPtoRepo;
        String rubro,descripcion;
        Laboratorio lab;
        //Cliente
        int nroDni;
        String apellido;//y nombre
        double saldo;  
        //Pedido
        Calendar fecha = new GregorianCalendar();
        Cliente cliente;
        ArrayList <Producto> productos = new ArrayList();
        int opcion;
        
        
        //1- agregar pedido 2-quitar pedido 3-mostrar listado
        System.out.println("*********************Bienvenido*************"+"\n"+
                           "Ingrese los datos del local proveedor");
        System.out.print("Nombre: ");
        nombre = teclado.next();
        System.out.print("Domicilio: ");
        domicilio = teclado.next();
        System.out.print("Telefono: ");
        telefono = teclado.next();
        lab = new Laboratorio(nombre,domicilio,telefono);
        System.out.println("\n"+"Ingrese datos del cliente");
        System.out.print("Nombre: ");
        nombre = teclado.next();
        System.out.print("Apellido: ");
        apellido = teclado.next();
        System.out.print("Dni: ");
        nroDni = teclado.nextInt();
        saldo = 0.0;
        cliente = new Cliente(nroDni,nombre,apellido,saldo);
        Pedido unPedido = new Pedido(fecha,cliente,productos);
        
        
        do{
            System.out.println("1 - Agregar pedido"+
                               "2 - Quitar pedido"+
                               "3 - Mostrar listado"+
                               "4 - Salir"+"\n");   
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1: //agregar pedido
                System.out.print("Codigo: ");
                codigo = teclado.nextInt();
                System.out.print("Stock: ");
                stock = teclado.nextInt();
                System.out.print("Existencia Minima: ");
                existenciaMinima = teclado.nextInt();
                System.out.print("Importe: ");
                costo = teclado.nextDouble();
                System.out.print("Porcentaje punto reposicion: ");
                porcPtoRepo = teclado.nextDouble();
                System.out.print("Rubro: ");
                rubro = teclado.next();
                System.out.print("Descripcion: ");
                descripcion = teclado.next();
                Producto producto = new Producto(codigo,rubro,descripcion,costo,porcPtoRepo,existenciaMinima,lab);
                
                if(unPedido.agregarProducto(producto)){
                    System.out.println("Pedido añadido!"+"\n");
                }
                break;
                
                case 2: //quitar pedido
                if (unPedido.getProductos().isEmpty() == true){
                    System.out.println("No hay pedidos para quitar!");
                }else{
                    System.out.print("\n"+"Ingrese el numero de orden que desea quitar: ");
                    opcion = teclado.nextInt();
                    Producto algunProducto = (Producto) unPedido.getProductos().get(opcion);
                    if(unPedido.quitarProducto(algunProducto)){
                        System.out.println("Pedido eliminado!"+"\n");
                    }
                }
                    break;
                
                    case 3:
                    unPedido.mostrarPedido();
                    break;
                    
                    default: System.out.println("Opcion incorrecta, vuelva a intentar");
            }
        }while(opcion != 4);
        
        
}
}