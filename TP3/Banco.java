import java.util.Scanner;
import java.util.*;

/**
 * Ejecuta la gestion de una cuenta bancaria.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class Banco
{
    public static void main (String [] args)
    {
        int dni, cuenta, anioNac, diaNac, mesNac;
        String nombre, apellido, op, op2, op3;
        double saldo;
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        System.out.println("--------- Banco x ----------"+"\n");
        System.out.println("\n"+"ingrese los datos solicitados del titular: ");
        System.out.print("Dni: ");
        dni = teclado.nextInt();
        System.out.print("Apellido: ");
        apellido = teclado.next();
        System.out.print("Nombre: ");
        nombre = teclado.next();
        System.out.print("Año de nacimiento: ");            
        anioNac = teclado.nextInt();
        System.out.print("Mes(nº): ");
        mesNac = teclado.nextInt();
        mesNac = (mesNac - 1);//0 enero - 11 diciembre
        System.out.print("Dia: ");
        diaNac = teclado.nextInt();
        System.out.println("Nro de cuenta: "+"\n");
        cuenta = teclado.nextInt();
        Calendar unNacimiento = new GregorianCalendar(anioNac,mesNac,diaNac);
        Persona unTitular = new Persona(dni,nombre,apellido,unNacimiento);
        if (unTitular.esCumpleaños() == true)
        {
            System.out.println("\n"+"El banco le decia un feliz cumpleaños "+unTitular.getNombre());
        }
        

        do
        {
            //utilizar una de las dos clases
            System.out.println("'1' para operar con c/c"+"\n"+"'2' para operar con Caja de Ahorro"+"\n"+"Cualquier tecla para salir");
            op = teclado.next();
            if (op.equals("1"))
            {
                //instanciar unaCC con uno de sus dos construtctores 
                System.out.println("\n"+"'1' para inicializar cuenta"+"\n"+"'2' para operar con saldo existente");
                op2 = teclado.next();
                if (op2.equals("1"))
                {
                    CuentaCorriente unaCC = new CuentaCorriente(cuenta,unTitular);
                    do
                    {
                        System.out.println("\n"+"1 - para depositar. 2- para extraer");
                        op3 = teclado.next();
                        if (op3.equals("1"))
                        {
                            System.out.println("Saldo a depositar: ");
                            saldo = teclado.nextDouble();
                            unaCC.depositar(saldo);
                        }
                        if (op3.equals("2"))
                        {
                            System.out.println("Saldo a extraer: ");
                            saldo = teclado.nextDouble();
                            unaCC.extraer(saldo);
                        }
                        unaCC.mostrar();
                        System.out.println("Repetir operacion?");
                        op3 = teclado.next();
                    }while(op3.equals("si"));
                }
                if (op2.equals("2"))
                {
                    System.out.print("Ingreso de saldo anterior: $");
                    saldo = teclado.nextDouble();
                    CuentaCorriente unaCC = new CuentaCorriente(cuenta,unTitular,saldo);
                    do
                    {
                        System.out.println("\n"+"1 - para depositar. 2- para extraer");
                        op3 = teclado.next();
                        if (op3.equals("1"))
                        {
                            System.out.println("Saldo a depositar: ");
                            saldo = teclado.nextDouble();
                            unaCC.depositar(saldo);
                        }
                        if (op3.equals("2"))
                        {
                            System.out.println("Saldo a extraer: ");
                            saldo = teclado.nextDouble();
                            unaCC.extraer(saldo);
                        }
                        unaCC.mostrar();
                        System.out.println("Repetir operacion?");
                        op3 = teclado.next();
                    }while(op3.equals("si"));                

                }

            }
            if (op.equals("2"))
            {
                {
                    //instanciar unaCC con uno de sus dos construtctores 
                    System.out.println("\n"+"'1' para inicializar cuenta"+"\n"+"'2' para operar con saldo existente");
                    op2 = teclado.next();
                    if (op2.equals("1"))
                    {
                        CajaDeAhorro unaCA = new CajaDeAhorro(cuenta,unTitular);
                        do
                        {
                            System.out.println("\n"+"1 - para depositar. 2- para extraer");
                            op3 = teclado.next();
                            if (op3.equals("1"))
                            {
                                System.out.println("Saldo a depositar: ");
                                saldo = teclado.nextDouble();
                                unaCA.depositar(saldo);
                            }
                            if (op3.equals("2"))
                            {
                                System.out.println("Saldo a extraer: ");
                                saldo = teclado.nextDouble();
                                unaCA.extraer(saldo);
                            }
                            unaCA.mostrar();
                            System.out.println("Repetir operacion?");
                            op3 = teclado.next();
                        }while(op3.equals("si"));
                    }
                    if (op2.equals("2"))
                    {
                        System.out.print("Ingreso de saldo anterior: $");
                        saldo = teclado.nextDouble();
                        CajaDeAhorro unaCA = new CajaDeAhorro(cuenta,unTitular,saldo);
                        do
                        {
                            System.out.println("\n"+"1 - para depositar. 2- para extraer");
                            op3 = teclado.next();
                            if (op3.equals("1"))
                            {
                                System.out.println("Saldo a depositar: ");
                                saldo = teclado.nextDouble();
                                unaCA.depositar(saldo);
                            }
                            if (op3.equals("2"))
                            {
                                System.out.println("Saldo a extraer: ");
                                saldo = teclado.nextDouble();
                                unaCA.extraer(saldo);
                            }
                            unaCA.mostrar();
                            System.out.println("Repetir operacion?");
                            op3 = teclado.next();
                        }while(op3.equals("si"));                

                    }

                }

            }
            System.out.println("Desea gestionar su cuenta nuevamente? (si)");
            op = teclado.next();
        }while(op.equals("si"));
    }
}