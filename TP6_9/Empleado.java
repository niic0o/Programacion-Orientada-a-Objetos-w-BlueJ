import java.util.*;
/**
 * Esta clase permite realizar la liquidacion de sueldo de los empleados.
 * @autor Sena, Nicolas Ariel
 * @version 1.0 - 30/08/2017
 * 
 * 
 */

public class Empleado extends Persona
{
    //atributos
    private long cuil;
    private double sueldoBasico;
    private int añoIngreso;
    private Calendar fechaIngreso;

    /**@param p_cuil identificacion numerica del empleado
     * @param p_apellido apellido del empleado
     * @param p_nombre nombre del empleado
     * @param p_importe ingreso del sueldo basico
     * @param p_anio año de ingreso del empleado
     */
    //constructor doblemente encapsulado
    Empleado (int p_dni, String p_nombre, String p_apellido, int p_añoNac,
    long p_cuil, double p_importe, int p_añoIngreso)
    {
        super(p_dni,p_nombre,p_apellido,p_añoNac);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_importe);
        this.setAñoIngreso(p_añoIngreso);
        this.setFechaIngreso(null);
    }

    Empleado (int p_dni, String p_nombre, String p_apellido, int p_añoNac,
    long p_cuil, double p_importe,  Calendar p_fecha)
    {
        super(p_dni,p_nombre,p_apellido,p_añoNac);
        this.setCuil(p_cuil);
        this.setSueldoBasico(p_importe);
        this.setAñoIngreso(0);
        this.setFechaIngreso(p_fecha);
    }  
    //setters
    private void setCuil (long p_cuil)
    {this.cuil = p_cuil;}

    private void setSueldoBasico (double p_importe)
    {this.sueldoBasico = p_importe;}

    private void setAñoIngreso (int p_año)
    {this.añoIngreso = p_año;}

    private void setFechaIngreso (Calendar p_fecha)
    {this.fechaIngreso = p_fecha;}

    //getters
    /** @return getters devuelven los valores que contienen los atributos referenciados */   
    public long getCuil ()
    {return this.cuil;}

    public double getSueldoBasico ()
    {return this.sueldoBasico;}

    public int getAñoIngreso ()
    {return this.añoIngreso;}

    public Calendar getFechaIngreso ()
    {return this.fechaIngreso;}

    //metodos
    /** @return devuelve la antiguedad en la empresa */
    public int antiguedad()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int añoHoy = fechaHoy.get(Calendar.YEAR);
        return añoHoy - this.getAñoIngreso();
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

    //falta mostar y mostrarlinea me fui a dormir
    public void mostrar()
    {
        super.mostrar();
        System.out.println("CUIL: "+this.getCuil()+
            " Antiguedad: "+this.antiguedad()+" años de servicio"+
            "\n"+"Sueldo Neto: $"+this.sueldoNeto());
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
