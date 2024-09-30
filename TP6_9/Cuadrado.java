
/**
 * Esta clase es una especializacion de Rectangulo. Permite conocer datos descriptivos de la figura indicada.
 * 
 * @author (Sena, Nicolas Ariel
 * @version 11/2017
 */
public class Cuadrado extends Rectangulo{
    private double lado;
    
    Cuadrado(Punto p_origen, double p_lado){
        super(p_origen,p_lado,p_lado);
        this.setLado(p_lado);
    }
    
    private void setLado (double p_lado){
        this.lado = p_lado;
    }
    public double getLado (){
        return this.lado;
    }
    
    public String nombreFigura (){
        return "***** Cuadrado *****";
    }
    
    public void caracteristicas (){
        System.out.println("\n"+this.nombreFigura()+
            "\n"+"Origen: "+this.getOrigen().coordenadas()+
            " - Lado: "+this.getLado()+
            "\n"+"Superficie: "+this.superficie()+" - Perimetro: "+
            this.perimetro()+"\n");
    }
}
