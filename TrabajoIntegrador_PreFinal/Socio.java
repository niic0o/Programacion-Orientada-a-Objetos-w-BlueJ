import java.util.*;
/**
 * Clase abstracta, generaliza a Alumno y Docente;
 * 
 * @author Diego G. Trangoni
 * @version 1.0 14/11/2017
 */
public abstract class Socio {
    /**
     * Atribuitos de la calse
     */
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList <Prestamo> prestamos;

    /**
     * Constructor
     * @param p_dniSocio        DNI del socio.
     * @param p_nombre          Nombre del socio.
     * @param p_diasPrestamo    Cantidad de días de préstamo. Depende del tipo de socio.
     */ 
    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo) {
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList());
    }

    /**
     * Asigna valor a dniSocio.
     * 
     * @param p_dniSocio es un entero que ingresa el dni del Socio actual.
     */
    private void setDniSocio(int p_dniSocio) {
        this.dniSocio = p_dniSocio;
    }

    /**
     * Asigna valor a nombre.
     * 
     * @param p_nombre es un String que ingresa el nombre del Socio.
     */
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    /**
     * Asigna valor a diasPrestamo.
     * 
     * @param p_diasPrestamo es un entero con la cantadid de dias asignados al socio.
     */
    public void setDiasPrestamo(int p_diasPrestamo) {
        this.diasPrestamo = p_diasPrestamo;
    }

    /**
     * Asigna la lista de préstamos.
     * 
     * @param p_prestamos es la lista o arrayList que contiene objetos de la clase Prestamo.     
     */    
    private void setPrestamos(ArrayList <Prestamo> p_prestamos) {
        this.prestamos = p_prestamos;
    }

    /**
     * Devuelve el N° de DNI del socio actual.
     * 
     * @return un entero con el DNI del socio.     
     */        
    public int getDniSocio() {
        return this.dniSocio;
    }

    /**
     * Devuelve el Nombre el socio actual.
     * 
     * @return un string con el Nombre del socio.     
     */     
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Retorna diasPrestamo.
     * 
     * @return un entero con la cantidad de dias de prestamos asigando al socio.
     */    
    public int getDiasPrestamo() {
        return this.diasPrestamo;
    }

    /**
     * Retorna la lista de préstamos.
     * 
     * @return un srraylist con objetos de la clase Prestamo.     
     */ 
    public ArrayList <Prestamo> getPrestamos() {
        return this.prestamos;
    }

    /**
     * Agrega nuevos prestamos a la lista.
     * 
     * @param p_prestamo es un objeto de la clase Prestamo.
     */    
    public void addPrestamo(Prestamo p_prestamo) {
        this.getPrestamos().add(p_prestamo);
    }

    /**
     * Remueve prestamos de la lista.
     * 
     * @param p_prestamo es un objeto de la clase Prestamo.     
     */  
    public void removePrestamo(Prestamo p_prestamo) {
        this.getPrestamos().remove(p_prestamo);
    }

    /**
     * Recorre la colección de préstamos y suma 1 al contador de prestados cada
     * vez que detecta un préstamo que no registre fecha de devolución.
     * 
     * @return int con la cantidad de libros prestados.
     */
    public int cantLibrosPrestados(){
        int prestados = 0;
        for (Prestamo prestamo:this.getPrestamos()){
            if (prestamo.getFechaDevolucion() == null){
                prestados++;
            }            
        }
        return prestados;
    }

    /**
     * Recorre la colección de préstamos en busca de algún Prestamo todavía sin devolución que
     * estuviera vencido. Un socio con algún Prestamo vencido no podrá solicitar otro Prestamo.
     * 
     * @return true si no se detectan préstamos vencidos.
     */   
    public boolean puedePedir(){
        ArrayList listaPrestamos = this.getPrestamos();
        boolean flag = true;
        for(int i = 0; flag && i < listaPrestamos.size(); i++){
            Prestamo unPrestamo = (Prestamo) listaPrestamos.get(i);
            if(unPrestamo.getFechaDevolucion() == null){
                if (unPrestamo.vencido(unPrestamo.getFechaDevolucion())) { // si alguno de los prestamos esta vencido (vencido() : true) se negara la condicion "puedePedir" (false)
                    flag = false;
                }
                   /* if (unPrestamo.getLibro().prestado() == true ){
                        flag = false;
                    }*/
            }
        }
        return flag;
    }

    /**
     * Devuelve informacion del socio: dni, nombre, clase.
     * 
     * @return un String con la información del socio.
     */ 
    public String toString() {
        return ("D.N.I.: "+this.getDniSocio()+" || "+this.getNombre()+" ("+this.soyDeLaClase()+")");
    }

    /**
     * Devuelve el nombre de la clase.
     * 
     * @return un String con el nombre de la clase.
     */
    public abstract String soyDeLaClase();
}
