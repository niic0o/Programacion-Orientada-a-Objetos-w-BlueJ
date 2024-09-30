
/**
 * Permite realizar movimientos monetarios dentro de un limite establecido y reflejarlos en pantalla.
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class CuentaCorriente
{
    private int nroCuenta;
    private double saldo;
    private double limiteDescubierto;
    private Persona titular;

    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     */    
    CuentaCorriente (int p_nroCuenta, Persona p_titular)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0.0);
        this.setLimiteDescubierto(500.0);
    }

    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     * @param p_saldo dinero 
     */    
    CuentaCorriente (int p_nroCuenta, Persona p_titular, double p_saldo)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.setLimiteDescubierto(500.0);
    }

    private void setNroCuenta (int p_nroCuenta)
    {this.nroCuenta = p_nroCuenta;}

    private void setTitular (Persona p_titular)
    {this.titular = p_titular;}

    private void setSaldo (double p_saldo)
    {this.saldo = p_saldo;}

    private void setLimiteDescubierto (double p_limite)
    {this.limiteDescubierto = p_limite;}

    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    public int getNroCuenta ()
    {return this.nroCuenta;}

    public Persona getTitular ()
    {return this.titular;}

    public double getSaldo ()
    {return this.saldo;}

    public double getLimiteDescubierto ()
    {return this.limiteDescubierto;}

    /**
     * @param p_importe suma de dinero a depositar/extraer
     * @return devuelve la confirmacion de extraccion
     */    
    private boolean puedeExtraer (double p_importe)
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

    public void depositar (double p_importe)
    {
        this.setSaldo(this.getSaldo() + p_importe);
    }

    public void extraer (double p_importe)
    {
        if (this.puedeExtraer(p_importe) == true)
        {
            this.extraccion(p_importe);
        }
        else
        {
            System.out.println("El importe de extraccion sobrepasa el limite de descubierto!"+"\n");
        }
    }    

    private void extraccion (double p_importe)
    {
        this.setSaldo(this.getSaldo() - p_importe);
    }    
    
    public void mostrar ()
    {
        System.out.println("\n"+"-    Cuenta Corriente    -");
        System.out.println("Nro. Cuenta: "+this.getNroCuenta()+" - Saldo: $"+this.getSaldo());
        System.out.println("Titular: "+this.getTitular().getNombre()+"\n"+"Descubierto: $"+this.getLimiteDescubierto()+"\n");
    }
}
