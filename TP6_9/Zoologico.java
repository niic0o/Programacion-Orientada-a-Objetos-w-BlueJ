import java.util.*;
/**
 * Write a description of class Zoologico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zoologico
{
    private String nombre;
    private ArrayList <Visitante> visitantes;

    Zoologico(String p_nombre){
        this.setNombre(p_nombre);
        this.setVisitantes(new ArrayList <Visitante> ());
    }

    Zoologico(String p_nombre, ArrayList p_visitantes){
        this.setNombre(p_nombre);
        this.setVisitantes(p_visitantes);
    }

    private void setNombre (String p_nombre){
        this.nombre = p_nombre;
    }

    private void setVisitantes (ArrayList <Visitante> p_visitante){
        this.visitantes = p_visitante;
    }

    public String getNombre (){
        return this.nombre;
    }

    public ArrayList <Visitante> getVisitantes (){
        return this.visitantes;
    }

    public void nuevoVisitante (Visitante p_visitante){
        this.getVisitantes().add(p_visitante);
    }
    
    public void removerVisitante (Visitante p_visitante){
        this.getVisitantes().remove(p_visitante);
    }
    
    public void listaTipoVisitantePorFecha(Calendar p_fecha, String p_visitante){
        for(int i=0;i < this.getVisitantes().size();i++){
            this.getVisitantes().get(i).listarPorFecha(p_fecha,p_visitante);
        }
    }
    
    public void listaVisitantePorFecha (Calendar p_fecha){
        for(int i=0;i < this.getVisitantes().size();i++){
            this.getVisitantes().get(i).listarPorFecha(p_fecha,"INDIVIDUO");
            this.getVisitantes().get(i).listarPorFecha(p_fecha,"DELEGACION");
        }        
    }
    
    public double recaudacion (Calendar p_fechaDesde, Calendar p_fechaHasta){
        double recaudado = 0.0;
        for(int i=0;i < this.getVisitantes().size();i++){
        Visitante aux = this.getVisitantes().get(i);
        if(aux.getFechaVisita().after(p_fechaDesde)
        && aux.getFechaVisita().before(p_fechaHasta)){
            recaudado += aux.entrada();
        }
        }
        return recaudado;
    }
}