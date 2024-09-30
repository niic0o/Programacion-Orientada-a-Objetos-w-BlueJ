
/**
 * Esta clase permite contabilizar el stock de un producto farmaceutico y conocer su valor economico.
 * 
 * @author _Nicolas Ariel Sena 
 * @version version 1.0 - 14/09/2017
 */
public class Producto
{
    //atributos
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio lab;

    //constructor 0 (inicializar)
    Producto ()
    {
        this.setStock(0);
    }
    //constructor 1
    /**
     * @param p_codigo numero clave de identificacion de un producto.
     * @param p_rubro categoria de un producto.
     * @param p_desc tipo y marca de un producto.
     * @param p_costo valor en pesos de un producto.
     * @param p_porcPtoRepo porcentaje de punto de reposicion.
     * @param p_existMin existencia minima del stock.
     * @param p_lab datos de tipo Laboratorio (nombre domicilio y telefono).
     */
    Producto (int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMin, Laboratorio p_lab)
    {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMin);
        this.setLab(p_lab);
    }
    //constructor 2
        /**
     * @param p_codigo numero clave de identificacion de un producto.
     * @param p_rubro categoria de un producto.
     * @param p_desc tipo y marca de un producto.
     * @param p_costo valor en pesos de un producto.
     * @param p_lab datos de tipo Laboratorio (nombre domicilio y telefono).
     */
    Producto (int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab)
    {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setLab(p_lab);
    }
    //setters
    private void setCodigo (int p_codigo)
        {this.codigo = p_codigo;}
    private void setRubro (String p_rubro)
        {this.rubro = p_rubro;}
    private void setDescripcion (String p_desc)
        {this.descripcion = p_desc;}
    private void setCosto (double p_costo)
        {this.costo = p_costo;}
    private void setStock (int p_stock)
        {this.stock = p_stock;}
    private void setPorcPtoRepo (double p_porcPtoRepo)
        {this.porcPtoRepo = p_porcPtoRepo;}
    private void setExistMinima (int p_existMin)
        {this.existMinima = p_existMin;}
    private void setLab (Laboratorio p_lab)
        {this.lab = p_lab;}
    
    /** @return getters devuelven los valores que contienen los atributos referenciados */      
    //getters
    public int getCodigo ()
        {return this.codigo;}
    public String getRubro ()
        {return this.rubro;}
    public String getDescripcion ()
        {return this.descripcion;}
    public double getCosto ()
        {return this.costo;}
    public int getStock ()
        {return this.stock;}
    public double getPorcPtoRepo ()
        {return this.porcPtoRepo;}
    public int getExistMinima ()
        {return this.existMinima;}
    public Laboratorio getLab ()
        {return this.lab;}

    //metodos
    // si ingresa cantidad positiva suma al stock actual, si ingresa negativo, quita esa cantidad
    /** @param p_cantidad contabilizacion del stock */  
    public void ajuste (int p_cantidad)
    {
        if (p_cantidad >= 0)
        {
            this.setStock(this.getStock() + p_cantidad);
            System.out.println("Stock añadido!");
        }
        else if ((p_cantidad < 0) & (p_cantidad > (0 - this.getStock())))
        {
            this.setStock(this.getStock() + p_cantidad);
            System.out.println("\n"+"---- Stock eliminado satisfactoriamente -----"+"\n");
        }
        else
        {
            System.out.print("Error, imposible quitar mas de la cuenta");
        }
    }

    //precio de costo + 12% sobre costo
    /** @return devuelve el 12% agregado sobre el costo del producto */
    public double precioLista ()
    {
        return (this.getCosto() + (this.getCosto() * 12 ) / 100);
    }

    // precio de lista - 5% sobre precio de lista
    /** @return devuelve el 5% descontado del precio de lista*/
    public double precioContado ()
    {
        return (this.precioLista() - (this.precioLista() * 12) / 100);
    }

    // stock * costo + 12% rentabilidad sobre (Stock * Costo)
    /** @return retorna el 12% de rentabilidad agregado sobre el costo multiplicado por la cantidad del stock*/
    public double stockValorizado ()
    {
        double aux = (this.getStock() * this.getCosto());
            return (aux + (aux * 12) / 100);
    }
    /** @param p_porce porcentaje del punto de reposicion. */
    public void ajustarPtoRepo (double p_porce)
    {
        this.setPorcPtoRepo(p_porce); 
    }
    
    /** @param p_cantidad stock. */
    public void ajustarExistMinima (int p_cantidad)
    {
        this.setExistMinima(p_cantidad);
    }

    public void mostrar ()
    {
        this.getLab().mostrar();
        System.out.println("Rubro: "+this.getRubro()+"\n"+"Descripcion: "+this.getDescripcion());
        System.out.println("Precio Costo: "+this.getCosto()+"\n"+"Stock: "+this.getStock()+" - "+"Sotck Valorizado: "+this.stockValorizado()+"\n");
    }
    
    public String mostrarLinea()
    {
        return (this.getDescripcion() + "    " + this.precioLista() + "  " + this.precioContado());
    }
    
}