import java.util.*;
/**
 * Esta clase permite conocer datos personales de varias personas, incluso conocer su edad y si es su cumpleaños.
 * @autor Sena, Nicolas Ariel
 * @version 1.1 - 14/09/2017
 *  
 */

public class Persona
{
    private int nroDni;
    private String nombre;
    private String apellido;
    private int anioNacimiento;
    private Calendar fechaNacimiento;

    /**@param p_dni se usa para ingresar el numero de DNI
     * @param p_nombre nombre de la persona
     * @param p_apellido apellido de la persona
     * @param p_anio se usa para ingresar el año de nacimiento de la persona
    */ 
    public Persona(int p_dni,String p_nombre,String p_apellido,int p_anio)
    {
        this.setNroDni(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_anio);
    }
    /**@param p_dni se usa para ingresar el numero de DNI
     * @param p_nombre nombre de la persona
     * @param p_apellido apellido de la persona
     * @param p_anio se usa para ingresar el año de nacimiento de la persona
     * @param p_fecha fecha de nacimiento 
    */ 
    public Persona(int p_dni,String p_nombre,String p_apellido,Calendar p_fecha)
    {
        this.setNroDni(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fecha);
    }

    private void setNroDni(int p_dni)
    {
        this.nroDni = p_dni;
    }

    private void setNombre(String p_nombre)
    {
        this.nombre = p_nombre;
    }

    private void setApellido(String p_apellido)
    {
        this.apellido = p_apellido;
    }

    private void setAnioNacimiento(int p_anio)
    {
        this.anioNacimiento = p_anio;
    }

    private void setFechaNacimiento(Calendar p_fecha)
    {
        this.fechaNacimiento = p_fecha;
    }

    /** @return getters devuelven el valor de los atributos referenciados */
    public int getNroDni()
    {
        return this.nroDni;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getApellido()
    {
        return this.apellido;
    }

    public int getAnioNacimiento()
    {
        return this.anioNacimiento;
    }

    public Calendar getFechaNacimiento()
    {
        return this.fechaNacimiento;
    }

    /** @return devuelve la edad de la persona */  
    public int edad()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - this.getAnioNacimiento();
    }

    /** @return retonrna el nombre y apellido */
    public String nomYApe()
    {
        return this.getNombre() + " " + this.getApellido();
    }

    /** @return retorna el apellido y nombre */
    public String apeYNom()
    {
        return this.getApellido() + ", " + this.getNombre();
    }

    public void mostrar()
    {
        System.out.println("Nombre y Apellido: "+ nomYApe());
        System.out.println("DNI: "+ this.getNroDni()+ " Edad: "+ this.edad()+ " años");
    }

    /** @return devuelve la confirmacion de fecha de cumpleaños */
    public boolean esCumpleaños ()
    {
        Calendar fechaActual = Calendar.getInstance();
        int mes = fechaActual.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
        int auxMes = this.getFechaNacimiento().get(Calendar.MONTH);
        int auxDia = this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH);

        if (mes == auxMes && dia == auxDia)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
