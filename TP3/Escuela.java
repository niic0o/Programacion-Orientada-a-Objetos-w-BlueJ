
/**
 * Brinda los datos basicos del establecimiento.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class Escuela
{
    //atributos
    private String nombre;
    private String domicilio;
    private String director;
    
    //constructores
    /**
     * @param p_nombre nombre del establecimiento.
     * @param p_domicilio ubicacion geografica del establecimiento.
     * @param p_director persona a cargo del establecimiento.
     */
    Escuela (String p_nombre, String p_domicilio, String p_director)
    {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setDirector(p_director);
    }
    
    //setters
    private void setNombre (String p_nombre)
    {this.nombre = p_nombre;}
    private void setDomicilio (String p_domicilio)
    {this.domicilio = p_domicilio;}
    private void setDirector (String p_director)
    {this.director = p_director;}
    
    //getters
    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    public String getNombre ()
    {return this.nombre;}
    public String getDomicilio ()
    {return this.domicilio;}
    public String getDirector ()
    {return this.director;}
    
    //metodos
    /**
     * @param p_docente contiene los datos del docente provenientes de la clase Docente
     */
    public void imprimirRecibo (Docente p_docente)
    {
        System.out.println("\n"+"Escuela: "+this.getNombre()+"\t"+"Domicilio: "+this.getDomicilio()+"\t"+"Director: "+this.getDirector());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Docente: "+p_docente.getNombre());
        System.out.println("Sueldo:........................... $"+p_docente.calcularSueldo());
        System.out.println("Sueldo Basico:.................... $"+p_docente.getSueldoBasico());
        System.out.println("Asignacion Familiar:.............. $"+p_docente.getAsignacionFamiliar()+"\n");
    }
        
}
