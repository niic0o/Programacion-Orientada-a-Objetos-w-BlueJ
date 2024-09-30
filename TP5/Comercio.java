import java.util.*;

/**
 * Write a description of class Comercio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comercio
{
    private String nombre;
    private HashMap <Long,Empleado> empleados;
    
    /**
     * @param p_nombre      Nombre del comercio
     */
    Comercio(String p_nombre){
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap <Long,Empleado>());
    }
    
    /**
     * @param p_nombre      Nombre del comercio
     * @param p_empleados   HashMap de empleados
     */
    Comercio(String p_nombre, HashMap p_empleados){
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }    
    
    private void setEmpleados(HashMap <Long,Empleado> p_empleados){
        this.empleados = p_empleados;
    }    
    
    public String getNombre(){
        return this.nombre;
    }    
    
    public HashMap <Long,Empleado> getEmpleados(){
        return this.empleados;
    }  
    
    /**
     * @param p_empleado objeto de tipo empleado
     */
    public void altaEmpleado(Empleado p_empleado){
        this.getEmpleados().put(new Long (p_empleado.getCuil()),p_empleado);
    }   
    
    /**
     * @return devuelve el objeto de tipo Empleado eliminado.
     */
    public Empleado bajaEmpleado(long p_cuil){
        return this.getEmpleados().remove(new Long (p_cuil));
    } 
    
    /**
     * @return devuelve la cantidad de emplados
     */
    public int CantidadDeEmpleados(){
        return this.getEmpleados().size();
    }   
    
    /**
     * @param p_cuil numero de cuil para comparar con el arreglo
     * @return Devuelve la confirmacion de la pertenencia de el emplado a la empresa.
     * 
     */
    public boolean esEmpleado(long p_cuil){
        return this.getEmpleados().containsKey(p_cuil);
    }    
    
    /**
     * @param p_cuil numero de cuil para buscar empleado
     * @return Devuelve el objeto de tipo Empleado buscado.
     */
    public Empleado buscarEmpleado(long p_cuil){
        return (this.getEmpleados().get(p_cuil));
    }    
    
    /**
     * @param p_cuil numero de cuil para buscar empleado
     */
    public void sueldoNeto(long p_cuil){
        System.out.println("Sueldo Neto: "+(this.getEmpleados().get(p_cuil)).sueldoNeto());
    }    
    
    public void nomina(){
        System.out.println("**** Nomina de empleados de "+this.getNombre()+" ****");
        for(Map.Entry <Long, Empleado> e : empleados.entrySet()){
            System.out.println(e.getValue().mostrarLinea());
        }
    }    
}
