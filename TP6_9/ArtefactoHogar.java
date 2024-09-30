/**
 * Clase abstracta que reune las caracteristicas generales de tipos de artefactos del hogar.
 * 
 * @author: Sena, Nicolas Ariel
 * Date: 11/2017
 */
public abstract class ArtefactoHogar
{
    private String marca;
    private float precio;
    private int stock;

    /**
     * @param p_marca marca del artefacto
     * @param p_precio costo sin interes del artefacto
     * @param p_stock cantidad disponible para la venta
     */
    ArtefactoHogar(String p_marca, float p_precio, int p_stock){
        this.setMarca(p_marca);
        this.setPrecio(p_precio);
        this.setStock(p_stock);
    }

    private void setMarca (String p_marca){
        this.marca = p_marca;
    }

    private void setPrecio (float p_precio){
        this.precio = p_precio;
    }

    private void setStock (int p_stock){
        this.stock = p_stock;
    }

    public String getMarca (){
        return this.marca;
    }

    public float getPrecio (){
        return  this.precio;
    }

    public int getStock (){
        return this.stock;
    }

    /**
     * @param p_cuotas cantidad de veces a pagar
     * @param p_interes porcentaje de interes
     * @return devuelve el costo con intereses a pagar.
     */
    public float cuotaCredito (int p_cuotas, float p_interes){
        return ((this.getPrecio() / p_cuotas) + (this.getPrecio() * p_interes) /100);
    }

    /**
     * @param p_cuotas cantidad de veces a pagar
     * @param p_interes porcentaje de interes
     * @return devuelve el credito con un adicional.
     */
    public abstract float creditoConAdicional (int p_cuotas, float p_interes);

    public void imprimir (){
        System.out.println("Marca: "+this.getMarca()+"  -  Precio: "+
            this.getPrecio()+"  -  Stock: "+this.getStock());
    }
}