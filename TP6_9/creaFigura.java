import java.util.*;
/**
 * Write a description of class Escuela here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class creaFigura{
    public static void main (String [] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        double ancho,alto,x,y,lado,radio,sEjeMayor,sEjeMenor;
        int opcion;
        String op;
        Rectangulo rectangulo = null;
        Cuadrado cuadrado = null;  
        Random unNumero = new Random();
        radio = unNumero.nextDouble() * 100.0;
        System.out.println("********Bienvenido********");
        do{
            System.out.println("\n"+"1 - Rectangulo"+
                "\n"+"2 - Cuadrado"+
                "\n"+"3 - Circulo"+
                "\n"+"4 - Elipse"+
                "\n"+"5 - Salir"+"\n");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
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
                break;
                case 2:
                //Las variables de tipo (x,y) son usadas para insertar (ancho, alto) de un rectangulo
                do
                {
                    System.out.print("Ingrese Lado del Cuadrado: ");
                    lado = teclado.nextDouble();
                    Punto unOrigen = new Punto(0,0);
                    Cuadrado unCuadrado = new Cuadrado(unOrigen,lado);
                    System.out.println("Desea desplazar el origen del cuadrado? 'si' 'no'");
                    op = teclado.next();
                    if (op.equals("si"))
                    {
                        System.out.print("'num' hacia la derecha, '-num' hacia la izquierda: ");
                        x = teclado.nextDouble();
                        System.out.print("'num' hacia arriba, '-num' hacia abajo: ");
                        y = teclado.nextDouble();
                        unOrigen.desplazar(x,y);
                    }
                    unCuadrado.caracteristicas();
                    System.out.println("Desea ingresar otro cuadrado? 'si' 'no'");
                    op = teclado.next();
                    if (op.equals("si"))
                    {
                        System.out.println("Introduzca posicion inicial del origen"+"\n");
                        System.out.print("Eje X: ");
                        x = teclado.nextDouble();
                        System.out.print("Eje Y: ");
                        y = teclado.nextDouble();
                        Punto otroOrigen = new Punto(x,y);
                        System.out.print("Ingrese Lado del Cuadrado: ");
                        lado = teclado.nextDouble();
                        Cuadrado otroCuadrado = new Cuadrado(otroOrigen,lado);
                        System.out.println("La distancia entre los cuadrados es de: " + otroCuadrado.distanciaA(unCuadrado));
                    }
                    System.out.println("Desea realizar una nueva operacion con Cuadrados? 'si' 'no'");
                    op = teclado.next();
                }while(op.equals("si"));                
                break;
                case 3:
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
                break;
                case 4:
                do
                {
                    System.out.println("Ingrese los siguientes datos: "+"\n");
                    System.out.print("Eje x: ");
                    x = teclado.nextDouble();
                    System.out.print("Eje y: ");
                    y = teclado.nextDouble();
                    System.out.print("Semieje Mayor: ");
                    sEjeMayor = teclado.nextDouble();
                    System.out.print("Semieje Menor: ");
                    sEjeMenor = teclado.nextDouble();                
                    Punto unPunto = new Punto(x,y);
                    Elipse unaElipse = new Elipse(sEjeMayor,sEjeMenor,unPunto);
                    unaElipse.caracteristicas();
                    //desplazar circulo1 (240 unidades a la izquierda y 230 hacia abajo)
                    System.out.println("Desea desplazar el punto central de la elipse? 'si' 'no'");
                    op = teclado.next();
                    if (op.equals("si"))
                    {
                        System.out.print("Eje x: ");
                        x = teclado.nextDouble();
                        System.out.print("Eje y: ");
                        y = teclado.nextDouble();
                        unaElipse.desplazar(x,y);
                    }
                    //mostrar caracteristicas del circulo1
                    unaElipse.caracteristicas();
                    //crear otro circulo2 en el punto (5.2, 0.5) y su radio aleatorio
                    System.out.println("Desea ingresar otra elipse? 'si' 'no'");
                    op = teclado.next();
                    if (op.equals("si")){
                        System.out.println("Ingrese los siguientes datos: "+"\n");
                        System.out.print("Eje x: ");
                        x = teclado.nextDouble();
                        System.out.print("Eje y: ");
                        y = teclado.nextDouble();
                        System.out.print("Semieje Mayor: ");
                        sEjeMayor = teclado.nextDouble();
                        System.out.print("Semieje Menor: ");
                        sEjeMenor = teclado.nextDouble();                
                        Punto otroPunto = new Punto(x,y);
                        Elipse otraElipse = new Elipse(sEjeMayor,sEjeMenor,otroPunto);
                        otraElipse.caracteristicas();
                        //mostrar las caracteristicas del mayor entre circulo 1 y 2
                        otraElipse.elMayor(unaElipse).caracteristicas();
                        // mostrar distancia circulo1 y 2
                        System.out.println("La distancia entre los circulos es de: " + otraElipse.distanciaA(unaElipse));
                    }
                    System.out.println("Desea realizar una nueva operacion con Elipses? 'si' 'no'");
                    op = teclado.next();
                }while(op.equals("si"));
                break;
                default: System.out.println("Chau pe!");

            }

        }while(opcion != 5);

    }

}

