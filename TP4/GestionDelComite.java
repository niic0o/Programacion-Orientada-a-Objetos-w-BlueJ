import java.util.*;
import java.io.*;

/**
 * Instancia objetos de la clase Siniestro, UnidadDeRiesgo y Poliza y guarda datos en un archivo secuencial.
 * 
 * 
 * @author: Nicolas Ariel Sena
 * @version: v1.0 - 10/2017
 */

public class GestionDelComite{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        Calendar fechaCosecha, fechaSiniestro, fechaContrato;
        Poliza poliza;
        Siniestro siniestro;
        UnidadDeRiesgo unidad;
        String agricultor, cultivo, cobertura, cancelacion, op;
        double valorAsegurado, valorPoliza, porceDanio;
        int dia, mes, anio;
        char sn;
        
        
        System.out.println("*********** GESTION DEL COMITE***********");
        
        do{
            System.out.println("1 - Archivo Nuevo"+
                             "\n2 - Archivo Existente");
            sn = teclado.next().charAt(0);
            if (sn != '1' && sn != '2'){
                System.out.println("Opcion incorrecta, vuelva a intentar");
            }
        } while (sn != '1' && sn != '2');
        
        try{
            FileOutputStream archiFOS; 
            if (sn == '1'){
                System.out.println(
                                 "\n¿Seguro que desea continuar? (s/n)");
                sn = teclado.next().charAt(0);
                if (sn == 's' || sn == 'S'){
                    archiFOS = new FileOutputStream("siniestros.dat");
                }
            }else{
                System.out.println("Se utilizara el archivo existente");
            }
            archiFOS = new FileOutputStream("siniestros.dat",true);
            DataOutputStream archiDOS = new DataOutputStream(archiFOS);
            
            sn = 's';
            while (sn == 's' || sn == 'S'){
                System.out.println(" - Unidad de Riesgo - ");
                System.out.println("Agricultor:");
                agricultor = teclado.next();
                System.out.println("Cultivo:");
                cultivo = teclado.next();
                System.out.println("Dia de Cosecha:");
                dia = teclado.nextInt();
                System.out.println("Mes de Cosecha:");
                mes = teclado.nextInt() - 1;
                System.out.println("Año de Cosecha:");
                anio = teclado.nextInt();
                fechaCosecha = new GregorianCalendar(anio,mes,dia);
                unidad = new UnidadDeRiesgo(agricultor,cultivo,fechaCosecha);
                
                System.out.println(" - Siniestro - ");
                System.out.println("Dia de Siniestro:");
                dia = teclado.nextInt();
                System.out.println("Mes de Siniestro:");
                mes = teclado.nextInt() - 1;
                System.out.println("Año de Siniestro:");
                anio = teclado.nextInt();
                fechaSiniestro = new GregorianCalendar(anio,mes,dia);
                System.out.println("Porcentaje del Daño:");
                porceDanio = teclado.nextDouble();
                siniestro = new Siniestro(fechaSiniestro, porceDanio);
                
                System.out.println(" - Poliza - ");
                System.out.println("Cobertura:");
                cobertura = teclado.next();
                System.out.println("Dia de contrato:");
                dia = teclado.nextInt();
                System.out.println("Mes de contrato:");
                mes = teclado.nextInt() - 1;
                System.out.println("Año de contrato:");
                anio = teclado.nextInt();
                fechaContrato = new GregorianCalendar(anio,mes,dia);
                System.out.println("Valor Poliza:");
                valorPoliza = teclado.nextDouble();
                System.out.println("Valor Asegurado:");
                valorAsegurado = teclado.nextDouble();
                System.out.println("Momento de Cancelacion");
                cancelacion = teclado.next();
                
                poliza = new Poliza(cobertura,fechaContrato,valorPoliza,valorAsegurado,cancelacion,siniestro,unidad);
                poliza.resumenIndemnizaciones();
                
                archiDOS.writeUTF(poliza.getCobertura());
                archiDOS.writeUTF(poliza.getUnidadDeRiesgo().getCultivo());
                archiDOS.writeDouble(poliza.getSiniestro().getPorceDanio());
                archiDOS.writeDouble(poliza.indemnizacion());
                
                System.out.println("\n¿Seguro que desea continuar? (s/n)");
                sn = teclado.next().charAt(0);
            }
            archiDOS.close();
            archiFOS.close();
        } catch(FileNotFoundException fnfe){
            System.out.println("Archivo no encontrado");
        } catch(IOException ioe){
            System.out.println("Error de escritura");
        }        
        
        try{
            FileInputStream archiFIS = new FileInputStream("siniestros.dat");
            DataInputStream archiDIS = new DataInputStream(archiFIS);
                            
            while (archiDIS.available() > 0){
                System.out.println(archiDIS.readUTF()+"\t\t"+
                                   archiDIS.readUTF()+"\t\t"+
                                   archiDIS.readDouble()+"\t\t"+
                                   archiDIS.readDouble());
            }
            archiFIS.close();
            archiDIS.close();
        } catch (FileNotFoundException fnfe){
            System.out.println("Archivo no encontrado");
        } catch (IOException ioe){
            System.out.println("Error de lectura/escritura");
        }    
    }
}   
