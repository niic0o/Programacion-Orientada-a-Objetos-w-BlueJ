
/**
 * Brinda los datos basicos del establecimiento.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class Hospital
{
    private String nombreHospital;
    private String nombreDirector;
    
    /**
     * @param p_nombreHospital Nombre del establecimiento
     * @param p_nombreDirector A cargo del establecimiento
     * 
     */
    Hospital (String p_nombreHospital, String p_nombreDirector)
    {
        this.setNombreHospital(p_nombreHospital);
        this.setNombreDirector(p_nombreDirector);
    }
    
    private void setNombreHospital (String p_nombreHospital)
    {this.nombreHospital = p_nombreHospital;}
    private void setNombreDirector (String p_nombreDirector)
    {this.nombreDirector = p_nombreDirector;}
    
    /** @return getters devuelven los valores que contienen los atributos referenciados */      
    public String getNombreHospital ()
    {return this.nombreHospital;}
    public String getNombreDirector ()
    {return this.nombreDirector;}
 
    /** @param p_paciente contiene los datos de un paciente */
    public void consultaDatosFiliatorios (Paciente p_paciente)
    {
        System.out.println("\n"+"Hospital: "+this.getNombreHospital()+"  Director: "+this.getNombreDirector());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        p_paciente.mostrarDatosPantalla();
    }
    
       
}
