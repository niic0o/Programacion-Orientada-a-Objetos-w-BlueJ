
/**
 * Permite realizar movimientos monetarios dentro de un limite establecido y reflejarlos en pantalla.
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class CuentaCorriente extends Cuenta
{
    private double limiteDescubierto;

    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     */    
    CuentaCorriente(int p_nroCuenta, Persona p_titular)
    {
        super(p_nroCuenta,p_titular);
        this.setLimiteDescubierto(500.0);
    }

    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     * @param p_saldo dinero 
     */    
    CuentaCorriente(int p_nroCuenta, Persona p_titular, double p_saldo)
    {
        super(p_nroCuenta,p_titular,p_saldo);
        this.setLimiteDescubierto(500.0);
    }

    private void setLimiteDescubierto (double p_limite)
    {this.limiteDescubierto = p_limite;}

    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    public double getLimiteDescubierto ()
    {return this.limiteDescubierto;}

    /**
     * @param p_importe suma de dinero a depositar/extraer
     * @return devuelve la confirmacion de extraccion
     */    
    public boolean puedeExtraer (double p_importe)
    {
        if ((this.getSaldo() + this.getLimiteDescubierto()) >= p_importe)
        {
            return true;
        }
        else
        {
            return false;
        }
    }  

    public boolean extraer (double p_importe)
    {
        if (this.puedeExtraer(p_importe) == true)
        {
            this.setSaldo(this.getSaldo() - p_importe);
            return true;
        }
        else
        {
            System.out.println(this.xQNoPuedoExtraer(p_importe));
            return false;
        }
    }    

    public String xQNoPuedoExtraer (double p_importe){
        if (this.puedeExtraer(p_importe) == false){
            return "El importe de extraccion sobrepasa el limite de descubierto!"+"\n";
        }else{
            return "Error!";
        }
    }

    public void mostrar ()
    {
        System.out.println("\n"+"-    Cuenta Corriente    -");
        super.mostrar();
        System.out.println("Descubierto: $"+this.getLimiteDescubierto()+"\n");
    }
}
