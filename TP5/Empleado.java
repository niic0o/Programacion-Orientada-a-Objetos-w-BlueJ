
/**
 * Esta clase permite realizar la liquidacion de sueldo de los empleados.
 * @autor Sena, Nicolas Ariel
 * @version 1.0 - 30/08/2017
 * 
 * 
 */
import java.util.*;
public class Empleado
{
    //atributos
    private long cuil;
    private String apellido;
    private String nombre;
    private double sueldoBasico;
    private int anioIngreso;
    private Calendar fechaIngreso;

    /**@param p_cuil identificacion numerica del empleado
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_importe ingreso del sueldo basico
     * @param p_anio año de ingreso del empleado
     */
    //constructor doblemente encapsulado
    Empleado (long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio)
    {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_anio);
    }
    /**@param p_cuil identificacion numerica del empleado
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_importe ingreso del sueldo basico
     * @param p_anio año de ingreso del empleado
     * @param p_fecha fecha de ingreso del empleado
     */
    Empleado (long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha)
    {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
    }  
    //setters
    private void setCuil (long p_cuil)
    {this.cuil = p_cuil;}

    private void setApellido (String p_apellido)
    {this.apellido = p_apellido;}

    private void setNombre (String p_nombre)
    {this.nombre = p_nombre;}

    private void setSueldoBasico (double p_importe)
    {this.sueldoBasico = p_importe;}

    private void setAnioIngreso (int p_anio)
    {this.anioIngreso = p_anio;}

    private void setFechaIngreso (Calendar p_fecha)
    {this.fechaIngreso = p_fecha;}

    //getters
    /** @return getters devuelven los valores que contienen los atributos referenciados */   
    public long getCuil ()
    {return this.cuil;}

    public String getApellido ()
    {return this.apellido;}

    public String getNombre ()
    {return this.nombre;}

    public double getSueldoBasico ()
    {return this.sueldoBasico;}

    public int getAnioIngreso ()
    {return this.anioIngreso;}

    public Calendar getFechaIngreso ()
    {return this.fechaIngreso;}

    //metodos
    /** @return devuelve la antiguedad en la empresa */
    public int antiguedad()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - this.getAnioIngreso();
    }
    
    /** @return devuelve la fecha de antiguedad en la empresa */
    public int antiguedad2()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - this.getFechaIngreso().get(Calendar.YEAR);
    }
    //Obra social 2% sobre el sBasico | -$12 seguro
    /** @return devuelve el descuento por obra social 2% y 12 pesos por seguro*/
    private double descuento()
    {
        return ((this.getSueldoBasico() * 2) / 100) + 12; 
    }

    //*= respecto al sBasico | < 2años el 2%*, entre 2 y 9años el 4%*, >= 10años el 6%*  
    /** @return retorna el adicional de un porcentaje basado en la antiguedad*/
    private double adicional()
    {
        double subtotal = 0;
        if (this.antiguedad() < 2)
        {
            subtotal = (this.getSueldoBasico() * 2) / 100;
        }
        if ((this.antiguedad() >= 2) & (this.antiguedad() < 10))
        {
            subtotal = (this.getSueldoBasico() * 4) / 100;
        }
        if (this.antiguedad() >= 10)
        {
            subtotal = (this.getSueldoBasico() * 6) / 100;
        }
        return subtotal;
    }
    //Sueldo Neto = sBasico + adicional - descuento

    /** @return devuelve el total a pagar*/
    public double sueldoNeto ()
    {
        return this.getSueldoBasico() + this.adicional() - this.descuento();
    }

    /** @return devuelve nombre y apellido encadenado */        
    public String nomYApe()
    {
        return this.getNombre() + " " + this.getApellido();
    }

    /** @return devuelve apellido y nombre encadenado */        
    public String apeYNom()
    {
        return this.getApellido() + ", " + this.getNombre();
    } 

    //falta mostar y mostrarlinea me fui a dormir
    public void mostrar()
    {
        System.out.println("Nombre y Apellido: "+this.nomYApe()+"\n"+"CUIL: "+this.getCuil()+"  Antiguedad: "+this.antiguedad()+" años de servicio");
        System.out.println("Sueldo Neto: $"+this.sueldoNeto()+"\n");
    }

    /** @return datos del objeto como cadena de caracteres*/
    public String mostrarLinea()
    {

        String auxCuil = String.valueOf(this.getCuil());
        String auxSueldo = String.valueOf(this.sueldoNeto());
        String espaciado = "    ";
        String punteado = "  .................$ ";
        return (auxCuil + espaciado + this.apeYNom() + punteado + auxSueldo); 
    }
    
    /**
     * @return devuelve la confirmacion del aniversario
     */
    public boolean esAniversario ()
    {
        Calendar fechaActual = Calendar.getInstance();
        int mes = fechaActual.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
        int auxMes = this.getFechaIngreso().get(Calendar.MONTH);
        int auxDia = this.getFechaIngreso().get(Calendar.DAY_OF_MONTH);

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
    