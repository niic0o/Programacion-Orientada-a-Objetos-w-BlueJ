import java.util.*;
/**
 * Abstract class Alojamiento - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Alojamiento
{
    private String nombre;
    private double precioBase;
    private int diasAlquiler;
    private ArrayList <Servicio> servicios;

    //coleccion vacia
    Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler){
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);
        this.setServicios(new ArrayList <Servicio> ());
    }

    Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler, ArrayList p_servicios){
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlquiler(p_diasAlquiler);        
        this.setServicios(p_servicios);
    }

    private void setNombre (String p_nombre){
        this.nombre = p_nombre;
    }

    private void setPrecioBase (double p_precioBase){
        this.precioBase = p_precioBase;
    }

    private void setDiasAlquiler (int p_diasAlquiler){
        this.diasAlquiler = p_diasAlquiler;
    }

    private void setServicios (ArrayList <Servicio> p_servicio){
        this.servicios = p_servicio;
    }

    public String getNombre (){
        return this.nombre;
    }

    public double getPrecioBase (){
        return this.precioBase;
    }

    public int getDiasAlquiler (){
        return this.diasAlquiler;
    }

    public ArrayList <Servicio> getServicios (){
        return this.servicios;
    }

    public boolean agregarServicio (Servicio p_servicio){
        return this.getServicios().add(p_servicio);
    }
    
    public boolean quitarServicio (Servicio p_servicio){
        return this.getServicios().remove(p_servicio);
    }
    
    public abstract int contar (String p_alojamiento);
    
    public double costo (){
        return this.getPrecioBase() * this.getDiasAlquiler();
    }
    
    public void listarServicios (){
        for(int i=0;i < this.getServicios().size();i++){
            Servicio aux = this.getServicios().get(i);
            System.out.println(""+aux.getDescripcion()+": "+aux.getPrecio());
        }
    }
    
    public double costoServicios (){
        double servicioTotal = 0.0;
        for(int i=0;i < this.getServicios().size();i++){
            servicioTotal += this.getServicios().get(i).getPrecio();
        }
        return servicioTotal;
    }
    
    public void liquidar (){
        System.out.println("\n"+"Alojamiento: "+this.getNombre()+
            "\n"+"Costo por "+this.getDiasAlquiler()+" dias: "+this.costo());
        this.listarServicios();            
    }
}
