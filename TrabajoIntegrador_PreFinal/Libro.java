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
     * Constructor de la clase
     * 
     * @param p_titulo      Titulo del libro.
     * @param p_edicion     Numero de edición.
     * @param p_editorial   Editorial del libro.
     * @param p_anio        Año de lanzamiento.
     */
    //coleccion de 0 elementos
    Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList <Prestamo> ());
    }

    /**
     * Constructor de la clase.
     * 
     * @param p_titulo      Titulo del libro.
     * @param p_edicion     Numero de edición.
     * @param p_editorial   Editorial del libro.
     * @param p_anio        Año de lanzamiento.
     * @param p_prestamos   Colección de libros.    
     */
    //Coleccion de n elementos
    Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio, ArrayList p_prestamos){
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(p_prestamos);
    }

    //setters
    /**
     * Asigna valor al atributo titulo.
     * 
     * @param p_titulo   Titulo del libro.
     */
    private void setTitulo (String p_titulo){
        this.titulo = p_titulo;
    }

    /**
     * Asigna valor al atributo edicion.
     * 
     * @param p_edicion     Numero de edición.
     */
    private void setEdicion (int p_edicion){
        this.edicion = p_edicion;
    }
    
    /**
     * Asigna valor al atributo editorial.
     * 
     * @param p_editorial   Editorial del libro.
     */
    private void setEditorial (String p_editorial){
        this.editorial = p_editorial;
    }
    
    /**
     * Asigna valor al atributo anio.
     * 
     * @param p_anio    Año de lanzamiento.
     */
    private void setAnio (int p_anio){
        this.anio = p_anio;
    }
    
    /**
     * Asigna valor a la lista de prestamos.
     * 
     * @param p_prestamos   Colección de libros.
     */
    private void setPrestamos (ArrayList <Prestamo> p_prestamos){
        this.prestamos = p_prestamos;
    }

    //getters
    /**
     * Retorna titulo.
     * 
     * @return un String con título del libro.
     */
    public String getTitulo (){
        return this.titulo;
    }

    /**
     * Retorna edicion.
     * 
     * @return un int con el numero de edición del libro.
     */
    public int getEdicion (){
        return this.edicion;
    }

    /**
     * Retorna editorial.
     * 
     * @return un String con la editorial del libro.
     */
    public String getEditorial (){
        return this.editorial;
    }

    /**
     * Retorna anio.
     * 
     * @return un int con el año de lanzamiento del libro.
     */
    public int getAnio (){
        return this.anio;
    }

    /**
     * Retorna el último préstamo de la lista.
     * 
     * @return el Prestamo último de la lista.
     */
    public Prestamo getPrestamo (){
        return this.getPrestamos().get(this.getPrestamos().size()-1);
    }
    
    /**
     * Retorma la lista de préstamos.
     * 
     * @return un ArrayList con la lista de préstamos.
     */
    public ArrayList <Prestamo> getPrestamos (){
        return this.prestamos;
    }
    
    /**
     * Agregar un préstamo a la lista de préstamos.
     * 
     * @param p_prestamo    Contiene una solicitud de prestamo.
     * @return true si se pudo realizar la operación.
     */
    public boolean addPrestamo (Prestamo p_prestamos){
        return this.getPrestamos().add(p_prestamos);
    }

    /**
     * Elimina un préstamo de la lista de préstamos
     * 
     * @param p_prestamo    Préstamo a remover.
     * @return true si se pudo realizar la operación.
     */
    public boolean removePrestamo (Prestamo p_prestamos){
        if(this.getPrestamos().isEmpty() == true){
            return false;
        }else{
            return this.getPrestamos().remove(p_prestamos);
        }
    }

   /**
     * Comprueba si el libro está prestado.
     * 
     * @return true si el libro está prestado.
     */
   public boolean prestado(){
        if (this.getPrestamos().size() > 0 ) {
             if (this.getPrestamo().getFechaDevolucion() == null ) {
                return true;
            } else {
                return false;
            }   
        }else{ 
            return false;
        }
    }
    
    /**
     * Retorna una cadena con el título del libro.ç
     * 
     * @return un String. Ejemplo: "Titulo: Traumas Post Serie Integradora I"
     * 
     */
    public String toString (){
        return "Titulo: "+this.getTitulo();
    }
}

