import java.util.*;

/**
 * Instancia un objeto con datos basicos del cultivo a proteger.
 * 
 * @author: Nicolas Ariel Sena
 * @version: v1.0 - 10/2017
 */
public class UnidadDeRiesgo{
    private String agricultor;
    private String cultivo;
    private Calendar fechaCosecha;
    
    /**
     * @param p_agricultor nombre de agricultor
     * @param p_cultivo tipo de cultipo
     * @param p_fecha .
     */
    public UnidadDeRiesgo(String p_agricultor, String p_cultivo, Calendar p_fecha){
        this.setAgricultor(p_agricultor);
        this.setCultivo(p_cultivo);
        this.setFechaCosecha(p_fecha);
    }
    
    private void setAgricultor(String p_agricultor){
        this.agricultor = p_agricultor;
    }
    
    private void setCultivo(String p_cultivo){
        this.cultivo = p_cultivo;
    }
    
    private void setFechaCosecha(Calendar p_fecha){
        this.fechaCosecha = p_fecha;
    }
    
    public String getAgricultor(){
        return this.agricultor;
    }
    
    public String getCultivo(){
        return this.cultivo;
    }
    
    public Calendar getFechaCosecha(){
        return this.fechaCosecha;
    }
    
    /**
     * Muestra los datos del agricultor y del cultivo
     */
    public void mostrarDetalle(){
        System.out.println("Agricultor: "+this.getAgricultor()+"\n"+
                           "Cultivo: "+this.getCultivo());
    }
}
