import java.util.*;
/**
 * Write a description of class Banco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banco{
    private String nombre;
    private int nroSucursal;
    private ArrayList <Empleado> empleados = new ArrayList <Empleado> ();
    private Localidad localidad;
    private ArrayList <CuentaBancaria> cuentasBancarias = new ArrayList <CuentaBancaria> (); //creo array vacio

    Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado){
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.agregarEmpleado(p_empleado);
    }

    Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList p_empleados){
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
    }

    Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList p_empleados, ArrayList p_cuentas){
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(p_cuentas);
    }

    private void setNombre (String p_nombre){
        this.nombre = p_nombre;}

    private void setLocalidad (Localidad p_localidad){
        this.localidad = p_localidad;}

    private void setNroSucursal (int p_nroSucursal){
        this.nroSucursal = p_nroSucursal;}

    private void setEmpleados (ArrayList <Empleado> p_empleados){
        this.empleados = p_empleados;}

    private void setCuentasBancarias (ArrayList <CuentaBancaria> p_cuenta){
        this.cuentasBancarias = p_cuenta;}

    public String getNombre (){
        return this.nombre;}

    public Localidad getLocalidad (){
        return this.localidad;}

    public int getNroSucursal (){
        return this.nroSucursal;}

    public ArrayList <Empleado> getEmpleados (){
        return this.empleados;}

    public ArrayList <CuentaBancaria> getCuentasBancarias (){
        return this.cuentasBancarias;}

    public boolean agregarEmpleado (Empleado p_empleado){
        return this.getEmpleados().add(p_empleado);
    }

    public boolean quitarEmpleado (Empleado p_empleado){
        if(this.getEmpleados().isEmpty() == true){
            return false;
        }else{
            return this.getEmpleados().remove(p_empleado);
        }
    }

    public void listarSueldos (){
        System.out.println("\n");
        for(int i=0;i<this.getEmpleados().size();i++){
            Empleado emp = this.getEmpleados().get(i);
            System.out.println(" "+emp.getCuil()+"\t"+
                " "+emp.apeYNom()+"\t"+
                "-------------------------------"+
                "$"+emp.sueldoNeto());
        }
        System.out.println("\n");
    }

    public double sueldosAPagar(){
        double totalAPagar = 0.0;
        for(int i=0;i<this.getEmpleados().size();i++){
            Empleado emp = this.getEmpleados().get(i);
            totalAPagar += emp.sueldoNeto();
        }
        return totalAPagar;
    }

    public void mostrar(){
        System.out.println("\n"+
            "Banco: "+this.getNombre()+"\t"+
            "Sucursal: "+this.getNroSucursal()+"\t"+
            "\n"+
            "Localidad: "+this.getLocalidad().getNombre()+"\t"+
            "Provincia: "+this.getLocalidad().getProvincia()+"\t"+
            "\n");
        this.listarSueldos();
        System.out.println("Total a pagar: "+
            "----------------------------------------------"+
            this.sueldosAPagar());
    }

    public boolean agregarCuentaBancaria (CuentaBancaria p_cuenta){
        return this.getCuentasBancarias().add(p_cuenta);
    }

    public boolean quitarCuentaBancaria (CuentaBancaria p_cuenta){
        if(this.getCuentasBancarias().isEmpty() == true){
            return false;
        }else{
            return this.getCuentasBancarias().remove(p_cuenta);
        }
    }

    private void mostrarSaldoCero (){
        System.out.println("\n"+
            "-----------------------------------------------------------"+"\n"+
            "Titulares con Cuenta en Saldo Cero"+"\n"+
            "-----------------------------------------------------------");
        for(int i=0;i<this.getCuentasBancarias().size();i++){
            CuentaBancaria cuenta = this.getCuentasBancarias().get(i);
            if(cuenta.getSaldo() <= 0){
                System.out.println(""+cuenta.getTitular().getNroDni()+"\t"+"\t"+
                    ""+cuenta.getTitular().apeYNom());
            }
        }
        System.out.println(
            "-----------------------------------------------------------"+
            "\n");
    }
    
    private int cuentasSaldoActivo (){
        int totalActivas = 0;
        for(int i=0;i<this.getCuentasBancarias().size();i++){
            if(this.getCuentasBancarias().get(i).getSaldo() > 0){
                totalActivas++;
            }
        }
        return totalActivas;
    }

        private int cuentasSaldoCero (){
        int totalSinSaldo = 0;
        for(int i=0;i<this.getCuentasBancarias().size();i++){
            if(this.getCuentasBancarias().get(i).getSaldo() <= 0){
                totalSinSaldo++;
            }
        }
        return totalSinSaldo;
    }
    
    public void mostrarResumen (){
        System.out.println("\n"+
            "Banco: "+this.getNombre()+"\t"+
            "Sucursal: "+this.getNroSucursal()+"\t"+
            "\n"+
            "Localidad: "+this.getLocalidad().getNombre()+"\t"+
            "Provincia: "+this.getLocalidad().getProvincia()+"\t"+
            "\n"+
            "***********************************************************"+
            "\n"+
            "RESUMEN DE CUENTAS BANCARIAS"+"\n"+
            "***********************************************************"+
            "\n"+
            "Numero total de Cuentas Bancarias: "+this.getCuentasBancarias().size()+
            "\n"+
            "Cuentas Activas: "+this.cuentasSaldoActivo()+"\n"+
            "Cuentas Saldo Cero: "+this.cuentasSaldoCero());
        this.mostrarSaldoCero();
        }
}
