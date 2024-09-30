import java.text.*;
import java.util.*;

/**
 * Permite generar Indemnizaciones ante daños ocasionados por siniestros.
 */

public class Poliza{
    private String cobertura;
    private Calendar fechaContrato;
    private double valorPoliza;
    private double valorAsegurado;
    private String momentoCancelacion;
    private Siniestro siniestro;
    private UnidadDeRiesgo unidad;
    
    /**
     * 
     * @param p_cobertura tipo de siniestro
     * @param p_fechaContraro  fecha de firma del contrato
     * @param p_valorPoliza valor en pesos de la cobertura
     * @param p_valorAsegurado  valor asegurado en pesos
     * @param p_momentoCancelacion  inicio o fin de siembra
     * @param p_siniestro  objeto con los datos del siniestro
     * @param p_unidad  cultivo asegurado
     */
    public Poliza(String p_cobertura, Calendar p_fechaContrato, double p_valorPoliza, double p_valorAsegurado, String p_momentoCancelacion, Siniestro p_siniestro, UnidadDeRiesgo p_unidad){
        this.setCobertura(p_cobertura);
        this.setFechaContrato(p_fechaContrato);
        this.setValorAsegurado(p_valorAsegurado);
        this.setValorPoliza(p_valorPoliza);
        this.setMomentoCancelacion(p_momentoCancelacion);
        this.setSiniestro(p_siniestro);
        this.setUnidadDeRiesgo(p_unidad);
    }
    
    private void setCobertura(String p_cobertura){
        this.cobertura = p_cobertura;
    }
    
    private void setFechaContrato(Calendar p_fechaContrato){
        this.fechaContrato = p_fechaContrato;
    }
    
    private void setValorPoliza(double p_valorPoliza){
        this.valorPoliza = p_valorPoliza;
    }

    private void setValorAsegurado(double p_valorAsegurado){
        this.valorAsegurado = p_valorAsegurado;
    }

    private void setMomentoCancelacion(String p_momentoCancelacion){
        this.momentoCancelacion = p_momentoCancelacion;
    }

    private void setSiniestro(Siniestro p_siniestro){
        this.siniestro = p_siniestro;
    }

    private void setUnidadDeRiesgo(UnidadDeRiesgo p_unidad){
        this.unidad = p_unidad;
    }

    public String getCobertura(){
        return this.cobertura;
    }
    
    public Calendar getFechaContrato(){
        return this.fechaContrato;
    }

    public double getValorPoliza(){
        return this.valorPoliza;
    }

    public double getValorAsegurado(){
        return this.valorAsegurado;
    }

    public String getMomentoCancelacion(){
        return this.momentoCancelacion;
    }

    public Siniestro getSiniestro(){
        return this.siniestro;
    }

    public UnidadDeRiesgo getUnidadDeRiesgo(){
        return this.unidad;
    }
    
    /**
     * 
     * @return Calcula la indemnizacion que corresponde dependiendo del tipo de cobertura
     */
    public double indemnizacion(){
        double indemnizacion = this.getSiniestro().totalDanio(this.getValorAsegurado());
        if (this.getCobertura().equals("Incendio")){
            indemnizacion *= 0.75;
        }
        if (this.getCobertura().equals("Resiembra")){
            indemnizacion *= 0.30;
        }
        return indemnizacion;
    }
    
    /**
     * 
     * @return Calcula la fecha en que se realizara la indemnizacion dependiendo del tipo de cobertura
     */
    public Calendar fechaIndemnizacion(){
        Calendar fechaIndemnizacion = new GregorianCalendar();
        fechaIndemnizacion = this.getSiniestro().getFecha();
        if (this.getCobertura().equals("Incendio")){
            fechaIndemnizacion.add(Calendar.DATE, 20);
            return fechaIndemnizacion;
        }else{
            return this.getUnidadDeRiesgo().getFechaCosecha();
        }
    }
    
    /**
     * Muestra detalles del precio de la poliza
     */
    public void detallePrecioPoliza(){
        if (this.getMomentoCancelacion().equals("Inicial")){
            System.out.println("El abono se realiza al comienzo de la siembra. Tiene un descuento del 25%. Precio Real Abonado: $"+this.getValorPoliza()*0.75);
        }else{
            System.out.println("El abono se realiza al finalizar la siembra. Se abona el 100% de la póliza");
        }
    }
    
    /**
     * Muestra un resumen con los datos de la poliza
     */
    public void resumenIndemnizaciones(){
        DateFormat formato1 = DateFormat.getDateInstance(DateFormat.FULL);
        SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("**** RESUMEN DEL SEGURO CONTRATADO EL DIA "+formato2.format(this.getFechaContrato().getTime())+" *****\n"+
        "------------Detalle de forma de pago de la póliza------------\n"+
        "Precio a pagar: $"+this.getValorPoliza()+"\n");
        this.detallePrecioPoliza();
        System.out.println("Valor de cultivo asegurado: $"+this.getValorAsegurado()+"\n"+
        "------------------Detalle de la unidad de riesgo----------------");
        this.getUnidadDeRiesgo().mostrarDetalle();
        System.out.println("\n******************************************************************");
    }
}