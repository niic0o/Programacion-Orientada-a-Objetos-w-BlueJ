
/**
 * Write a description of class Lavarropa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lavarropas extends ArtefactoHogar
{
    private int programas;
    private float kilos;
    private boolean automatico;

    /**
     * @param p_marca marca del artefacto
     * @param p_precio costo sin interes del artefacto
     * @param p_stock cantidad disponible para la venta
     * @param p_programas cantidad de tareas que realiza
     * @param p_kilos peso en gramos
     * @param p_automatico si lo es o no
     */
    Lavarropas(String p_marca, float p_precio, int p_stock,
    int p_programas, float p_kilos, boolean p_automatico){
        super(p_marca,p_precio,p_stock);
        this.setProgramas(p_programas);
        this.setKilos(p_kilos);
        this.setAutomatico(p_automatico);
    }
    
    private void setProgramas (int p_programas){
        this.programas = p_programas;
    }
    private void setKilos (float p_kilos){
        this.kilos = p_kilos;
    }
    private void setAutomatico (boolean p_automatico){
        this.automatico = p_automatico;
    }
    public int getProgramas (){
        return this.programas;
    }
    public float getKilos (){
        return this.kilos;
    }
    public boolean getAutomatico (){
        return this.automatico;
    }

    /**
     * @param p_cuotas cantidad de veces a pagar
     * @param p_interes porcentaje de interes
     * @return devuelve el credito con un adicional.
     */    
    public float creditoConAdicional (int p_cuotas, float p_interes){
        float aux = this.cuotaCredito(p_cuotas,p_interes);
        if(this.getAutomatico() == false){
            return aux - ((aux * 0.02F) * p_cuotas);
        }else{
            return aux;
        }
    }
    
    public void imprimir(){
        String aux = " ";
        if(this.getAutomatico() == true){
            aux = "si";
        }else{
            aux = "no";
        }        
        System.out.println("\n"+"* * * * Lavarropas * * * *");
        super.imprimir();
        System.out.println("Programas: "+this.getProgramas()+
            "\n"+"Kilos: "+this.getKilos()+
            "\n"+"Automatico: "+aux);
        }    
}
