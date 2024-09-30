
/**
 * Write a description of class Cabaña here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cabaña extends Alojamiento
{
    private int nroHabitaciones;
    
    Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler,
    int p_nroHabitaciones){
        super(p_nombre,p_precioBase,p_diasAlquiler);
        this.setNroHabitaciones(p_nroHabitaciones);
    }
    
    private void setNroHabitaciones (int p_nroHabitaciones){
        this.nroHabitaciones = p_nroHabitaciones;
    }
    
    public int getNroHabitaciones (){
        return this.nroHabitaciones;
    }
    //30 * habitacion
    public double costo (){
        return super.costo() + (30 * this.getNroHabitaciones() * this.getDiasAlquiler());
    }
    
    public int contar (String p_alojamiento){
        int cabaña = 0;
        if ("Cabaña" == p_alojamiento || "cabaña" == p_alojamiento){
            cabaña++;
            return cabaña;
        }else{
            return cabaña;
        }
    }
    
    public void liquidar (){
        double aux = this.costoServicios() + this.costo();
        super.liquidar();
        System.out.println("Cabaña con "+this.getNroHabitaciones()+
            " habitaciones"+"\n"+
            "Total: ------> $"+aux);
    }
    
    /* gerencia contarAlojamientos("cabaña")
       cabañas += getAlojamientos().get(i).contar("cabaña")
       return cabañas
       */
    }
