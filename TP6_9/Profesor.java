import java.util.*;
/**
 * Write a description of class Profesor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Profesor extends Persona
{
    private String titulo;
    private ArrayList <Cargo> cargos;

    // 1 solo cargo
    Profesor(int p_dni,String p_nombre,String p_apellido,int p_año,
    String p_titulo, Cargo p_cargo){
        super(p_dni,p_nombre,p_apellido,p_año);
        this.setTitulo(p_titulo);
        this.setCargos(new ArrayList <Cargo> ());
        agregarCargo(p_cargo);
    }

    Profesor(int p_dni,String p_nombre,String p_apellido,int p_año,
    String p_titulo, Cargo p_cargo1, Cargo p_cargo2){
        super(p_dni,p_nombre,p_apellido,p_año);
        this.setTitulo(p_titulo);
        this.setCargos(new ArrayList <Cargo> ());
        agregarCargo(p_cargo1);
        agregarCargo(p_cargo2);
    }

    Profesor(int p_dni,String p_nombre,String p_apellido,int p_año,
    String p_titulo, Cargo p_cargo1, Cargo p_cargo2, Cargo p_cargo3){
        super(p_dni,p_nombre,p_apellido,p_año);
        this.setTitulo(p_titulo);
        this.setCargos(new ArrayList <Cargo> ());
        agregarCargo(p_cargo1);
        agregarCargo(p_cargo2);
        agregarCargo(p_cargo3);
    }

    private void setTitulo (String p_titulo){
        this.titulo = p_titulo;
    }
    private void setCargos (ArrayList <Cargo> p_cargos){
        this.cargos = p_cargos;
    }
    public String getTitulo (){
        return this.titulo;
    }
    public ArrayList <Cargo> getCargos (){
        return this.cargos;
    }
    
    public boolean agregarCargo (Cargo p_cargo){
        if (this.getCargos().size() >= 4){
            return false;
        }else{
            return this.getCargos().add(p_cargo);
        }
    }
    
    public boolean quitarCargo (Cargo p_cargo){
        if(this.getCargos().isEmpty() == true){
            return false;
        }else{
            return this.getCargos().remove(p_cargo);
        }
    }
    
    public double sueldoTotal (){
        double sueldoXCargo = 0.0;
        for(int i=0;i<this.getCargos().size();i++){
            sueldoXCargo += this.getCargos().get(i).sueldoDelCargo();
        }
        return sueldoXCargo;        
    }
    
    public void listarCargos(){
        System.out.println("\n"+"_***** Cargos Asignados *****_"+
            "\n"+"-------------------------------");
        for(int i=0;i<this.getCargos().size();i++){
            this.getCargos().get(i).mostrarCargo();
        }
    }
    
    public void mostrar(){
        super.mostrar();
        System.out.println("Titulo: "+this.getTitulo());
        this.listarCargos();
        System.out.println("\n"+"**Sueldo Total: "+this.sueldoTotal()+" **");
    }
    
    public String mostrarLinea(){
        return ("DNI: "+this.getNroDni()+" - "+"Nombre: "+this.nomYApe()+
            " - Sueldo Total: "+this.sueldoTotal());
    }
    
}
