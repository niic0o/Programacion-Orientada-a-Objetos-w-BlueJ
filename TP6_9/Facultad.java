import java.util.*;
/**
 * Write a description of class Facultad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Facultad
{
    private String nombre;
    private ArrayList <Profesor> profesores;

    Facultad(String p_nombre,Profesor p_profesor){
        this.setNombre(p_nombre);
        this.setProfesores(new ArrayList <Profesor> ());
        agregarProfesor(p_profesor);
    }

    Facultad(String p_nombre,ArrayList p_profesores){
        this.setNombre(p_nombre);
        this.setProfesores(p_profesores);
    }

    private void setNombre (String p_nombre){
        this.nombre = p_nombre;
    }

    private void setProfesores (ArrayList <Profesor> p_profesores){
        this.profesores = p_profesores;
    }

    public String getNombre (){
        return this.nombre;
    }

    public ArrayList <Profesor> getProfesores (){
        return this.profesores;
    }

    public boolean agregarProfesor (Profesor p_profesor){
        return this.getProfesores().add(p_profesor);
    }

    public boolean quitarProfesor (Profesor p_profesor){
        if(this.getProfesores().isEmpty() == true){
            return false;
        }else{
            return this.getProfesores().remove(p_profesor);
        }
    }

    public double totalAPagar(){
        double total = 0.0;
        for(int i=0;i<this.getProfesores().size();i++){
            total += this.getProfesores().get(i).sueldoTotal();
        }
        return total;
    }

    public void nominaProfesores(){
        System.out.println("\n"+"***************** Nomina Facultad: "+
            this.getNombre()+"\n"+"--------------------------------------");
        for(int i=0;i<this.getProfesores().size();i++){
            System.out.println(""+this.getProfesores().get(i).mostrarLinea());
        }
        System.out.println("--------------------------------------"+
            "\n"+"Total a pagar: "+this.totalAPagar());
    }

    public void listarProfesorCargos (){
        int totalProfesores = 0;
        System.out.println("\n"+"***** Detalle de Profesores y cargos de Facultad: "+
            this.getNombre()+" *****"+"\n"+"-----------------------------------------");
        for(int i=0;i<this.getProfesores().size();i++){
            this.getProfesores().get(i).mostrar();
            totalProfesores++;
            System.out.println("\n"+"------------------ **** -------------------");
        }
        System.out.println("------------------------------------------"+
        "\n"+"Hay "+totalProfesores+" profesores");
    }

}
