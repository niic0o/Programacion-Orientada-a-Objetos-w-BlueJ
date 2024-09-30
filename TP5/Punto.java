/**
 * Esta clase permite conocer las coordenadas de un punto en un plano de dos dimensiones, tambien permite su desplazamiento.
 * @autor Sena, Nicolas Ariel
 * @version 1.0 - 30/08/2017
 */
import java.lang.*;
public class Punto
{
    //atributos
    private double x;
    private double y;
    Punto otroPunto;

    /** @param - solo inicializa atributos */
    //sobrecarga (inicializar en 0)
    Punto()
    {
        this.setX(0.0);
        this.setY(0.0);
    }

    //constructor doblemente encapsulado
    /** @param p_x posicion del punto en X
     *  @param p_y posicion del punto en Y
     */
    Punto(double p_x, double p_y)
    {
        this.setX(p_x);
        this.setY(p_y);
    }

    Punto(double p_x, double p_y, Punto p_otroPunto)
    {
        this.setX(p_x);
        this.setY(p_y);
        this.setOtroPunto(p_otroPunto);
    }

    //setters
    private void setX (double p_x)
    {this.x = p_x;}

    private void setY (double p_y)
    {this.y = p_y;}

    private void setOtroPunto (Punto p_otroPunto)
    {this.otroPunto = p_otroPunto;}

    //getters
    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    public double getX ()
    {return this.x;}

    public double getY ()
    {return this.y;}

    public Punto getOtroPunto ()
    {return this.otroPunto;}

    /** @param p_dx valor de X ingresado para desplazamiento del punto
     *  @param p_dy valor de Y ingresado para desplazamiento del punto
     */    
    //metodos
    public void desplazar (double p_dx, double p_dy)
    {
        double auxX=0.0, auxY=0.0;
        auxX = this.getX() + p_dx;
        auxY = this.getY() + p_dy;
        this.setX(auxX);
        this.setY(auxY);
    }

    public void mostrar()
    {
        System.out.println("\n"+"Punto X: "+this.getX()+", "+"Y: "+this.getY()+"\n");
    }

    /** @return retorna las coordenadas del punto como cadena de caracteres*/    
    public String coordenadas()
    {
        String auxX = String.valueOf(this.getX());
        String auxY = String.valueOf(this.getY());
        return ("(" + auxX +", " + auxY + ")");
    }
    /** @return devuelve la distancia entre dos puntos */
    public double distanciaA (Punto p_otroPunto)
    {
        double x1 = this.getX();
        double y1 = this.getY();
        double x2 = p_otroPunto.getX();
        double y2 = p_otroPunto.getY();
        return (Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2))));
    }    
}
