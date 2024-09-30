import java.util.*;

/**
 * Instancia un objeto Siniestro.
 *  
 * @author: Nicolas Ariel Sena
 * @version: v1.0 - 10/2017
 */
public class Siniestro{
    private Calendar fecha;
    private double porcentajeDanio;
    
    /**
     * 
     * @param Calendar p_fecha
     * @param double p_porceDanio
     */
    public Siniestro(Calendar p_fecha, double p_porceDanio){
        this.setFecha(p_fecha);
        this.setPorceDanio(p_porceDanio);
    }
    
    /**
     * 
     * @param Calendar p_fecha
     */
    private void setFecha(Calendar p_fecha){
        this.fecha = p_fecha;
    }
    
    /**
     * @param double p_porceDanio
     */
    private void setPorceDanio(double p_porceDanio){
        this.porcentajeDanio = p_porceDanio;
    }
    
    /**
     * @return Calendar fecha
     */
    public Calendar getFecha(){
        return this.fecha;
    }
        /**
     * @return Retorna porcentajeDanio
     */
    public double getPorceDanio(){
        return this.porcentajeDanio;
    }
    
       /**
     * @return Calcula el importe que representa el porcentaje del daño ocasionado por el siniestro
     * sobre el 
     * 
     */
        public double totalDanio(double p_valorAsegurado){
        return this.getPorceDanio() * p_valorAsegurado / 100;
    }
}