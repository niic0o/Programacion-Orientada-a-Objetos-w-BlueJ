
import java.lang.StrictMath;
/**
 * Esta clase crea un circulo, calcula su distancia de otro, su perimetro y superficie.
 * 
 * @author Nicolas Ariel Sena 
 * @version 1.0 - 14/09/2017
 */
public class Circulo extends Elipse
{   
    
    Circulo (double p_radio, Punto p_centro)
    {
        super(p_radio,p_radio,p_centro);
    }
    
    public void caracteristicas ()
    {
        System.out.println("\n"+this.nombreFigura());
        System.out.println("Centro: " + this.getCentro().coordenadas() + "  - Radio: " + this.getSEjeMayor());
        System.out.println("Superficie: " + this.superficie() + " - Perimetro: " + this.perimetro() + "\n");
    }
    public String nombreFigura (){
        return "****** Circulo ******";
    }
        /** @return devuelve el calculo del perimetro de un circulo **/
    public double perimetro ()
    {
        return 2 * Math.PI * (this.getSEjeMayor());
    }
    
}