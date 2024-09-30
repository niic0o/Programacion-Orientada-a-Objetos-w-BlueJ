import java.util.*;
/**
 * Write a description of class Evento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Evento
{
    private String nombre;
    private String lugar;
    private Calendar fecha;
    private int diasInscripcion;
    private double costo;

    Evento (String p_nombre, String p_lugar, Calendar p_fecha, int p_diasIns, double p_costo)
    {
        this.setNombre(p_nombre);
        this.setLugar(p_lugar);
        this.setFecha(p_fecha);
        this.setDiasIns(p_diasIns);
        this.setCosto(p_costo);
    }

    private void setNombre (String p_nombre)
    { this.nombre = p_nombre;}

    private void setLugar (String p_lugar)
    {this.lugar = p_lugar;}

    private void setFecha (Calendar p_fecha)
    {this.fecha = p_fecha;}
    
    private void setDiasIns (int p_diasIns)
    {this.diasInscripcion = p_diasIns;}
    
    private void setCosto (double p_costo)
    {this.costo = p_costo;}
    
    public String getNombre ()
    {return this.nombre;}
    
    public String getLugar ()
    {return this.lugar;}
    
    public Calendar getFecha ()
    {return this.fecha;}
    
    public int getDiasIns ()
    {return this.diasInscripcion;}
    
    public double getCosto()
    {return this.costo;}
    
    // -10% sobre el costo a mayores o igual 60 años
    public String costoFinal (int p_edadInvitado)
    {
        double aux = this.getCosto();
        if (p_edadInvitado > 59)
        {
            return "$"+(aux - ((aux * 10) / 100)) + " (incluye descuento)";
        }
        else
        {
            return "$"+aux;
        }
    }
    
    public Calendar fechaInscripcion ()
    {
        //calculo la fecha de inscripcion
        Calendar unaInscripcion = new GregorianCalendar(this.getFecha().get(Calendar.YEAR),this.getFecha().get(Calendar.MONTH),this.getFecha().get(Calendar.DATE));
        unaInscripcion.add(Calendar.DATE,-this.getDiasIns()); 
        return unaInscripcion;
    }

}
