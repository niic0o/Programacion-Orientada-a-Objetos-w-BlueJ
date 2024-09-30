import java.util.*;
/**
 * Write a description of class Gerencia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gerencia
{
    private String nombre;
    private ArrayList <Alojamiento> alojamientosAlquilados;

    Gerencia(String p_nombre){
        this.setNombre(p_nombre);
        this.setAlojamientosAlquilados(new ArrayList <Alojamiento> ());
    }

    Gerencia(String p_nombre, ArrayList p_alojamientosAlquilados){
        this.setNombre(p_nombre);
        this.setAlojamientosAlquilados(p_alojamientosAlquilados);
    }

    private void setNombre (String p_nombre){
        this.nombre = p_nombre;
    }

    private void setAlojamientosAlquilados (ArrayList <Alojamiento> p_alojamientosAlquilados){
        this.alojamientosAlquilados = p_alojamientosAlquilados;
    }

    public String getNombre (){
        return this.nombre;
    }

    public ArrayList <Alojamiento> getAlojamientosAlquilados (){
        return this.alojamientosAlquilados;
    }

    public boolean agregarAlojamiento (Alojamiento p_alojamiento){
        return this.getAlojamientosAlquilados().add(p_alojamiento);
    }
    
    public boolean quitarAlojamiento (Alojamiento p_alojamiento){
        return this.getAlojamientosAlquilados().remove(p_alojamiento);
    }
    
    public int contarAlojamiento (String p_tipoAlojamiento){
        int alojamiento = 0;
        for(int i=0;i<this.getAlojamientosAlquilados().size();i++){
            alojamiento += this.getAlojamientosAlquilados().get(i).contar(p_tipoAlojamiento);
        }
        return alojamiento;
    }
    
    public void liquidar (){
        for(int i=0;i<this.getAlojamientosAlquilados().size();i++){
            this.getAlojamientosAlquilados().get(i).liquidar();
        }
    }
    
    public void mostrarLiquidacion (){
        System.out.println("\n"+"Gerencia "+this.getNombre()+
            "\n"+"Liquidacion --------------------");
        this.liquidar();
        System.out.println("\n"+"Alojamiento tipo Cabaña ---->"+
            this.contarAlojamiento("Cabaña")+
            "\n"+"Alojamiento tipo Hotel ------>"+
            this.contarAlojamiento("Hotel"));
    }
}
