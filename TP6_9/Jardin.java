import java.util.*;
import java.math.*;
/**
 * Write a description of class Jardin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jardin{
    private String nombre;
    ArrayList <FiguraGeometrica> figuras;
    
    Jardin(String p_nombre){
        this.setNombre(p_nombre);
        this.setFiguras(new ArrayList <FiguraGeometrica> ());
    }
    
    Jardin(String p_nombre, ArrayList p_figuras){
        this.setNombre(p_nombre);
        this.setFiguras(p_figuras);
    }
    
    private void setNombre (String p_nombre){
        this.nombre = p_nombre;
    }
    private void setFiguras (ArrayList <FiguraGeometrica> p_figuras){
        this.figuras = p_figuras;
    }
    public String getNombre(){
        return this.nombre;
    }
    public ArrayList <FiguraGeometrica> getFiguras (){
        return this.figuras;
    }
    
    public boolean agregarFigura (FiguraGeometrica p_figura){
        return this.getFiguras().add(p_figura);
    }
    
    public boolean quitarFigura (FiguraGeometrica p_figura){
        if(this.getFiguras().isEmpty() == true){
            return false;
        }else{
            return this.getFiguras().remove(p_figura);
        }
    }
        
    public int cuantasLatas(){
         return (int)Math.ceil(this.cuantosMetros() / 20);   
    }
    
    public double cuantosMetros(){
        double totalSuperficie = 0.0;
        for(int i=0;i<this.getFiguras().size();i++){
            totalSuperficie += this.getFiguras().get(i).superficie();
        }
        return totalSuperficie;
    }
    private double cuantosLitros(){
        int litrosXLata = 4;
        double aux = 20 / litrosXLata;
        if (this.cuantosMetros() < 0 || aux <= 0){
            return 0.0;
        }else{
            return this.cuantosMetros() / aux;
        }
    }
    
    public void detalleFiguras(){
        System.out.println("\n"+"Presupuesto: "+this.getNombre()+"\n");
        for(int i=0;i<this.getFiguras().size();i++){
            this.getFiguras().get(i).mostrarSuperficie();
        }
        System.out.println("\n"+"Total a cubrir: "+this.cuantosMetros()+
            "\n"+"Comprar "+this.cuantasLatas()+" latas");        
    }
}
