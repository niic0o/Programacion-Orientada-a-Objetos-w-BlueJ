import java.util.*;
/**
 * Esta clase permite instanciar "libros" de una "biblioteca" y conocer su titulo y si fue prestado o no.
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 15/11/2017
 */
public class Libro{
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList <Prestamo> prestamos;

    /**
     * @param p_titulo titulo del libro.
     * @param p_edicion numero de edicion.
     * @param p_editorial por quien fue editado el ejemplar.
     * @param p_anio año de lanzamiento.
     */
    //coleccion de 0 elementos
    Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamo(new ArrayList <Prestamo> ());
    }

    /**
     * @param p_titulo titulo del libro.
     * @param p_edicion numero de edicion.
     * @param p_editorial por quien fue editado el ejemplar.
     * @param p_anio año de lanzamiento.
     * @param p_prestamo disponibilidad del libro.
     */
    //Coleccion de n elementos
    Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio, ArrayList p_prestamo){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamo(p_prestamo);
    }

    //setters
    /**
     * @param p_titulo modifica el titulo del libro.
     */
    private void setTitulo (String p_titulo){
        this.titulo = p_titulo;
    }

    /**
     * @param p_edicion modifica el numero de edicion del libro.
     */
    private void setEdicion (int p_edicion){
        this.edicion = p_edicion;
    }
    /**
     * @param p_editorial modifica editorial del libro.
     */
    private void setEditorial (String p_editorial){
        this.editorial = p_editorial;
    }
    
    /**
     * @param p_anio modifica el año de lanzamiento del libro.
     */
    private void setAnio (int p_anio){
        this.anio = p_anio;
    }
    
    /**
     * @param p_prestamos modifica la disponibilidad del libro.
     */
    private void setPrestamo (ArrayList <Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }

    //getters
    /**
     * @return devuelve el titulo del libro.
     */
    public String getTitulo (){
        return this.titulo;
    }

    /**
     * @return devuelve el numero de edicion del libro.
     */
    public int getEdicion (){
        return this.edicion;
    }

    /**
     * @return devuelve la editorial del libro.
     */
    public String getEditorial (){
        return this.editorial;
    }

    /**
     * @return devuelve el año de lanzamiento del libro.
     */
    public int getAnio (){
        return this.anio;
    }

    /**
     * @return devuelve el ultimo prestamo.
     */
    public Prestamo getPrestamo (){
        return this.getPrestamos().get(this.getPrestamos().size());
    }
    
    /**
     * @return retorna una coleccion de prestamos.
     */
    public ArrayList <Prestamo> getPrestamos (){
        return this.prestamos;
    }
    
    /**
     * @param p_prestamo contiene una solicitud de prestamo.
     * @return devuelve "true" si se pudo realizar la operacion.
     */
    public boolean addPrestamo (Prestamo p_prestamo){
        return this.getPrestamos().add(p_prestamo);
    }

    /**
     * @param p_prestamo contiene una solicitud de cancelacion de prestamo.
     * @return devuelve "true" si se pudo realizar la operacion.
     */
    public boolean removePrestamo (Prestamo p_prestamo){
        if(this.getPrestamos().isEmpty() == true){
            return false;
        }else{
            return this.getPrestamos().remove(p_prestamo);
        }
    }

    /**
     * @return devuelve "true" si el libro fue prestado.
     */
    public boolean prestado (){
        if(this.getPrestamos().isEmpty() == true){
            return false;
        }else{
            return true;
        }
    }   
    
    /**
     * @return devuelve una cadena de caracteres.
     *  Ejemplo: "Titulo: Traumas Post Serie Integradora I"
     * 
     */
    public String toString (){
        return "Titulo: "+this.getTitulo();
    }
}

