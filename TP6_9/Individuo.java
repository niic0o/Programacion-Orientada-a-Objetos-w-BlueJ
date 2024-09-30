import java.util.*;
/**
 * Write a description of class Delegacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Individuo extends Visitante
{
    private Persona persona;

    Individuo(String p_nombre, Calendar p_fechaVisita, Persona p_persona){
        super(p_nombre,p_fechaVisita);
        this.setPersona(p_persona);
    }

    private void setPersona (Persona p_persona){
        this.persona = p_persona;
    }

    public Persona getPersona (){
        return this.persona;
    }

    public void mostrar (){
        this.getPersona().mostrar();
    }
    
    public double entrada (){
        return 10.0;
    }

    public String tipoVisitante (){
        return "INDIVIDUO";
    }

    public void listarPorFecha (Calendar p_fecha, String p_visitante){
        if(p_fecha == this.getFechaVisita() && p_visitante == this.tipoVisitante()){
            this.mostrar();
        }else{
            System.out.println("");
        }
    }
}
