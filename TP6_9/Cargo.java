import java.util.*;
/**
 * Write a description of class Cargo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cargo
{
    private String nombreCargo;
    private double sueldoBasico;
    private int añoIngreso;
    private int horasDeDocencia;
    
    Cargo(String p_nombreCargo, double p_sueldoBasico, int p_añoIngreso, int p_horasDeDocencia){
        this.setNombreCargo(p_nombreCargo);
        this.setSueldoBasico(p_sueldoBasico);
        this.setAñoIngreso(p_añoIngreso);
        this.setHorasDeDocencia(p_horasDeDocencia);
    }
    
    private void setNombreCargo (String p_nombreCargo){
        this.nombreCargo = p_nombreCargo;
    }
    private void setSueldoBasico (double p_sueldoBasico){
        this.sueldoBasico = p_sueldoBasico;
    }
    private void setAñoIngreso (int p_añoIngreso){
        this.añoIngreso = p_añoIngreso;
    }
    private void setHorasDeDocencia (int p_horasDeDocencia){
        this.horasDeDocencia = p_horasDeDocencia;
    }
    
    public String getNombreCargo (){
        return this.nombreCargo;
    }
    public double getSueldoBasico (){
        return this.sueldoBasico;
    }
    public int getAñoIngreso (){
        return this.añoIngreso;
    }
    public int getHorasDeDocencia (){
        return this.horasDeDocencia;
    }
    
    public int antiguedad (){
        Calendar fechaHoy = new GregorianCalendar();
        return  fechaHoy.get(Calendar.YEAR) - this.getAñoIngreso();
    }
    
    private double adicionalXAntiguedad(){
        return this.getSueldoBasico() * 0.01 * this.antiguedad();
    }
    
    public double sueldoDelCargo(){
        return this.getSueldoBasico() + this.adicionalXAntiguedad();
    }
    
    public void mostrarCargo(){
        System.out.println("\n"+this.getNombreCargo()+
            " - Sueldo Basico: "+this.getSueldoBasico()+
            " - Sueldo Cargo: "+this.sueldoDelCargo()+
            " - Antiguedad: "+this.antiguedad()+" año(s)"+
            "\n"+"Horas Docencia: "+this.getHorasDeDocencia());
    }
    
    
}
