import java.util.*;
/**
 * Gestiona empleados en una determinada empresa
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class GestionComercio
{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        String nombre, apellido;
        double basico;
        long cuil;
        int año, opcion;
        char sn;
        
        System.out.println("************* BIENVENIDO *************");
        System.out.print("Nombre del comercio: ");
        nombre = teclado.next();
        Comercio comercio = new Comercio(nombre);
        
        do{
            System.out.println("\n1 - Alta empleado"+
                               "\n2 - Baja empleado"+
                               "\n3 - Listar empleados"+
                               "\n4 - Buscar empleados"+
                               "\n5 - Mostrar sueldo neto"+
                               "\n6 - Salir");
            opcion = teclado.nextInt();
            
            switch (opcion){
                case 1: 
                    System.out.println("Alta empleado? (s/n)");
                    sn = teclado.next().charAt(0);  
                    while (sn == 's' || sn == 'S'){
                        System.out.println(" - NUEVO EMPLEADO - ");
                        System.out.println("Nombre:");
                        nombre = teclado.next();
                        System.out.println("Apellido:");
                        apellido = teclado.next();
                        System.out.println("CUIL:");
                        cuil = teclado.nextLong();
                        System.out.println("Sueldo Basico:");
                        basico = teclado.nextDouble();
                        System.out.println("Año Ingreso:");
                        año= teclado.nextInt();
                        Empleado empleado = new Empleado(cuil,nombre,apellido,basico,año);
                        empleado.mostrar();
                        
                        if (sn == 's' || sn == 'S'){
                            comercio.altaEmpleado(empleado);
                        }
                        System.out.println("¿Otro empleado? (s/n)");
                        sn = teclado.next().charAt(0);
                    }
                    break;
                    
                case 2:
                    if(comercio.getEmpleados().isEmpty()){
                        System.out.println("No hay emplaedos dados de alta");
                        sn = 'n';
                    }else{
                        sn = 's';
                    }
                    while(sn == 's' || sn == 'S'){
                        System.out.println("Ingrese el Nro de CUIL:");
                        cuil = teclado.nextLong();
                        if(comercio.esEmpleado(cuil)){
                            ((Empleado) comercio.getEmpleados().get(cuil)).mostrar();
                            System.out.println("Seguro que desea eliminar el empleado? (s/n)");
                            sn = teclado.next().charAt(0);
                            if (sn == 's' || sn == 'S'){
                                comercio.bajaEmpleado(cuil);
                                System.out.println("Eliminado!");
                            }
                        }else{
                            System.out.println("No existe el empleado");
                        }
                        
                        if(comercio.getEmpleados().isEmpty()){
                            System.out.println("No hay emplaedos dados de alta");
                                sn = 'n';
                        }else{
                            System.out.println("Otro empleado? (s/n)");
                            sn = teclado.next().charAt(0);
                        }
                    }
                  break;
                  
                case 3:
                    comercio.nomina();
                  break;
                  
                case 4:
                   if(comercio.getEmpleados().isEmpty()){
                       System.out.println("No hay emplaedos dados de alta");
                       sn = 'n';
                   }else{
                       sn = 's';
                   }
                   while(sn == 's' || sn == 'S'){
                       System.out.println("Ingrese el Nro de CUIL:");
                       cuil = teclado.nextLong();
                       if(comercio.esEmpleado(cuil)){
                           ((Empleado) comercio.getEmpleados().get(cuil)).mostrar();
                       }else{
                          System.out.println("No existe el empleado");
                       }
                       System.out.println("Otro empleado? (s/n)");
                       sn = teclado.next().charAt(0);
                   }
                  break;
                  
                case 5:
                    if(comercio.getEmpleados().isEmpty()){
                        System.out.println("No hay emplaedos dados de alta");
                        sn = 'n';
                    }else{
                        sn = 's';
                    }
                    while(sn == 's' || sn == 'S'){
                        System.out.println("Ingrese el Nro de CUIL:");
                        cuil = teclado.nextLong();
                        if(comercio.esEmpleado(cuil)){
                            comercio.sueldoNeto(cuil);
                        }else{
                           System.out.println("No existe el empleado");
                        }
                        System.out.println("Otro empleado? (s/n)");
                        sn = teclado.next().charAt(0);
                    }
                  break;
                  
                default: System.out.println("Chau pe!");
            }
            opcion = 6;
        } while (opcion != 6);
    }
}