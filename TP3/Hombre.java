
/**
 * Permite casar o divorciar a una pareja
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class Hombre
{
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Mujer esposa;

    /**
     * @param p_nombre nombre de la persona
     * @param p_apellido apellido de la persona
     * @param p_edad edad de la persona
     */
    Hombre (String p_nombre, String p_apellido, int p_edad)
    {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEsposa(null);
        this.setEstadoCivil("Soltero");
    }

    /**
     * @param p_nombre nombre de la persona
     * @param p_apellido apellido de la persona
     * @param p_edad edad de la persona
     * @param p_esposa contiene los datos de su pareja
     */
    Hombre (String p_nombre, String p_apellido, int p_edad, Mujer p_esposa)
    {
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEsposa(p_esposa);
    }

    private void setNombre (String p_nombre)
    {this.nombre = p_nombre;}

    private void setApellido (String p_apellido)
    {this.apellido = p_apellido;}

    private void setEdad (int p_edad)
    {this.edad = p_edad;}

    public void setEsposa (Mujer p_esposa)
    {this.esposa = p_esposa;}

    private void setEstadoCivil (String p_estadoCivil)
    {this.estadoCivil = p_estadoCivil;}

    /** @return getters devuelven los valores que contienen los atributos referenciados */      
    public String getNombre ()
    {return this.nombre;}

    public String getApellido ()
    {return this.apellido;}

    public int getEdad ()
    {return this.edad;}

    public Mujer getEsposa ()
    {return this.esposa;}

    public String getEstadoCivil ()
    {return this.estadoCivil;}

    /** @param p_mujer contiene los datos de la paraja a casar */
    public void casarseCon (Mujer p_mujer)
    {
        String ellaEsta = p_mujer.getEstadoCivil();
        String elEsta = this.getEstadoCivil();
        if ((elEsta == "Soltero" || elEsta == "Divorciado") && (ellaEsta == "Soltera" || ellaEsta == "Divorciada"))
        {
            this.setEsposa(p_mujer);
            p_mujer.setEsposo(this);
            //Mujer casamiento = new Mujer(p_mujer.getNombre(),p_mujer.getApellido(),p_mujer.getEdad(),this);            
            this.setEstadoCivil("Casado");
        }
    }

    public void divorcio ()
    {
        if (this.getEstadoCivil() == "Casado")
        {
            this.setEsposa(null);
            this.setEstadoCivil("Divorciado");
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

    public void casadoCon ()
    {
        if (this.getEsposa() != null)
        {
            System.out.println("\n"+this.datos()+" esta casada con "+this.getEsposa().nomYApe()+" de "+this.getEsposa().getEdad());
        }   
    }
}
