import java.util.Scanner;
/**
 * Esta clase interactua con el usuarion la creacion de un punto.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 14/09/2017
 */
public class CreaPunto
{
    public static void main (String [] args)
    {
                double x1, y1, x2, y2;
                String op, op2;
                Scanner teclado = new Scanner(System.in);
                teclado.useDelimiter("\n");
                System.out.println("------ Bienvenido -----"+"\n");
                Punto inicializarPunto = new Punto();
                do{
                    System.out.println("Ingrese las coordenadas del 1er punto: ");
                    System.out.print("Punto X1: ");
                    x1 = teclado.nextDouble();
                    System.out.print("Punto Y1: ");
                    y1 = teclado.nextDouble();
                    Punto otroPunto = new Punto(x1,y1);
                    System.out.println("\n"+ "Ingrese las coordenadas del 2do punto: ");
                    System.out.print("Punto X2: ");
                    x2 = teclado.nextDouble();
                    System.out.print("Punto Y2: ");
                    y2 = teclado.nextDouble();
                    Punto unPunto = new Punto(x2,y2,otroPunto);
                    System.out.println("\n"+"Variables ingresadas x1, y1: ");
                    otroPunto.mostrar();
                    System.out.println("\n"+"Variables ingresadas x2, y2: ");
                    unPunto.mostrar();
                    System.out.println("\n"+"Las cordenadas x1,y1 son: "+otroPunto.coordenadas());
                    System.out.println("\n"+"Las cordenadas x2,y2 son: "+unPunto.coordenadas());
                    System.out.println("Desea desplazar los puntos? presione 'si' o cualquier letra para salir");
                    op2 = teclado.next();
                    if (op2.equals("si"))
                        {
                            System.out.print("Punto X1: ");
                            x1 = teclado.nextDouble();
                            System.out.print("Punto Y1: ");
                            y1 = teclado.nextDouble();
                            otroPunto.desplazar(x1,y1);
                            System.out.print("Punto X2: ");
                            x2 = teclado.nextDouble();
                            System.out.print("Punto Y2: ");
                            y2 = teclado.nextDouble();
                            unPunto.desplazar(x2,y2);
                            System.out.println("\n"+"Las cordenadas x1,y1 son: "+otroPunto.coordenadas());
                            System.out.println("\n"+"Las cordenadas x2,y2 son: "+unPunto.coordenadas());
                        }
                    System.out.println("\n"+"Desea conocer la distancia desde el primer punto hacia el segundo? ('si')");
                    op2 = teclado.next();
                    if (op2.equals("si"))
                    {
                        System.out.println("La distancia es de: "+unPunto.distanciaA(otroPunto));
                    }    
                    System.out.println("Desea ingresar otros puntos? presione 'si' o cualquier letra para salir");
                    op = teclado.next();
                }while(op.equals("si"));
            }
}
