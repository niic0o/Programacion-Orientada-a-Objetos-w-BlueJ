
/**
 * Permite realizar movimientos monetarios dentro de un limite establecido y reflejarlos en pantalla.
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class CajaDeAhorro
{
    private int nroCuenta;
    private double saldo;
    private int extraccionesPosibles;
    private Persona titular;
    
    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     */
    CajaDeAhorro (int p_nroCuenta, Persona p_titular)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0.0);
        this.setExtraccionesPosibles(10);
    }

    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     * @param p_saldo dinero 
     */    
    CajaDeAhorro (int p_nroCuenta, Persona p_titular, double p_saldo)
    {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
        this.setExtraccionesPosibles(10);
    }

    private void setNroCuenta (int p_nroCuenta)
    {this.nroCuenta = p_nroCuenta;}
    private void setTitular (Persona p_titular)
    {this.titular = p_titular;}
    private void setSaldo (double p_saldo)
    {this.saldo = p_saldo;}
    private void setExtraccionesPosibles (int p_extracciones)
    {this.extraccionesPosibles = p_extracciones;}

    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    public int getNroCuenta ()
    {return this.nroCuenta;}
    public Persona getTitular ()
    {return this.titular;}
    public double getSaldo ()
    {return this.saldo;}
    public int getExtraccionesPosibles ()
    {return this.extraccionesPosibles;}
    
    /**
     * @param p_importe suma de dinero a depositar/extraer
     * @return devuelve la confirmacion de extraccion
     */
    private boolean puedeExtraer (double p_importe)
    {
        if ((this.getSaldo() >= p_importe) && (this.getExtraccionesPosibles() != 0))
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
        if (this.puedeExtraer(p_importe) == false)
        {
            if (this.getExtraccionesPosibles() == 0){
                System.out.println("No tiene habilitada mas extracciones!"+"\n");
            }else{
                System.out.println("No puede extraer mas que el saldo!"+"\n");
            }
        }
    }    

    private void extraccion (double p_importe)
    {
        this.setSaldo(this.getSaldo() - p_importe);
        this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
    }    

    public void mostrar ()
    {
        System.out.println("\n"+"-    Caja de Ahorro   -");
        System.out.println("Nro. Cuenta: "+this.getNroCuenta()+" - Saldo: $"+this.getSaldo());
        System.out.println("Titular: "+this.getTitular().getNombre()+"\n"+"Extracciones posibles: "+this.getExtraccionesPosibles()+"\n");
    }    
}
