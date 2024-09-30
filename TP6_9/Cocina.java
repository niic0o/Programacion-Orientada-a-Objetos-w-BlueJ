
/**
 * Permite conocer las caracteristicas de este artefacto y sus costos.
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class Cocina extends ArtefactoHogar
{
    private int hornallas;
    private int calorias;
    private String dimensiones;

    /**
     * @param p_marca marca del artefacto
     * @param p_precio costo sin interes del artefacto
     * @param p_stock cantidad disponible para la venta
     * @param p_hornallas numero de hornallas
     * @param p_calorias numero de calorias
     * @param p_dimensiones tamaño del artefacto
     */
    Cocina(String p_marca, float p_precio, int p_stock,
    int p_hornallas, int p_calorias, String p_dimensiones){
        super(p_marca,p_precio,p_stock);
        this.setHornallas(p_hornallas);
        this.setCalorias(p_calorias);
        this.setDimensiones(p_dimensiones);
    }

    private void setHornallas (int p_hornallas){
        this.hornallas = p_hornallas;
    }

    private void setCalorias (int p_calorias){
        this.calorias = p_calorias;
    }

    private void setDimensiones (String p_dimensiones){
        this.dimensiones = p_dimensiones;
    }

    public int getHornallas (){
        return this.hornallas;
    }

    public int getCalorias (){
        return this.calorias;
    }

    public String getDimensiones (){
        return this.dimensiones;
    }
    
    /**
     * @param p_cuotas cantidad de veces a pagar
     * @param p_interes porcentaje de interes
     * @return devuelve el credito con un adicional.
     */
    public float creditoConAdicional (int p_cuotas, float p_interes){
        return this.cuotaCredito(p_cuotas,p_interes);
    }
    
    public void imprimir(){
        System.out.println("\n"+"* * * * Cocina * * * *");
        super.imprimir();
        System.out.println("Hornallas: "+this.getHornallas()+
            "\n"+"Calorias: "+this.getCalorias()+
            "\n"+"Dimensiones: "+this.getDimensiones());
    }
}
