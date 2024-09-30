/**
 * Abstract class FiguraGeometrica - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class FiguraGeometrica
{
    private Punto origen;

    FiguraGeometrica(Punto p_origen){
        this.setOrigen(p_origen);
    }

    private void setOrigen(Punto p_origen){
        this.origen = p_origen;
    }

    public Punto getOrigen (){
        return this.origen;
    }

    public abstract String nombreFigura();

    public abstract double superficie();

    public void mostrarSuperficie(){
        System.out.println("\n"+this.nombreFigura()+"\n"+
            "Superficie: "+this.superficie());
    }
}