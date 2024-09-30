
/**
 * Write a description of class Hotel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hotel extends Alojamiento
{
    private String tipoHabitacion;

    Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler,
    String p_tipoHabitacion){
        super(p_nombre,p_precioBase,p_diasAlquiler);
        this.setTipoHabitacion(p_tipoHabitacion);
    }

    private void setTipoHabitacion (String p_tipoHabitacion){
        this.tipoHabitacion = p_tipoHabitacion;
    }

    public String getTipoHabitacion (){
        return this.tipoHabitacion;
    }

    public double costo (){
        double aux = super.costo();
        String tipo = this.getTipoHabitacion();
        if(tipo == "Single" || tipo == "single"){
            return aux + (20 * this.getDiasAlquiler());
        }else if(tipo == "Doble" || tipo == "doble"){
            return aux + (35 * this.getDiasAlquiler());
        }
        return 0.0;
    }
    
    public int contar (String p_alojamiento){
        int hotel = 0;
        if("hotel" == p_alojamiento || "Hotel" == p_alojamiento){
            hotel++;
            return hotel;
        }else{
            return hotel;
        }
    }
    
    public void liquidar (){
        double aux = this.costoServicios() + this.costo();
        super.liquidar();
        System.out.println("Habitacion "+this.getTipoHabitacion()+
            "\n"+"Total: -------> $"+aux);
    }
    
} 
