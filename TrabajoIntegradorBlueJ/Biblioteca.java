import java.util.*;
/**
 * Permite crear y manipular un objeto de la clase Biblioteca
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
     */
    public Biblioteca(String p_nombre){
        //Inicializamos los Atributos
        this.setNombre(p_nombre);
        this.setSocios(new ArrayList <Socio> ());
        this.setLibros(new ArrayList <Libro> ());        
    }
    
     /**
     * Constructor publico de la clase Biblioteca
     */
    public Biblioteca(String p_nombre,ArrayList <Socio> p_socios, ArrayList <Libro> p_libros){
        //Inicializamos los Atributos
        this.setNombre(p_nombre);
        this.setSocios(p_socios);
        this.setLibros(p_libros); 
    }
    
     /**
     * Constructor publico de la clase Biblioteca
     */
    public Biblioteca(String p_nombre, Socio p_socio, Libro p_libros){
        this.setNombre(p_nombre);
        this.setSocios(new ArrayList <Socio> ());
        this.setLibros(new ArrayList <Libro> ()); 
        this.addSocio(p_socio);
        this.addLibro(p_libros);
    }
    
    //SETTERS Y GETTERS
    public void setNombre(String p_nombre){
        this.nombre = p_nombre;}
    public String getNombre(){
        return this.nombre;}       
    //array de socios
    private void setSocios(ArrayList <Socio> p_socio){
        this.socios = p_socio;}
    public ArrayList <Socio> getSocios(){
        return this.socios;}
    private void setLibros(ArrayList<Libro> p_libro){
        this.libros = p_libro;}
    public ArrayList <Libro> getLibros(){
        return this.libros;}
        
    //METODOS
    /**
     * Agrega un socio a la coleccion de socios
     */
    public void addSocio(Socio p_socio){
        this.getSocios().add(p_socio);
    }
    
    /**
     * Quita un socio de la coleccion de socios
     */
    public void removeSocio(Socio p_socio){
        this.getSocios().remove(p_socio);
    }
    
    /**
     * Agrega un libro a la coleccion de libros
     */
    public void addLibro(Libro p_libro){
        this.getLibros().add(p_libro);
    }
    
    /**
     * Quita un libro de la coleccion de libros
     */
    public void removeLibro(Libro p_libro){
        this.getLibros().remove(p_libro);
    }
    
    //constructor de un libro
    public void nuevoLibro(String p_titulo, int p_edicion,String p_editorial,int anio){
        Libro unLibro = new Libro(p_titulo, p_edicion, p_editorial, anio);
        this.addLibro(unLibro);
    }
    
    //constructor de un socio estudiante
    public void nuevoSocioEstudiante(int p_dniSocio, String p_nombre, String p_carrera){
        Estudiante unEstudiante = new Estudiante(p_dniSocio, p_nombre, 20, p_carrera);
        this.addSocio(unEstudiante);
    }
    
    //constructor de un socio docente
    public void nuevoSocioDocente(int p_dniSocio, String p_nombre, String p_area){
        Docente unDocente = new Docente(p_dniSocio, p_nombre, p_area);
        this.addSocio(unDocente);
    }
    
    /**
     * Devuelve la cantidad de socios de un determinado tipo, segun un tipo de socio
     * dado
     * @return Devuelve un int
     */
    public int cantidadSociosPorTipo(String p_objeto){
        int contador = 0;
        for(Socio unS : this.getSocios()){
            if(unS.soyDeLaClase() == p_objeto){
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Crea el prestamo, y lo agrega en el libro y en el socio
     * @return Devuelve un boolean
     */
    public boolean prestarLibro(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro){
            if(p_libro.prestado() == true){
                if (p_socio.puedePedir() == true){
                    Prestamo unPrestamo = new Prestamo(p_fechaRetiro,p_socio,p_libro);
                    p_socio.addPrestamo(unPrestamo);
                    p_libro.addPrestamo(unPrestamo);
                    return true;
                }
            }
            return false;
    }
    
    /**
     * Asigna la fecha de devolucion del prestamo con la fecha actual
     * 
     */
    public void devolverLibro(Libro p_libro){
      Calendar fechaHoy = new GregorianCalendar();        
      Prestamo prestamo = p_libro.getPrestamo() ;
      prestamo.registrarFechaDevolucion(fechaHoy);
      prestamo.getSocio().removePrestamo(prestamo);
    }
    
    /**
     * Devuelve una coleccion con los prestamos vencidos al dia de la fecha
     * @return Devuelve un ArrayList de tipo Prestamo
     */
    public ArrayList <Prestamo> prestamosVencidos(){
        ArrayList <Prestamo> vec= new ArrayList<Prestamo>();
        for(Socio unS : this.getSocios()){
            for(Prestamo unP : unS.getPrestamos()){
                if(unS.puedePedir()){
                    vec.add(unP);
                }
            }
        }
        return vec;
    }
    
    /**
     * Devuelve una coleccion con los docentes responsables
     * @return Devuelve un ArrayList de tipo Docente
     */
     public ArrayList <Docente> docentesResponsables (){
      ArrayList <Docente> docRes = new ArrayList <Docente> ();
      for (int i=0;i<this.getSocios().size();i++){
          Socio socio = this.getSocios().get(i);
          String nombre = socio.soyDeLaClase();
          if (nombre.equals("Docente")){
              Docente docente = (Docente)this.getSocios().get(i);
              if (docente.esResponsable()){
                  docRes.add(docente);
              }
          }
      }
      return docRes;
    }
    
    /**
     * Devuelve el nombre del Socio que tiene el libro con el titulo ingresado
     * @return Devuelve un String
     */
    public String quienTieneElLibro (Libro p_libro){
          if (p_libro.prestado()){
          return (p_libro.getPrestamo().getSocio().getNombre()+" tiene el libro "+p_libro.getTitulo());
        }
        else{
          return ("El libro "+p_libro.getTitulo()+" se encuentra en la biblioteca");
        } 
    }
    
    /**
     * Devuelve el listado de socios, y la cantidad de socios por tipo
     * @return Devuelve un String
     */
    public String listaDeSocios(){
      System.out.println("LISTA DE SOCIOS");
      System.out.println("===================================");
      String impresion = " ";
      for (Socio unS : this.getSocios()){
          System.out.println(this.getSocios().indexOf(unS)+")"+unS.toString());
      }
        System.out.println("--------------------------------------");
        String p_obj="Estudiante"; String p_obj2="Docente";
        System.out.println("Cant. Socios tipo Estudiante: "+this.cantidadSociosPorTipo(p_obj));
        System.out.println("Cant. Socios tipo Docente: "+this.cantidadSociosPorTipo(p_obj2));
        System.out.println("-------------------------------------");
        return impresion; 
    }
    
    /**
     * Devuelve el listado de libros y si los mismos se encuentran prestados o no
     * @return Devuelve un String
     */
    public String listaDeLibros(){
        String impresion = " ";
        String cond = " ";
        int cuenta = 0;
      for (Libro unL : this.getLibros()){
          cuenta++;
          if(unL.prestado()){
              cond = "SI";
            } else {
                cond = "NO";
            }
          return cuenta + ") " +unL.toString()+" || Prestado: "+cond;
      } 
        return "-------------------------------------" + "\n" + impresion;
    }
    
    /**
     * Devuelve un objeto tipo Socio con el dni especificado
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
     * Devuelve un listado de los Docentes Responsables
     * @return Devuelve un String
     */
    public String listaDeDocentesResponsables(){
        System.out.println("LISTA DE DOCENTES RESPONSABLES");
        System.out.println("===================================");
        String impresion = " ";
        for (Docente doc: this.docentesResponsables() ){
         
          System.out.println(doc.toString());
        }        
        return impresion;
    }
    
}//Fin clase Biblioteca