
/**
 * Da a conocer el lugar de procedencia o localizacion de una persona.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class Localidad
{
   private String nombre;
   private String provincia;
   
   /**
    * @param p_nombre ciudad
    * @param p_provincia provincia
    */
   Localidad (String p_nombre, String p_provincia)
   {
       this.setNombre(p_nombre);
       this.setProvincia(p_provincia);
   }
   
   private void setNombre (String p_nombre)
   {this.nombre = p_nombre;}
   private void setProvincia (String p_provincia)
   {this.provincia = p_provincia;}
   
   /** @return getters devuelven los valores que contienen los atributos referenciados */     
   public String getNombre ()
   {return this.nombre;}
   public String getProvincia ()
   {return this.provincia;}
   
   /** @return cadena de caracteres con la ciudad y provincia */
   public String mostrar ()
   {
       return ("Localidad: "+this.getNombre()+"\t"+"Provincia: "+this.getProvincia());
   }
}
