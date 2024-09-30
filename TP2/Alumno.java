/**
 * Esta clase permite conocer los datos y el promedio de dos calificaciones de un alumno, con una leyenda de su estado.
 * @autor Sena, Nicolas Ariel
 * @version 1.0 - 30/08/2017
 * 
 * 
*/
public class Alumno
{
    //atributos
    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;  
    
    /**@param p_lu ingreso del numero de Libreta Universitaria
     * @param p_apellido apellido del alumno
     * @param p_nombre nombre del alumno
    */
    //constructor doblemente encapsulado
    Alumno(int p_lu, String p_nombre, String p_apellido)
        {
            this.setLu(p_lu);
            this.setNombre(p_nombre);
            this.setApellido(p_apellido);
        }
        
    //setters
    private void setLu (int p_lu)
        {this.lu = p_lu;}
    private void setNombre (String p_nombre)
        {this.nombre = p_nombre;}
    private void setApellido (String p_apellido)
        {this.apellido = p_apellido;}
    /** 
     * @param p_nota1 permite ingresar calificacion desde la clase ejecutable
    */    
    public void setNota1 (double p_nota)
        {this.nota1 = p_nota;}
    /** 
     * @param p_nota2 permite ingresar calificacion desde la clase ejecutable
    */     
    public void setNota2 (double p_nota)
        {this.nota2 = p_nota;}
    
    /** @return getters devuelven los valores que contienen los atributos referenciados */   
    //getters
    public int getLu ()
        {return this.lu;}
    public String getNombre ()
        {return this.nombre;}
    public String getApellido ()
        {return this.apellido;}
    public double getNota1 ()
        {return this.nota1;}
    public double getNota2 ()
        {return this.nota2;}
    
    /** @return devuelve si aprobo o no */    
    //metodos
    private boolean aprueba ()
        {
            if (this.promedio() >= 6.0)
                {
                    return true;
                }
            else
                {
                    return false;
                }
        }
        
    /** @return devuelve el estado calificativo del alumno */    
    private String leyendaAprueba()
        {
            if (this.aprueba() == true)
                {
                    return "APROBADO";
                }
            else
                {
                    return "DESAPROBADO";
                }
         }
    
    /** @return promedio de dos notas */     
    public double promedio ()
        {
          return ((this.getNota1() + this.getNota2()) / 2); 
        }
    
    /** @return devuelve nombre y apellido encadenado */    
    public String nomYApe()
        {
            return this.getNombre() + " " + this.getApellido();
        }
   
    /** @return devuelve apellido y nombre encadenado */    
    public String apeYNom()
        {
            return this.getApellido() + " " + this.getNombre();
        }
    
    public void mostrar() 
        {
            System.out.println("\n"+"Nombre y Apellido: "+this.nomYApe());
            System.out.print("Lu: "+this.getLu()+"   "+"Notas: "+this.getNota1()+" - "+this.getNota2()+"\n");
            System.out.println("Promedio: "+this.promedio()+" - "+this.leyendaAprueba());
        }
}
