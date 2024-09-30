import java.util.*;
/**
 * Permite crear y manipular un objeto de la clase Biblioteca.
 * 
 * autor Ojeda Eric, Souto Flores, Villareal Matias
 * 
 */
public class Biblioteca{
    //Atributos
    private String nombre;
    private ArrayList <Socio> socios;
    private ArrayList <Libro> libros;
    
    /**
     * Constructor publico de la clase Biblioteca
     * 
     * @param p_nombre      Nombre de la bilbioteca.
     */
    public Biblioteca(String p_nombre){
        //Inicializamos los Atributos
        this.setNombre(p_nombre);
        this.setSocios(new ArrayList <Socio> ());
        this.setLibros(new ArrayList <Libro> ());        
    }
    
    /**
     * Constructor publico de la clase Biblioteca
     * 
     * @param p_nombre      Nombre de la bilbioteca.
     * @param p_socios      Lista de socios de la biblioteca.
     * @param p_libos       Lista de libros de la biblioteca.    
     */
    public Biblioteca(String p_nombre,ArrayList <Socio> p_socios, ArrayList <Libro> p_libros){
        //Inicializamos los Atributos
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(p_libros); 
    }
    
    /**
     * Constructor publico de la clase Biblioteca
     * 
     * @param p_nombre      Nombre de la bilbioteca.
     * @param p_socio       Primer socio de la colección.
     * @param p_libro       Primer libros de la colección
     */
    public Biblioteca(String p_nombre, Socio p_socio, Libro p_libros){
        this.setNombre(p_nombre);
        this.setSocios(new ArrayList <Socio> ());
        this.setLibros(new ArrayList <Libro> ()); 
        this.addSocio(p_socio);
        this.addLibro(p_libros);
    }
    
    /**
     * Asigna el valor p_nombre a nombre.
     * 
     * @param p_nombre es un String que ingresa el nombre de la biblioteca.
     */
    public void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    /**
     * Devuelve el nombre de la biblioteca.
     * 
     * @return un string con el nombre del la biblioteca.     
     */     
    public String getNombre(){
        return this.nombre;
    }       
    
    /**
     * Asigna el valor de p_socio a socio.
     * 
     * @param p_socio       Lista de socios de la biblioteca.
     */
    private void setSocios(ArrayList <Socio> p_socio)
    {
        this.socios = p_socio;
    }
    
    /**
     * Devuelve la colección de socios.
     * 
     * @return socios       Lista de socios de la biblioteca.
     */  
    public ArrayList <Socio> getSocios(){
        return this.socios;
    }
    
    /**
     * Asigna el valor de p_socio a socio.
     * 
     * @param p_libros       Lista de libros de la biblioteca.    
     */
    private void setLibros(ArrayList<Libro> p_libros){
        this.libros = p_libros;
    }
    
    /**
     * Devuelve la colección de libros.
     * 
     * @return libros       Lista de libros de la biblioteca.    
     */  
    public ArrayList <Libro> getLibros(){
        return this.libros;
    }
        
    //METODOS
    /**
     * Agrega un socio a la coleccion de socios.
     * 
     * @param p_socio       Nuevo socio.
     */
    public void addSocio(Socio p_socio){
        this.getSocios().add(p_socio);
    }
    
    /**
     * Quita un socio de la coleccion de socios
     * 
     * @param p_socio       Socio a eliminar.
     */
    public void removeSocio(Socio p_socio)
    {
        this.getSocios().remove(p_socio);
    }
    
    /**
     * Agrega un libro a la coleccion de libros
     * 
     * @param p_libro       Nuevo libro.
     */
    public void addLibro(Libro p_libro)
    {
        this.getLibros().add(p_libro);
    }
    
    /**
     * Quita un socio de la coleccion de libros.
     * 
     * @param p_libros      Libro a eliminar.
     */
    public void removeLibro(Libro p_libro)
    {
        this.getLibros().remove(p_libro);
    }
    
    /**
     * Instancia un nuevo libro y lo agrega a la colección de libros.
     * 
     * @param p_titulo      Titulo del libro.
     * @param p_edicion     Numero de edición.
     * @param p_editorial   Editorial del libro.
     * @param p_anio        Año de lanzamiento.
     */
    public void nuevoLibro(String p_titulo, int p_edicion,String p_editorial,int anio){
        Libro unLibro = new Libro(p_titulo, p_edicion, p_editorial, anio);
        this.addLibro(unLibro);
    }
    
