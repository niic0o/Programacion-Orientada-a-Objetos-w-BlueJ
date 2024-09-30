/**
 * Esta clase permite conocer 3 datos personales de varias personas.
 * @autor Sena, Nicolas Ariel
 * @version 1.0 - 30/08/2017
 * 
 * 
*/


import java.util.*;

public class Persona
{
   private int nroDni;
   private String nombre;
   private String apellido;
   private int anioNacimiento;
   
   /**@param p_dni se usa para ingresar el numero de DNI
    * @param p_nombre nombre de la persona
      @param p_apellido apellido de la persona
      @param p_anio se usa para ingresar el año de nacimiento de la persona*/ 
   public Persona(int p_dni,String p_nombre,String p_apellido,int p_anio)
    {
        this.setNroDni(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_anio);
    }
   private void setNroDni(int p_dni)
    {
        this.nroDni = p_dni;
    }
   private void setNombre(String p_nombre)
    {
       this.nombre = p_nombre;
    }
   private void setApellido(String p_apellido)
    {
        this.apellido = p_apellido;
    }
   private void setAnioNacimiento(int p_anio)
    {
        this.anioNacimiento = p_anio;
    }
    
   /** @return getters devuelven el valor de los atributos referenciados */
   public int getNroDni()
    {
        return this.nroDni;
    }
   public String getNombre()
    {
        return this.nombre;
    }
   public String getApellido()
    {
        return this.apellido;
    }
   public int getAnioNacimiento()
    {
        return this.anioNacimiento;
    }
    
   /** @return devuelve la edad de la persona */  
   public int edad()
    {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - this.getAnioNacimiento();
    }
   public String nomYApe()
    {
        return this.getNombre() + " " + this.getApellido();
    }
   public String apeYNom()
    {
        return this.getApellido() + " " + this.getNombre();
    }
   public void mostrar()
    {
        System.out.println("Nombre y Apellido: "+ nomYApe());
        System.out.println("DNI: "+ this.getNroDni()+ " Edad: "+ this.getAnioNacimiento()+ " años");
    }
}