/**
 * Esta clase permite conocer las coordenadas de un punto en un plano de dos dimensiones, tambien permite su desplazamiento.
 * @autor Sena, Nicolas Ariel
 * @version 1.0 - 30/08/2017
*/

public class Punto
{
    //atributos
    private double x;
    private double y;
    
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
    //setters
    private void setX (double p_x)
        {this.x = p_x;}
    private void setY (double p_y)
        {this.y = p_y;}
    
    //getters
    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    public double getX ()
        {return this.x;}
    public double getY ()
        {return this.y;}
    
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
            System.out.println("Punto X: "+this.getX()+", "+"Y: "+this.getY()+"\n");
        }
    
    /** @return retorna las coordenadas del punto como cadena de caracteres*/    
    public String coordenadas()
        {
            String auxX = String.valueOf(this.getX());
            String auxY = String.valueOf(this.getY());
            return ("(" + auxX +", " + auxY + ")");
        }
}
