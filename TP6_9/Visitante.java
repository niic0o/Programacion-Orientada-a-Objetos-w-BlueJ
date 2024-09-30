import java.util.*;
/**
 * Abstract class Visitante - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Visitante
{
    private String nombre;
    private Calendar fechaVisita;

    Visitante(String p_nombre, Calendar p_fechaVisita){
        this.setNombre(p_nombre);
        this.setFechaVisita(p_fechaVisita);
    }

    private void setNombre (String p_nombre){
        this.nombre = p_nombre;
    }

    private void setFechaVisita (Calendar p_fechaVisita){
        this.fechaVisita = p_fechaVisita;
    }

    public String getNombre (){
        return this.nombre;
    }

    public Calendar getFechaVisita (){
        return this.fechaVisita;
    }

    public abstract void mostrar();

    public abstract double entrada ();

    public abstract void listarPorFecha (Calendar p_fecha, String p_visitante);

    public abstract String tipoVisitante();
}