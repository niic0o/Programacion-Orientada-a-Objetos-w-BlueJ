import java.util.*;
/**
 * Clase DOCENTE: extiende SOCIO;
 * @author (DP) 
 * @version (1.0)
 */
public class Docente extends Socio {
    private String area;
    
    public Docente(int p_dniSocio, String p_nombre, String p_area){
        super (p_dniSocio, p_nombre, 0); 
        this.setArea(p_area);
    }
    
    private void setArea (String p_area){
        this.area = p_area;
    }
    
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
    
    public void agregarDiasDePrestamo (int p_dias) {
       this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }
    
    public String soyDeLaClase () {
        return "Docente";
    }
    

}