/**
 * Instancia un objeto de la clase Estudiante.
 * 
 * @author (DOMINGO PACHECO) 
 * @version (1.0 // 10/11/2017: 21.55)
 */
public class Estudiante extends Socio {
    private String carrera;
    
    /**
     * Constructor de objetos de la clase Estudiante
     * 
     * @param p_dniSocio    DNI del socio.
     * @param p_nombre      Nombre del socio.
     * @param p_carrera     Carreara que estudia es estudiante.
     */
    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera){
        super (p_dniSocio, p_nombre, 20);  
        this.setCarrera(p_carrera);
    }
    
    /**
     * Asigna valor al atributo carrera.
     * 
     * @param p_carrera String que contiene el valor de Carrera.
     */
    private void setCarrera(String p_carrera) {
        this.carrera = p_carrera;
    }
    
    /**
     * Retorna el valor de la carrea que cursa el estudiante.
     * 
     * @return un String con el nombre de la carrera que cursa el socio estudiante.
     */
    public String getCarrera() {
        return this.carrera;
    }
    
    /**
     * Especialización del comportamiento del método puedePedir() de la clase Socio.
     * Comprueba que Estudiante no tenga más de 3 libros en su poder ya que aparte
     * del vencimiento, requisito común a todos los socios, un Estudiante no podrá
     * tener más de libros simultaneamente.
     * 
     * @return true si Estudiante tiene menos de 3 libros en su poder
     */
    public boolean puedePedir() {
       if (super.puedePedir() && this.cantLibrosPrestados() < 3) { 
           return true;
       }else{
           return false;
       }
    }
    
    /**
     * Identifica a la instancia retornando una cadena con el nombre de la clase.
     * 
     * @return String "Estudiante"
     */
    public String soyDeLaClase() {
        return "Estudiante";
    }
}