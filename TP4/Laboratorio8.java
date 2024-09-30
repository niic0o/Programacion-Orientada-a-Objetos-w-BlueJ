import java.util.*;
/**
 * Esta clase permite conocer datos para la compra de productos de un laboratorio.
 * @autor Sena, Nicolas Ariel
 * @version 1.3 - 10/2017
 * 
 * 
*/
public class Laboratorio8
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
    Laboratorio8 (String p_nom, String p_dom, String p_tel, int p_compraMin, int p_diaEnt)
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
    Laboratorio8 (String p_nom, String p_dom, String p_tel)
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
        
    /** @return devuelve los dias habiles restantes para la entrega, considerando que el dia 1 y 7 de la semana que inicia en domingo, no son laborables*/    
    public int diaParaEntrega ()
    //getActualMaximun(Calendar.) retorna el maximo valor del campo especificado.
    {
        Calendar fechaHoy = new GregorianCalendar();
        int diaHoy = fechaHoy.get(Calendar.DATE);
        int diasEntrega;
        if (diaHoy < this.getDiaEntrega()){
            Calendar fechaEntrega = new GregorianCalendar();
            diasEntrega = this.getDiaEntrega() - diaHoy;
            fechaEntrega.add(Calendar.DATE,diasEntrega);
            if (fechaEntrega.get(Calendar.DAY_OF_WEEK) == 1){
                diasEntrega += 1;
            }
            if (fechaEntrega.get(Calendar.DAY_OF_WEEK) == 7){
                diasEntrega += 2;
            }
            return diasEntrega;
        }else{
            Calendar fechaEntrega = new GregorianCalendar();
            diasEntrega = fechaHoy.getActualMaximum(Calendar.DATE) - diaHoy + this.getDiaEntrega();
            fechaEntrega.add(Calendar.DATE,diasEntrega);
            if (fechaEntrega.get(Calendar.DAY_OF_WEEK) == 1){
                diasEntrega += 1;
            }
            if (fechaEntrega.get(Calendar.DAY_OF_WEEK) == 7){
                diasEntrega += 2;
            }
            return diasEntrega;
        }
    }
    /**
     * @param p_compraMin valor que modificará la compra minima
     */
    public void ajusteCompraMinima (int p_compraMin)
        {
            setCompraMinima(p_compraMin);
        }
    /**
     * @param p_diaEnt valor que modificará el dia de entrega
     */        
    public void ajusteDeEntrega (int p_diaEnt)
        {
            setDiaEntrega(p_diaEnt);
        }
        
    public void mostrar()
        {
        System.out.println("--------------------------------------------------");
        System.out.println("Laboratorio: "+getNombre());
        System.out.println("Domicilio: "+getDomicilio()+" - Telefono: "+getTelefono());
        System.out.println("--------------------------------------------------");

    }            
}
