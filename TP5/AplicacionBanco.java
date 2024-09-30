import java.util.*;
/**
 * Aplicacion para gestionar empleados o cuentas de un banco
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class AplicacionBanco
{
    public static void main (String [] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        //Localidad
        String nombre,provincia;
        //Empleado
        long cuil;
        String apellido;//y nombre
        double sueldoBasico;
        int añoIngreso;
        //Banco
        int nroSucursal,opcion;//y nombre
        //CuentaBancaria
        int nroCuenta;
        double saldo;
        //Persona
        int nroDni,añoNacimiento;
        //String nombre,apellido;

        System.out.println("************ Bienvenido *************"+"\n");
        System.out.println("\n"+
            "1 - Gestionar empleados \n"+
            "2 - Gestionar cuentas \n");     
        opcion = teclado.nextInt();
        while (opcion == 1){
            System.out.println("Datos de la entidad bancaria");
            System.out.print("Localidad: ");
            nombre = teclado.next();
            System.out.print("Provincia: ");
            provincia = teclado.next();
            Localidad localidad = new Localidad(nombre,provincia);
            System.out.print("NroSucursal: ");
            nroSucursal = teclado.nextInt();
            System.out.print("Nombre: ");
            nombre = teclado.next();
            System.out.println("\n"+"Ingrese los datos del empleado a contratar");
            System.out.print("CUIL: ");
            cuil = teclado.nextLong();
            System.out.print("Apellido: ");
            apellido = teclado.next();
            System.out.print("Nombre: ");
            nombre = teclado.next();
            System.out.print("Sueldo Basico: ");
            sueldoBasico = teclado.nextDouble();
            System.out.print("Año de Ingreso: "+"\n");
            añoIngreso = teclado.nextInt();
            Empleado unEmpleado = new Empleado(cuil,apellido,nombre,sueldoBasico,añoIngreso);
            Banco unBanco = new Banco(nombre,localidad,nroSucursal,unEmpleado);        
            do{
                System.out.println("\n"+
                    "1 - Contratar empleado \n"+
                    "2 - Despedir empleado \n"+
                    "3 - Liquidar sueldos \n"+
                    "4 - Salir");
                opcion = teclado.nextInt();
                switch (opcion){
                    case 1:
                    System.out.println("\n"+"Ingrese los datos del empleado a contratar");
                    System.out.print("CUIL: ");
                    cuil = teclado.nextLong();
                    System.out.print("Apellido: ");
                    apellido = teclado.next();
                    System.out.print("Nombre: ");
                    nombre = teclado.next();
                    System.out.print("Sueldo Basico: ");
                    sueldoBasico = teclado.nextDouble();
                    System.out.print("Año de Ingreso: "+"\n");
                    añoIngreso = teclado.nextInt();
                    Empleado empleado = new Empleado(cuil,apellido,nombre,sueldoBasico,añoIngreso);
                    if(unBanco.agregarEmpleado(empleado) == true){
                        System.out.print("Empleado contratado satisfactoriamente!");
                    }
                    break;

                    case 2:
                    System.out.println("\n"+"Ingrese nro de cuil del despedido");
                    cuil = teclado.nextLong();
                    for(int i=0;i<unBanco.getEmpleados().size();i++){
                        Empleado emp = unBanco.getEmpleados().get(i);
                        if(cuil == emp.getCuil()){
                            unBanco.quitarEmpleado(emp);
                        }else{
                            System.out.println("No existe ese empleado en el listado");
                        }
                    }
                    break;

                    case 3://construir banco 2do constructor
                    Banco elBanco = new Banco(nombre,localidad,nroSucursal,unBanco.getEmpleados());
                    elBanco.mostrar();
                    break;

                    default: System.out.println("Chau pe!");
                }//unBanco.getEmpleados() y obtengo el arreglo de empleados
                opcion = 4;
            }while(opcion != 4);
        }
        while (opcion == 2){
            System.out.println("Datos de la entidad bancaria");
            System.out.print("Localidad: ");
            nombre = teclado.next();
            System.out.print("Provincia: ");
            provincia = teclado.next();
            Localidad localidad = new Localidad(nombre,provincia);
            System.out.print("NroSucursal: ");
            nroSucursal = teclado.nextInt();
            System.out.print("Nombre: ");
            nombre = teclado.next();
            System.out.println("Ingrese los datos del titular de la cuenta");
            System.out.print("Nro Dni: ");
            nroDni = teclado.nextInt();
            System.out.print("Nombre: ");
            nombre = teclado.next();
            System.out.print("Apellido: ");
            apellido = teclado.next();
            System.out.print("Año nacimiento: ");
            añoNacimiento = teclado.nextInt();
            Persona titular = new Persona(nroDni,nombre,apellido,añoNacimiento);
            System.out.println("Ingrese datos de la cuenta bancaria");
            System.out.print("nro cuenta: ");
            nroCuenta = teclado.nextInt();
            System.out.print("Saldo: ");
            saldo = teclado.nextDouble();
            CuentaBancaria unaCuenta = new CuentaBancaria(nroCuenta,titular,saldo);
            ArrayList <CuentaBancaria> unArreglo = new ArrayList <CuentaBancaria> ();
            unArreglo.add(unaCuenta);
            ArrayList <Empleado> otroArreglo = new ArrayList <Empleado> ();
            Banco unBanco = new Banco(nombre,localidad,nroSucursal,otroArreglo,unArreglo);
            do{
                System.out.println("\n"+
                    "1 - Añadir cuenta \n"+
                    "2 - Eliminar cuenta \n"+
                    "3 - Mostrar resumen de cuentas \n"+
                    "4 - Salir");
                opcion = teclado.nextInt();
                switch (opcion){
                    case 1:
                    System.out.println("Ingrese los datos del titular de la cuenta");
                    System.out.print("Nro Dni: ");
                    nroDni = teclado.nextInt();
                    System.out.print("Nombre: ");
                    nombre = teclado.next();
                    System.out.print("Apellido: ");
                    apellido = teclado.next();
                    System.out.print("Año nacimiento: ");
                    añoNacimiento = teclado.nextInt();
                    Persona otroTitular = new Persona(nroDni,nombre,apellido,añoNacimiento);
                    System.out.println("Ingrese datos de la cuenta bancaria");
                    System.out.print("nro cuenta: ");
                    nroCuenta = teclado.nextInt();
                    System.out.print("Saldo: ");
                    saldo = teclado.nextDouble();
                    CuentaBancaria otraCuenta = new CuentaBancaria(nroCuenta,otroTitular,saldo);
                    if(unBanco.agregarCuentaBancaria(otraCuenta) == true){
                        System.out.print("Cuenta añadida satisfactoriamente!");
                    }
                    break;

                    case 2:
                    System.out.println("\n"+"Ingrese nro de dni del titular de la cuenta a eliminar");
                    nroDni = teclado.nextInt();
                    for(int i=0;i<unBanco.getCuentasBancarias().size();i++){
                        CuentaBancaria cuenta = unBanco.getCuentasBancarias().get(i);
                        if(nroDni == cuenta.getTitular().getNroDni()){
                            unBanco.quitarCuentaBancaria(cuenta);
                        }else{
                            System.out.println("No existe esa cuenta en el listado");
                        }
                    }
                    break;

                    case 3:
                    unBanco.mostrarResumen();
                    break;

                    default: System.out.println("Chau pe!");
                }//unBanco.getEmpleados() y obtengo el arreglo de empleados
                opcion = 4;
            }while(opcion != 4);
        }
    }
}