    /**
     * Instancia un nuevo estudiate y lo agrega a la colección de socios.
     *
     * @param p_dniSocio    DNI del socio.
     * @param p_nombre      Nombre del socio.
     * @param p_carrera     Carreara que estudia es estudiante.
     */
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera){
        Estudiante unEstudiante = new Estudiante(p_dniSocio, p_nombre, p_carrera);
        this.addSocio(unEstudiante);
    }
    
    /**
     * Instancia un nuevo docente y lo agrega a la colección de socios.
     * 
     * @param p_dniSocio    DNI del socio.
     * @param p_nombre      Nombre del socio.
     * @param p_area        Area a la que pertenece el docente.
     */
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area){
        Docente unDocente = new Docente(p_dniSocio, p_nombre, p_area);
        this.addSocio(unDocente);
    }
    
    /**
     * Devuelve la cantidad de socios de un determinado tipo.
     * 
     * @param p_objeto      Tipo de socio.
     * @return un int con el contador de socios del tipo especificado.
     */
    public int cantidadSociosPorTipo(String p_objeto)
    {
        int contador = 0;
        
        for(Socio unS : this.getSocios())
        {
            if(unS.soyDeLaClase() == p_objeto)
            {
                contador++;
            }
        }
        
        return contador;
    }
    
    /**
     * Crea el prestamo y lo registra en la lista de préstamos del libro y del socio.
     * 
     * @param p_fechaRetiro     Calendar con el día en el que se realiza el préstamo.
     * @param p_socio           Socio que solicitó el préstamo.
     * @param p_libro           Libro solicitado.
     * 
     * @return true si la operación se realizó exitosamente
     */
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
        boolean flag = true;
        if(p_libro.prestado() == false){
            if (p_socio.puedePedir() == true){
                Prestamo unPrestamo = new Prestamo(p_fechaRetiro,p_socio,p_libro);
                p_socio.addPrestamo(unPrestamo);
                p_libro.addPrestamo(unPrestamo);
            }else{
                flag = false;
            }
        }else{
            flag = false;
        }
        return flag;
    }
    
    /**
     * Asigna la fecha de devolucion del prestamo con la fecha actual
     * 
     * @param p_libro   Libro sobre el que se registrará fecha de devolución.
     */
    public void devolverLibro(Libro p_libro){
        Calendar fechaHoy = new GregorianCalendar();        
        Prestamo prestamo = p_libro.getPrestamo(); 
        prestamo.registrarFechaDevolucion(fechaHoy);
    }
    
    /**
     * Devuelve una coleccion con los prestamos vencidos al dia de la fecha.
     * 
     * @return Devuelve un ArrayList de tipo Prestamo
     */
    public ArrayList <Prestamo> prestamosVencidos(){
        Calendar fechaHoy = new GregorianCalendar();
        ArrayList <Prestamo> vencidos = new ArrayList <Prestamo> ();
        for(Libro libro : this.getLibros()){
            if(libro.prestado() == true){
                Prestamo prestamo = libro.getPrestamo();
                if(prestamo.vencido(fechaHoy) == true){
                    vencidos.add(prestamo);
                }
            }
        }
        return vencidos;
    }
    
    /**
     * Devuelve una coleccion con los docentes responsables.
     * 
     * @return un ArrayList de tipo Docente
     */
    public ArrayList <Docente> docentesResponsables(){
        ArrayList <Docente> docRes = new ArrayList <Docente> ();
        for(Socio socio : this.getSocios()){
            String tipoSocio = socio.soyDeLaClase();
            if (tipoSocio.equals("Docente")){
                Docente docente = (Docente) socio;
                if (docente.esResponsable()){
                    docRes.add(docente);
                }
            }
        }
        return docRes;
    }
    
    /**
     * Devuelve el nombre del Socio que tiene el libro que ingresa como parámetro. Si el libro no se
     * encuentra prestado el método devolverá una cadena informado tal situación.
     * 
     * @return un String con el nombre del socio si el libro está prestado.
     */
    public String quienTieneElLibro(Libro p_libro){
         if (p_libro.prestado()){
              return (p_libro.getPrestamo().getSocio().getNombre()+" tiene el libro "+p_libro.getTitulo());
         }else{
             return ("El libro "+p_libro.getTitulo()+" se encuentra en la biblioteca");
         } 
    }
  
    /**
     * Devuelve el listado de socios, y la cantidad de socios por tipo
     * @return Devuelve un String
     */
    public String listaDeSocios(){
        int cuenta = 1;
        String lista = "LISTA DE SOCIOS\n====================================================="+ ("\n");
        for(int i=0;i<this.getSocios().size();i++){
            lista = lista + cuenta + ")" + (this.getSocios().get(i)).toString()+("\n");
            cuenta++;
        }
        lista = lista +"******************************************************"+("\n")+"Cant. Socios tipo Estudiantes: "+
        this.cantidadSociosPorTipo("Estudiante")+("\n")+"Cant. Socios tipo Docentes: "+
        this.cantidadSociosPorTipo("Docente")+("\n")+"******************************************************";
        return lista; 
    }
    
    /**
     * Devuelve el listado de libros y si los mismos se encuentran prestados o no
     * @return Devuelve un String
     */
    public String listaDeLibros(){
        String impresion = "LISTA DE LIBROS\n====================================================="+ ("\n");
        String cond = " ";
        int cuenta = 1;
        for (Libro unLibro : this.getLibros()){
            if(unLibro.prestado()){
                cond = "SI";
            }else{
                cond = "NO";
            }
            impresion = impresion + cuenta + ") " +unLibro.toString()+" || Prestado: "+cond + "\n";
            cuenta++;
        } 
        return impresion;
    }
    
    /**
     * Devuelve un objeto tipo Socio con el DNI especificado.
     * 
     * @return Un socio respecto del parametro ingresado
     */
    public Socio buscarSocio(int p_dni){
        Socio p_socio = null;
        for(Socio socio: this.getSocios()){
            if(socio.getDniSocio() == p_dni){
                p_socio = socio;
            }
        }
        return p_socio;
    }
    
    /**
     * Devuelve un listado de los docentes responsables.
     * 
     * @return un String con la lista de docentes responsables.
     */
    public String listaDeDocentesResponsables(){
        String impresion = "LISTA DE DOCENTES RESPONSABLES\n==================================="+"\n";
        for (Docente docente: this.docentesResponsables()){
            impresion = impresion + docente.toString() + "\n";
        }     
        return impresion;
    }
}//Fin clase Biblioteca