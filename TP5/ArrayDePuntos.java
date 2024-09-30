import java.util.Scanner;
/**
 * Ejecutable que gestiona el ingreso de puntos en un arreglo.
 * 
 * @author Sena, Nicolas Ariel
 * @version 1.0 - 11/2017
 */
public class ArrayDePuntos
{
    public static void main (String [] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        double x,y; //ejes del punto
        Punto puntos [] = new Punto[6];
        System.out.println("***** Bienvenido *****"+"\n");
        for (int i=0;i<puntos.length;i++){
            System.out.print("\n"+"Ingrese eje x: ");
            x = teclado.nextInt();
            System.out.print("Ingrese eje y: ");
            y = teclado.nextInt();
            puntos[i] = new Punto(x,y);
        }
        System.out.println("\n");
        for (int i=0;i<puntos.length;i++){
            puntos[i].mostrar();
            if(i>0){
                System.out.println("\n"+"La distancia entre los dos puntos anteriores es: "+puntos[i].distanciaA(puntos[i-1]));                
            }
        }
    }
}
