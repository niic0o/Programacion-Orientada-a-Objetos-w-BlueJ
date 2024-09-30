import java.util.Scanner;
import java.util.Random;

/**
 * Esta clase gestiona la creacion de una fijura en un plano bidimensional.
 * 
 * @author Nicolas Ariel Sena
 * @version 1.0 - 14/09/2017
 */
public class CreaFigura
{
    public static void main (String [] args)
    {
        int op2;
        double radio, x, y;
        String op;
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        //inicializar circulo1. radio de numero aleatorio.
        Random unNumero = new Random();
        radio = unNumero.nextDouble() * 100.0;
        System.out.println("------------ Figura -----------"+"\n");
        System.out.print("'1' - para operar con circulos. '2' - para operar con rectangulos"+"\n");
        op2 = teclado.nextInt();
        if (op2 == 1)
        {
            Circulo inicializar = new Circulo();
            do
            {
                System.out.println("Ingrese los siguientes datos: "+"\n");
                System.out.print("Eje x: ");
                x = teclado.nextDouble();
                System.out.print("Eje y: ");
                y = teclado.nextDouble();
                Punto unPunto = new Punto(x,y);
                Circulo unCirculo = new Circulo(radio,unPunto);
                unCirculo.caracteristicas();
                //desplazar circulo1 (240 unidades a la izquierda y 230 hacia abajo)
                System.out.println("Desea desplazar el punto central del circulo? 'si' 'no'");
                op = teclado.next();
                if (op.equals("si"))
                {
                    System.out.print("Eje x: ");
                    x = teclado.nextDouble();
                    System.out.print("Eje y: ");
                    y = teclado.nextDouble();
                    unCirculo.desplazar(x,y);
                }
                //mostrar caracteristicas del circulo1
                unCirculo.caracteristicas();
                //crear otro circulo2 en el punto (5.2, 0.5) y su radio aleatorio
                System.out.println("Desea ingresar otro circulo? 'si' 'no'");
                op = teclado.next();
                if (op.equals("si"))
                {
                    radio = unNumero.nextDouble() * 100.0;
                    System.out.print("Eje x: ");
                    x = teclado.nextDouble();
                    System.out.print("Eje y: ");
                    y = teclado.nextDouble();
                    Punto otroPunto = new Punto(x,y);
                    Circulo otroCirculo = new Circulo(radio,otroPunto);
                    //mostrar las caracteristicas del mayor entre circulo 1 y 2
                    otroCirculo.elMayor(unCirculo).caracteristicas();
                    // mostrar distancia circulo1 y 2
                    System.out.println("La distancia entre los circulos es de: " + otroCirculo.distanciaA(unCirculo));
                }
                System.out.println("Desea realizar una nueva operacion con Circulos? 'si' 'no'");
                op = teclado.next();
            }while(op.equals("si"));
        }
        if (op2 == 2)
        {
            Rectangulo inicializar = new Rectangulo(0,0);
            //Las variables de tipo (x,y) son usadas para insertar (ancho, alto) de un rectangulo
            do
            {
                System.out.println("Ingreso aleatorios de Ancho y Alto del rectangulo: "+"\n");
                x = unNumero.nextDouble() * 100.0;
                y = unNumero.nextDouble() * 100.0;
                Punto unOrigen = new Punto(0,0);
                Rectangulo unRectangulo = new Rectangulo(unOrigen,x,y);
                System.out.println("Desea desplazar el origen del rectangulo? 'si' 'no'");
                op = teclado.next();
                if (op.equals("si"))
                {
                    System.out.print("'num' hacia la derecha, '-num' hacia la izquierda: ");
                    x = teclado.nextDouble();
                    System.out.print("'num' hacia arriba, '-num' hacia abajo: ");
                    y = teclado.nextDouble();
                    unOrigen.desplazar(x,y);
                }
                unRectangulo.caracteristicas();
                System.out.println("Desea ingresar otro rectangulo? 'si' 'no'");
                op = teclado.next();
                if (op.equals("si"))
                {
                    System.out.println("Introduzca posicion inicial del origen"+"\n");
                    System.out.print("Eje X: ");
                    x = teclado.nextDouble();
                    System.out.print("Eje Y: ");
                    y = teclado.nextDouble();
                    Punto otroOrigen = new Punto(x,y);
                    x = unNumero.nextDouble() * 100.0;
                    y = unNumero.nextDouble() * 100.0;
                    Rectangulo otroRectangulo = new Rectangulo(otroOrigen,x,y);
                    System.out.println("La distancia entre los rectangulos es de: " + otroRectangulo.distanciaA(unRectangulo));
                }
                System.out.println("Desea realizar una nueva operacion con Rectangulos? 'si' 'no'");
                op = teclado.next();
            }while(op.equals("si"));
        }
  }
}