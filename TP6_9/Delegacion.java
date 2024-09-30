import java.util.*;
/**
 * Write a description of class Delegacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Delegacion extends Visitante
{
    private ArrayList <Individuo> individuos;
    
    Delegacion(String p_nombre, Calendar p_fechaVisita, Individuo p_individuo){
        super(p_nombre,p_fechaVisita);
        this.setIndividuos(new ArrayList <Individuo> ());
        this.inscribirIndividuo(p_individuo);
    }
    
    Delegacion(String p_nombre, Calendar p_fechaVisita, ArrayList p_individuos){
        super(p_nombre,p_fechaVisita);
        this.setIndividuos(p_individuos);
    }
    
    private void setIndividuos (ArrayList <Individuo> p_individuo){
        this.individuos = p_individuo;
    }
    
    public ArrayList <Individuo> getIndividuos (){
        return this.individuos;
    }
    
    //total delegacion - total delegacion * 0.10
    public double entrada (){
        double total = 0.0;
        for(int i=0; i<this.getIndividuos().size();i++){
            total += this.getIndividuos().get(i).entrada();
        }
        return total - (total * 0.10);
    }
    
    public void inscribirIndividuo(Individuo p_individuo){
        this.getIndividuos().add(p_individuo);
    }
    
    public void removerIndividuo (Individuo p_individuo){
        this.getIndividuos().remove(p_individuo);
    }
    
    public int cantidadDeIntegrantes (){
        int cantidad = 0;
        for(int i=0; i<this.getIndividuos().size();i++){
            cantidad++;
        }
        return cantidad;
    }
    
        public String tipoVisitante (){
        return "DELEGACION";
    }
    
    public void listarPorFecha (Calendar p_fecha, String p_visitante){
        if(p_fecha == this.getFechaVisita() && p_visitante == this.tipoVisitante()){
            this.mostrar();
        }else{
            System.out.println("");
        }
    }
    
    public void mostrar (){
        System.out.println("------------------------------------------------------"+
            "\n"+"Delegacion: "+this.getNombre()+
            "\n"+"\n"+"Integrantes");
        for(int i=0; i<this.getIndividuos().size();i++){
            this.getIndividuos().get(i).mostrar();
        }
        System.out.println("Cantidad de Integrantes: "+this.cantidadDeIntegrantes());
        System.out.println("------------------------------------------------------");
    }
}