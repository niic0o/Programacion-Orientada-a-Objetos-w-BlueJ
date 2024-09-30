
/**
 * Esta clase calcula el sueldo basico de un docente.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class Docente
{
    //atributos
    private String nombre;
    private String grado;
    private double sueldoBasico;
    private double asignacionFamiliar;
    
    //constructor
    /**
     * @param p_nombre nombre del docente
     * @param p_grado nivel educativo a cargo del docente
     * @param p_sueldoBasico subtotal a cobrar
     * @param p_asignacionFamiliar aumento a otorgar.
     */
    Docente (String p_nombre, String p_grado, double p_sueldoBasico, double p_asignacionFamiliar)
    {
        this.setNombre(p_nombre);
        this.setGrado(p_grado);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAsignacionFamiliar(p_asignacionFamiliar);
    }
        
    //setters
    private void setNombre (String p_nombre)
    {this.nombre = p_nombre;}
    private void setGrado (String p_grado)
    {this.grado = p_grado;}
    private void setSueldoBasico (double p_sueldoBasico)
    {this.sueldoBasico = p_sueldoBasico;}
    private void setAsignacionFamiliar (double p_asignacionFamiliar)
    {this.asignacionFamiliar = p_asignacionFamiliar;}
    
    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    //getters
    public String getNombre ()
    {return this.nombre;}
    public String getGrado ()
    {return this.grado;}
    public double getSueldoBasico ()
    {return this.sueldoBasico;}
    public double getAsignacionFamiliar ()
    {return this.asignacionFamiliar;}
    
    //metodos
    /** @return devuelve el total a cobrar */
    public double calcularSueldo ()
    {
        return (this.getSueldoBasico() + this.getAsignacionFamiliar());
    }
}
