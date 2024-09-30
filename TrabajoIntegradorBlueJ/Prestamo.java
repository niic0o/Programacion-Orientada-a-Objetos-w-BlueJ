import java.util.*;
/**
 *
 * @author Diego G. Trangoni
 * @version 1.0 14/11/2017
 */
public class Prestamo {
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private Socio socio;
    private Libro libro;

    public Prestamo(Calendar p_fechaRetiro, Socio p_socio, Libro p_libro) {
        this.setFechaRetiro(p_fechaRetiro);
        this.setSocio(p_socio);
        this.setLibro(p_libro);
        this.setFechaDevolucion(null);
    }

    private void setFechaRetiro(Calendar p_fechaRetiro) {
        this.fechaRetiro = p_fechaRetiro;
    }

    private void setFechaDevolucion(Calendar p_fechaDevolucion) {
        this.fechaDevolucion = p_fechaDevolucion;
    }

    private void setSocio(Socio p_socio) {
        this.socio = p_socio;
    }

    private void setLibro(Libro p_libro) {
        this.libro = p_libro;
    }
    
    public Calendar getFechaRetiro() {
        return this.fechaRetiro;
    }

    public Calendar getFechaDevolucion() {
        return this.fechaDevolucion;
    }

    public Socio getSocio() {
        return this.socio;
    }
    
    public Libro getLibro() {
        return this.libro;
    }
    
    public void registrarFechaDevolucion(Calendar p_fechaDevolucion){
        this.setFechaDevolucion(p_fechaDevolucion);
    }
    
    public boolean vencido(Calendar p_fecha) {
        Calendar fechaVencimiento = this.getFechaRetiro();
        if (p_fecha == null){
            p_fecha = new GregorianCalendar();
        }
        
        if (this.getSocio().soyDeLaClase().equals("Estudiante")){
            fechaVencimiento.add(Calendar.DATE, 20);
        }
        if (this.getSocio().soyDeLaClase().equals("Docente")){
            fechaVencimiento.add(Calendar.DATE, 5);
        }

        if (p_fecha.after(fechaVencimiento)) {
            return true;
        }else{
            return false;
        }
    }
}