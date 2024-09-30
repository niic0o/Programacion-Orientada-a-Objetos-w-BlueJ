import java.util.*;
/**
 *
 * @author Diego G. Trangoni
 * @version 1.0 14/11/2017
 */
public class Prestamo {
    /**
     *ATRIBUTOS de al clase.
     */
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;
    /**
     * Constructor de la clase.
     * 
     *@param p_fechaRetiro es un dato de tipo Calendar, que contiene la fecha en que se retiró el libro.
     *@param p_socio es un objeto d ela clase Socio.
     *@param p_libro es un objeto d ela clase Libro.
     */
    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
        this.setFechaRetiro(p_fechaRetiro);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
        this.setFechaDevolucion(null);
    }
    
    /**
     * Establece la fecha de retiro del libro prestado.
     * 
     * @param p_fechaRetiro con tiene esa infrmación.
     */
    private void setFechaRetiro(Calendar p_fechaRetiro) {
        this.fechaRetiro = p_fechaRetiro;
    }
    
    /**
     * Establece la fecha de devolución del libro prestado.
     * 
     * @param p_fechaDevolucion es un objeto de tipo Calendar con el que se asigna valor al atributo en cuestión.  
     */
    private void setFechaDevolucion(Calendar p_fechaDevolucion) {
        this.fechaDevolucion = p_fechaDevolucion;
    }
    
    /**
     * Asigna el valor de p_socio a socio.
     * 
     * @param p_socio un objeto de tipo Socio, que da valor al atributo.
     */     
    private void setSocio(Socio p_socio) {
        this.socio = p_socio;
    }
    
    /**
     * Asigna el valor de p_libro a libro.
     * 
     * @param p_libro de la clase Libro, asigna valor al atributo libro.
     */  
    private void setLibro(Libro p_libro) {
        this.libro = p_libro;
    }
    
    /**
     * Retorna fechaRetiro.
     * 
     * @return un objeto de tipo Calendar, con el valor de la fecha en que se retiró el libro prestado.
     */   
    public Calendar getFechaRetiro() {
        return this.fechaRetiro;
    }
    
    /**
     * Retorna fechaDevolucion.
     * 
     * @return un objeto de tipo Calendar con el valor de la fecha de devolucion del libro prestado.
     */        
    public Calendar getFechaDevolucion() {
        return this.fechaDevolucion;
    }
    
    /**
     * Retorna socio.
     * 
     * @return el atributo socio, de la clase Socio.
     */ 
    public Socio getSocio() {
        return this.socio;
    }
    
    /**
     * Retorna libro.
     * 
     * @return el objeto Libro, que es atributo de la clase.
     */
    public Libro getLibro() {
        return this.libro;
    }
    
    /**
     * Registra la fecha en que se devuelve el libro prestado.
     * 
     * @param p_fechaDevolucion de tipo Calendar con la fecha en que se devolvió el libro.
     */            
    public void registrarFechaDevolucion(Calendar p_fechaDevolucion){
        this.setFechaDevolucion(p_fechaDevolucion);
    }
    
    /**
     * Verifica si la fecha de devolución ha expirado.
     * 
     * @param p_fecha de tipo Calendar, con la fecha a evaluar.
     * @return true si expiró la fecha de entrega.
     */   
    public boolean vencido(Calendar p_fecha) {
        Calendar fechaVencimiento = this.getFechaRetiro();
        if (p_fecha == null){
            p_fecha = new GregorianCalendar();
        }
        
        fechaVencimiento.add(Calendar.DATE, this.getSocio().getDiasPrestamo());
        
        if (p_fecha.after(fechaVencimiento)) {
            return true;
        }else{
            return false;
        }
    }
}