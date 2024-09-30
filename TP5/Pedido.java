import java.util.*;
import java.text.*;

/**
 * Permite a los clientes realizar pedidos de uno o varios productos. 
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class Pedido{
    private Calendar fecha;
    private Cliente cliente;
    private ArrayList <Producto> productos;
    
    /**
     * @param p_fecha fecha
     * @param p_cliente objeto de tipo Cliente
     * @param p_productos Una coleccion de productos
     */
    //construyo una coleccion de productos
    Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList p_productos){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }

    /**
     * @param p_fecha fecha
     * @param p_cliente objeto de tipo Cliente
     * @param p_producto objeto de tipo Producto
     */
    //construyo un solo producto
    Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList <Producto> ());
        this.agregarProducto(p_producto);
    }

    private void setFecha (Calendar p_fecha){
        this.fecha = p_fecha;}

    private void setCliente (Cliente p_cliente){
        this.cliente = p_cliente;}

    private void setProductos (ArrayList <Producto> p_productos){
        this.productos = p_productos;}

    public Calendar getFecha (){
        return this.fecha;}

    public Cliente getCliente (){
        return this.cliente;}

    public ArrayList <Producto> getProductos (){
        return this.productos;}

    /**
     * @return devuelve el resumen total de los productos pedidos al precio contado.
     */
    public double totalAlContado(){
        double totalContado = 0.0;
        for(int i=0;i<this.getProductos().size();i++){
            Producto prod = this.getProductos().get(i);
            totalContado += prod.precioContado();
        }
        return totalContado;

    }
    /**
     * @return totalLista devuelve el resumen de los productos pedidos al precio de lista
     */
    public double totalFinanciado(){
        double totalLista = 0.0;
        for(int i=0;i<this.getProductos().size();i++){
            Producto prod = this.getProductos().get(i);
            totalLista += prod.precioLista();
        }
        return totalLista;

    }
    
    /**
     * @param p_producto objeto de tipo producto
     */
    public boolean agregarProducto (Producto p_producto){
        return this.getProductos().add(p_producto);
    }
    
    /**
     * @param p_producto objeto de tipo producto
     */
    public boolean quitarProducto (Producto p_producto){
        return this.getProductos().remove(p_producto);
    }

    public void mostrarPedido(){
        DateFormat formato1 = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("****** Detalle del pedido ****** Fecha: "+formato1.format(this.getFecha().getTime())+
            "\nProducto\t\tPrecio Lista\t\tPrecio Contado\n"+
            "--------------------------------------------------------\n");
        for(int i=0;i<this.getProductos().size();i++){
            Producto prod = this.getProductos().get(i);
            System.out.println(prod.mostrarLinea());
        }
        System.out.println("--------------------------------------------------------\n"+
            "**** Total\t\t"+this.totalFinanciado()+"\t\t"+this.totalAlContado());
    }    
}
