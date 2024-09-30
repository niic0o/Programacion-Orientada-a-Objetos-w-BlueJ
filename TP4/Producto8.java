/**
 * Esta clase permite contabilizar el stock de un producto farmaceutico y conocer su valor economico.
 * 
 * @author _Nicolas Ariel Sena 
 * @version version 1.0 - 14/09/2017
 */
public class Producto8
{
    //atributos
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio8 lab;

    //constructor 0 (inicializar)
    Producto8 ()
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
    Producto8 (int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMin, Laboratorio8 p_lab)
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
    Producto8 (int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio8 p_lab)
    {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setLab(p_lab);
    }

    /**
     * @param p_codigo numero clave de identificacion de un producto.
     * @param p_rubro categoria de un producto.
     * @param p_desc tipo y marca de un producto.
     * @param p_costo valor en pesos de un producto.
     * @param p_porcPtoRepo porcentaje de punto de reposicion.
     * @param p_existMin existencia minima del stock.
     * @param p_lab datos de tipo Laboratorio (nombre domicilio y telefono).
     * @param p_stock cantidad numerica de productos de un mismo rubro.
     */    
    Producto8 (int p_codigo, String p_rubro, String p_desc, int p_existMin, double p_porcPtoRepo, int p_stock, double p_costo,  Laboratorio8 p_lab)
    {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMin);
        this.setLab(p_lab);
        this.setStock(p_stock);
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

    private void setLab (Laboratorio8 p_lab)
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

    public Laboratorio8 getLab ()
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
        if (p_porce >= 0 && p_porce <= 100){ 
            this.setPorcPtoRepo(p_porce);
            System.out.println("Ajustado! - Porcentaje Punto de Reposicion: "+this.getPorcPtoRepo()+"%");
        }else{
            System.out.println("Porcentaje incorrecto!");
        }
    }

    /** @param p_cantidad stock. */
    public void ajustarExistMinima (int p_cantidad)
    {
        if (p_cantidad >= 0){
            this.setExistMinima(p_cantidad);
            System.out.println("Ajustado! - Existencia Minima: "+this.getExistMinima());
        }else{
            System.out.println("Existencia Minima no puede ser menor que 0!");
        }
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

    /** @return devuelve el tipo de politica de punto de reposicion a implementar. **/    
    public char solicitar ()
    {   //calculo el punto en donde el stock debe reponerse
        double ptoReposicion = this.getExistMinima() * (1 + this.getPorcPtoRepo() / 100);
        if (this.getStock() <= lab.getCompraMinima())
        {
            return 'F';
        }
        else if (this.getStock() <= ptoReposicion && lab.diaParaEntrega() > 5)
        {
            return 'P';
        }
        else
        {
            return 'N';
        }
    }

    public void mostrarReposicionAutomatica ()       
    {
        System.out.println("************************************");
        this.getLab().mostrar();
        System.out.println("Rubro: "+this.getRubro());
        System.out.println("Descripcion: "+this.getDescripcion());
        System.out.println("Precio Costo: $ "+this.getCosto());
        System.out.println("Stock: "+this.getStock()+" - Stock Valorizado: $ "+this.stockValorizado());
        System.out.println("************************************");
    }
}

