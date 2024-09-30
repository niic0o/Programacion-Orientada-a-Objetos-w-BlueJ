
/**
 * Crea una cuenta bancaria.
 * 
 * @author Sena Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public abstract class Cuenta
{
    private Persona titular;
    private int nroCuenta;
    private double saldo;

    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     */
    Cuenta(int p_nroCuenta, Persona p_titular)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0.0);
    }

    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     * @param p_saldo dinero 
     */    
    Cuenta(int p_nroCuenta, Persona p_titular, double p_saldo)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }

    private void setNroCuenta (int p_nroCuenta)
    {this.nroCuenta = p_nroCuenta;}

    private void setTitular (Persona p_titular)
    {this.titular = p_titular;}

    protected void setSaldo (double p_saldo)
    {this.saldo = p_saldo;}

    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    public int getNroCuenta ()
    {return this.nroCuenta;}

    public Persona getTitular ()
    {return this.titular;}

    public double getSaldo ()
    {return this.saldo;}

    protected abstract boolean puedeExtraer (double p_importe);

    public void depositar (double p_importe)
    {
        this.setSaldo(this.getSaldo() + p_importe);
    }

    public abstract boolean extraer (double p_importe);

    public abstract String xQNoPuedoExtraer (double p_importe);

    public void mostrar ()
    {
        System.out.println("Nro. Cuenta: "+this.getNroCuenta()+" - Saldo: $"+this.getSaldo());
        System.out.println("Titular: "+this.getTitular().apeYNom());
    }    
}
