
/**
 * Write a description of class Triangulo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangulo extends FiguraGeometrica{
    private double base;
    private double altura;
    
    Triangulo(Punto p_origen, double p_base, double p_altura){
        super(p_origen);
        this.setBase(p_base);
        this.setAltura(p_altura);
    }
    
    private void setBase (double p_base){
        this.base = p_base;
    }
    private void setAltura (double p_altura){
        this.altura = p_altura;
    }
    public double getBase (){
        return this.base;
    }
    public double getAltura (){
        return this.altura;
    }
    
    public String nombreFigura(){
        return "****** Triángulo ******";
    }
    
    public double superficie(){
        return (this.getBase() * this.getAltura()) / 2;
    }
    
}
