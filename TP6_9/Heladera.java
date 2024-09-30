
/**
 * Permite conocer las caracteristicas de este artefacto y sus costos.
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class Heladera extends ArtefactoHogar
{
    private int pies;
    private int puertas;
    private boolean compresor;
    
    /**
     * @param p_marca marca del artefacto
     * @param p_precio costo sin interes del artefacto
     * @param p_stock cantidad disponible para la venta
     * @param p_pies altura
     * @param p_puertas accesos al interior
     * @param p_compresor si lo posee o no
     */
    Heladera(String p_marca, int p_precio, int p_stock,
    int p_pies, int p_puertas, boolean p_compresor){
        super(p_marca,p_precio,p_stock);
        this.setPies(p_pies);
        this.setPuertas(p_puertas);
        this.setCompresor(p_compresor);
    }

    private void setPies (int p_pies){
        this.pies = p_pies;
    }

    private void setPuertas (int p_puertas){
        this.puertas = p_puertas;
    }

    private void setCompresor (boolean p_compresor){
        this.compresor = p_compresor;
    }

    public int getPies (){
        return this.pies;
    }

    public int getPuertas (){
        return this.puertas;
    }

    public boolean getCompresor (){
        return this.compresor;
    }
    
    /**
     * @param p_cuotas cantidad de veces a pagar
     * @param p_interes porcentaje de interes
     * @return devuelve el credito con un adicional.
     */    
    public float creditoConAdicional (int p_cuotas, float p_interes){
        if(this.getCompresor() == true){
            return (this.cuotaCredito(p_cuotas,p_interes)) + (50 * p_cuotas);
        }else{
            return this.cuotaCredito(p_cuotas,p_interes);
        }
    }
    
    public void imprimir(){
        String aux = " ";
        if(this.getCompresor() == true){
            aux = "si";
        }else{
            aux = "no";
        }        
        System.out.println("\n"+"* * * * Heladera * * * *");
        super.imprimir();
        System.out.println("Pies: "+this.getPies()+
            "\n"+"Puertas: "+this.getPuertas()+
            "\n"+"Compresor: "+aux);
        }
    }