
/**
 * Permite casar o divorciar a una pareja
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class Mujer
{
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Hombre esposo;

    /**
     * @param p_nombre nombre de la persona
     * @param p_apellido apellido de la persona
     * @param p_edad edad de la persona
     */    
    Mujer (String p_nombre, String p_apellido, int p_edad)
    {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEsposo(null);
        this.setEstadoCivil("Soltera");
    }

    /**
     * @param p_nombre nombre de la persona
     * @param p_apellido apellido de la persona
     * @param p_edad edad de la persona
     * @param p_esposa contiene los datos de su pareja
     */    
    Mujer (String p_nombre, String p_apellido, int p_edad, Hombre p_esposo)
    {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEsposo(p_esposo);
    }

    private void setNombre (String p_nombre)
    {this.nombre = p_nombre;}

    private void setApellido (String p_apellido)
    {this.apellido = p_apellido;}

    private void setEdad (int p_edad)
    {this.edad = p_edad;}

    public void setEsposo (Hombre p_esposo)
    {this.esposo = p_esposo;}

    private void setEstadoCivil (String p_estadoCivil)
    {this.estadoCivil = p_estadoCivil;}

    /** @return getters devuelven los valores que contienen los atributos referenciados */
    public String getNombre ()
    {return this.nombre;}

    public String getApellido ()
    {return this.apellido;}

    public int getEdad ()
    {return this.edad;}

    public Hombre getEsposo ()
    {return this.esposo;}

    public String getEstadoCivil ()
    {return this.estadoCivil;}

    /** @param p_hombre contiene los datos de la paraja a casar */    
    public void casarseCon (Hombre p_hombre)
    {
        String elEsta = p_hombre.getEstadoCivil();
        String ellaEsta = this.getEstadoCivil();
        if ((elEsta == "Soltero" || elEsta == "Divorciado") && (ellaEsta == "Soltera" || ellaEsta == "Divorciada"))
        {
            this.setEsposo(p_hombre);
            p_hombre.setEsposa(this);
           // Hombre casamiento = new Hombre(p_hombre.getNombre(),p_hombre.getApellido(),p_hombre.getEdad(),this);
            this.setEstadoCivil("Casada");
        }
    }

    public void divorcio ()
    {
        if (this.getEstadoCivil() == "Casada")
        {
            this.setEsposo(null);
            this.setEstadoCivil("Divorciada");
        }
    }

    public String nomYApe()
    {
        return this.getNombre() + " " + this.getApellido();
    }

    public String apeYNom()
    {
        return this.getApellido() + ", " + this.getNombre();
    }

    public String datos ()
    {
        return (this.nomYApe()+" de "+this.getEdad()+" años");
    }

    public void mostrarEstadoCivil ()
    {
        System.out.println("\n"+this.datos()+" - "+this.getEstadoCivil()+"\n");
    }

    public void casadaCon ()
    {
        if (this.getEsposo() != null)
        {
            System.out.println("\n"+this.datos()+" esta casada con "+this.getEsposo().nomYApe()+" de "+this.getEsposo().getEdad());
        }   
    }
}