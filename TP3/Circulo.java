
import java.lang.StrictMath;
/**
 * Esta clase crea un circulo, calcula su distancia de otro, su perimetro y superficie.
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class Circulo
{   
    //atributos
    //centro es de tipo punto, punto tiene valor de X y valor de Y, centro posee X e Y como atributo
    private double radio;
    private Punto centro;
    
    //constructores
    Circulo ()
    {
        //Creo un objeto que setea en 0 sus atributos de clase punto
        //paso ese objeto al atributo centro de esta clase para que lo setee y reconozca
        this.setCentro(new Punto());
        this.setRadio(0.0);
    }
    
    /**
     * @param p_radio valor real de una figura circular
     * @param p_centro representa al punto central del circulo ubicado en ejes(x,y)
     */
    Circulo (double p_radio, Punto p_centro)
    {
        this.setRadio(p_radio);
        this.setCentro(p_centro);
    }
    
    //setters
    private void setCentro (Punto p_centro)
        {this.centro = p_centro;}
    private void setRadio (double p_radio)
        {this.radio = p_radio;}
         
    /** @return getters devuelven los valores que contienen los atributos referenciados */          
    //getters
    public Punto getCentro ()
        {return this.centro;}
    public double getRadio ()
        {return this.radio;}
    
    //metodos
    /**
     * @param p_dx distancia a desplazar en el eje x
     * @param p_dy distancia a desplazar en el eje y       
    */
    public void desplazar (double p_dx, double p_dy)
    {
        this.centro.desplazar(p_dx,p_dy);
    }
    
    /** @return devuelve el calculo del perimetro de un circulo */
    public double perimetro ()
    {
        return 2 * Math.PI * this.getRadio();
    }

    /** @return devuelve el calculo de la superficie de un circulo */
    public double superficie ()
    {
        return Math.PI * Math.pow(this.getRadio(),2);
    }
    
    public void caracteristicas ()
    {
        System.out.println("\n"+"****** Circulo ******");
        System.out.println("Centro: " + this.getCentro().coordenadas() + "  - Radio: " + this.getRadio());
        System.out.println("Superficie: " + this.superficie() + " - Perimetro: " + this.perimetro() + "\n");
    }
    
    /** @return retorna la distancia entre dos circulos */
    public double distanciaA (Circulo otroCirculo)
    {        
        return this.getCentro().distanciaA(otroCirculo.getCentro());
    }
    
    /** @return devuelve el circulo de mayor superficie */
    public Circulo elMayor (Circulo otroCirculo)
    {
        if (this.superficie() >= otroCirculo.superficie())
        {
            return this;
        }    
        else
        {
            return otroCirculo;
        }
    }
     
}