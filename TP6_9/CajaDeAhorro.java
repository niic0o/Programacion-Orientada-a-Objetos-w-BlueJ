
/**
 * Permite realizar movimientos monetarios dentro de un limite establecido y reflejarlos en pantalla.
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class CajaDeAhorro extends Cuenta
{
    private int extraccionesPosibles;
    
    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     */
    CajaDeAhorro (int p_nroCuenta, Persona p_titular)
    {
        super(p_nroCuenta,p_titular);
        this.setExtraccionesPosibles(10);
    }

    /**
     * @param p_nroCuenta numero clave de identificacion
     * @param p_titular contiene informacion del propietario de la cuenta
     * @param p_saldo dinero 
     */    
    CajaDeAhorro (int p_nroCuenta, Persona p_titular, double p_saldo)
    {
        super(p_nroCuenta,p_titular,p_saldo);
        this.setExtraccionesPosibles(10);
    }

    private void setExtraccionesPosibles (int p_extracciones)
    {this.extraccionesPosibles = p_extracciones;}

    /** @return getters devuelven los valores que contienen los atributos referenciados */  

    public int getExtraccionesPosibles ()
    {return this.extraccionesPosibles;}
    
    /**
     * @param p_importe suma de dinero a depositar/extraer
     * @return devuelve la confirmacion de extraccion
     */
    protected boolean puedeExtraer (double p_importe)
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
    
    public boolean extraer (double p_importe)
    {
        if (this.puedeExtraer(p_importe) == true)
        {            
            this.setSaldo(this.getSaldo() - p_importe);
            this.setExtraccionesPosibles(this.getExtraccionesPosibles() - 1);
            return true;
        }else{
            System.out.println(this.xQNoPuedoExtraer(p_importe));
            return false;
        }
    }
    
    public String xQNoPuedoExtraer (double p_importe){
        if (this.getExtraccionesPosibles() == 0){
                return "No tiene habilitada mas extracciones!"+"\n";
            }else{
                return "No puede extraer mas que el saldo!"+"\n";
            }
        
    }
    
    public void mostrar ()
    {
        System.out.println("\n"+"-    Caja de Ahorro   -");
        super.mostrar();
        System.out.println("Extracciones posibles: "+this.getExtraccionesPosibles()+"\n");
    }    
}
