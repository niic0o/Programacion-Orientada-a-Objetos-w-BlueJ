/**
 * Esta clase permite conocer el valor del saldo y sus movimientos de un determinado cliente.
 * @autor Sena, Nicolas Ariel
 * @version 1.0 - 30/08/2017
 * 
 * 
*/
public class Cliente
{   //Atributos
    private int nroDni;
    private String apellido;
    private String nombre;
    private double saldo;    

    /**@param p_dni se usa para ingresar el numero de dni del cliente
     * @param p_apellido apellido del cliente
     * @param p_nombre nombre del cliente
     * @param p_importe ingresar el saldo inicial
    */
    //constructor
    Cliente (int p_dni, String p_apellido, String p_nombre, double p_importe)
        {
            this.setNroDni(p_dni);
            this.setApellido(p_apellido);
            this.setNombre(p_nombre);
            this.setSaldo(p_importe);
        }
    //setters
    private void setNroDni(int p_dni)
        {this.nroDni = p_dni;}
    private void setApellido(String p_apellido)
        {this.apellido = p_apellido;}
    private void setNombre(String p_nombre)
        {this.nombre = p_nombre;}
    private void setSaldo(double p_importe)
        {this.saldo = p_importe;}
    //getters
    /** @return getters devuelven los valores que contienen los atributos referenciados */
    public int getNroDni()
        {return this.nroDni;}
    public String getApellido()
        {return this.apellido;}
    public String getNombre()
        {return this.nombre;}
    public double getSaldo()
        {return this.saldo;}
    
    //metodos
    /** @return devuelve nombre y apellido encadenado */
    public String nomYApe()
    {
        return this.getNombre() + " " + this.getApellido();
    }
    
    /** @return devuelve apellido y nombre encadenado */
    public String apeYNom()
    {
        return this.getApellido() + " " + this.getNombre();
    }
    public void mostrar()
        {
            System.out.println("\n"+"Nombre y Apellido: "+nomYApe()+"("+this.getNroDni()+")"+"\n"+"Saldo: "+"$"+this.getSaldo()+"\n");
        } 
        
    /** @return reemplaza el saldo por el importe ingresado y devuelve el resultado */
    public double nuevoSaldo(double p_importe)
        {
            return this.saldo = p_importe;
        }
        
    /** @return actualiza el saldo con el importe ingresado y devuelve el resultado */
    public double agregaSaldo(double p_importe)
        {
            return this.saldo = this.saldo + p_importe;
        }
    }
