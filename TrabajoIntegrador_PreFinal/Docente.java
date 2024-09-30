import java.util.*;
/**
 * Instancia un objeto de la clase Docente.
 * 
 * Clase DOCENTE: extiende SOCIO;
 * @author (Domingo Pacheco) 19/11/2017
 * @version (1.0) 19
 */
public class Docente extends Socio {
    /**
     * ATRIBUTOS: solo area, a la que pertenece el Docente actual.
     */
    private String area;
    
    /**
     * Constructor de la clase.
     * 
     * @param p_dniSocio    DNI del socio.
     * @param p_nombre      Nombre del socio.
     * @param p_area        Area a la que pertenece el docente.
     */
    public Docente(int p_dniSocio, String p_nombre, String p_area){
        super (p_dniSocio, p_nombre, 5); 
        this.setArea(p_area);
    }
    
    /**
     * Asigna el valor a area.
     * 
     * @param p_area un String con el area al que pertenece el docente.
     */
    private void setArea (String p_area){
        this.area = p_area;
    }
    
    /**
     * Obtiene el valor de area
     * 
     * @return un String con el nombre el area al que pertenece el Docente.
     */
    public String getArea () {
        return this.area;
    }
    
    /**
     * Recorre el contenedor de préstamos en busca de algún préstamo que esté
     * vencido o que haya estado vencido al momento de la devolución. Se considera
     * que el docente es responsable si no registra préstamos vencidos.
     * 
     * @return true si el docente es responsable
     */
    public boolean esResponsable () {
       int i = 0;
       boolean flag = true;
       ArrayList listaPrestamos = this.getPrestamos();
       while(flag && i < listaPrestamos.size()){
           Prestamo unPrestamo = (Prestamo) listaPrestamos.get(i);
           if(unPrestamo.vencido(unPrestamo.getFechaDevolucion())){
               flag = false;
           }
           i++;
       }
       return flag;
    }
    
    /**
     * Agrega dias de préstamos al Docente, como premio a su responsabilidad.
     * A lo que ya tiene, se le agregan p_dias días.
     * 
     * @param p_dias un entero con la cantidad de dias que se le asignan de nuevo, como premio.
     */   
    public void agregarDiasDePrestamo (int p_dias) {
       this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }
    
    /**
     * Devuelve el nombre de la clase como String.
     * 
     * @return un String con el className().
     */
    public String soyDeLaClase () {
        return "Docente";
    }
}