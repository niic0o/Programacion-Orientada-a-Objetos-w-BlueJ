import java.util.*;

public abstract class Socio {
    private int dniSocio;
    private String nombre;
    private int diasPrestamo;
    private ArrayList <Prestamo> prestamos;
    

    public Socio(int p_dniSocio, String p_nombre, int p_diasPrestamo) {
        this.setDniSocio(p_dniSocio);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_diasPrestamo);
        this.setPrestamos(new ArrayList());
    }

    private void setDniSocio(int p_dniSocio) {
        this.dniSocio = p_dniSocio;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    public void setDiasPrestamo(int p_diasPrestamo) {
        this.diasPrestamo = p_diasPrestamo;
    }
    
    private void setPrestamos(ArrayList <Prestamo> p_prestamos) {
        this.prestamos = p_prestamos;
    }
    
    public int getDniSocio() {
        return this.dniSocio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getDiasPrestamo() {
        return this.diasPrestamo;
    }

    public ArrayList <Prestamo> getPrestamos() {
        return this.prestamos;
    }
    
    public void addPrestamo(Prestamo p_prestamo) {
        this.getPrestamos().add(p_prestamo);
    }
    
    public void removePrestamo(Prestamo p_prestamo) {
        this.getPrestamos().remove(p_prestamo);
    }
    
    /**
     * Recorre la colección de préstamos y suma 1 al contador de prestados cada
     * vez que detecta un préstamo sin fecha de devolución.
     * 
     * @return int con la cantidad de libros prestados.
     */
    public int cantLibrosPrestados(){
        int prestados = 0;
        for (Prestamo prestamo:this.getPrestamos()){
            if (prestamo.getFechaDevolucion() == null){
                prestados += 1;
            }            
        }
        return prestados;
    }
    
    /**
     * Recorre la colección de préstamos empezando por los agregados más recientemente
     * en busca de algún Prestamo todavía sin devolución que estuviera vencido. Un socio
     * con algún Prestamo vencido no podrá solicitar otro Prestamo.
     * 
     * @return true si no tiene préstamos vencidos
     */
    public boolean puedePedir(){
        int i = this.getPrestamos().size();
        ArrayList listaPrestamos = this.getPrestamos();
        boolean flag = true;
        while(i > -1 && flag ) {
            Prestamo unPrestamo = (Prestamo) listaPrestamos.get(i);
            if( (unPrestamo.getFechaDevolucion() == null && unPrestamo.vencido(unPrestamo.getFechaDevolucion())) ) {
                flag = false;
            }
            i--;
        }
        return flag;
    }
    
    public String toString() {
        return ("D.N.I.: "+this.getDniSocio()+" || "+this.getNombre()+" ("+this.soyDeLaClase()+")");
    }
    
    public abstract String soyDeLaClase();
    
}
