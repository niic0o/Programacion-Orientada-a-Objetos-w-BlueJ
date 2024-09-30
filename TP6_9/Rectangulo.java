
/**
 * Esta clase crea un Rectangulo, calcula su distancia de otro, su perimetro y superficie.
 * 
 * @author Nicolas Ariel Sena.
 * @version 1.0 - 14/09/2017.
 */
public class Rectangulo extends FiguraGeometrica
{
    //atributos | coordenada (x,y) = (ancho,alto)
    private Punto origen;
    private double ancho;
    private double alto;

    //constructores
    /**
     * @param p_origen representa al punto de origen del rectangulo ubicado en ejes(x,y)
     * @param p_ancho dado por el eje x en el plano
     * @param p_alto dado por el eje y en el plano
       */
    Rectangulo (Punto p_origen, double p_ancho, double p_alto)
    {
        super(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
        this.setOrigen(p_origen);
    }

    //inicializar rectangulo
    /**
     * @param p_ancho dado por el eje x en el plano
     * @param p_alto dado por el eje y en el plano
     */
    Rectangulo (double p_ancho, double p_alto)
    {
        super(new Punto());
    }

    //setters
    private void setOrigen (Punto p_origen)
    {this.origen = p_origen;}

    private void setAncho (double p_ancho)
    {this.ancho = p_ancho;}

    private void setAlto (double p_alto)
    {this.alto = p_alto;}

    /** @return getters devuelven los valores que contienen los atributos referenciados */  
    //getters
    public Punto getOrigen ()
    {return this.origen;}

    public double getAncho ()
    {return this.ancho;}

    public double getAlto ()
    {return this.alto;}

    //metodos
    /**
     * @param p_dx distancia a desplazar en el eje x
     * @param p_dy distancia a desplazar en el eje y       
    */    
    public void desplazar (double p_dx, double p_dy)
    {
        this.origen.desplazar(p_dx,p_dy);
    }

    /** @return devuelve el calculo del perimetro de un rectangulo */    
    public double perimetro ()
    {
        return (2 * (this.getAncho() + this.getAlto()));
    }

    /** @return devuelve el calculo de la superficie de un rectangulo */   
    public double superficie ()
    {
        return (this.getAncho() * this.getAlto());
    }
    
    //envio mensaje al origen actual y le paso como parametro el origen de otroRectangulo. Retorna el calculo
    
    /** @return retorna la distancia entre dos rectangulos */
    public double distanciaA (Rectangulo otroRectangulo)
    {
        return this.getOrigen().distanciaA(otroRectangulo.getOrigen());
    }
    
    /** @return devuelve el rectangulo de mayor superficie */
    public Rectangulo elMayor (Rectangulo otroRectangulo)
    {
        if (this.superficie() >= otroRectangulo.superficie())
        {
            return this;
        }
        else
        {
            return otroRectangulo;
        }
    }
    
    public void caracteristicas ()
        {
            System.out.println("\n"+this.nombreFigura());
            System.out.println("Origen: " + this.getOrigen().coordenadas() + "  - Alto: " + this.getAlto() + " - Ancho: " + this.getAncho());
            System.out.println("Superficie: " + this.superficie() + " - Perimetro: " + this.perimetro() + "\n");
        }
        
    public String nombreFigura (){
        return "***** Rectangulo *****";
    }
}
