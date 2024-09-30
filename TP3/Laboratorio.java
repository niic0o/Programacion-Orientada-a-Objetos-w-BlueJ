/**
 * Esta clase permite conocer nombres y ubicaciones de sucursales de droguerias.
 * @autor Sena, Nicolas Ariel
 * @version 1.0 - 30/08/2017
 * 
 * 
*/
public class Laboratorio
{   //atributos
    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega;
    
    /**@param p_nom se usa para ingresar el nombre de la sucursal
     * @param p_dom ingresar la ubicacion geografica
     * @param p_tel un numero telefonico para contactarse
     * @param p_compraMin ingresar la compra minima
     * @param p_diaEnt se usa para ingresar el dia entrega
       */
    //constructor doblemente encapsulado
    Laboratorio (String p_nom, String p_dom, String p_tel, int p_compraMin, int p_diaEnt)
        {
            this.setNombre(p_nom);
            this.setDomicilio(p_dom);
            this.setTelefono(p_tel);
            this.setCompraMinima(p_compraMin);
            this.setDiaEntrega(p_diaEnt);
        }
        
    /**@param p_nom se usa para ingresar el nombre de la sucursal
     * @param p_dom ingresar la ubicacion geografica
     * @param p_tel un numero telefonico para contactarse    
       */
    //sobrecarga
    Laboratorio (String p_nom, String p_dom, String p_tel)
        {
            this.setNombre(p_nom);
            this.setDomicilio(p_dom);
            this.setTelefono(p_tel);
        }
    //setters
    private void setNombre (String p_nom)
        {this.nombre = p_nom;}  
    private void setDomicilio (String p_dom)
        {this.domicilio = p_dom;}
    private void setTelefono (String p_tel)
        {this.telefono = p_tel;}
    private void setCompraMinima (int p_compraMin)
        {this.compraMinima = p_compraMin;}
    private void setDiaEntrega (int p_diaEnt)
        {this.diaEntrega = p_diaEnt;}
    
    /** @return getters devuelven el valor de los atributos referenciados */    
    //getters
    public String getNombre()
        {return this.nombre;}
    public String getDomicilio()
        {return this.domicilio;}
    public String getTelefono()
        {return this.telefono;}
    public int getCompraMinima()
        {return this.compraMinima;}
    public int getDiaEntrega()
        {return this.diaEntrega;}
        
    //metodos
    public void ajusteCompraMinima (int p_compraMin)
        {
            setCompraMinima(p_compraMin);
        }
    public void ajusteDeEntrega (int p_diaEnt)
        {
            setDiaEntrega(p_diaEnt);
        }
    public void mostrar()
        {
            System.out.println("Laboratorio: "+this.getNombre()+"\n"+"Domicilio: "+this.getDomicilio()+" - "+"Telefono: "+this.getTelefono()+"\n");
        }            
}

