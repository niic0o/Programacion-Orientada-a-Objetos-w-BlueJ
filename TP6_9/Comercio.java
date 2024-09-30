import java.util.Scanner;
/**
 * Realiza consultas sobre la disponibilidad y costos de artefactos del hogar.
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class Comercio
{
    public static void main (String [] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        int opcion = 0, cuotas;
        float interes, credito, creditoAdicional;

        // artefactos disponibles para la venta

        Heladera heladera = new Heladera("Whirlpool",12580,5,7,2,true);
        Cocina cocina = new Cocina("Brogas",4250,4,2,1500,"80 x 90");
        Lavarropas lavarropas = new Lavarropas("El Lavarropas",18054,9,4,85,false);

        do{
            try{
            System.out.println("\n"+" 1 - Heladera"+
                "\n"+" 2 - Cocina"+
                "\n"+" 3 - Lavarropas"+
                "\n"+" 4 - Salir"+"\n");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                System.out.print("Interes: ");
                interes = teclado.nextFloat();
                System.out.print("Cuotas: ");
                cuotas = teclado.nextInt();
                credito = heladera.cuotaCredito(cuotas,interes);
                creditoAdicional = heladera.creditoConAdicional(cuotas,interes);
                heladera.imprimir();
                System.out.println("Cuotas: "+cuotas+" - Interes: "+interes+"%"+
                    "\n"+"Valor Cuota: "+credito+
                    "\n"+"Valor Cuota Con Adicionales: "+creditoAdicional);
                break;
                case 2:
                System.out.print("Interes: ");
                interes = teclado.nextFloat();
                System.out.print("Cuotas: ");
                cuotas = teclado.nextInt();
                credito = cocina.cuotaCredito(cuotas,interes);
                creditoAdicional = cocina.creditoConAdicional(cuotas,interes);
                cocina.imprimir();
                System.out.println("Cuotas: "+cuotas+" - Interes: "+interes+"%"+
                    "\n"+"Valor Cuota: "+credito+
                    "\n"+"Valor Cuota Con Adicionales: "+creditoAdicional);                
                break;
                case 3:
                System.out.print("Interes: ");
                interes = teclado.nextFloat();
                System.out.print("Cuotas: ");
                cuotas = teclado.nextInt();
                credito = lavarropas.cuotaCredito(cuotas,interes);
                creditoAdicional = lavarropas.creditoConAdicional(cuotas,interes);
                lavarropas.imprimir();
                System.out.println("Cuotas: "+cuotas+" - Interes: "+interes+"%"+
                    "\n"+"Valor Cuota: "+credito+
                    "\n"+"Valor Cuota Con Adicionales: "+creditoAdicional);                
                break;

                default: System.out.println("Chau pe!");
            }
        }
            catch(Exception e){
                System.out.print("Opcion incorrecta!");
                teclado = new Scanner(System.in);
        }
        }while(opcion != 4);
        }
   
    }
