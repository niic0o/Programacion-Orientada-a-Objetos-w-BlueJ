
import java.lang.StrictMath;
/**
 * Esta clase crea un circulo, calcula su distancia de otro, su perimetro y superficie.
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class Elipse extends FiguraGeometrica
{   

    private double sEjeMayor;
    private double sEjeMenor;
    private Punto centro;
    
    //constructores
    /**

     */
    Elipse (double p_sEjeMayor, double p_sEjeMenor, Punto p_centro)
    {
        super(p_centro);
        this.setSEjeMayor(p_sEjeMayor);
        this.setSEjeMenor(p_sEjeMenor);
        this.setCentro(p_centro);
    }
    
    //setters
    private void setCentro (Punto p_centro)
        {this.centro = p_centro;}
    private void setSEjeMayor (double p_sEjeMayor)
        {this.sEjeMayor = p_sEjeMayor;}
    private void setSEjeMenor (double p_sEjeMenor)
        {this.sEjeMenor = p_sEjeMenor;}
        
    /** @return getters devuelven los valores que contienen los atributos referenciados */          
    //getters
    public Punto getCentro ()
        {return this.centro;}
    public double getSEjeMayor ()
        {return this.sEjeMayor;}
    public double getSEjeMenor ()
        {return this.sEjeMenor;}
        
    //metodos
    /**
     * @param p_dx distancia a desplazar en el eje x
     * @param p_dy distancia a desplazar en el eje y       
    */
    public void desplazar (double p_dx, double p_dy)
    {
        this.centro.desplazar(p_dx,p_dy);
    }
    /*
    /** @return devuelve el calculo del perimetro de un circulo 
    public double perimetro ()
    {
        return 2 * Math.PI * this.getRadio();
    }
    */
    /** @return devuelve el calculo de la superficie de un circulo */
    public double superficie ()
    {
        return Math.PI * this.getSEjeMayor() * this.getSEjeMenor();
    }

    public void caracteristicas ()
    {
        System.out.println("\n"+this.nombreFigura()+
            "\n"+"Centro: "+this.getCentro().coordenadas()+" - Semieje Mayor: "+
            this.getSEjeMayor()+" - Semieje Menor: "+this.getSEjeMenor()+
            "\n"+"Superficie: "+this.superficie()+"\n");
    }
    
    /** @return retorna la distancia entre dos circulos */
    public double distanciaA (Elipse otraElipse)
    {        
        return this.getCentro().distanciaA(otraElipse.getCentro());
    }
    
    /** @return devuelve el circulo de mayor superficie */
    public Elipse elMayor (Elipse otraElipse)
    {
        if (this.superficie() >= otraElipse.superficie())
        {
            return this;
        }    
        else
        {
            return otraElipse;
        }
    }
     
    public String nombreFigura (){
        return "****** Elipse ******";
    }
}