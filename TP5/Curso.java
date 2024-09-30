import java.util.*;
/**
 * Inscribe alumnos en un curso.
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class Curso{
    private String nombre;
    private HashMap <Integer, Alumno> alumnos;

    /**
     * @param p_nombre nombre del curso
     */
    Curso(String p_nombre){
        this.setNombre(p_nombre);
        this.setAlumnos(new HashMap <Integer, Alumno> ());
    }


    /**
     * @param p_nombre nombre del curso
     * @param p_alumnos coleccion de alumnos
     */    
    Curso(String p_nombre, HashMap p_alumnos){
        this.setNombre(p_nombre);
        this.setAlumnos(p_alumnos);
    }

    private void setNombre (String p_nombre){
        this.nombre = p_nombre;}

    private void setAlumnos (HashMap <Integer, Alumno> p_alumnos){
        this.alumnos = p_alumnos;}

    public String getNombre (){
        return this.nombre;}

    public HashMap <Integer, Alumno> getAlumnos (){
        return this.alumnos;}

    /**
     * @param p_alumno objeto alumno a inscribir
     */    
    public void inscribirAlumno(Alumno p_alumno){
        this.getAlumnos().put(new Integer(p_alumno.getLu()),p_alumno);
    }

    /**
     * @param p_lu clave para buscar alumno
     * @return devuelve el alumno dado de baja
     */
    public Alumno quitarAlumno (int p_lu){
        return this.getAlumnos().remove(new Integer(p_lu));

    }

    /**
     * @return devuelve la cantidad de alumnos inscriptos
     */
    public int cantidadDeAlumnos (){
        int totalAlumnos = 0;
        for(int i=0;i<this.getAlumnos().size();i++){
            totalAlumnos++;
        }
        return totalAlumnos;
    }

    /**
     * @param p_lu clave para buscar alumno
     * @return devuelve confirmacion de alumno inscripto
     */
    public boolean estaInscripto (int p_lu){
        return this.getAlumnos().containsKey(new Integer(p_lu));
    }

    /**
     * @param p_alumno valor (objeto) para buscar alumno
     * @return devuelve confirmacion de alumno inscripto
     */
    public boolean estaInscripto (Alumno p_alumno){
        return this.getAlumnos().containsKey(new Integer(p_alumno.getLu()));
    }

    /**
     * @param p_lu clave para buscar alumno
     * @return devuelve alumno buscado
     */    
    public Alumno buscarAlumno (int p_lu){
        return this.getAlumnos().get(new Integer(p_lu));
    }

    /**
     * @param p_lu clave para buscar alumno
     */    
    public void imprimirPromedioDelAlumno(int p_lu){
        if(this.estaInscripto(p_lu) == false){
            System.out.println("Ese alumno no esta inscripto!");
        }else{
            Alumno unAlumno = this.getAlumnos().get(new Integer(p_lu));
            System.out.println("\n"+
                "****-- Mostrar promedio del alumno "+unAlumno.getLu()+" --****"+
                "\n"+"Promedio: "+unAlumno.promedio()+"\n");
        }
    }

    public void mostrarInscriptos(){
        System.out.println("****-- Alumnos inscriptos actualmente: "+this.cantidadDeAlumnos());
        for(Map.Entry <Integer, Alumno> i : this.getAlumnos().entrySet()){
            System.out.println(""+i.getKey()+" "+i.getValue().apeYNom());
        }
    }
    /**
     * @param p_lu clave para buscar alumno
     */
    public void muestraAlumno (int p_lu){
        System.out.println("\n");
        if(this.estaInscripto(p_lu) == false){
            System.out.println("Ese alumno no esta inscripto!");
        }else{
            Alumno unAlumno = this.buscarAlumno(p_lu);
            System.out.println("Apellido y nombre: "+unAlumno.apeYNom()+
                "\n"+"LU: "+unAlumno.getLu()+" Notas: "+
                unAlumno.getNota1()+", "+unAlumno.getNota2()+
                "\n"+"Promedio: "+unAlumno.promedio()+
                " "+unAlumno.leyendaAprueba());
        }
    }
    /**
     * @param p_lu clave para buscar alumno
     * @param p_nota1 nota 1er parcial
     * @param p_nota2 nota 2do parcial
     */
    public void agragarNotas (int p_lu,double p_nota1,double p_nota2){
        System.out.println("\n");
        if(this.estaInscripto(p_lu) == false){
            System.out.println("Ese alumno no esta inscripto!");
        }else{
            Alumno unAlumno = this.buscarAlumno(p_lu);
            unAlumno.setNota1(p_nota1);
            unAlumno.setNota2(p_nota2);
            System.out.println("Notas añadidas: "+
                unAlumno.getNota1()+", "+unAlumno.getNota2());
        }
    }
}