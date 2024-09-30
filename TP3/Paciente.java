
/**
 * Datos de un paciente hospitalario.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class Paciente
{
    private int historiaClinica;
    private String nombre;
    private String domicilio;
    private Localidad localidadNacido;
    private Localidad localidadVive;    

    /**
     * @param p_historia numero clave de identificacion
     * @param p_nombre nombre del paciente
     * @param p_domicilio lugar de residencia del paciente
     * @param p_localidadNacido ciudad de procedencia del paciente
     * @param p_localidadVive ciudad de residencia del paciente
     */
    Paciente (int p_historia, String p_nombre, String p_domicilio, Localidad p_localidadNacido, Localidad p_localidadVive)
    {
        this.setHistoriaClinica(p_historia);
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setLocalidadNacido(p_localidadNacido);
        this.setLocalidadVive(p_localidadVive);
    }

    private void setHistoriaClinica (int p_historia)
    {this.historiaClinica = p_historia;}

    private void setNombre (String p_nombre)
    {this.nombre = p_nombre;}

    private void setDomicilio (String p_domicilio)
    {this.domicilio = p_domicilio;}

    private void setLocalidadNacido (Localidad p_localidad)
    {this.localidadNacido = p_localidad;}

    private void setLocalidadVive (Localidad p_localidad)
    {this.localidadVive = p_localidad;}

    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    public int getHistoriaClinica ()
    {return this.historiaClinica;}

    public String getNombre ()
    {return this.nombre;}

    public String getDomicilio ()
    {return this.domicilio;}

    public Localidad getLocalidadNacido ()
    {return this.localidadNacido;}

    public Localidad getLocalidadVive ()
    {return this.localidadVive;}

    public void mostrarDatosPantalla ()
    {
        System.out.println("\n"+"Paciente: "+this.getNombre()+"   Historia clinica: "+this.getHistoriaClinica()+"   Domicilio: "+this.getDomicilio());
        System.out.println(this.getLocalidadVive().mostrar()+"\n");
    }

    /** @return cadena de caracteres con datos del paciente */    
    public String cadenaDeDatos ()
    {
        return (this.getNombre()+" ..... "+this.getHistoriaClinica()+" ..... "+this.getDomicilio()+" - "+this.getLocalidadVive().getNombre()+" - "+this.getLocalidadVive().getProvincia());
    }

}

