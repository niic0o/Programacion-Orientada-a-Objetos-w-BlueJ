import java.io.*;
import java.util.*;
import java.text.*;
/**
 * Write a description of class Fundacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fundacion
{
    private String nombre;
    
    Fundacion (String p_nombre)
    {
        this.setNombre(p_nombre);
    }
    
    private void setNombre (String p_nombre)
    {this.nombre = p_nombre;}
    
    public String getNombre ()
    {return this.nombre;}
    
    public void imprimirInvitacion (Evento p_evento, Persona p_persona)
    {
        //convierto mi Calendar en un objeto de clase Date
        Date unDate = p_evento.fechaInscripcion().getTime();
        Date dosDate = p_evento.getFecha().getTime();
        //formateo un objeto de forma SHORT = dd/mm/aa y LONG (dia de mes de año)
        DateFormat formato1 = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat formato2 = DateFormat.getDateInstance(DateFormat.LONG);
        //aplico formato sobre unDate (6to System)
        System.out.println("\n"+"*___________________________________________________________________________*");
        System.out.println("Estimado/a: "+p_persona.nomYApe());
        System.out.println("La fundación: "+this.getNombre());
        System.out.println("Invita a Ud. al próximo evento: "+p_evento.getNombre());
        System.out.println("Las inscripciones se realizan con "+p_evento.getDiasIns()+" dias de anticipación.");
        System.out.println("Las mismas se llevaran a cabo el día: "+formato1.format(unDate));
        System.out.println("El evento tendra lugar en: "+p_evento.getLugar()+", el dia "+formato2.format(dosDate));
        System.out.println("Costo: "+p_evento.costoFinal(p_persona.edad())+" Lo esperamos.");
        System.out.println("*___________________________________________________________________________*"+"\n");
        
    }
    public void grabarInvitacion (Evento p_evento, Persona p_persona, DataOutputStream unArchivo)
    {
        try
        {
        unArchivo.writeInt(p_persona.getNroDni());
        unArchivo.writeUTF(p_persona.apeYNom());
        unArchivo.writeUTF(p_evento.getLugar());
        unArchivo.writeDouble(p_evento.getCosto());
        unArchivo.writeInt(p_evento.getFecha().get(Calendar.MONTH));
        unArchivo.writeInt(p_evento.getFecha().get(Calendar.DATE));
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println("Archivo no encontrado");
        }
        catch(IOException ioe)
        {
            System.out.println("Error al grabar");
        }
    }
}
