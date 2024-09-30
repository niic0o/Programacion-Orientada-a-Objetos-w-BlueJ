
/**
 * Permite realizar movimientos monetarios y reflejarlos en pantalla.
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class CuentaBancaria
{
    //atributos
    private int nroCuenta;
    private double saldo;
    private Persona titular;
    
    //constructores
    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     */
    CuentaBancaria (int p_nroCuenta, Persona p_titular)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
    }
    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     * @param p_saldo dinero 
     */    
    CuentaBancaria (int p_nroCuenta, Persona p_titular, double p_saldo)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }
    
    //setters
    private void setNroCuenta (int p_nroCuenta)
    {this.nroCuenta = p_nroCuenta;}
    private void setSaldo (double p_saldo)
    {this.saldo = p_saldo;}
    private void setTitular (Persona p_titular)
    {this.titular = p_titular;}
    
    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    //getters
    public int getNroCuenta ()
    {return this.nroCuenta;}
    public double getSaldo ()
    {return this.saldo;}
    public Persona getTitular ()
    {return this.titular;}
    
    //metodos
    // saldo acutal + p_importe
    /**
     * @param p_importe suma de dinero a depositar/extraer
     * @return saldo actualizado
     */
    public double depositar (double p_importe)
    {
        this.setSaldo(this.getSaldo() + p_importe);
        return this.getSaldo();
    }
    
    public double extraer (double p_importe)
    {
        if (this.getSaldo() >= p_importe)
        {
            this.setSaldo(this.getSaldo() - p_importe);
            return this.getSaldo();
        }
        else
        {
            System.out.println("Error!, su saldo es de: "+this.getSaldo()+"\n");
            return this.getSaldo();
        }
    }
    
    public void mostar ()
    {
        System.out.println("\n"+" - Cuenta Bancaria - ");
        System.out.println("Titular: "+this.getTitular().nomYApe()+"("+this.getTitular().edad()+" años)");
        System.out.println("Saldo: "+this.getSaldo());
    }
    
    /** @return devuelve una concatenacion de caracteres */
    public String toString ()
    {
        return (" "+this.getNroCuenta()+"\t"+this.getTitular().nomYApe()+"\t"+this.getSaldo());
    }
    
            
}
